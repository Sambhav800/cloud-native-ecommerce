# Cloud-Native E-commerce Microservices Platform

A comprehensive e-commerce platform built with microservices architecture, deployed on Azure using Kubernetes, Terraform, and modern DevOps practices.

## Architecture

This project implements a cloud-native architecture with the following components:

- **Product Service**: Manages product catalog and inventory
- **User Service**: Handles user authentication and profiles
- **Cart Service**: Manages shopping carts
- **Order Service**: Processes orders
- **Payment Service**: Handles payment processing
- **API Gateway**: Routes client requests to appropriate services
- **MongoDB**: NoSQL database for storing service data

## Technologies Used

- **Azure Kubernetes Service (AKS)**: For container orchestration
- **Azure Container Registry (ACR)**: For storing Docker images
- **Terraform**: For infrastructure as code
- **Docker**: For containerization
- **MongoDB**: For data persistence
- **GitHub Actions**: For CI/CD pipelines
- **Spring Boot**: For microservices implementation

## Infrastructure

The infrastructure is provisioned using Terraform, making it reproducible and maintainable:

- Virtual Network with proper CIDR range
- AKS cluster with appropriate node pools
- Container Registry for Docker images
- Network security rules and RBAC configuration

## Deployment

Services are deployed as Kubernetes resources with:
- Deployments for each microservice
- Services for internal communication
- ConfigMaps and Secrets for configuration
- Persistent Volume Claims for database storage

## CI/CD Pipelines

Continuous integration and deployment are handled with GitHub Actions:
- Automated builds when code is pushed
- Container image creation and publishing
- Kubernetes manifests deployment
- Environment-specific configurations
