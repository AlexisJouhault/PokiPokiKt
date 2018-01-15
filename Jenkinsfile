pipeline {
    agent any

    environment {
        flavor = ''

    }

    stages {

        // Mark the code checkout 'stage'....
        stage ('Stage Checkout') {
            steps {
                // Checkout code from repository and update any submodules
                checkout scm
                sh 'git submodule update --init'
            }
        }

        stage('Stage Build') {
            steps {
                //branch name from Jenkins environment variables
                echo "My branch is: ${env.GIT_BRANCH}"

                //build your gradle flavor, passes the current build number as a parameter to gradle
                sh "./gradlew clean assembleDebug -PBUILD_NUMBER=${env.BUILD_NUMBER}"
            }
        }

        stage('Stage Archive') {
            steps {
                //tell Jenkins to archive the apks
                archiveArtifacts artifacts: 'app/build/outputs/apk/*.apk', fingerprint: true
            }
        }

        /*
        stage('Stage Upload To Fabric') {
            sh "./gradlew crashlyticsUploadDistribution${flavor}Debug  -PBUILD_NUMBER=${env.BUILD_NUMBER}"
        }
        */
    }
}
