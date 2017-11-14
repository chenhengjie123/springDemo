pipeline {
    agent any
    //{
        //node {
        //    label 'mac'
        //}
    //}
    tools {
        // use tools in Manage Jenkins → Global Tool Configuration
        maven 'maven'
    }
    stages {
        stage('Build') {
            steps {
                // show current path
                sh 'echo `pwd`'
                // build
                sh 'mvn clean install'
            }
        }
        stage('Sonar scan') {
            steps {
                // Fail when quality gate is not OK
                // reference: https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Jenkins#AnalyzingwithSonarQubeScannerforJenkins-AnalyzinginaJenkinspipeline
                withSonarQubeEnv('SonarQube') { // Need to set Sonar qube server named as SonarQube in Jenkins
                    // sonar 扫描
                    // TODO: sonar地址、token等应放在项目自身的 pom.xml 文件中
                    sh "mvn sonar:sonar -Dsonar.host.url=http://192.168.1.215:9000 -Dsonar.login=868e2116f0b059b007f210e301cef6a4a4ff1b31"
                }
                script {
                    timeout(time: 10, unit: 'MINUTES') {
                        def qg = waitForQualityGate() 
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }
            }
        }
        stage('api test') {
            steps {
                def gitUrl = 'https://github.com/chenhengjie123/springDemo.git'
                def mvnCommand = 'mvn test'

                // git clone && run test
                sh "git clone "${gitUrl}" apiTest && cd apiTest && "${mvnCommand}
            }
        }
    }
}
