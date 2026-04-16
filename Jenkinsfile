@Library('my-shared-library@main') _

pipeline {
    agent any
    stages {
        stage('Local Initial Check') {
            steps {
                echo "Vérification locale sur mon Mac M3..."
            }
        }
        stage('Main Pipeline') {
            steps {
                // On appelle le template ici
                standardDeploy(appName: 'MyM3App')
            }
        }
    }
}