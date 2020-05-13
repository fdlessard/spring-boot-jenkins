pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                gradle {
                    tasks: 'clean'
                }
             }
        }
        stage('Compiling') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Test') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}