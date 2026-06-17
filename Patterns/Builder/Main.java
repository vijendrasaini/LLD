package Patterns.Builder;

public class Main {
    public static void main(String[] args) {
        // Normal builder
        HttpRequest request = HttpRequest.builder()
            .withUrl("https://api.example.com")
            .withMethod("POST")
            .withHeaders("Content-Type", "application/json")
            .withBody("username", "admin")
            .build();

        request.execute();

        // Builder via Director
        HttpRequest request2 = HttpRequestBuilderDirector.buildGetRequest("https://api.example.com");
        request2.execute();

        HttpRequest request3 = HttpRequestBuilderDirector.buildPostRequest("https://api.example.com", "username", "admin");
        request3.execute();

        // Step builder
        HttpRequestStepWise request4 = HttpRequestStepWise.builder()
            .startWithURL("https://api.example.com")
            .withMethod("POST")
            .withBody("name", "Vijendra")
            .withHeaders("Content-Type", "application/json")
            .withQueryParameters("page", "1")
            .build();


        request4.execute();

    }
}
