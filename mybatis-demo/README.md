# MyBatis Demo

This small Maven project demonstrates using MyBatis to perform CRUD on the `students` table in the `score_management_system` database.

Prerequisites
- Docker (to run the provided MySQL container)
- Maven
- Java 11+

Run steps

1. Start the MySQL container (it runs initialization from `init.sql`):

```bash
docker-compose up -d
```

2. Build and run the demo from the `mybatis-demo` folder:

```bash
cd mybatis-demo
mvn -q compile exec:java
```

The demo will:
- List all students
- Insert a demo student
- Update and query the demo student
- Run a dynamic multi-condition query
- Delete the demo student

If you want to change DB credentials, edit `src/main/resources/mybatis-config.xml`.
