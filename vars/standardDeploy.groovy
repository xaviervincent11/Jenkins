// vars/standardDeploy.groovy

def call(Map config = [:]) {
    pipeline {
        agent any
        parameters {
            choice(name: 'ENVIRONMENT', choices: ['Dev', 'Staging', 'Prod'], description: 'Where to deploy?')
            string(name: 'VERSION', defaultValue: '1.0.0', description: 'Build version')
        }
        stages {
            stage('Deploy') {
                steps {
                    // We use config.appName to access the variable passed from the Jenkinsfile
                    echo "Deploying ${config.appName} version ${params.VERSION} to ${params.ENVIRONMENT}"
                }
            }
        }
    }
}