package com.nlehman.vuetailwind;

import com.nlehman.vuetailwind.controllers.ProfileController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfileController.class)
@OverrideAutoConfiguration(enabled = true)
public class ProfileControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldShowProfilePage() throws Exception {
        this.mvc
                .perform(get("/profile"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Profile")));
    }

    @Test
    public void shouldShowSettingsPage() throws Exception {
        this.mvc
                .perform(get("/settings"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Settings")));
    }
}
