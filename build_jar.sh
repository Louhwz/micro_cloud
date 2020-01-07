#!/bin/bash

echo '============================================================='
echo '$                                                           $'
echo '$                      Louhwz                               $'
echo '$                                                           $'
echo '$  email:    19212010032@fudan.edu.cn                       $'
echo '$                                                           $'
echo '============================================================='
echo '.'

cd micro_sbdata
mvn clean package -DskipTests

cd ..

docker-compose build
docker-compose down
docker-compose up -d