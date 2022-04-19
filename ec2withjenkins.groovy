pipeline{
    agent any
    tools {
       terraform 'terraform'
    }
    stages{
        stage('Pull'){
            steps{
                git 'https://github.com/easyawslearn/terraform-aws-instance.git'

            }
        }
        stage('Terraform Init'){
            steps{
                sh '''terraform int'''
            }
        }
        stage('Terraform apply'){
            steps{
                sh '''terraform apply --auto-approve'''
            }
        }

    }
}