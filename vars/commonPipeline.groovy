def call() {
    pipeline {
        agent any

        stages {
            stage('Build') {
                steps {
                    echo 'Building...'
                    sh 'mvn clean package'
                }
            }
            stage('Test') {
                steps {
                    echo 'Testing...'
                    // Your test steps here
                }
            }
            // Add more stages as needed
        }
    }
}
