# Azure Event Grid for event-driven architecture
resource "azurerm_eventgrid_topic" "ecommerce_events" {
  name                = "ecommerce-events"
  location            = azurerm_resource_group.rg.location
  resource_group_name = azurerm_resource_group.rg.name
  tags = {
    environment = "Development"
  }
}

# Azure Service Bus for reliable messaging
resource "azurerm_servicebus_namespace" "ecommerce_servicebus" {
  name                = "ecommerce-servicebus"
  location            = azurerm_resource_group.rg.location
  resource_group_name = azurerm_resource_group.rg.name
  sku                 = "Standard"
  tags = {
    environment = "Development"
  }
}

resource "azurerm_servicebus_queue" "orders_queue" {
  name                = "orders"
  namespace_id        = azurerm_servicebus_namespace.ecommerce_servicebus.id
  enable_partitioning = true
}

# Azure Application Insights for monitoring
resource "azurerm_application_insights" "ecommerce_insights" {
  name                = "ecommerce-insights"
  location            = azurerm_resource_group.rg.location
  resource_group_name = azurerm_resource_group.rg.name
  application_type    = "web"
}

# Azure Key Vault for secrets management
resource "azurerm_key_vault" "ecommerce_keyvault" {
  name                        = "ecommerce-keyvault"
  location                    = azurerm_resource_group.rg.location
  resource_group_name         = azurerm_resource_group.rg.name
  enabled_for_disk_encryption = true
  tenant_id                   = data.azurerm_client_config.current.tenant_id
  soft_delete_retention_days  = 7
  purge_protection_enabled    = false
  sku_name                    = "standard"
}

# Get current client config
data "azurerm_client_config" "current" {}
