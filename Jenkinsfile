pipeline {
  agent any
 
 parameters {
  // string(name: 'VERSION', defaultValue:'', desription: 'version to deploy onn prod')
   choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'try choices')
   booleanParam(name: 'executeTests', defaultValue: true, description: 'say to true or false')
 }

 // CODE_CHANGES = getChanges() // this is the groovy method to be implemented
  environment {
       PATH = "C:/apache-maven-3.8.1/bin:$PATH"
      
      NEW_VERSION = '1.3.0'
    SERVER_CREDENTIALS = credentials('dawed-server')
    }
  
   /* tools {
    maven 'maven_8_2'
  }
  */
  stages {
     stage('Clone COde') {
       
      when {
        expression {
          params.executeTests
        }
      }
    
       
       
      steps {
   git branch: 'main', changelog: false, credentialsId: 'MyGitHub', poll: false, url: 'https://github.com/Dawed-Muzeyen/exception-handling.git'
      }}
    stage('Compile Stage') {
      steps {
        echo "Compiling a new version ${NEW_VERSION}"
      //  echo "${GIT_AUTHOR_EMAIL}"
          bat "mvn clean"
        
      }
      }
    stage('Testing Stage') {
      
    /*   when {
        expression {
          BRANCH_NAME == 'dev' && CODE_CHANGES == 'master'
        }
      }
      */
          steps {
          
              bat 'mvn test'
            
          }
          }
    stage('Packagin Stage') {
   /*   when {
        expression {
          BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
        }
      } */
          steps {
             bat 'mvn package'
   /*     withCredentials(
          [
            usernamePassword(credentials: 'server-credentials', 
                             usernameVariable: USER, passwordVariable: PWD)
          ]
        ) 
            {
              bat "SHOWING HOW TO DISPLAY CREDENTIALS ${USER} ${PWD}"
            }
            */
          }
          }
    stage('Installing Stage') {
          steps {
         
              bat 'mvn install'
            echo "installed it successfully ${SERVER_CREDENTIALS}"
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
