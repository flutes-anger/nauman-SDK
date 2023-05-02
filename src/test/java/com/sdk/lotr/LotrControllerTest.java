package com.sdk.lotr;

import com.sdk.lotr.model.Movie;
import com.sdk.lotr.model.Quote;
import com.sdk.lotr.service.LotrService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LotrControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LotrService lotrService;

    @Test
    public void testGetMovie() throws Exception {

        when(lotrService.getMovie()).thenReturn(new Movie("1", "The Fellowship of the Ring"));

        // Test the /movie endpoint
        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("The Fellowship of the Ring"));

        // Verify that the service method was called once
        verify(lotrService, times(1)).getMovie();
    }

    @Test
    public void testGetQuote() throws Exception {

        when(lotrService.getQuote()).thenReturn(new Quote("1", "No living man can kill him"));

        // Test the /movie endpoint
        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].desc").value("No living man can kill him"));

        // Verify that the service method was called once
        verify(lotrService, times(1)).getMovie();
    }
}
