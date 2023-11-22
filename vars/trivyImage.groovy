def call() {
    sh 'trivy image 5b5anuroop/youtube:latest > trivyimage.txt'
}
