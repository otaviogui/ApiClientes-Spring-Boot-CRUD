# ApiClientes-Spring-Boot
* Project Maven
* Spring Boot
* Spring Data JPA
* MySQL

## HTTPS 

* GET ALL CLIENTES : http://locahost:9080/allClients
* GET BY ONE CLIENTE : http://localhost:9080/client/{id}. | ID is a number int.

* POST NEW CLIENTE : http:/localhost:9080/newClient | if you are going to use a tool like POSTMAN in JSON send any ID, just for application, as it will be responsible for creating the ID automatically. The JSON header must be of type application / json

* PUT CLIENTE : http://localhost:9080/client/{id}
* DELETE CLIENTE: http://localhost:9080/client/{id}
### Atention in send json 
  Header : Content-Type: Application/json
  Field Email, it has to be a real email ( Exemplo: email@hostname.com )
  Field Name it can not be null or empty
  
## STRUCTURE OF PACKAGES PROJECT
* MAIN: com.clientes.APIClientes
* SubPackages: 
* * com.clientes.APIClientes.controller
* * com.clientes.APIClientes.Entitys
* * com.clientes.APIClientes.exception
* * com.clientes.APIClientes.repository
* * com.clientes.APIClientes.services

## ERROR HANDLING - HTTP - RESOLUTION
* "Email nao e valido" - POST - "Verify field E-mail".
* "Esse cliente nao existe, por favor tente novamente" - GET - "Verify ID if is valid"
* "Esse cliente nao existe, por favor tente novamente" - PUT - "Verify ID if is valid "

## ENTITY DDL
CREATE TABLE `ApiClientes`.`clientes` ( `id` INT NOT NULL , `name` VARCHAR(255) NOT NULL , `email` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
* id - int - primary key
* name - varchar(255) - not null
* email - varchar(255) - not null

##CONFIG DEFAULT
* SYSTEM PORT: 9080
* MYSQL PORT: 8889
* MYSQL DBNAME: ApiClientes


##CONFIG PROPERTIES
server.port=9080
spring.datasource.url=jdbc:mysql://localhost:8889/ApiClientes
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.generate-ddl=true
