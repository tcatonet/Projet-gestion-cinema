port des micro service:

APIGateway: 4000
ManageUserMicroservice: 4040
BusinessLogicMicroservice:5000
RecieveDataMicroservice: 6000
InfosAppMicroservice:7000 (pas implémenté pour le moment et pas prioritaire)


base postgres:
		addresse: localhost:5432/userdb
		username=tcatonet
		password=postgres
		
Attention: pour le moment,  l'API gateway utilise l'url localhots pour accéder aux autres API


package: y'a moyen que les dépendances soit tiré à partir du pom.xml au lancement du docker 


            <artifactId>spring-boot-starter-security</artifactId>
            <artifactId>spring-boot-starter-web</artifactId>
            <artifactId>jjwt</artifactId><jjwt.version>0.9.1</jjwt.version>
            <artifactId>jaxb-api</artifactId><jaxb.version>2.3.1</jaxb.version>
            <artifactId>spring-boot-starter-test</artifactId>
            <artifactId>spring-security-test</artifactId>
            <artifactId>jdom</artifactId><version>1.1.3</version>
            <artifactId>postgresql</artifactId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <artifactId>spring-session-core</artifactId>
            <artifactId>spring-session-jdbc</artifactId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
            <artifactId>gson</artifactId><version>2.8.6</version>
            <artifactId>android-json</artifactId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <artifactId>lombok</artifactId>



Ce qu'il se passe au lancement du code:

2021-07-04 02:29:36.563  INFO 43834 --- [           main] c.u.demo.security.SecurityApplication    : Starting SecurityApplication on cat-VirtualBox with PID 43834 (/home/cat/Bureau/projetALJEE/APIGateway/target/classes started by cat in /home/cat/Bureau/projetALJEE/APIGateway)
2021-07-04 02:29:36.573  INFO 43834 --- [           main] c.u.demo.security.SecurityApplication    : No active profile set, falling back to default profiles: default
2021-07-04 02:29:40.990  INFO 43834 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-07-04 02:29:40.991  INFO 43834 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.33]
2021-07-04 02:29:41.250  INFO 43834 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-07-04 02:29:41.645  INFO 43834 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2021-07-04 02:29:41.718  INFO 43834 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.12.Final
2021-07-04 02:29:41.937  INFO 43834 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
2021-07-04 02:29:42.088  INFO 43834 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-07-04 02:29:42.481  INFO 43834 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-07-04 02:29:42.496  INFO 43834 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL10Dialect
2021-07-04 02:29:43.408  INFO 43834 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2021-07-04 02:29:44.129 DEBUG 43834 --- [           main] eGlobalAuthenticationAutowiredConfigurer : Eagerly initializing {webConfig=com.under.demo.security.WebConfig$$EnhancerBySpringCGLIB$$2bf1f609@152035eb}
2021-07-04 02:29:44.345 DEBUG 43834 --- [           main] edFilterInvocationSecurityMetadataSource : Adding web access control expression 'permitAll', for Ant [pattern='/login']
2021-07-04 02:29:44.346 DEBUG 43834 --- [           main] edFilterInvocationSecurityMetadataSource : Adding web access control expression 'permitAll', for Ant [pattern='/create']
2021-07-04 02:29:44.346 DEBUG 43834 --- [           main] edFilterInvocationSecurityMetadataSource : Adding web access control expression 'hasRole('ROLE_USER')', for Ant [pattern='/user/**']
2021-07-04 02:29:44.346 DEBUG 43834 --- [           main] edFilterInvocationSecurityMetadataSource : Adding web access control expression 'hasRole('ROLE_ADMIN')', for Ant [pattern='/admin/**']
2021-07-04 02:29:44.346 DEBUG 43834 --- [           main] edFilterInvocationSecurityMetadataSource : Adding web access control expression 'authenticated', for any request
2021-07-04 02:29:44.367 DEBUG 43834 --- [           main] o.s.s.w.a.i.FilterSecurityInterceptor    : Validated configuration attributes
2021-07-04 02:29:44.369 DEBUG 43834 --- [           main] o.s.s.w.a.i.FilterSecurityInterceptor    : Validated configuration attributes
2021-07-04 02:29:44.371  INFO 43834 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Creating filter chain: any request, [org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@5ee95d42, org.springframework.security.web.context.SecurityContextPersistenceFilter@4f5bfbca, org.springframework.security.web.header.HeaderWriterFilter@7b364f47, org.springframework.web.filter.CorsFilter@52b32622, org.springframework.security.web.authentication.logout.LogoutFilter@2dd46693, com.under.demo.security.security.JWTFilter@7fb1820d, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@3cd6d147, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@49c947f7, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@7e27b77a, org.springframework.security.web.session.SessionManagementFilter@78c23ade, org.springframework.security.web.access.ExceptionTranslationFilter@49ee3b8d, org.springframework.security.web.access.intercept.FilterSecurityInterceptor@7a7bd9a8]
2021-07-04 02:29:44.373  WARN 43834 --- [           main] o.s.s.c.a.web.builders.WebSecurity       : 




utiliser maven

pour lancer une api éxécuter le code:

NomMicroservice/src/main/java/com.under.demo.security/StartMonMicroservice.java
ou 
NomMicroservice/src/main/java/com/under/demo/security/StartMonMicroservice.java

bd à mettre dans ResourceMicroservice: 
