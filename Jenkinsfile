#!/usr/bin/env groovy
// Here we will use grovvy script from which we are going to call function inside our stage. because these stages can contain too many code init. To do this first we need to define init stage.
// One thing to keep in mind is that, the parameter which are defind in jenkins files are also availabe in script.groovy

pipeline{
    agent any
    parameters {
        choice(name: 'VERSION', choices:['1.1.2', '1.2.1', '1.3.1'], description: '1.1 - Production, 1.2 - Test Env, 1.3 - Development')
        booleanParam(name:'ExecuteTest', defaultValue:'false', description:'')
    }

    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy' 
                }
            }
        }

        stage('Developing') {
            steps {
                script {
                    gv.devStep()
                }
            }
        }

        stage('Testing') {
            when {
                expression {
                    params.ExecuteTest == true
                    }
                }            
            steps {
                script {
                    gv.testStep()
                }
                    
            }
        }

        stage('Final_Recheck') {
            input {
                message "Chose where to ENV to deploy"
                ok "User chose it's input, DONE"
                parameters {
                    choice(name:'ENV_one', choices: ['DEV', 'Testing', 'Production'], description:'')
                    // When you want to deploy to multiple env, you can duplicate above parameter and deployment will be pushed to 2nd env too.
                    choice(name:'ENV_two', choices: ['DEV', 'Testing', 'Production'], description:'')
                }
            }            
            steps {
                script {
                    echo "User has chosen, ${ENV_one} Environment for deployment"
                    echo "User has chosen, ${ENV_two} Environment for deployment"
                    gv.beforProd()
                }
            }
        }
    }

}
