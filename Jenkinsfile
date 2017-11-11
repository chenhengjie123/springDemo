pipeline {
    agent mac 
    stages {
        stage('Build') {
            steps {
                sh './mvnw build'
            }
        }
        stage('Sonar scan') {
            steps {
                sh './mvnw sonar:sonar -Dsonar.host.url=http://192.168.1.215:9000 -Dsonar.login=868e2116f0b059b007f210e301cef6a4a4ff1b31'
            }
        }
    }
}
