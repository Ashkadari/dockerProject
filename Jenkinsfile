pipeline {
    agent none
    stages {
        stage('Build Jar') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                	app = docker.build("vinsdocker/selenium-docker")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}

// for windows and mac machine
// pipeline {
//     // master executor should be set to 0
//     agent any
//     stages {
//         stage('Build Jar') {
//             steps {
//                 //bat -> windows
//                 sh "mvn clean package -DskipTests"
//             }
//         }
//         stage('Build Image') {
//             steps {
//                 //bat
//                 sh "docker build -t='vinsdocker/selenium-docker' ."
//             }
//         }
//         stage('Push Image') {
//             steps {
// 			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
//                     //bat
// 			        sh "docker login --username=${user} --password=${pass}"
// 			        sh "docker push vinsdocker/selenium-docker:latest"
// 			    }
//             }
//         }
//     }
// }