# prova-java

Passos para iniciar o programa utilizando docker:

docker network create prova

docker build -t java-crm-api .

docker run -p 8080:8080 --name java-crm-api --network prova java-crm-api