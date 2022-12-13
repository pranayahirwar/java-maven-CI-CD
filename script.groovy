def buildApp() {
    echo 'Building Maven Package ...'
    sh "mvn package"
}

def  dockerBuild() {
    echo "Building docker image..."
    sh "docker build -t trymi0/tryout:jam-100.1 ."
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', usernameVariable:'USER', passwordVariable:'PSD')]){
        sh "echo $PSD | docker login -u $USER --password-stdin "
        sh "docker push trymi0/tryout:jam-100.1"
    }
}

def beforProd() {
    echo "Final rechecking before Production"
    // echo "You have chosen ${params.VERSION} during build"
}


return this
