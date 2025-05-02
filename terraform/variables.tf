# Variables for Terraform Configuration
variable "resource_group_name" {
  description = "Name of the resource group"
  type        = string
  default     = "ecommerce-microservices-rg"
}

variable "location" {
  description = "Azure region to deploy resources"
  type        = string
  default     = "eastus"
}

variable "cluster_name" {
  description = "Name of AKS cluster"
  type        = string
  default     = "ecommerce-aks"
}

variable "kubernetes_version" {
  description = "Kubernetes version"
  type        = string
  default     = "1.30.11"
}

variable "vm_size" {
  description = "VM size for AKS nodes"
  type        = string
  default     = "Standard_B2s"  # Cost-effective VM size
}

variable "node_count" {
  description = "Number of nodes in the AKS cluster"
  type        = number
  default     = 1  # Minimum for learning
}
