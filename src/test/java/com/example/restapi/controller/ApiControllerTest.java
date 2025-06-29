package com.example.restapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ApiControllerTest {

    @Autowired
    private ApiController apiController;

    @Test
    public void testValid() {
        String response = apiController.coinList(7.03);

        assertThat(response).contains("7.03");
        assertThat(response).contains("Output");
    }
    @Test
    public void testInvalid() {
        String response = apiController.coinList(-5);
        assertThat(response).contains("Invalid amount");
    }

}
