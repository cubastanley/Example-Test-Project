pipeline {
  agent any
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
          junit(allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml')
        }
      }
    }

    stage('Test Unstable') {
      steps {
        sh 'mvn test -PtestFailure'
      }
        post {
        always {
          junit(allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml')
        }
      }
    }
  }
}
