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
            parallel {
                  stage('Checkstyle') {
                    steps {
                        withGradle {
                            sh './gradlew checkstyleMain'
                        }
                     }
                  }
                  stage('Pmd') {
                    steps {
                        withGradle {
                            sh './gradlew pmdMain'
                        }
                    }
                  }
                  stage('Cpd') {
                    steps {
                        withGradle {
                            sh './gradlew cpd'
                        }
                     }
                  }
                  stage('Cpd') {
                    steps {
                         withGradle {
                            sh './gradlew cpd'
                         }
                    }
                  }
                  stage('Spotbugs') {
                    steps {
                         withGradle {
                            sh './gradlew spotbugsMain'
                         }
                    }
                  }
                  stage('Spotbugs') {
                    steps {
                         withGradle {
                            sh './gradlew dependencyCheckAnalyze'
                         }
                    }
                  }
/*                   steps {
                    withGradle {
                        sh './gradlew checkstyleMain'
                        sh './gradlew pmdMain'
                        sh './gradlew cpd'
                        sh './gradlew spotbugsMain'
                        sh './gradlew dependencyCheckAnalyze'
                    }
                } */
            }
        }
    }
    post {
        always {
            junit '**/test-results/test/*.xml'
            junit '**/test-results/integrationTest/*.xml'
             step([
                  $class: 'JacocoPublisher',
                  execPattern: 'build/jacoco/*.exec',
                  classPattern: 'build/classes',
                  sourcePattern: 'src/main/java',
                  exclusionPattern: 'src/test*'
            ])
            recordIssues enabledForFailure: false, tools: [checkStyle(pattern: 'build/reports/checkstyle/*.xml')]
            recordIssues enabledForFailure: false, tools: [pmdParser(pattern: 'build/reports/pmd/*.xml')]
            recordIssues enabledForFailure: false, tools: [cpd(pattern: 'build/reports/cpd/*.xml')]
            recordIssues enabledForFailure: false, tools: [spotBugs(pattern: 'build/reports/spotbugs/*.xml')]
            recordIssues enabledForFailure: false, tools: [dependencyCheckPublisher(pattern: 'build/reports/*.xml')]
        }
    }
}