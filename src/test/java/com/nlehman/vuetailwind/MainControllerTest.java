package com.nlehman.vuetailwind;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nlehman.vuetailwind.controllers.MainController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MainController.class)
@OverrideAutoConfiguration(enabled = true)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldShowHomePage() throws Exception {
        this.mockMvc
                .perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Home page")));
    }

    @Test
    public void shouldShowAboutPage() throws Exception {
        this.mockMvc
                .perform(get("/about"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("About page")));
    }

    @Test
    public void shouldShowContactPage() throws Exception {
        this.mockMvc
                .perform(get("/contact"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Contact page")));
    }

    @Test
    public void shouldShowProductsPage() throws Exception {
        this.mockMvc
                .perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<products></products>")));
    }

    @Test
    public void anyProductIdShouldShowProductsPage() throws Exception {
        this.mockMvc
                .perform(get("/products/1234"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<products></products>")));
    }
}
