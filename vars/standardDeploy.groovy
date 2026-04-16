// vars/standardDeploy.groovy
def call(Map config = [:]) {
    // Note : On n'écrit PAS "pipeline {}" ici
    stage('Build') {
        steps { echo "Building ${config.appName}..." }
    }
    stage('Test') {
        steps { echo "Testing..." }
    }
    stage('Security') {
        steps { echo "Scanning..." }
    }
    stage('Deploy') {
        steps { echo "Deploying to ${params.ENVIRONMENT}..." }
    }
}