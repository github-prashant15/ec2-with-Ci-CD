/* groovylint-disable CompileStatic */
pipeline {
    agent any
    tools {
       terraform 'terraform'
    }
    stages{
        stage ('Pull'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/github-prashant15/ec2-with-Ci-CD.git']]])

            }
        }
        stage ("terraform init") {
            steps {
               sh 'terraform init'
            }
        }

        stage ('terraform Apply') {
            steps {
                sh 'terraform apply  --auto-approve'
            }
        }

    }
}
