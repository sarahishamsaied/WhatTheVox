package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Purchase {
    String itemName;
    Double amountPaid;
    String dateOfPurchase;
    String purchaseId;

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Purchase(String itemName, Double amountPaid, String purchaseId) {
        this.itemName = itemName;
        this.amountPaid = amountPaid;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\"");
        LocalDateTime now = LocalDateTime.now();
        this.dateOfPurchase = dtf.format(now);
        this.purchaseId = purchaseId;
    }


    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }


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

}
