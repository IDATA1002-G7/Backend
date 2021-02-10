# NoProc - Backend

A Maven project using the Spring Framework to create an API backend service together with an PostgresQL database.

## Project setup

To serve this project you will need [Maven](https://maven.apache.org/) installed globally on your computer.

### Install the project dependencies by running the following command:
```
mvn install
```

### Serve the service
To serve, simply run the main function in the [Application class](https://github.com/IDATA1002-G7/Backend/blob/master/src/main/java/edu/ntnu/idata1002g7/Application.java)


## PostgresQL

### Use remote database

To use a remote database, simply enter its url with username and password in the [application.properties](https://github.com/IDATA1002-G7/Backend/blob/master/src/main/resources/application.properties) file.
```
spring.datasource.url=<url>
spring.datasource.username=<username>
spring.datasource.password=<password>
```

### Serve your database locally

If you want to run the database locally, you will need [Docker](https://www.docker.com/) and the [PostgresQL Commandline Tool](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) installed. 

To serve the database use following command:
```
docker-compose up -d
```

To shut it down use:
```
docker-compose down
```

Connect to the database in to PostgresQL by running:
```
psql -d <dbname> -U <username>
```

After connecting in, create the database.
```
CREATE DATABASE <database name>
```

Then grant your user access to the database.
```
GRANT ALL PRIVILEGES ON DATABASE "<database name>" TO <username>
```

Finally, update your [application.properties](https://github.com/IDATA1002-G7/Backend/blob/master/src/main/resources/application.properties) file to use your database credentials.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/<database name>
spring.datasource.username=<username>
spring.datasource.password=<password>
```
