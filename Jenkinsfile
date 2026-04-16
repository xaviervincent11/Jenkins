@Library('my-shared-library@main') _

pipeline {
    agent any
    
    parameters {
        choice(name: 'ENVIRONMENT', choices: ['Dev', 'Staging', 'Prod'], description: 'Target')
        string(name: 'APP_VERSION', defaultValue: 'latest', description: 'Application version/tag to deploy')
        booleanParam(name: 'DRY_RUN', defaultValue: false, description: 'Simulate deployment without applying changes')
    }

    stages {
        stage('Local Setup') {
            steps {
                echo "[Local Setup] START - ${new Date()}"
                echo "[Local Setup] Parameters: ENVIRONMENT=${params.ENVIRONMENT}, APP_VERSION=${params.APP_VERSION}, DRY_RUN=${params.DRY_RUN}"
                echo "Initialisation sur Mac M3..."
                sleep(time: 3, unit: 'SECONDS')
                echo "[Local Setup] END - ${new Date()}"
            }
        }
        
        // On appelle le template qui contient nos 4 stages
        stage('App Stages') {
            steps {
                echo "[App Stages] START - ${new Date()}"
                script {
                    standardDeploy(appName: 'MyM3App')
                }
                sleep(time: 3, unit: 'SECONDS')
                echo "[App Stages] END - ${new Date()}"
            }
        }

        stage('Final Notification') {
            steps {
                echo "[Final Notification] START - ${new Date()}"
                echo "Pipeline terminé avec succès !"
                sleep(time: 0.3, unit: 'SECONDS')
                echo "[Final Notification] END - ${new Date()}"
            }
        }
    }
}