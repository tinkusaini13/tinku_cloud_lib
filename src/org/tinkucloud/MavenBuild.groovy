package org.tinkucloud

class Utils {
    static void gitCheckout(String branch, String credentialsId, String url) {
        git branch: branch, credentialsId: credentialsId, url: url
    }

    static void mavenBuild() {
        sh 'mvn clean package'
    }
}
