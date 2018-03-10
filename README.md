# demo-MVC
demo project for spring in mvc

Setup in done via intellij so .idea has preset configs.
change path variables accordingly if needed. 

dependency
tomcat 8.5
mysql-connector 5.1.2
spring 4.3.14.RELEASE
Hibernate 5.2.14
thymeleaf tiles2 integration
servlet 3.0.1  

##
Artifact configs
make a Web-app:exploded artifact
with WEB-INF of build and web facet resources
web facet resource include:
simple path to deployemt descriptor i.e WEB.xml (though not using it yet!!)

###
SLF4j or other impl not added yet 

#NOTE
We used class as deployment descriptor so needed to renamed web.xml and comment dispatchor xml path.


