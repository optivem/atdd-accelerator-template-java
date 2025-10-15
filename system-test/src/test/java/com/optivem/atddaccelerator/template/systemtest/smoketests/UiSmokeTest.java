package com.optivem.atddaccelerator.template.systemtest.smoketests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
