// vars/standardDeploy.groovy
def call(Map config = [:]) {
    // Note : On n'écrit PAS "pipeline {}" ici
    stage('Build') {
        echo "[Build] START - ${new Date()}"
        echo "Building ${config.appName}..."
        sleep(time: 3, unit: 'SECONDS')
        echo "[Build] END - ${new Date()}"
    }
    stage('Test') {
        echo "[Test] START - ${new Date()}"
        echo "Testing..."
        sleep(time: 3, unit: 'SECONDS')
        echo "[Test] END - ${new Date()}"
    }
    stage('Security') {
        echo "[Security] START - ${new Date()}"
        echo "Scanning..."
        sleep(time: 3, unit: 'SECONDS')
        echo "[Security] END - ${new Date()}"
    }
    stage('Deploy') {
        echo "[Deploy] START - ${new Date()}"
        echo "Deploying to ${params.ENVIRONMENT}..."
        sleep(time: 3, unit: 'SECONDS')
        echo "[Deploy] END - ${new Date()}"
    }
}