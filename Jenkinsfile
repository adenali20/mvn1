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
        stage('Git Checkout & Compile'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'dockerhublogin', url: 'https://github.com/adenali20/mvn1.git']])
                sh "mvn clean compile"
            }
        }


        // stage('Code Analysis') {
        //     environment {
        //         scannerHome = tool 'Sonar'
        //     }
        //      steps {
        //         script {
        //             withSonarQubeEnv('Sonar') {
        //                 sh "${scannerHome}/bin/sonar-scanner \
        //                     -Dsonar.projectKey=syl_test \
        //                     -Dsonar.projectName=syl_test \
        //                     -Dsonar.projectVersion=1.0 \
        //                     -Dsonar.java.binaries=target/classes \
        //                     -Dsonar.sourceEncoding=UTF-8 \
        //                     -Dsonar.tests=src/test  \
        //                     -Dsonar.dynamicAnalysis=reuseReports \
        //                     -Dsonar.junit.reportsPath=target/surefire-reports \
        //                     -Dsonar.java.coveragePlugin=jacoco \
        //                     -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml \
        //                     -Dsonar.sources=src/main"
        //             }
        //         }
        //         echo "code scanning completed..."
        //     }
        // }
        //   stage("OWASP Dependency Check"){
        //     steps{
        //         dependencyCheck additionalArguments: '--scan ./ --format HTML ', odcInstallation: 'DP'
        //         dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
        //     }
        // }

         stage("Build"){
            steps{
                sh " mvn clean install"
            }
        }

        stage('Build Docker image') {
              steps{
                script {
                  dockerImage = docker.build dockerimagename
                }
              }
            }
        stage('Push image to Hub') {
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
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8secret2')
                }
            }
        }
    }
}
