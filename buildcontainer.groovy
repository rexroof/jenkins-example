pipeline {
  agent {
    kubernetes {
      containerTemplate {
        name 'kaniko'
        image 'gcr.io/kaniko-project/executor:latest'
        ttyEnabled true
        command 'cat'
      }
    }
  }
  stages {
    stage('Echo hi') {
        steps {
            container('kaniko') {
                sh 'echo hi'
            }
        }
    }
  }
}
