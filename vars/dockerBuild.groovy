def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=4c0a1f395fmsh41a8613e1b953e0p16789ejsn208365f2effa -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker_cred']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
