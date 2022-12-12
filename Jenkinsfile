#!/usr/bin/env groovy
pipeline{
    agent any
    environment {
        NEW_VERSION = '8.5.9'
        // Calling credentails from jenkins saved cred
        // For doing this you would have to include two things in Jenkins
        //* Credentails Plugin
        //* Credentials Buinding Plugin

        SERVER_CREDENTIAL = credentails('our-server-cred')
    }

    parameters {
        //// There are different kinds of parameter, string, choice, boolean, etc.
        // string(name:'StringParam', defaultValue: '', description:'XYZ')
        choice(name: 'VERSION', choices:['1.1.2', '1.2.1', '1.3.1'], description: '1.1 - Production, 1.2 - Test Env, 1.3 - Development')
        booleanParam(name:'ExecuteTest', defaultValue:'true', description:'')
    }

    // Describing tools, which can be used to run installed tool plugin inside this script
    // tools {
        // Remeber to include this in quote and it should be the NAME of our tool which we have assigned. Here version is not used, it's just how i have defined the maven name in jenkins.
    //     maven 'ourMaven_3.8.6'
    // }
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
                        params.ExecuteTest == true or //params.ExecuteTest
                    }
                }
                script {
                    echo 'Doing testing soon, results are going to come!!!'
                    // echo "we usually use cred in shell script, but for example i am calling it here, ${our-server-cred}"

                    // To see the difference b/w string with single quote and double
                    // echo 'we usually use cred in shell script, but for example i am calling it here, ${our-server-cred}'
                }
            }
        }

        stage('Final_Recheck') {
            steps {
                script {
                    echo 'Doing Rechecks soon launching in Production env!!!'
                    echo "You have chosen ${params.VERSION} during build"

                    //? creating credentials inside script, like an wrapper.
                    // withCredentails([
                    //     usernamePassword(credentials:'our-server-cred', usernameVariable:USER, passwordVariable:PASS
                    // ]) {
                    //     sh "our shell script which is going to call user:{USER} and password:{PASS}"
                    // }
                }
            }
        }
    }

}
