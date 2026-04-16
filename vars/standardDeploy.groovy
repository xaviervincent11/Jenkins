def call(Map config = [:]) {
    pipeline {
        agent any
        
        parameters {
            choice(name: 'ENVIRONMENT', choices: ['Dev', 'Staging', 'Prod'], description: 'Target Environment')
            string(name: 'VERSION', defaultValue: '1.0.0', description: 'Build version')
        }

        stages {
            stage('Build') {
                steps {
                    echo "--- Building ${config.appName} ---"
                    // Simulation d'une compilation
                    sh 'echo "Compiling code..." && sleep 2'
                }
            }

            stage('Test') {
                steps {
                    echo "--- Running Unit Tests ---"
                    sh 'echo "Tests passed!"'
                }
            }

            stage('Security Scan') {
                steps {
                    echo "--- Scanning for vulnerabilities ---"
                    sh 'echo "No high vulnerabilities found."'
                }
            }

            stage('Deploy') {
                steps {
                    echo "--- Deploying ${config.appName} v${params.VERSION} to ${params.ENVIRONMENT} ---"
                    // Utilisation des paramètres choisis par l'utilisateur
                    sh "echo 'Deploying to ${params.ENVIRONMENT}...'"
                }
            }
        }
    }
}