package ex21.legacy;

/**
 * LEGACY: an immutable request object, Java-style — which means a Builder: ~40 lines
 * of ceremony for four fields. Port target: ex21/Builders.kt.
 */
public final class LegacyRequest {

    private final String url;
    private final String method;
    private final String body;
    private final int timeoutMillis;

    private LegacyRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.timeoutMillis = builder.timeoutMillis;
    }

    public String getUrl() { return url; }
    public String getMethod() { return method; }
    public String getBody() { return body; }
    public int getTimeoutMillis() { return timeoutMillis; }

    // CLUTTER: the Builder pattern — a shadow class repeating every field, a setter
    // per field, and a build() at the end. This is what "no default parameter values
    // and no named arguments" costs, per class, forever.
    public static final class Builder {
        private String url;                    // DANGER: nothing forces this to be set
        private String method = "GET";
        private String body = null;
        private int timeoutMillis = 30_000;

        public Builder url(String url) { this.url = url; return this; }
        public Builder method(String method) { this.method = method; return this; }
        public Builder body(String body) { this.body = body; return this; }
        public Builder timeoutMillis(int timeoutMillis) { this.timeoutMillis = timeoutMillis; return this; }

        // DANGER: build() happily builds a request with url == null — the Builder
        // deferred construction, so the compiler can't see the missing field. The
        // NPE is scheduled for whenever someone first USES the url, far from here.
        public LegacyRequest build() { return new LegacyRequest(this); }
    }

    // CLUTTER: "copy with one change" — the helper the Builder makes you hand-roll,
    // repeating every field one more time.
    public LegacyRequest withTimeout(int newTimeoutMillis) {
        return new Builder()
                .url(url)
                .method(method)
                .body(body)
                .timeoutMillis(newTimeoutMillis)
                .build();
    }
}
