FROM debian:stable-20240311

COPY /usr/local/share/ca-certificates/zscaler-ca.crt /usr/local/share/ca-certificates/zscaler-ca.crt

RUN apt-get update && \
    apt-get install -y gnupg ca-certificates curl && \
    update-ca-certificates && \
    curl -s https://repos.azul.com/azul-repo.key | gpg --dearmor -o /usr/share/keyrings/azul.gpg && \
    echo "deb [signed-by=/usr/share/keyrings/azul.gpg] https://repos.azul.com/zulu/deb stable main" | tee /etc/apt/sources.list.d/zulu.list && \
    apt-get update && \
    apt-get install -y zulu21-jre && \
    useradd -ms /bin/bash app

USER app

WORKDIR /app
