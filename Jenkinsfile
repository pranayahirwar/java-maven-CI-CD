#!/usr/bin/env groovy
pipeline{
    agent any
    parameters {
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
            when {
                expression {
                    params.ExecuteTest == true
                    }
                }            
            steps {
                    echo 'Doing testing soon, results are going to come!!!'
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
