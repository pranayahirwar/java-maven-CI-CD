#!/usr/bin/env groovy
// Here we will use grovvy script from which we are going to call function inside our stage. because these stages can contain too many code init. To do this first we need to define init stage.
// One thing to keep in mind is that, the parameter which are defind in jenkins files are also availabe in script.groovy
def gv
pipeline{
    agent any
    tools {
        maven 'ourMaven_3.8.6'
    }

    stages{
        stage('init'){
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }

        stage('Building Jar'){
            steps {
                script {
                    echo 'Building Maven Package ...'
                    sh "mvn package"
                }
            }
        }

        stage('Building Docker Image'){
            steps {
                script {
                    echo "Building docker image..."
                    sh "docker build -t trymi0/tryout:jam-100.1 ."
                    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', usernameVariable:'USER', passwordVariable:'PSD')]){
                        sh "echo $PSD | docker login -u $USER --password-stdin "
                        sh "docker push trymi0/tryout:jam-100.1"
                    }
                    
                    
                }
            }
        }

        stage('Deploying'){
            steps {
                script {
                    gv.beforProd()
                }
            }
        }
    }

}
