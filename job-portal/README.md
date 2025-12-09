Job Portal Spring Boot Project
================================

This is a simple Job Application Portal built with Spring Boot, Thymeleaf and H2 in-memory database.

Project structure:
- 4 Entities: User, Job, Applicant, Application
- Repositories: JPA repositories for CRUD
- Controllers: Basic web controllers and REST endpoints
- Templates: Thymeleaf templates for simple UI

How to run in Eclipse:
1. Ensure you have Java 17 and Maven installed.
2. Import -> Existing Maven Projects -> select the extracted folder.
3. Run JobPortalApplication as a Spring Boot application.
4. H2 console: http://localhost:8080/h2-console (jdbc url: jdbc:h2:mem:jobdb)
5. Web UI: http://localhost:8080/

Files included:
- pom.xml
- src/main/java/... (controllers, models, repositories, services)
- src/main/resources/templates (Thymeleaf pages)
- src/main/resources/application.properties

