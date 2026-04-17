// vars/standardDeploy.groovy
def call(Map config = [:]) {
    String chartPath = config.chartPath ?: './helm-templates-demo'
    String releaseName = config.releaseName ?: config.appName?.toLowerCase()?.replaceAll(/[^a-z0-9-]/, '-')
    String envName = params.ENVIRONMENT.toString().toLowerCase()
    String namespace = config.namespace ?: "${envName}"

    // Note : On n'écrit PAS "pipeline {}" ici
    stage('Build') {
        echo "[Build] START - ${new Date()}"
        sh 'helm version --short'
        sh "helm lint ${chartPath}"
        echo "[Build] END - ${new Date()}"
    }
    stage('Test') {
        echo "[Test] START - ${new Date()}"
        sh "helm template ${releaseName}-${envName} ${chartPath} --set image.tag=${params.APP_VERSION} > rendered-${envName}.yaml"
        sh "wc -l rendered-${envName}.yaml"
        echo "[Test] END - ${new Date()}"
    }
    stage('Security') {
        echo "[Security] START - ${new Date()}"
        echo "[Security] Placeholder: integrate chart security checks (e.g. Trivy/Checkov)"
        echo "[Security] END - ${new Date()}"
    }
    stage('Deploy') {
        echo "[Deploy] START - ${new Date()}"
        echo "[Deploy] Waiting for manual approval..."
        // input message: "Approve deployment of ${config.appName}:${params.APP_VERSION} to ${params.ENVIRONMENT}?", ok: 'Yes'
        // echo "[Deploy] Approval received. Continuing deployment stage."
        // if (params.DRY_RUN) {
        //     echo "[Deploy] DRY RUN enabled - no deployment changes will be applied to ${params.ENVIRONMENT}."
        //     sh "helm upgrade --install ${releaseName}-${envName} ${chartPath} --namespace ${namespace} --create-namespace --set image.tag=${params.APP_VERSION} --dry-run --debug"
        // } else {
        //     sh "helm upgrade --install ${releaseName}-${envName} ${chartPath} --namespace ${namespace} --create-namespace --set image.tag=${params.APP_VERSION}"
        // }
        echo "[Deploy] END - ${new Date()}"
    }
}