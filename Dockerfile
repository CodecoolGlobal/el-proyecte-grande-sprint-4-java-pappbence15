# syntax=docker/dockerfile:1
FROM maven

WORKDIR /REST-api

COPY . .

RUN mvn dependency:go-offline

CMD ["bash", "run.sh"]


