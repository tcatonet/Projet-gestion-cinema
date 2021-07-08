port des micro service:

ManageUserMicroservice: 4000
BusinessLogicMicroservice:5000
RecieveDataMicroservice: 6000
InfosAppMicroservice:7000



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
