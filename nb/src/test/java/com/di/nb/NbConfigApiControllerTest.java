package com.di.nb;

import com.di.nb.controller.NbConfigApiController;
import org.junit.Before;
import org.junit.Test;



import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration

public class NbConfigApiControllerTest {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new NbConfigApiController()).build();
    }

    @Test
    public void testNbConfigApiControllerGetConfig() throws Exception {
        RequestBuilder request;
        request = get("/config")
                    .param("id","[ab123]");
        mvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(equalTo("success")));
    }

}
