// vars/standardDeploy.groovy
def call(Map config = [:]) {
    // Note : On n'écrit PAS "pipeline {}" ici
    stage('Build') {
        echo "Building ${config.appName}..."
        sleep(time: 3, unit: 'SECONDS')
    }
    stage('Test') {
        echo "Testing..."
        sleep(time: 3, unit: 'SECONDS')
    }
    stage('Security') {
        echo "Scanning..."
        sleep(time: 3, unit: 'SECONDS')
    }
    stage('Deploy') {
        echo "Deploying to ${params.ENVIRONMENT}..."
        sleep(time: 3, unit: 'SECONDS')
    }
}