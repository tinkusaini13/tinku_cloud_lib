// vars/deployWithSSH.groovy

def call(Map<String, String> params) {
    def serverHost = '15.206.163.197'
    def serverPort = '22'
    def username = 'tomcat'
    def remotePath = '/tmp/'

    stage('Deploy') {
        sshDeploy(serverHost, serverPort, username, remotePath, params.credentialsId)
    }
}

def sshDeploy(String serverHost, String serverPort, String username, String remotePath, String credentialsId) {
    script {
        withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            def password = credentials(credentialsId)
            // Your SSH deployment steps here
            echo "Deploying to ${serverHost}:${serverPort} with username ${username} and password *** (masked)"
            sh "sshpass -p ${password} scp -P ${serverPort} *.war ${username}@${serverHost}:${remotePath}"
        }
    }
}
