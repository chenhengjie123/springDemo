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
                sh 'mvn clean install'
            }
        }
        stage('Sonar scan') {
            steps {
                // 尝试加上扫描后不通过自动失败
                withSonarQubeEnv('SonarQube') {
                    // sonar 扫描
                    // TODO: sonar地址、token等应放在项目自身的 pom.xml 文件中
                    sh "mvn sonar:sonar -Dsonar.host.url=http://192.168.1.215:9000 -Dsonar.login=868e2116f0b059b007f210e301cef6a4a4ff1b31"
                }
                script {
                    timeout(10) { 
                        //利用sonar webhook功能通知pipeline代码检测结果，未通过质量阈，pipeline将会fail
                        def qg = waitForQualityGate() 
                        if (qg.status != 'OK') {
                            error "未通过Sonarqube的代码质量阈检查，请及时修改！failure: ${qg.status}"
                        }
                    }
                }
            }
        }
    }
}
