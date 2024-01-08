// vars/yourPipelineStep.groovy

def call() {
    pipeline {
        agent any
        stages {
            stage('Git Checkout') {
                steps {
                    script {
                        git branch: "main", credentialsId: 'git_token', url: 'https://github.com/tinkusaini13/uber.git'
                    }
                }
            }

            stage('Maven build') {
                steps {
                    script {
                        sh 'mvn clean package'
                    }
                }
            }
        }
    }
}
