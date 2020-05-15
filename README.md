# Domain Event Dispatching Service
Sample Simple Microservice

## SpringBoot Service
- Configuration
    - Refer `application.properties`
- Tests
	- Unit Tests - `mvn test`
	- Integration Tests - `mvn verify`
		- Application Profile for tests is `staging`
		- Use spring-contract-verifier and exports stub to repository

_Note_: Skip Tests with `-DskipTests` , `-Dit.skip=true`

## Downstream Services
catalog-service
