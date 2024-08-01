pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'mpcibeira'
        DOCKERHUB_REPO = 'mpcibeira/jenkins' 
    }

    stages {
        stage('Checkout SCM') {
            steps {
                script {
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/Paula-Cibeira/final-isa-v5', credentialsId: '0528de17-5f6e-4fcb-b010-6367765ddbde']]])
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def customImage = docker.build("$DOCKERHUB_REPO")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS_ID) {
                        customImage.push('latest')
                    }
                }
            }
        }
    }
}
