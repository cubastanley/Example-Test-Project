pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build Success') {
      steps {
        sh 'mvn -B -DskipTests clear install'
      }
    }

    stage('Test Success') {
      steps {
        sh 'mvn test -PtestSuccess'
      }
    }

    stage('Test Unstable') {
      steps {
        sh 'mvn test -PtestFailure'
        junit(allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml')
      }
    }

  }
}