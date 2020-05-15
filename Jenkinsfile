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
                withGradle {
                    sh './gradlew integrationTestClasses'
                }
            }
        }
        stage('Unit Tests') {
            steps {
                withGradle {
                    sh './gradlew test'
                }
            }
        }
        stage('Integration Tests') {
            steps {
                withGradle {
                    sh './gradlew integrationTest'
                }
            }
        }
        stage('Code Coverage') {
            steps {
                withGradle {
                    sh './gradlew jacocoTestCoverageVerification'
                }
            }
        }
        stage('Static Code Analysis') {
            steps {
                withGradle {
                    sh './gradlew checkstyleMain'
                    sh './gradlew pmdMain'
                    //recordIssues(tools: [pmd()])
                    sh './gradlew spotbugsMain'
                    sh './gradlew dependencyCheckAnalyze'
                    //recordIssues(tools: [dependencyCheck()])
                }
            }
        }
    }
    post {
        always {
            junit '**/test-results/test/*.xml'
            junit '**/test-results/integrationTest/*.xml'
            step([
                  $class: 'JacocoPublisher',
                  execPattern: '**/build/jacoco/*.exec',
                  classPattern: '**/build/classes',
                  sourcePattern: 'src/main/java',
                  exclusionPattern: 'src/test*'
            ])
            recordIssues enabledForFailure: false, tools: [checkStyle(reportEncoding: 'UTF-8')]
            recordIssues enabledForFailure: false, tools: [pmd()]
            recordIssues enabledForFailure: false, tools: [spotBugs()]
            //recordIssues enabledForFailure: false, tools: [dependencyCheck()]
        }
    }
}