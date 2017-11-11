pipeline {
    agent {
        node {
            label 'mac'
        }
    } 
    stages {
        stage('Build') {
            steps {
                // show current path
                sh 'echo `pwd`'
                // build
                sh 'mvn build'
            }
        }
        stage('Sonar scan') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.215:9000 -Dsonar.login=868e2116f0b059b007f210e301cef6a4a4ff1b31'
            }
        }
    }
}
