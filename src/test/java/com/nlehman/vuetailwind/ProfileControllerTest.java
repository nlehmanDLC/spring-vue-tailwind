package com.nlehman.vuetailwind;

import com.nlehman.vuetailwind.controllers.ProfileController;
import com.nlehman.vuetailwind.services.MyUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProfileController.class)
@OverrideAutoConfiguration(enabled = true)
@Import(MyUserDetailsService.class)
public class ProfileControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void guestsShouldRedirectOnProfilePage() throws Exception {
        this.mvc
                .perform(get("/profile"))
                .andDo(print())
                .andExpect(redirectedUrl("http://localhost/login"))
                .andExpect(status().isFound());
    }

    @Test
    @WithUserDetails("nlehman")
    public void authenticatedShouldShowProfilePage() throws Exception {
        this.mvc
                .perform(get("/profile"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Profile")));
    }

    @Test
    public void guestsShouldRedirectOnSettingsPage() throws Exception {
        this.mvc
                .perform(get("/settings"))
                .andDo(print())
                .andExpect(redirectedUrl("http://localhost/login"))
                .andExpect(status().isFound());
    }

    @Test
    @WithUserDetails("nlehman")
    public void authenticatedShouldShowSettingsPage() throws Exception {
        this.mvc
                .perform(get("/settings"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Settings")));
    }
}
