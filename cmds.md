# Docker build & run Jenkins with plugins

docker build -t my-jenkins-with-plugins .

```bash
docker run -p 8080:8080 -p 50000:50000 -d \
  -v jenkins_home:/var/jenkins_home \
  --name jenkins-m3 \
  my-jenkins
```




