pipeline {
  agent any
  tools {
        maven 'maven_8_2'
        jdk 'jdk8'
    }
  stages {
    stage('Compile Stage') {
      steps {
     
          sh 'mvn clean'
        
      }
      }
    stage('Testing Stage') {
          steps {
          
              sh 'mvn test'
            
          }
          }
    stage('Packagin Stage') {
          steps {
        
              sh 'mvn package'
            
          }
          }
    stage('Installing Stage') {
          steps {
         
              sh 'mvn install'
            
          }
          }
  }
}
