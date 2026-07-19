package ex16.legacy;

import java.util.List;
import java.util.Objects;

/**
 * Kotlin: data class Order(val id: Int, val customer: Customer, val items: List<LineItem>)
 */
public class Order {

    private final int id;
    private final Customer customer;
    private final List<LineItem> items;

    public Order(int id, Customer customer, List<LineItem> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
    }

    public int getId() { return id; }

    public Customer getCustomer() { return customer; }

    // DANGER: returns the internal mutable list — any caller can add, remove, or clear
    // line items on an order it doesn't own. `final` on the field above protects the
    // reference, not the contents. (Kotlin's List<LineItem> is a read-only interface.)
    public List<LineItem> getItems() { return items; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id
                && Objects.equals(customer, order.customer)
                && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, items);
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", customer=" + customer + ", items=" + items + "}";
    }
}
