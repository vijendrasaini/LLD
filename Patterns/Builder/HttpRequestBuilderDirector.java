package Patterns.Builder;

public class HttpRequestBuilderDirector {
    public static HttpRequest buildGetRequest(String url) {
        return new HttpRequest.Builder()
                .withUrl(url)
                .withMethod("GET")
                .build();
    }

    public static HttpRequest buildPostRequest(String url, String key, String value) {
        return new HttpRequest.Builder()
                .withUrl(url)
                .withMethod("POST")
                .withHeaders("Content-Type", "application/json")
                .withBody(key, value)
                .build();
    }

}
