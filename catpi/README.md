PROJETO PARA API DE CONSUMO CATAPI [SpringBoot](http://projects.spring.io/spring-boot/) RESTful web service aplicação com: 
[Docker](https://www.docker.com/) 
[Sring Data Elasticsearch]https://spring.io/projects/spring-data-elasticsearch)
[Kibana] https://www.elastic.co/guide/en/kibana/current/index.html

#### Pré - requisito

INSTALADO: [Docker](https://www.docker.com/), [Java 1.8](https://www.oracle.com/technetwork/java/javase/overview/index.html), [Maven 3.x](https://maven.apache.org/install.html), [git](https://www.digitalocean.com/community/tutorials/how-to-contribute-to-open-source-getting-started-with-git),  [Docker-Compose](https://docs.docker.com/compose/install/)

#### Documento
https://rodrigolemmocatapi.atlassian.net/wiki/spaces/CATAPI/pages/131093/CASE+ITAU+CATAPI+Rodrigo+Lemmo


#### Steps

##### Clone do código git
```
$  git clone https://github.com/RodrigoLemmo/case/catapi/
```

##### Build/RUN Docker 

docker network create catapinetwork docker pull mysql:latestdocker pull kibana:7.6.2

docker build -t catapi/springboot {caminho DockerFile}

DockerFile está localizado na raiz do projeto

docker run -d --name elasticsearch  -p 9200:9200 --network=catapinetwork -e "discovery.type=single-node" elasticsearch:7.6.2

docker run -d --name kibana -p 5601:5601  -e "http.host=0.0.0.0" -e "transport.host=127.0.0.1" --network=catapinetwork --link elasticsearch:elasticsearch \  docker.elastic.co/kibana/kibana:7.6.2

docker run  -p8080:8080 -e "http.host=0.0.0.0" -e "transport.host=127.0.0.1" --network=catapinetwork --link catapidb:catapidb --link elasticsearch:elasticsearch --name catspring -d catapi/springboot


##### Test application

```
$ curl localhost:8080/servicos/teste
```

a resposta deveria ser:
```
Teste
```

##### Test application with command

junit /catpi/src/test/java/catapi/bancodados/teste/TesteAcessoMySql.java

junit /catpi/src/test/java/catapi/business/teste/TesteBusiness.java

junit /catpi/src/test/java/catapi/configuracao/teste/TesteConfiguracao.java

junit /catpi/src/test/java/catapi/integrador/teste/TesteIntegrador.java

#### Test API

//POSTAMAN Collection
catapicollection.postman_collection.json

/servicos/listarracas/
/servicos/listarracas/
/servicos/listarinformacaoraca/abys
/servicos/listarinformacaotemperamento/Independent/
/servicos/listarinformacaoorigem/Egypt/
/servicos/listarcategoria/
/servicos//gravarimagemtodasracas/1
/servicos/gravarimagemcategoria/1/3
/servicos/gravarimagemcategoria/4/1