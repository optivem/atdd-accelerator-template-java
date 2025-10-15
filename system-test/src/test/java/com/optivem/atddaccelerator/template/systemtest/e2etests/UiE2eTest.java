package com.optivem.atddaccelerator.template.systemtest.e2etests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UiE2eTest {

    @Test
    void fetchTodo_shouldDisplayTodoDataInUI() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            
            // Navigate to the todo page
            page.navigate("http://localhost:8080/todos");
            
            // 1. Check there's a textbox with id
            Locator todoIdInput = page.locator("#todoId");
            assertTrue(todoIdInput.isVisible(), "Todo ID input textbox should be visible");
            
            // 2. Input value 4 into that textbox
            todoIdInput.fill("4");
            
            // 3. Click "Fetch Todo" button
            Locator fetchButton = page.locator("#fetchTodo");
            fetchButton.click();
            
            // 4. Verify that below we have the expected todo data
            // Wait for the result to appear
            page.waitForSelector("#todoResult", new Page.WaitForSelectorOptions().setTimeout(5000));
            
            Locator todoResult = page.locator("#todoResult");
            String resultText = todoResult.textContent();
            
            // Verify the todo data is displayed (flexible format checking)
            assertTrue(resultText.contains("userId") && resultText.contains("1"), 
                      "Result should contain userId: 1");
            assertTrue(resultText.contains("id") && resultText.contains("4"), 
                      "Result should contain id: 4");
            assertTrue(resultText.contains("title"), 
                      "Result should contain title field");
            assertTrue(resultText.contains("completed"), 
                      "Result should contain completed field");
            
            browser.close();
        }
    }
}