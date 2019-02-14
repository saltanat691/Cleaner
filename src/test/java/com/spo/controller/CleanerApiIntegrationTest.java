package com.spo.controller;

import com.spo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CleanerApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200WhenRequestIsCorrect() throws Exception {

        String request = "{\"rooms\": [35, 21, 17], \"senior\": 10, \"junior\": 6}";

        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldReturn400WhenNoRoomsInRequestProvided() throws Exception {

        String request = "{\"rooms\": [], \"senior\": 10, \"junior\": 6}";

        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        ).andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldReturn400WhenSeniorCapacityIsNegative() throws Exception {

        String request = "{\"rooms\": [35, 21, 17], \"senior\": -1, \"junior\": 6}";

        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        ).andExpect(status().is4xxClientError());
    }
}
