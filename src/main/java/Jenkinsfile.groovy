pipeline {
    agent {
        label 'ubuntu'
    }
    stages {
        stage('Build Success') {
            steps {
                sh 'mvn -B -DskipTests clean install'
            }
        }
        
        stage('Test Success') {
            steps {
                sh 'mvn test -PtestSuccess'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage ('Test Unstable') {
            steps {
                sh 'mvn test -PtestFailure'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        // stage ('Build Failure') {
        //     steps {
        //         sh 'mvn -B -DskipTests -PbuildFailure clean install'
        //     }
        // }
    }
}