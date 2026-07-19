package ex16.legacy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The classic dumping ground: Java has no top-level functions, so every function
 * without an obvious home ends up in a final class with a private constructor and a
 * pile of statics. (Kotlin: top-level and extension functions — ex07.)
 *
 * This class WORKS — it compiles, and LegacyJavaTest exercises it. Your job in ex16
 * is to port it (and the three POJOs) to Kotlin so that the DANGER comments below
 * become either impossible to write or a compile error.
 */
public final class OrderUtils {

    private OrderUtils() {}   // CLUTTER: ritual to stop instantiation of a non-class

    // CLUTTER: money math without operators. `price * quantity` is illegal on BigDecimal
    // in Java, so every formula becomes a method chain.
    // Kotlin target: fun LineItem.lineTotal() = unitPrice * quantity.toBigDecimal()
    public static BigDecimal lineTotal(LineItem item) {
        return item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
    }

    // Kotlin target: items.sumOf { it.lineTotal() }
    public static BigDecimal grandTotal(Order order) {
        BigDecimal total = BigDecimal.ZERO;
        for (LineItem item : order.getItems()) {
            // DANGER: BigDecimal is immutable — `total.add(...)` alone compiles cleanly
            // and sums NOTHING. Forgetting the `total =` reassignment is a classic bug.
            total = total.add(lineTotal(item));
        }
        return total;
    }

    // DANGER: getEmail() may return null — only the Javadoc on Customer says so, and the
    // compiler doesn't read Javadoc. This compiles without a single warning and throws
    // NullPointerException at runtime, far from where the null was created.
    // LegacyJavaTest.`careless null handling...` proves it.
    public static String contactLineCareless(Customer c) {
        return c.getName() + " <" + c.getEmail().toLowerCase() + ">";
    }

    // The careful version: an if/else at EVERY access, forever, enforced by nothing —
    // the next caller of getEmail() starts from zero. Kotlin: `String?` makes the
    // compiler enforce the check, and ?. / let / ?: make it one line.
    public static String contactLine(Customer c) {
        if (c.getEmail() != null) {
            return c.getName() + " <" + c.getEmail().toLowerCase() + ">";
        } else {
            return c.getName() + " (no email)";
        }
    }

    // DANGER: Payment is a plain abstract class, so the compiler cannot know this chain
    // is complete. Add a new Payment subtype and this method compiles unchanged — you
    // find out at runtime via the IllegalStateException. Or never, if a colleague
    // "fixes" the crash with `return ""`.
    public static String paymentMessage(Payment p) {
        if (p instanceof Paid) {
            Paid paid = (Paid) p;                  // CLUTTER: cast after the check
            return "Paid " + paid.getAmount();
        } else if (p instanceof Refunded) {
            Refunded refunded = (Refunded) p;
            return "Refunded " + refunded.getAmount() + " (" + refunded.getReason() + ")";
        } else if (p instanceof Pending) {
            return "Awaiting payment";
        } else {
            throw new IllegalStateException("unreachable");   // DANGER: it isn't
        }
    }

    // CLUTTER: telescoping overloads instead of default parameter values (ex06).
    public static String receipt(Order order) {
        return receipt(order, "EUR", "Thank you!");
    }

    public static String receipt(Order order, String currency) {
        return receipt(order, currency, "Thank you!");
    }

    // DANGER: currency and footer are both String — swap them at a call site,
    // receipt(order, "Thank you!", "EUR"), and it still compiles. Kotlin named
    // arguments make the call site say what it means: receipt(order, footer = "...").
    public static String receipt(Order order, String currency, String footer) {
        StringBuilder sb = new StringBuilder();   // CLUTTER: the code hides the output's shape
        sb.append("Order #").append(order.getId())
          .append(" for ").append(order.getCustomer().getName());
        if (order.getCustomer().isVip()) {
            sb.append(" (VIP)");
        }
        sb.append("\n");
        for (LineItem item : order.getItems()) {
            sb.append(item.getQuantity()).append(" x ").append(item.getProduct())
              .append(" = ").append(lineTotal(item)).append(" ").append(currency)
              .append("\n");
        }
        sb.append("Total: ").append(grandTotal(order)).append(" ").append(currency).append("\n");
        sb.append(footer);
        return sb.toString();
    }

    public static List<String> bigSpenders(List<Order> orders) {
        return bigSpenders(orders, new BigDecimal("100"));
    }

    // CLUTTER: with BigDecimal, Collectors.summingDouble is gone too — summing money
    // needs the three-argument Collectors.reducing ceremony. And `>=` is illegal on
    // BigDecimal, so the filter becomes compareTo(minimum) >= 0.
    // Kotlin: groupBy { } / filterValues { sum >= minimum } / sorted().
    public static List<String> bigSpenders(List<Order> orders, BigDecimal minimum) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        o -> o.getCustomer().getName(),
                        Collectors.reducing(BigDecimal.ZERO, OrderUtils::grandTotal, BigDecimal::add)))
                .entrySet().stream()
                .filter(e -> e.getValue().compareTo(minimum) >= 0)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

    // DANGER (the worst one): "applies" the discount by mutating the order it was given.
    // Every other holder of this reference — the cache, the audit log, the thread
    // halfway through printing a receipt — silently sees discounted prices. Call it
    // twice and the discount is applied twice. Nothing in the `void` signature warns
    // you. LegacyJavaTest proves both failure modes; the Kotlin version (`copy()` on
    // immutable data classes) cannot express this bug at all.
    //
    // Bonus DANGER: divide() with no rounding mode throws ArithmeticException the day
    // a quotient stops terminating — this only works because the divisor is 100.
    public static void applyDiscount(Order order, int percentOff) {
        for (LineItem item : order.getItems()) {
            item.setUnitPrice(item.getUnitPrice()
                    .multiply(BigDecimal.valueOf(100 - percentOff))
                    .divide(BigDecimal.valueOf(100)));
        }
    }
}
