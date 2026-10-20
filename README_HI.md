# Shastra — Student Assistant

A web-based student assistant developed using Java and Spring Boot, designed to provide a simple and accessible interface for student support.

🌐 **Live Website:** https://shastra-xlij.onrender.com/  
💻 **Source Code:** https://github.com/varun07-source/shastra

## Overview

Shastra is a web application built with Java and Spring Boot. It combines a web-based user interface with a Java backend to provide an interactive student-assistance experience.

The project focuses on backend development, web technologies, application configuration, and cloud deployment.

## Features

- Interactive web-based interface
- Java-based backend using Spring Boot
- HTML and CSS for frontend development
- Maven-based dependency management
- Configurable application settings
- Cloud deployment using Render
- Version control and source-code management with Git and GitHub

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 17 | Backend programming |
| Spring Boot 3.5.6 | Web application development |
| Maven | Build and dependency management |
| HTML | Webpage structure |
| CSS | Interface styling |
| JDBC | Database connectivity support |
| MySQL | Planned database integration, if required |
| Git and GitHub | Version control |
| Render | Cloud hosting and deployment |

## Live Demo

**Visit Shastra:** https://shastra-xlij.onrender.com/

The application is deployed on Render and can be accessed through a web browser without running the project locally.

*Note: The free hosting service may take additional time to respond after a period of inactivity.*

## Project Structure

```text
shastra/
├── src/
│   └── main/
│       ├── java/
│       │   └── in/shastra/
│       └── resources/
│           ├── static/
│           │   ├── index.html
│           │   └── style.css
│           └── application.properties
├── pom.xml
├── Dockerfile
├── .gitignore
└── README.md
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17
- Maven
- Git

### Installation

Clone the repository:

```bash
git clone https://github.com/varun07-source/shastra.git
cd shastra
```

Build the application:

```bash
mvn clean package
```

Run the application:

```bash
mvn spring-boot:run
```

Open the application in your browser:

http://localhost:8080/

Additional configuration may be required depending on the features enabled.

## Configuration and Security

Application settings and credentials should be managed securely through environment variables or other appropriate configuration mechanisms.

Database settings, if required, should be configured for the target environment. Sensitive credentials must not be committed to the public repository.

## Remaining Work

- [ ] Test the deployed application across different browsers and devices.
- [ ] Verify all interface interactions and backend functionality.
- [ ] Complete and test database connectivity if required.
- [ ] Improve input validation and error handling.
- [ ] Review application configuration and deployment security.
- [ ] Improve responsive design and accessibility.
- [ ] Add application screenshots and technical documentation.
- [ ] Perform final end-to-end testing.

## Future Enhancements

- Improved user-interface design
- Additional student-support features
- Persistent data storage where required
- Better validation and exception handling
- Performance and usability improvements

## Project Status

**Status:** Initial deployment completed; application testing and further improvements are ongoing.

Shastra demonstrates the use of Java, Spring Boot, web technologies, Maven, Git, and cloud deployment in developing a student-oriented web application.

---

**Developed as a Java-based web application project.**
