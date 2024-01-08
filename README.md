# Back End
## Requirements
- Java 17
- Gradle
- MySQL 8.1.0 or Docker (Rancher can alternatively be used for Docker)

## Set Up the Backend

### 1. Setup Database

To set up the database, you can install a local MySQL server or use Docker. When using Docker, simply run the following command:
    
```bash
 docker-compose up -d
```

To terminate the Docker container, run:

```bash
 docker-compose down
```

Should you not have Docker installed and want to use a local MySQL server, you will need to configure the application with your database.

Go to src/main/application.properties.

The file should look like this:

    spring.jpa.hibernate.ddl-auto=create-drop
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://127.0.0.1:{YourPort}/{YourDatabaseName}
    spring.datasource.username={YourMysqlUserName}
    spring.datasource.password={YourMysqlPassword}
    spring.jpa.show-sql= true

### 2. Run the Application

Once you have set up the application correctly and your database is running, run the following command to start the application.

```bash
    gradle bootRun
```

Or, when using an IDE, execute the main method in:

    java/com/example/paragonPioneerBackend/PpApiApplication.java


## Api Documentation

[Go To Swagger UI](./Documentation/Api/openapi.yaml)

[Klassen Diagram](./Documentation/Code/src.png)

## Database UML

[Go To DB-Diagrams](https://dbdiagram.io/d/PP-PR-655c68de3be14957876943d3)

[UML Diagram](./Documentation/Database/ppAssemblyLineBa.png)

[back](../../README.md)
