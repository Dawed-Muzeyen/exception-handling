pipeline {
  agent any
  stages {
    stage('Compile Stage') {
      steps {
        withMaven(maven : maven) {
          sh 'mvn clean'
        }
      }
      }
    stage('Testing Stage') {
          steps {
            withMaven(maven : maven) {
              sh 'mvn test'
            }
          }
          }
    stage('Packagin Stage') {
          steps {
            withMaven(maven : maven) {
              sh 'mvn package'
            }
          }
          }
    stage('Installing Stage') {
          steps {
            withMaven(maven : maven) {
              sh 'mvn install'
            }
          }
          }
  }
}