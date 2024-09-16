pipeline {
environment {
    dockerimagename = "adenli/mvn1"
    dockerImage = ""
  }
    agent any

    tools{
        maven 'maven'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'dockerhublogin', url: 'https://github.com/adenali20/mvn1.git']])
                sh 'mvn clean install'
            }
        }
        stage("build & SonarQube analysis") {
                  node {
                      withSonarQubeEnv('My SonarQube Server') {
                         sh 'mvn clean package sonar:sonar'
                      }
                  }
              }

              stage("Quality Gate"){
                  timeout(time: 1, unit: 'HOURS') {
                      def qg = waitForQualityGate()
                      if (qg.status != 'OK') {
                          error "Pipeline aborted due to quality gate failure: ${qg.status}"
                      }
                  }
              }
        stage('Build image') {
              steps{
                script {
                  dockerImage = docker.build dockerimagename
                }
              }
            }
        stage('Pushing Image') {
              environment {
                       registryCredential = 'dockerhublogin'
                   }
              steps{
                script {
                  docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
                    dockerImage.push("latest")
                  }
                }
              }
            }
//         stage('Build docker image'){
//             steps{
//                 script{
//                     sh 'docker build -t javatechie/devops-integration .'
//                 }
//             }
//         }
//         stage('Push image to Hub'){
//             steps{
//                 script{
//                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
//                    sh 'docker login -u javatechie -p ${dockerhubpwd}'
//                    }
//                    sh 'docker push javatechie/devops-integration'
//                 }
//             }
//         }
//         stage('Deploy to k8s'){
//             steps{
//                 script{
//                     kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8sconfigpwd')
//                 }
//             }
//         }
    }
}