package com.nlehman.vuetailwind;

import static org.assertj.core.api.Assertions.assertThat;

import com.nlehman.vuetailwind.controllers.MainController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VueTailwindApplicationTests {

    @Autowired
    private MainController controller;

	@Test
	void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
	}

}
