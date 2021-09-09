pipeline {
  agent any
  tools {
        maven 'Maven 3.3.9'
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
