# oesm
online exam system(shit) manager(mountain)💩

## Prerequest
- Openjdk-17
- node-18
- mysql-8

## How to *run this project* ?

### First step! The *MOST* crutial part
Don't panic!

### Prepare your database:
- You can use the data prepared in data/backup.sql, exec command below:

```bash
cat backup.sql | mysql -u root --password=z oesm
# mysql in docker? exec command below!
cat backup.sql | docker exec -i <your-container-name> /usr/bin/mysql -u root --password=z oesm

```

```yaml
# modify this file, change the port and database to your own database.
# oesm/backend/oesm/src/main/resources/application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:8888/oesm
    username: root
    password: z
```

### Run backend
open backend/oesm/ with idea, right click pom.xml and load as maven project.

### Run frontend
open frontend/oesm with vscode
run command below:
```bash
yarn
yarn serve
```
[No yarn? click here!](https://classic.yarnpkg.com/lang/en/docs/install/#windows-stable)

you can login as teacher: 
- `username: teacher`
- `password: teacher`

### Note: the upload csv function
the sample data format is in `frontend/oesm/data/*.csv`