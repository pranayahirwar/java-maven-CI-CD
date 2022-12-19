#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'ourMaven_3.8.6'
    }
    stages {
        stage('increment version') {
            steps {
                script {
                    echo 'incrementing app version...'
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }
        stage('build app') {
            steps {
                script {
                    echo "building the application..."
                    sh 'mvn clean package'
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "building the docker image..."
                    sh "docker build -t trymi0/jenkins_ci-cd-repo:jam-100.1 ."
//                     withCredentials([usernamePassword(credentialsId: 'dockerHubCred', usernameVariable:'USER', passwordVariable:'PSD')]){
//                                             sh "echo $PSD | docker login -u $USER --password-stdin "
//                                             sh "docker push trymi0/jenkins_ci-cd-repo:jam-100.1"
//                     }
                    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//                         sh "docker build -t trymi0/jenkins_ci-cd-repo:${IMAGE_NAME} ."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push trymi0/tryout:${IMAGE_NAME}"

                    }
//                     echo "Build is done and deployed to docker too. Current Build Image $IMAGE_NAME"
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo 'deploying docker image to Azure...'
                }
            }
        }

    }
}
