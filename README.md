# Backoffice gRPC API

A modern gRPC-based backend service demonstrating clean architecture, scalability, and senior-level engineering practices.  
Built with Spring Boot 3, Java 21, PostgreSQL, and gRPC.

---

## 🎯 Project Objective
Build a production-ready gRPC API that:
- Implements **Ports & Adapters (Hexagonal) Architecture**
- Demonstrates robust error handling, observability, and testing strategies
- Serves as a reference implementation for distributed backend systems
- Showcases senior developer skills in API design, infrastructure, and DevOps integration

---

## 📋 Logical TODO List
Follow this sequence for incremental development:

### Phase 1: Foundation Setup
1. [ ] Add Docker Compose for PostgreSQL and pgAdmin
2. [ ] Configure Spotless (code formating)
3. [ ] Set up basic CI pipeline (GitHub Actions)

### Phase 2: Core Domain
4. [ ] Define Protobuf service contracts (`*.proto` files)
5. [ ] Implement base entities and domain models
6. [ ] Create repository interfaces (Ports)

### Phase 3: Business Logic
7. [ ] Implement use cases with domain services
8. [ ] Add gRPC service adapter implementations
9. [ ] Integrate Flyway database migrations

### Phase 4: Enhancements
10. [ ] Add validation (gRPC interceptors + Bean Validation)
11. [ ] Implement global error handling (StatusRuntimeException mapping)
12. [ ] Configure Micrometer metrics and OpenTelemetry tracing
13. [ ] Add structured logging (Logback + JSON formatting)

### Phase 5: Quality Assurance
14. [ ] Write unit tests with JUnit 5 and Mockito
15. [ ] Create integration tests using Testcontainers
16. [ ] Add contract tests for gRPC endpoints
17. [ ] Configure SonarQube for code quality checks

### Phase 6: Deployment Readiness
18. [ ] Build Docker image with JVM/Native compilation
19. [ ] Create Kubernetes deployment manifests
20. [ ] Configure TLS for gRPC endpoints
21. [ ] Implement basic auth/JWT authentication

### Phase 7: Documentation & Observability
22. [ ] Generate OpenAPI documentation via gRPC Gateway
23. [ ] Build operational dashboard (Grafana)
24. [ ] Create architectural decision records (ADRs)

---

## 🏛 Architecture: Ports & Adapters

```text
                          +----------------+
                          |   gRPC Adapter |
                          +--------+-------+
                                   ▲
                                   │ serves
                                   │
+-------------+        +-----------v-----------+        +-------------+
|   Domain    |        |     Application       |        | Infrastructure |
|  (Entities, |◀------▶|  (Use Cases, Ports)   |◀------▶|  (DB Adapters, |
|  Business   |        |                       |        |  External API  |
|  Rules)     |        +-----------+-----------+        |  Clients)      |
+-------------+                    ▲                    +-------------+
                                   │
                          implements│
                                   ▼
                          +-----------------+
                          |   REST Adapter  |
                          | (Optional)      |
                          +-----------------+