pipeline {
    agent any

    environment {
        RECIPIENT = 'oguzhanmguclu@gmail.com'
        GIT_CREDENTIALS_ID = 'dc56b904-2c60-4991-91e7-e86def0e981b'
        TARGET_BRANCH = 'master'
        REPO_URL = 'https://github.com/cansu-altunsoy/com.BuySellCycle_1.git'
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: "${env.GIT_CREDENTIALS_ID}", url: "${env.REPO_URL}", branch: "${env.TARGET_BRANCH}"
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Running Maven tests with @E2E'
                bat 'mvn clean install -Dgroups=E2E'
            }
        }

        stage('Push to GitHub') {
            when {
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                echo 'Tests passed, pushing to GitHub...'
                withCredentials([usernamePassword(credentialsId: "${env.GIT_CREDENTIALS_ID}", usernameVariable: 'GIT_USER', passwordVariable: 'GIT_PASS')]) {
                    bat """
                        git config --global user.email "jenkins@example.com"
                        git config --global user.name "Jenkins CI"
                        git remote set-url origin https://${env.GIT_USER}:${env.GIT_PASS}@${env.REPO_URL.replace('https://', '')}
                        git add .
                        git commit -m "Automated commit by Jenkins after successful build" || echo "Nothing to commit"
                        git push origin ${env.TARGET_BRANCH}
                    """
                }
            }
        }
    }

    post {
        failure {
            mail to: "${env.RECIPIENT}",
                 subject: "🚨 Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: """\
Build başarısız oldu.

Detaylar: ${env.BUILD_URL}console
"""
        }
    }
}
