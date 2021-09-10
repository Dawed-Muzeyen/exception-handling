pipeline {
  agent any
 
 // CODE_CHANGES = getChanges() // this is the groovy method to be implemented
  environment {
       PATH = "C:/apache-maven-3.8.1/bin:$PATH"
      NEW_VERSION = '1.3.0'
    }
  stages {
     stage('Clone COde') {
      steps {
   git branch: 'main', changelog: false, credentialsId: 'MyGitHub', poll: false, url: 'https://github.com/Dawed-Muzeyen/exception-handling.git'
      }}
    stage('Compile Stage') {
      steps {
        echo "Compiling a new version ${NEW_VERSION}"
        echo ${GIT_AUTHOR_EMAIL}
          bat "mvn clean"
        
      }
      }
    stage('Testing Stage') {
      
       when {
        expression {
          BRANCH_NAME == 'dev' && CODE_CHANGES == 'master'
        }
      }
          steps {
          
              bat 'mvn test'
            
          }
          }
    stage('Packagin Stage') {
      when {
        expression {
          BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
        }
      }
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
      echo "Alwyas ok"
    }
    success {
      echo "we are successful"
    }
    failure {
      echo "good to know the failure"
    }
  }
}
