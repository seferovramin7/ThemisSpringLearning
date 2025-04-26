# ThemisSpringLearning - Dockerized Spring Boot Application

This document explains the Docker structure of this Spring Boot application and introduces essential Docker concepts for students.

## Docker Structure

This application is containerized using Docker with the following components:

1. **Dockerfile**: Defines how to build the application image.
2. **docker-compose.yml**: Orchestrates the container setup.
3. **.dockerignore**: Specifies which files to exclude from the Docker build context.

## Key Docker Concepts

### What is Docker?

Docker is a platform that enables developers to package applications into containers—standardized executable components that combine application source code with all the operating system libraries and dependencies required to run the code in any environment.

### Docker Components in This Project

#### 1. Dockerfile

Our Dockerfile uses a multi-stage build approach:

```dockerfile
# Build stage: Uses JDK for compiling
FROM eclipse-temurin:17-jdk AS build
# ...build commands...

# Runtime stage: Uses JRE for running (smaller footprint)
FROM eclipse-temurin:17-jre
# ...runtime setup...
```

**Key concepts:**
- **Base images**: `eclipse-temurin:17-jdk` (for building) and `eclipse-temurin:17-jre` (for running)
- **Multi-stage builds**: Separate build and runtime environments to create smaller final images
- **Layer caching**: Copying dependencies first to leverage Docker's layer caching mechanism

#### 2. docker-compose.yml

The compose file defines our application service:

```yaml
services:
  app:
    build: .
    ports:
      - "8081:8080"
    environment:
      # Environment variables
    volumes:
      # Persistent data
```

**Key concepts:**
- **Services**: Defines containerized components of the application
- **Port mapping**: Maps host ports to container ports
- **Environment variables**: Configuration injected into containers
- **Volumes**: Persists data outside container lifecycle

## Running the Application with Docker

1. **Build and start the application**:
   ```
   docker compose up --build
   ```

2. **Access the application**:
   - Web application: http://localhost:8081
   - H2 Console: http://localhost:8081/h2-console

3. **Stop the application**:
   ```
   docker compose down
   ```

## Docker Benefits

1. **Consistency**: Ensures the same environment across development, testing, and production.
2. **Isolation**: Application dependencies are contained within the Docker container.
3. **Portability**: Run anywhere Docker is installed, regardless of underlying host system.
4. **Efficiency**: Containers share the host OS kernel, making them lightweight compared to VMs.
5. **Scalability**: Easy to scale with orchestration tools like Docker Compose or Kubernetes.

## Common Docker Commands

- `docker build -t app-name .`: Build an image
- `docker images`: List all images
- `docker run -p 8081:8080 app-name`: Run a container
- `docker ps`: List running containers
- `docker stop container-id`: Stop a container
- `docker logs container-id`: View container logs
- `docker exec -it container-id bash`: Connect to a running container

## Docker Best Practices

1. Use specific image tags instead of `latest`
2. Minimize the number of layers in your Dockerfile
3. Use multi-stage builds to reduce image size
4. Don't run containers as root
5. Store secrets securely, not in Dockerfiles
6. Keep images small by including only necessary files 