package ua.opnu.java.inheritance.bill;


public final class DiscountBill2 {

    private final GroceryBill bill;
    private final boolean regularCustomer;
    private int discountCount = 0;
    private double discountAmount = 0;
    private static final double PERCENT_BASE = 100.0;

    public DiscountBill2(final Employee clerk, final boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public void add(final Item i) {
        bill.add(i);
        if (regularCustomer && i.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    public double getTotal() {
        double total = bill.getTotal();
        if (regularCustomer) {
            total -= discountAmount;
        }
        return Math.round(total * PERCENT_BASE) / PERCENT_BASE;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        double total = bill.getTotal();
        if (!regularCustomer || total == 0.0) {
            return 0.0;
        }
        double percent = PERCENT_BASE - ((total - discountAmount)
                * PERCENT_BASE / total);
        return Math.round(percent * 1e13) / 1e13;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }
}