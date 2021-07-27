port des micro service:
APIgateway: 4000
ManageUser: 4040
MarketManager:5000
EducationManager:7000



varialbe d'environnement:
export $URL_MANAGE_USER =  http://localhost:4040
export $URL_BUISNESS_LOGIC =   http://localhost:5000

 http://localhost:4040
 http://localhost:5000


base postgres:
		addresse: localhost:5432/userdb
		username=tcatonet
		password=postgres


utiliser maven

pour lancer une api éxécuter le code:

NomMicroservice/src/main/java/com.under.demo.security/StartMonMicroservice.java
ou 
NomMicroservice/src/main/java/com/under/demo/security/StartMonMicroservice.java

bd à mettre dans ResourceMicroservice: 

installation kafka:

télécharger

https://apache.mediamirrors.org/kafka/2.8.0/kafka_2.13-2.8.0.tgz
tar -xzf kafka_2.13-2.8.0.tgz
cd kafka_2.13-2.8.0
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
