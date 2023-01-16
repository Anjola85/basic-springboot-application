# PREREQUISITE
- Docker
- Java SDK
- IntelliJ IDE
- PostgreSQL

## Running the application
- Run docker compose up -d on terminal
- Press run on intelliJ when source code has been downloaded
- The web server should start running on localhost:8080


## DATABASE SETUP
- `psql -h hostname -U username -d databasename`
- username is likely `127.0.0.1`
- `docker compose ps` :  is a command that is used to list the containers that are running as part of a specific Docker Compose project.
- `docker logs postgres -f` :  is used to view the logs of a running container called "postgres" and the -f option allows the logs to be streamed in real-time. This command will show you the output of the Postgres server, including any error messages or other important information.
- `docker exec -it {container_name} bash` : execute shell commands within the terminal - enter postgres
  - `psql -U {username}` : to connect to the DB
  - `\l` : list databases
  - `CREATE DATABASE customer;` : to create a database called **customer**
  - `\du` : it will show a table with columns for the role name, attributes, and the member roles.
  - Learn more commands...