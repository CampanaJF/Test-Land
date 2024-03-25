# Microservicio de CONFIG-SERVER

## Como Generar .JAR de config-server

Adentro de la carpeta que tenga el pom del MS correr por consola el comando: mvn package

El archivo .JAR se genera dentro de la carpeta target.

## Como Correr el .JAR Generado

En la carpeta donde se encuentra el .JAR ejecutar el siguiente comando pro consola:
java -jar config-server-0.0.1-SNAPSHOT.jar --gitUser={usernameBitBucket}  --gitToken={tokenBitBucket}

- tokenBitBucket debe tener permisos de lectura

