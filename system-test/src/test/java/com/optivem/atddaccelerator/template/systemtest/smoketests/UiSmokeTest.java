package com.optivem.atddaccelerator.template.systemtest.smoketests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UiSmokeTest {
    @Test
    void shouldOpenLocalhostAndCheckStatus200() {
        // DISCLAIMER: This is an example of a badly written test
        // which unfortunately simulates real-life software test projects.
        // This is the starting point for our ATDD Accelerator exercises.

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            Response response = page.navigate("http://localhost:8080");
            assertEquals(200, response.status());
            browser.close();
        }
    }

    @Test
    void home_shouldReturnHtmlContent() throws Exception {
        // Arrange
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/"))
                .GET()
                .build();

        // Act
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Assert
        assertEquals(200, response.statusCode());
        
        String responseBody = response.body();
        String contentType = response.headers().firstValue("content-type").orElse("");
        
        // Check content type is HTML
        assertTrue(contentType.contains("text/html"), 
                  "Content-Type should be text/html, but was: " + contentType);
        
        // Check HTML structure
        assertTrue(responseBody.contains("<html"), "Response should contain HTML opening tag");
        assertTrue(responseBody.contains("</html>"), "Response should contain HTML closing tag");
    }
}
