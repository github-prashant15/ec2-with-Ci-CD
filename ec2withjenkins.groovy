/* groovylint-disable CompileStatic */
pipeline {
    agent any
    tools {
       terraform 'terraform'
    }
    stages{
        stage ('Pull'){
            steps{
                git 'https://github.com/github-prashant15/ec2-instaces.git'

            }
        }
        stage ("terraform init") {
            steps {
               sh 'terraform init'
            }
        }

        stage ("terraform Plan") {
            steps {
               sh 'terraform  plan'
            }
        }
        stage ('terraform Apply') {
            steps {
                sh 'terraform apply --auto-approve'
            }
        }

    }
}
