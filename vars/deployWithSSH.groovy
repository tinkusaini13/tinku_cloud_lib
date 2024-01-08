def call(String credentialsId) {
    def serverHost = '15.206.163.197'
    def serverPort = '22'
    def username = 'tomcat'
    def remotePath = '/tmp/'

    stage('Deploy') {
        sshDeploy(serverHost, serverPort, username, remotePath, credentialsId)
    }
}

def sshDeploy(String serverHost, String serverPort, String username, String remotePath, String credentialsId) {
    script {
        withCredentials([usernamePassword(credentialsId: 'dev_passwd', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {  // Obtain the password from Jenkins credentials
            def password = credentials(credentialsId)
            // Your SSH deployment steps here
            echo "Deploying to ${serverHost}:${serverPort} with username ${username} and password *** (masked)"
            sh "sshpass -p ${password} scp -P ${serverPort} *.war ${username}@${serverHost}:${remotePath}"
        }
    }
}
