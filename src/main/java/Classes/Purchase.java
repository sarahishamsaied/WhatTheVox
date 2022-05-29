package Classes;

public class Purchase {
    String itemName;
    Double amountPaid;

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    String purchaseId;

    public Purchase() {
        this.amountPaid = 0.0;
        this.itemName = "";
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Purchase(String itemName, Double amountPaid,String ID) {
        this.itemName = itemName;
        this.amountPaid = amountPaid;
        this.purchaseId = ID;
    }
}
