#!/usr/bin/env groovy
pipeline{
    agent any
    environment {
        NEW_VERSION = '8.5.9'
        // Calling credentails from jenkins saved cred
        // For doing this you would have to include two things in Jenkins
        //* Credentails Plugin
        //* Credentials Buinding Plugin

        SERVER_CREDENTIAL = credentials('our-server-cred')
    }

    parameters {
        //// There are different kinds of parameter, string, choice, boolean, etc.
        // string(name:'StringParam', defaultValue: '', description:'XYZ')
        choice(name: 'VERSION', choices:['1.1.2', '1.2.1', '1.3.1'], description: '1.1 - Production, 1.2 - Test Env, 1.3 - Development')
        booleanParam(name:'ExecuteTest', defaultValue:'true', description:'')
    }

    stages {
        stage('Developing') {
            steps {
                script {
                    echo "Developing build, going to test next"
                }
            }
        }

        stage('Testing') {
            steps {
                // When expression used for condition on which this steps are going to run.
                when {
                    expression {
                        params.ExecuteTest == true // or params.ExecuteTest
                    }
                }
                script {
                    echo 'Doing testing soon, results are going to come!!!'
            
                }
            }
        }

        stage('Final_Recheck') {
            steps {
                script {
                    echo 'Doing Rechecks soon launching in Production env!!!'
                    echo "You have chosen ${params.VERSION} during build"
                }
            }
        }
    }

}
