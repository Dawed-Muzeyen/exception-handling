pipeline {
  agent any
  environment {
       PATH = "C:/apache-maven-3.8.1/bin:$PATH"
      
    }
  stages {
     stage('Clone COde') {
      steps {
   git branch: 'main', changelog: false, credentialsId: 'MyGitHub', poll: false, url: 'https://github.com/Dawed-Muzeyen/exception-handling.git'
      }}
    stage('Compile Stage') {
      steps {
     
          bat "mvn clean"
        
      }
      }
    stage('Testing Stage') {
          steps {
          
              bat 'mvn test'
            
          }
          }
    stage('Packagin Stage') {
          steps {
        
              bat 'mvn package'
            
          }
          }
    stage('Installing Stage') {
          steps {
         
              bat 'mvn install'
            
          }
          }
  }
  post {
    always {
      echo "it is always executed!"
    }
    success {
      echo "we are successful"
    }
    failure {
      echo "good to know the failure"
    }
  }
}
