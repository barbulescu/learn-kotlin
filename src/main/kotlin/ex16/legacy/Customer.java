package ex16.legacy;

import java.util.Objects;

/**
 * Three fields. ~50 lines. This is the honest cost of a Java "data class" — hand-written
 * in millions of codebases before Lombok, and still regenerated (and forgotten) after
 * every field change.
 *
 * Kotlin, all of it:
 *   data class Customer(val name: String, val email: String?, val vip: Boolean = false)
 */
public class Customer {

    private String name;
    private String email;   // DANGER: may be null — see getEmail(); the type can't say it
    private boolean vip;

    // CLUTTER: telescoping constructors stand in for default parameter values (ex06).
    public Customer(String name, String email) {
        this(name, email, false);
    }

    public Customer(String name, String email, boolean vip) {
        this.name = name;
        this.email = email;
        this.vip = vip;
    }

    public String getName() { return name; }

    // DANGER: setters — any code holding a reference can rewrite this object under you.
    public void setName(String name) { this.name = name; }

    /** @return the email, or null if the customer never gave one — this Javadoc is the ONLY warning */
    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public boolean isVip() { return vip; }

    public void setVip(boolean vip) { this.vip = vip; }

    // DANGER: add a field and forget to regenerate equals()/hashCode() — it still
    // compiles, and HashMaps/HashSets containing customers silently misbehave.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return vip == customer.vip
                && Objects.equals(name, customer.name)
                && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, vip);
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', email='" + email + "', vip=" + vip + "}";
    }
}
