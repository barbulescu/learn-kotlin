package ex22.legacy;

/**
 * LEGACY: primitive obsession — every domain identifier is a String, so the compiler
 * cannot tell a customer from a product. Port target: ex22/ValueClasses.kt.
 */
public final class LegacyBilling {

    private LegacyBilling() {}

    // DANGER: two Strings in a row. Swap them at a call site and the compiler
    // shrugs — LegacyJavaTest documents the resulting garbage invoice in green.
    // The classic fix is a wrapper class per ID — correct, but each one is a real
    // heap object plus ~30 lines of equals/hashCode, so most teams never bother.
    // (Project Valhalla's value types have been "coming soon" since 2014.)
    public static String invoiceLine(String customerId, String productId, int quantity) {
        return "Invoice " + customerId + ": " + quantity + " x " + productId;
    }

    // CLUTTER: validation by convention — customer IDs look like "C-42", product IDs
    // like "P-7", and only this comment says so. The check is advisory: nothing stops
    // an unvalidated String from flowing all the way to the invoice.
    public static boolean looksLikeCustomerId(String raw) {
        return raw.startsWith("C-");
    }

    public static boolean looksLikeProductId(String raw) {
        return raw.startsWith("P-");
    }
}
