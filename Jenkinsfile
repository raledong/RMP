node {
    stage('SCM') {
        git 'https://github.com/raledong/RMP.git'
    }
    
    stage('QA') {
        def scHome = tool 'sonarqube-scanner'
        sh "${scHome}/bin/sonar-scanner"
    }
    
    stage('build') {
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn -B clean package"
    }
    stage('deploy') {
        sh "docker stop my || true"
        sh "docker rm my || true"
        sh "docker run --name my -p 11111:8080 -d tomcat:9.0"
        sh "docker cp target/RMP-0.0.1-SNAPSHOT.war my:/usr/local/tomcat/webapps/RMP.war"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
