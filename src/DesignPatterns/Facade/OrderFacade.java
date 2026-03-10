package DesignPatterns.Facade;

public class OrderFacade {

    private final PaymentService paymentService;
    private final InventoryService inventoryService;

    public OrderFacade(PaymentService paymentService, InventoryService inventoryService) {
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
    }

    public void payAndBuy() {
        paymentService.validatePaymentSrc();
        inventoryService.checkInventory();
    }
}
