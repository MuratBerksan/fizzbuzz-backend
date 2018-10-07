package com.serviceflow.fizzbuzz;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FizzbuzzRestControllerTest extends BaseTestController {

    @Test
    public void testFizzBuzz() throws Exception {

        JSONArray array = new JSONArray();

        for (int i = 0; i < 20; i++) {
            array.add(i);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(array);

        MvcResult result = this.mockMvc.perform(post("/fizzbuzz/convert")
                .contentType("application/json;charset=UTF-8")
                .accept("application/json;charset=UTF-8")
                .content(content))
                .andExpect(status().isOk())
                .andReturn();

        String resultString = result.getResponse().getContentAsString();
        Assert.assertEquals("{\"fizzBuzz\":\"Fizz Buzz,1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,Fizz Buzz,16,17,Fizz,19\"}", resultString);
    }

}
