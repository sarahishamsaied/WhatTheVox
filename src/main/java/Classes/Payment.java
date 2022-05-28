package Classes;

public class Payment {
    double amountPaid;
    String paymentMethod;

    public Payment(double amountPaid, String paymentMethod) {
        this.amountPaid = amountPaid;
        this.paymentMethod = paymentMethod;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void payInCash(){}
    public void payByCreditCard(){}
}
