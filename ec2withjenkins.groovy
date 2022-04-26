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
               sh ('terraform init')
            }
        }

        stage ('terraform Apply') {
            steps {
                echo "Terraform action is --> ${action}"
                sh ('terraform ${action} --auto-approve')
            }
        }

    }
}
