package ua.opnu.java.inheritance.bill;

public class DiscountBill extends GroceryBill {

    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;
    private double fullPriceTotal;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
        this.fullPriceTotal = 0.0;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        this.fullPriceTotal += i.getPrice();

        if (this.regularCustomer) {
            double discount = i.getDiscount();
            if (discount > 0.0) {
                this.discountCount++;
                this.discountAmount += discount;
            }
        }
    }

    @Override
    public double getTotal() {
        if (this.regularCustomer) {
            return this.fullPriceTotal - this.discountAmount;
        } else {
            return super.getTotal();
        }
    }

    public int getDiscountCount() {
        return this.regularCustomer ? this.discountCount : 0;
    }

    public double getDiscountAmount() {
        return this.regularCustomer ? this.discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!this.regularCustomer || this.fullPriceTotal == 0.0) {
            return 0.0;
        }

        double totalBeforeDiscount = this.fullPriceTotal;
        double discountedPrice = totalBeforeDiscount - this.discountAmount;

        double percent = 100.0 - (discountedPrice * 100.0) / totalBeforeDiscount;

        return Math.round(percent * 1e13) / 1e13;
    }
}