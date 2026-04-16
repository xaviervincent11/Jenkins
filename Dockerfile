FROM jenkins/jenkins:lts-jdk17

# Install the Locale plugin automatically
RUN jenkins-plugin-cli --plugins locale:614.va_6a_5a_1a_f2b_38
