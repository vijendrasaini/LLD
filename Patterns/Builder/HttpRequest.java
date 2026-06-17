package Patterns.Builder;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String url;
    private String method = "GET";
    private Map<String, String> body = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> queryParameters = new HashMap<>();

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.headers = builder.headers;
        this.queryParameters = builder.queryParameters;
    }

    static class Builder {
        private String url;
        private String method = "GET";
        private Map<String, String> body = new HashMap<>();
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> queryParameters = new HashMap<>();
        
        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder withBody(String key, String value) {
            this.body.put(key, value);
            return this;
        }

        public Builder withHeaders(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder withQueryParameters(String key, String value) {
            this.queryParameters.put(key, value);
            return this;
        }

        private void validate() {
            if(this.url == null || this.url.isEmpty()) {
                throw new IllegalArgumentException("Url is required");
            }
        }

        public HttpRequest build() {
            validate();
            return new HttpRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();

    }

    public void execute() {
        System.out.println();
        System.out.println("Executing request...");
        System.out.println("URL: " + this.url);
        System.out.println("Method: " + this.method);
        System.out.println("Body: " + this.body);
        System.out.println("Query Parameters: " + this.queryParameters);
        System.out.println("Headers: " + this.headers);
    }
}