FROM jenkins/jenkins:lts-jdk17

USER root

ARG HELM_VERSION=v4.1.4

RUN apt-get update \
	&& apt-get install -y --no-install-recommends ca-certificates curl tar \
	&& rm -rf /var/lib/apt/lists/*

RUN set -eux; \
	ARCH="$(dpkg --print-architecture)"; \
	case "${ARCH}" in \
		amd64) HELM_ARCH="amd64" ;; \
		arm64) HELM_ARCH="arm64" ;; \
		*) echo "Unsupported architecture: ${ARCH}"; exit 1 ;; \
	esac; \
	curl -fsSL "https://get.helm.sh/helm-${HELM_VERSION}-linux-${HELM_ARCH}.tar.gz" -o /tmp/helm.tar.gz; \
	tar -xzf /tmp/helm.tar.gz -C /tmp; \
	mv "/tmp/linux-${HELM_ARCH}/helm" /usr/local/bin/helm; \
	chmod +x /usr/local/bin/helm; \
	rm -rf /tmp/helm.tar.gz "/tmp/linux-${HELM_ARCH}"

# Install the Locale plugin automatically
RUN jenkins-plugin-cli --plugins locale:614.va_6a_5a_1a_f2b_38
RUN jenkins-plugin-cli --plugins pipeline-stage-view

USER jenkins