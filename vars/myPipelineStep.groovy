def call() {
    pipeline {
        agent any

        stages {
            stage('Git Checkout') {
                steps {
                    script {
                        org.tinkucloud.Utils.gitCheckout('main', 'git_token', 'https://github.com/tinkusaini13/uber.git')
                    }
                }
            }

            stage('Maven build') {
                steps {
                    script {
                        org.tinkucloud.Utils.mavenBuild()
                    }
                }
            }
        }
    }
}

