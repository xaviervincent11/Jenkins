// vars/standardDeploy.groovy
def call(Map config = [:]) {
    // Note : On n'écrit PAS "pipeline {}" ici
    stage('Build') {
        echo "Building ${config.appName}..."
    }
    stage('Test') {
        echo "Testing..."
    }
    stage('Security') {
        echo "Scanning..."
    }
    stage('Deploy') {
        echo "Deploying to ${params.ENVIRONMENT}..."
    }
}