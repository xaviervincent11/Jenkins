@Library('my-shared-library@main') _

pipeline {
    agent any
    
    parameters {
        choice(name: 'ENVIRONMENT', choices: ['Dev', 'Staging', 'Prod'], description: 'Target')
    }

    stages {
        stage('Local Setup') {
            steps {
                echo "Initialisation sur Mac M3..."
            }
        }
        
        // On appelle le template qui contient nos 4 stages
        stage('App Stages') {
            steps {
                script {
                    standardDeploy(appName: 'MyM3App')
                }
            }
        }

        stage('Final Notification') {
            steps {
                echo "Pipeline terminé avec succès !"
            }
        }
    }
}