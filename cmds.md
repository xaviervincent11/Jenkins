# Docker build & run Jenkins with plugins

docker build -t my-jenkins-with-plugins .

```bash
docker run -p 8080:8080 -p 50000:50000 -d \
  -v jenkins_home:/var/jenkins_home \
  --name jenkins-m3 \
  my-jenkins
```

## Helm templates demo

```bash
helm lint ./helm-templates-demo
helm template demo ./helm-templates-demo

# Try conditional rendering
helm template demo ./helm-templates-demo --set ingress.enabled=false --set autoscaling.enabled=false
```




