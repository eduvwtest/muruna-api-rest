# muruna-api-rest

El proyecto muruna-api-rest ha sido desarrollado durante el proceso de postulación con la empresa muruna.
## Tecnologías Utilizadas

A continuacion se muestran las tecnologias utilizadas para desarrollar este producto de software:

- Java v17/v22
- Spring Boot v3.3.0
- Acceso a Datos Spring JPA
- Base de datos H2 2.2.224
- Gestion de librerias Maven
- Generacion de tokens utilizando JWT
- Unit Tests usando MockMVC
- Swagger MVC UI v2.3.0


## Requisitos Previos

- Insalar Cliente Git en su máquina local https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
- Instalar JDK 17+ en su entorno de trabajo https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- Instalar Maven 3.9.6 en su entorno de trabajo https://maven.apache.org/download.cgi


## Ejecución

- Ejecute el comando `cmd`
- Desde el directorio raiz agregue el siguiente directorio `murunaApiRest`, ejemplo `C:\mkdir murunaApiRest`
- Desde el directorio raiz ingrese al nuevo directorio, ejemplo `cd murunaApiRest`
- Clonar el repositorio desde Github, utilizando el comando `git clone git@github.com:eduvwtest/muruna-api-rest.git`
- Desde el directorio murunaApiRest, ingresar al directorio `muruna-api-rest`, ejemplo `C:\murunaApiRest\cd muruna-api-rest`
- Ejecutar el comando `.\mvnw spring-boot:run`

## Uso

- Una vez inicializado el proyecto desde la ventana de consola, abra una pagina de browser e ingrese a la siguiente URL `http://localhost:8088/api/swagger-ui/index.html#/`

## Pruebas

Desde la pagina `http://localhost:8088/api/swagger-ui/index.html#/` puede ejecutar el caso de prueba que se muestra

- Presione el boton `Try it out`
- Presione el boton `Execute`
- Resultados presentados

Curl
curl -X 'POST' \
  'http://localhost:8088/v1/create' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "phones": [
    {
      "number": 12345678,
      "citycode": 0,
      "countrycode": 56
    }
  ],
  "name": "Juan Perez",
  "email": "juan@perez",
  "password": "juan$Perez"
}'

Request URL
http://localhost:8088/v1/create


Code	
201	

Details
Response body
Download
{
  "userId": "3deb4af8-e451-402a-9474-64f4ffdb7cbb",
  "phones": [
    {
      "id": 2,
      "number": 12345678,
      "citycode": 0,
      "countrycode": 56
    }
  ],
  "name": "Juan Perez",
  "email": "juan@perez",
  "password": "juan$Perez",
  "created": "2024-06-15T15:44:01.043+00:00",
  "modified": "2024-06-15T15:44:01.043+00:00",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFuQHBlcmV6IiwiaWF0IjoxNzE4NDY2MjQxLCJleHAiOjE3MTg0Njk4NDF9.moqnJpF_i_HqTIhy_K6zU1ZwffyxZjRGGWfWbf9ZFDw",
  "isactive": true
}


## Licencia

- Licencia proyecto de pruebas no uso comercial.

## Contacto

- Autor: Eduardo Vasquez W
- Email: eduardo.vw@gmail.com


### Conclusión

El proyecto murunaApiRest permite explorar las tecnologias Spring Boot, Maven y la base de datos H2. A traves de Maven es posible ejecutar el proyecto para su revision desde una pagina web utilizando `Swagger`.

Puede buscar mas informacion acerca del esquema de datos utilizados en la aplicacion y de la intereaccion de los objetos para la ejecucion del proceso de creacion y validacion de usuarios.