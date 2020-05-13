pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
             sh 'gradle clean'
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