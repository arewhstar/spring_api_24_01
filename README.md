# spring_api_24_01

1. Install Docker, docker-compse.

2. In the docker-compose.yml change the version to your current docker compose version.

3. Run the docker-compse.yml : docker-compose up

When the contaiers are built up, a spring application and postgresql database are available.
Spring port: 6868
database: 5433

You can manage person entites through the spring application by REST request.

GET - /person?id=
GET - /people
POST - /person
PUT - /person?id=
DELETE - /person?id=

Note:

PersonRepositoryTests.java
These unit tests are worked only in locally, not in docker environment, so the tests are commented. Fixing database connenction reference is still needed.

application.properties
This should be overwritten by the given properties in docker-compose.yml, but still cause trobule. The related properties are commented for the smooth running in docker.



