pipeline {
    agent any
    tools {
       gradle 'Gradle 6.3'
       jdk 'jdk11'
    }
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