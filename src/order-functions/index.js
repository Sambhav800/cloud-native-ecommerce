module.exports = async function (context, eventGridEvent) {
    context.log('JavaScript EventGrid trigger function processing an event', eventGridEvent);
    
    // Process order event
    const order = {
        id: eventGridEvent.data.orderId,
        userId: eventGridEvent.data.userId,
        items: eventGridEvent.data.items,
        totalAmount: eventGridEvent.data.totalAmount,
        status: "PROCESSING",
        createdAt: new Date().toISOString()
    };
    
    // Output the order to Cosmos DB
    context.bindings.outputDocument = order;
    
    context.log(`Order processed: ${order.id}`);
    context.done();
};
