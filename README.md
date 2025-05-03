# Blog Application

A full-featured blogging platform built with Java Spring Boot.

## Tech Stack

- **Backend**: Spring Boot 3.4.4
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA
- **Security**: Spring Security with JWT authentication
- **Build Tool**: Maven
- **Java Version**: 21
- **Mapping**: MapStruct
- **Validation**: Spring Validation
- **Testing**: JUnit
- **Containerization**: Docker

## Features

- **User Authentication**: Secure login with JWT tokens
- **Post Management**: Create, read, update, and delete blog posts
- **Categories**: Organize posts by categories
- **Tags**: Add multiple tags to posts for better searchability
- **Draft Support**: Save posts as drafts before publishing
- **Filtering**: Filter posts by category and tags
- **API Endpoints**:
  - Authentication: `/api/v1/auth`
  - Posts: `/api/v1/posts`
  - Categories: `/api/v1/categories`
  - Tags: `/api/v1/tags`

## Future Enhancements

- Comment system for posts
- Rich text editor for post creation
- Image upload support
- Social media sharing
- Search functionality
- User profile management
- Admin dashboard
- Analytics and reporting
- Email notifications

## Setup Locally

1. **Prerequisites**:
   - Java 21 or higher
   - Maven
   - Docker and Docker Compose

2. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd blog
   ```

3. **Database setup**:
   - The PostgreSQL database runs in Docker
   - Run the following command to start the database container:
     ```bash
     docker-compose up -d
     ```
   - The application is already configured to connect to the Docker PostgreSQL instance (port 5435)

4. **Build and run the application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Access the application**:
   - The API will be available at `http://localhost:5050`
   - Default user credentials:
     - Email: user@gmail.com
     - Password: password

## Contribution Guide

1. **Fork the repository**

2. **Create a feature branch**:
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Commit your changes**:
   ```bash
   git commit -m "Add feature: your feature description"
   ```

4. **Push to your branch**:
   ```bash
   git push origin feature/your-feature-name
   ```

5. **Create a pull request**

6. **Code Standards**:
   - Follow Java coding conventions
   - Write unit tests for new features
   - Update documentation as needed
   - Ensure code passes all existing tests

7. **Review Process**:
   - All PRs require at least one review
   - CI checks must pass
   - Changes must be well-documented
