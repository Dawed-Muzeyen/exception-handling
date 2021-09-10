pipeline {
  agent any
  environment {
       PATH = "C:\apache-maven-3.8.1\bin:$PATH"
      
    }
  stages {
     stage('Compile Stage') {
      steps {
    git url: "https://github.com/Dawed-Muzeyen/exception-handling.git"
      }}
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
