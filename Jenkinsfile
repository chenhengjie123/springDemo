pipeline {
    agent none 
    stages {
        stage('Build') {
            steps {
                sh 'mvn build'
            }
        }
        stage('Sonar scan') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.167:9000 -Dsonar.login=b4d1460d7d90189e14c928ebca2e5b4c283e31ad'
            }
        }
    }
}
