# Software Requirements Specification – Web Search Engine

## Overview
This repository contains a complete **Software Requirements Specification (SRS)**
for a Google-like web search engine. The specification is developed in accordance
with the **IEEE 830 standard** and defines the functional behavior, non-functional
constraints, and system design of a scalable web-based search platform.

The document serves as a foundation for system development, validation, and
future enhancement by clearly capturing requirements, use cases, and design
models.

---

## Scope of the System
The specified system is a web-based search engine that enables users to:
- Submit search queries
- Receive ranked and filtered results
- Navigate search results efficiently

In addition, the system supports administrative functionality that allows
website owners to submit content for crawling and indexing. Core system
capabilities include crawling, indexing, query processing, ranking, filtering,
and periodic re-crawling.

---

## Contents of This Repository
This repository includes the following artifacts:

- **Software Requirements Specification (SRS)**
  - Functional requirements
  - Non-functional requirements (performance, scalability, security, usability)
  - System constraints and assumptions
- **Use Case Definitions**
  - User search workflows
  - Admin indexing workflows
- **Traceability Matrix**
  - Mapping between use cases and requirements
- **System Design Models**
  - Domain model (Boundary–Control–Entity)
  - UML diagrams
  - Sequence diagrams for key use cases

---

## Repository Structure
README.md/
docs/
diagrams

## Key Features Defined in the SRS
- Search query processing and ranking
- Autocorrection and query suggestions
- Filtering and sorting of results
- Web crawling and indexing
- Periodic crawling automation
- Admin control panel for website submission
- Performance and scalability constraints

---

## Purpose
This project demonstrates skills in:
- Requirements Engineering
- System Analysis and Design
- UML Modeling
- Use Case Modeling
- Software Documentation Standards
- Traceability and Validation

---

## Academic Note
This project was developed as part of an academic software engineering course
and is intended to demonstrate requirements engineering and system design
principles.

---

## REST API Implementation 

This repository also includes a **REST-based backend implementation**
developed as part of the Software Engineering laboratory assignment.

The REST API provides functionality to:

- Register websites for crawling
- Create crawl jobs for registered websites
- Query existing websites and crawl jobs

The implementation follows REST principles and uses JSON as the primary
data exchange format.

### Implemented Endpoints

#### Websites
- `POST /api/websites` – Register a new website
- `GET /api/websites` – Retrieve all registered websites

#### Crawl Jobs
- `POST /api/crawl-jobs` – Create a crawl job for a website
- `GET /api/crawl-jobs` – Retrieve crawl jobs (with optional filtering)

### Technology Stack
- Java
- JAX-RS (Jersey)
- Grizzly HTTP Server
- In-memory data storage (no database)

This implementation is **independent of the SRS** and serves as a prototype
demonstrating RESTful API design.

---

## Author
**Thilakraj Soundararajan**

---

## License
This repository is shared for educational and demonstration purposes.
## Repository Structure

