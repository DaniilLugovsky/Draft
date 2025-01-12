pipeline {
    agent any

    tools {
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/DaniilLugovsky/Draft.git'
            }
        }
        stage('Test') {
            steps {
                bat "mvn clean test"
            }

        post {
                        success {
                            junit '**/target/surefire-reports/TEST-*.xml'
                            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
                        }
        }
    }
}