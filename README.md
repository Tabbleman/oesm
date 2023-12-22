# oesm
online exam system(shit) manager(mountain)

## Prerequest
Openjdk-17
node-18

## How to *run this project* ?

### Prepare your database:
- You can use the data prepared in data/backup.sql, exec command below:

```bash
cat backup.sql | mysql -u root --password=z oesm
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
yarn genshin_activate
```