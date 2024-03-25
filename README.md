# README


## Instructivo para iniciar los MS

- Levantar eureka.
- Levantar config-server.
- Levantar gateway.

## IMPORTANTE

- Utilizar dependencia bootstrap para nuevos microservicios:
    
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-bootstrap</artifactId>
            </dependency>

- Remplazar el nombre del application.properties a bootstrap.yml.

## Nombres y puertos de microservicios

|Nombre Microservicio|Numero de Puerto|
|--|--|
|eureka|8761|
|config-server|8888|
|gateway|8080|
|onboarding|8081|