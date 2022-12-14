#!/usr/bin/env groovy
// Here we will use grovvy script from which we are going to call function inside our stage. because these stages can contain too many code init. To do this first we need to define init stage.
// One thing to keep in mind is that, the parameter which are defind in jenkins files are also availabe in script.groovy

@Library('shared-pipeline')
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
                    buildApp()
                    // gv.buildApp()
                    
                }
            }
        }

        stage('Building Docker Image'){
            steps {
                script {
                    // fucntion call from external groovy
                    // gv.dockerBuild()

                    //How to call function without any parameter
                    // dockerBuild()

                    //function call using parameter from jenkins shared lib
                    dockerBuild 'trymi0/tryout:jam-101.1'
                    
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
