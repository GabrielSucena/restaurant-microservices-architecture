# Restaurant Microservices Architecture 🍽️

This repository contains a microservices architecture designed for restaurant management. The project is built using Java and Spring Boot, leveraging cloud technologies and robust databases for seamless operation and scalability.

## Overview 🛠️

The project consists of the following services:

### 1. **Eureka Server** 🌐
- Acts as a **service registry** and **service discovery** server.
- Enables the dynamic registration and discovery of microservices within the system.

### 2. **API Gateway** 🚪
- Provides a **single entry point** for all microservices.
- Handles routing, load balancing, and security for incoming requests.

### 3. **Orders Service** 🛍️
- Manages customer orders.
- **Database**: MongoDB.
- Features:
  - **Asynchronous communication**: Sends order data to a message queue upon order creation.
  - **Synchronous communication**: Updates the order status to "paid" when the payment is confirmed.

### 4. **Payments Service** 💳
- Handles payment processing.
- **Database**: PostgreSQL with Flyway for database versioning and migration management.
- Features:
  - Consumes order data from the message queue to create payments.
  - Updates the payment status and triggers a synchronous update to the corresponding order status.

## Communication Patterns 🔗

1. **Asynchronous Communication** 📨:
   - When an order is created in the Orders Service, its details are sent to a **message queue**.
   - The Payments Service consumes this data to process the payment.

2. **Synchronous Communication** 🔄:
   - When the payment status is updated to "confirmed" in the Payments Service, the Orders Service synchronously updates the order status to "paid".

## Tech Stack 💻

- **Programming Language**: Java ☕
- **Framework**: Spring Boot 🌱
- **Databases**:
  - MongoDB for the Orders Service 🍃
  - PostgreSQL for the Payments Service 🐘
- **Database Versioning**: Flyway 🛤️
- **Service Discovery**: Eureka Server 🌐
- **API Gateway**: Spring Cloud Gateway 🚪
- **Message Queue**: RabbitMQ 🐇

## Getting Started 🚀

### Prerequisites 📋
- Java 17 or later ☕
- Docker and Docker Compose 🐳
- MongoDB 🍃
- PostgreSQL 🐘

### Running the Project ▶️
1. Clone the repository:
   ```bash
   git clone https://github.com/GabrielSucena/restaurant-microservices-architecture.git
2. Navigate to the project directory:
   ```bash
   cd restaurant-microservices-architecture
3. Build and start the services using Docker Compose:
   ```bash
   docker-compose up --build
  
### Accessing Services 🌍
- **Eureka Server**: `http://localhost:8761`
- **RabbitMQ**: `http://localhost:15672`

## Contribution 🤝

Contributions are welcome! Feel free to submit issues or pull requests for improvements.

---

Feel free to explore and adapt the code for your own projects. Happy coding! 💻
