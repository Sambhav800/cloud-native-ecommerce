# Cloud-Native Microservices E-commerce Platform

A comprehensive e-commerce platform built with microservices architecture, deployed on Azure using Kubernetes, Terraform, and modern DevOps practices.

## Features

- Microservices-based architecture
- Cloud-native design patterns
- Infrastructure as Code with Terraform
- GitOps continuous delivery with Flux
- Service mesh with Istio
- Event-driven architecture with Azure Event Grid and Service Bus
- Serverless components with Azure Functions
- Comprehensive monitoring and observability

## Architecture

![Architecture Diagram](docs/architecture.png)

The platform consists of the following components:

- **Product Service**: Manages product catalog and inventory
- **User Service**: Handles user authentication and profiles
- **Cart Service**: Manages shopping carts
- **Order Service**: Processes orders and payments
- **API Gateway**: Routes requests to appropriate services
- **MongoDB**: Stores product and user data
- **Redis**: Caches frequently accessed data
- **Elasticsearch**: Powers product search functionality

## Deployment

The platform is deployed on Azure Kubernetes Service (AKS) using Terraform for infrastructure provisioning and Flux for continuous delivery.

## Getting Started

See the [documentation](docs/) for detailed instructions on how to set up and run the platform.
