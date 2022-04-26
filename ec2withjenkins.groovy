/* groovylint-disable CompileStatic */
pipeline {
    agent any
    tools {
       terraform 'terraform'
    }
    stages{
        stage('Pull'){
            steps{
                git 'https://github.com/github-prashant15/ec2-instaces.git'

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