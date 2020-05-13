pipeline {
    agent any
    tools {
       maven 'Gradle 6.3'
       jdk 'jdk11'
    }
    stages {
        stage('Clean') {
          withGradle {
            sh './gradlew clean'
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