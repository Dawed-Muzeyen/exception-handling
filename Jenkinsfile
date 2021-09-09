pipeline {
  agent any
  stages {
    stage('Compile Stage') {
      steps {
        withMaven(maven : 'maven_8_2') {
          sh 'mvn clean'
        }
      }
      }
    stage('Testing Stage') {
          steps {
            withMaven(maven : 'maven_8_2') {
              sh 'mvn test'
            }
          }
          }
    stage('Packagin Stage') {
          steps {
            withMaven(maven : 'maven_8_2') {
              sh 'mvn package'
            }
          }
          }
    stage('Installing Stage') {
          steps {
            withMaven(maven : 'maven_8_2') {
              sh 'mvn install'
            }
          }
          }
  }
}