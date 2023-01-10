#!/usr/bin/env sh

cd CrudChatyMensajes/api-chat
mvn clean package 

cd ..
cd ..

cd CrudUsuarios/api-usuarios
mvn clean package 

cd ..
cd ..

cd CrudAmigos/api-amigos
mvn clean package

cd ..
cd ..

cd SpringBootAdmin/service-monitoreo
mvn clean package

cd ..
cd ..

cd ServiceDiscovery/service-discovery
mvn clean package

docker-compose up --build

docker-compose stop
docker-compose kill
docker-compose rm -f
