package Patterns.Builder;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestStepWise {
    private String url;
    private String method = "GET";
    private Map<String, String> body = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> queryParameters = new HashMap<>();

    private HttpRequestStepWise(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.headers = builder.headers;
        this.queryParameters = builder.queryParameters;
    }

    static class Builder implements MethodBuilder, BodyBuilder, HeadersBuilder, QueryParametersBuilder, Build, URLBuilder {
        private String url;
        private String method = "GET";
        private Map<String, String> body = new HashMap<>();
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> queryParameters = new HashMap<>();

        @Override
        public Build withQueryParameters(String key, String value) {
            this.queryParameters.put(key, value);
            return this;
        }

        @Override
        public QueryParametersBuilder withHeaders(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        @Override
        public HeadersBuilder withBody(String key, String value) {
            this.body.put(key, value);
            return this;
        }

        @Override
        public BodyBuilder withMethod(String method) {
            this.method = method;
            return this;
        }

        public MethodBuilder startWithURL(String url) {
            this.url = url;
            return this;
        }

        public void validate() {
            if(this.url == null || this.url.isEmpty()) {
                throw new IllegalArgumentException("Url is required");
            }
        }
        public HttpRequestStepWise build() {
            validate();
            return new HttpRequestStepWise(this);
        }
    }

    public static URLBuilder builder() {
        return new Builder();
    }

    public void execute() {
        System.out.println();
        System.out.println("Executing request via Step Builder...");
        System.out.println("URL: " + this.url);
        System.out.println("Method: " + this.method);
        System.out.println("Body: " + this.body);
        System.out.println("Query Parameters: " + this.queryParameters);
        System.out.println("Headers: " + this.headers);
    }
}

interface MethodBuilder {
    BodyBuilder withMethod(String method);
}

interface BodyBuilder {
    HeadersBuilder withBody(String key, String value);
}

interface HeadersBuilder {
    QueryParametersBuilder withHeaders(String key, String value);
}

interface QueryParametersBuilder {
    Build withQueryParameters(String key, String value);
}

interface URLBuilder {
    MethodBuilder startWithURL(String url);
}

interface Build {
    HttpRequestStepWise build();
}