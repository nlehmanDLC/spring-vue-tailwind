package com.nlehman.vuetailwind;

import com.nlehman.vuetailwind.entities.Product;
import com.nlehman.vuetailwind.repositories.ProductRepository;
import com.nlehman.vuetailwind.services.MyUserDetailsService;
import com.nlehman.vuetailwind.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@OverrideAutoConfiguration(enabled = true)
@Import(MyUserDetailsService.class)
public class ProductsRestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ProductRepository repo;

    @MockBean
    private ProductService service;

    @Test
    public void getProductList() throws Exception {
        Product product1 = new Product("product 123");
        Product product2 = new Product("product 456");
        Iterable<Product> products = repo.saveAll(new ArrayList<Product>(List.of(product1, product2)));
        when(service.getProducts()).thenReturn(products);
        mockMvc
                .perform(get("/api/products").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..*").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andReturn();
    }

    @Test
    public void showProduct() throws Exception {
        Product product = new Product("product 123");
        product = repo.save(product);
        when(service.getProduct(product.getId())).thenReturn(product);
        mockMvc
                .perform(get("/api/products/" + product.getId()).accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(product.getName()))
                .andReturn();
    }
}
