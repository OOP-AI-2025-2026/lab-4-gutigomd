package ua.opnu.java.inheritance.bill;

import java.util.ArrayList;
import java.util.List;

public class GroceryBill {

    private Employee clerk;
    private List<Item> items;
    private double totalBill;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.items = new ArrayList<>();
        this.totalBill = 0.0;
    }

    public void add(Item i) {
        this.items.add(i);
        this.totalBill += i.getPrice();
    }

    public double getTotal() {
        return Math.round(totalBill * 100.0) / 100.0;
    }


    public Employee getClerk() {
        return this.clerk;
    }
}