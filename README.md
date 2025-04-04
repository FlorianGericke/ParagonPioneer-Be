# Back-End Documentation
This document provides a comprehensive guide for setting up and running the back-end environment for our application. It outlines the requirements, steps to set up the database, and instructions to run the application.
## Requirements
Before proceeding, ensure you have the following prerequisites installed on your system:
- **Java** 17: Required for running the application.
- **Gradle**: Used for building and running the application.
- **MySQL 8.1.0** or **Docker**: MySQL for database management, Docker for containerization. Rancher can be used as an alternative for Docker.

## Setting Up the Back End

### Create local.env file

```dotenv
# Mysql environment variables
MYSQL_ROOT_PASSWORD=password_for_local_mysql_root
MYSQL_DATABASE=ppAssemblyLineBa # Database name No need to change
MYSQL_USER=paragon-user # Database user No need to change
MYSQL_PASSWORD=password_for_local_mysql_user
MYSQL_DATABASE_URL=127.0.0.1 # Database URL No need to change

# API environment variables
API_ADDRESS=localhost # API Domain No need to change
API_PORT=8080 # API Port No need to change
ADMIN_USER=email_to_login_as_admin
ADMIN_PASSWORD=lpassword_to_login_as_admin

# Open Api Spec
OPEN_API_ADDRESS=localhost # Open API Domain No need to change
```

### Database Setup

You have two options for setting up the database: using a local MySQL server or Docker.

#### Using Docker
To create and start the Docker environment, execute:
    
```bash
  make dev_enviroment
```

To stop the Docker environment:

```bash
 make stop_dev_enviroment
```

To reset the Docker environment to its initial state:

```bash
 make rebuild_dev_enviroment
```

#### Using Local MySQL Server

1. Ensure MySQL is installed and running.

2. Adjust [local.env]('create-local.env-file') file with your MySQL credentials.


### Running the Application

1. To Run the app in intellij you need to add the local.env file to the run configuration.
2. Go to your Run Configurations and click edit configurations.
3. Enable the checkbox "Enable EnvFile"
4. Add the path to the local.env in your configuration."

#### With Docker
To run both the database and application using Docker, execute:

```bash
    make deploy_enviroment
```

To stop the Docker environment:

```bash
    make stop_deploy_enviroment
```

To reset the Docker environment to its initial state:

```bash
    make rebuild_deploy_enviroment
```

You can Stop all Containers with:

```bash
    make stop_all
```

### 3. Access the Application

Now that the application is running, you can access it via the following URL:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

All available endpoints are listed here. You Should be able to use all GET Requests without any problems.
For POST, PUT and DELETE requests, you will need to authenticate yourself. To do this, you can use the following credentials:

    email: your_email_from_local.env
    password: your_password_from_local.env

These Credentials are only for testing purposes. In a real application, you would need to create your own user and request 
Admin Access from the Owner of the Application.

## Api Documentation

[Klassen Diagram](./Documentation/code/src.png)

[Java Doc](https://htmlpreview.github.io/?https://raw.githubusercontent.com/LF12-ParagonPioneer/ParagonPioneer-Be/main/Documentation/Java/index.html)

## Database UML

[UML Diagram](./Documentation/Database/ppAssemblyLineBa.png)

