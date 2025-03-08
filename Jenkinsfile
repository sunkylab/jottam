pipeline {
    agent any  // Runs on any available agent

    environment {
        DOCKER_IMAGE = 'jottam'
        DOCKER_TAG = 'latest'
        DEPLOY_SERVER = 'your-server-ip'
        DEPLOY_DIR = '/var/www/app'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'git@github.com:your-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'gradle clean build'  // Use 'mvn package' for Maven
            }
        }

        stage('Test') {
            steps {
                sh 'gradle test'  // Run tests
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    sh "docker build -t $DOCKER_IMAGE:$DOCKER_TAG ."
                    sh "docker tag $DOCKER_IMAGE:$DOCKER_TAG your-dockerhub/$DOCKER_IMAGE:$DOCKER_TAG"
                    sh "docker push your-dockerhub/$DOCKER_IMAGE:$DOCKER_TAG"
                }
            }
        }

        stage('Deploy') {
            steps {
                sshagent(['jenkins-ssh-key']) {
                    sh """
                    ssh user@$DEPLOY_SERVER '
                    docker pull your-dockerhub/$DOCKER_IMAGE:$DOCKER_TAG &&
                    docker stop app || true &&
                    docker rm app || true &&
                    docker run -d --name app -p 8080:8080 your-dockerhub/$DOCKER_IMAGE:$DOCKER_TAG
                    '
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Build or deployment failed!'
        }
    }
}
