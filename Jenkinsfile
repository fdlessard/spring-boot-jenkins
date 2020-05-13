pipeline {
    agent any
    stages {
        stage('Clean') {
          steps {
            withGradle {
                sh './gradlew clean'
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