# Cloud-Native E-commerce Microservices Platform

A comprehensive e-commerce platform demonstrating cloud-native architecture principles using Azure, Kubernetes, and modern DevOps practices.

## Architecture Overview

This project implements a microservices-based e-commerce platform with:
- **6 microservices**: Product, User, Cart, Order, Payment, and API Gateway
- **Database**: MongoDB for data persistence
- **Orchestration**: Kubernetes on Azure (AKS)
- **Infrastructure**: Terraform for IaC
- **Monitoring**: Prometheus & Grafana (designed for observability)

## Technical Stack

- **Cloud Platform**: Microsoft Azure
- **Container Orchestration**: Azure Kubernetes Service (AKS)
- **Infrastructure as Code**: Terraform
- **Containerization**: Docker
- **Database**: MongoDB
- **Programming Languages**: Java (Spring Boot) for microservices
- **Frontend**: React (designed)
- **CI/CD**: GitHub Actions
- **Monitoring**: Prometheus, Grafana

### Microservices Design
Each service is independently deployable and scalable, following these principles:
- Single Responsibility Principle
- Domain-driven design
- Independent deployment
- Own data storage (per-service database pattern)

### Infrastructure
- **Terraform** for reproducible infrastructure
- **AKS** for managed Kubernetes
- **Azure Container Registry** for Docker images
- **VNets** for network isolation

### Scalability & Resilience
- Horizontal pod autoscaling
- Load balancing at service mesh level
- Circuit breaker patterns (designed)
- Database replication (planned)

## Learning Outcomes

This project demonstrated:
1. Cloud-native architecture design
2. Infrastructure automation
3. Container orchestration at scale
4. Microservices communication patterns
5. DevOps principles and CI/CD
6. Cloud platform specifics (Azure)

## Future Improvements

- Implement service mesh (Istio)
- Add distributed tracing
- Implement caching layers (Redis)
- Set up automated testing pipelines
- Add A/B testing capabilities

## Resume Highlights

When discussing this project:
- Designed and implemented a microservices-based e-commerce platform on Azure Kubernetes Service
- Utilized Terraform for infrastructure as code, automating the provisioning of cloud resources
- Containerized 6 microservices using Docker and managed them with Kubernetes
- Implemented monitoring architecture using Prometheus and Grafana
- Created CI/CD pipelines using GitHub Actions for automated deployment
- Demonstrated understanding of cloud-native principles, distributed systems, and DevOps practices

## Repository

This project is hosted on GitHub at: https://github.com/Sambhav800/cloud-native-ecommerce





