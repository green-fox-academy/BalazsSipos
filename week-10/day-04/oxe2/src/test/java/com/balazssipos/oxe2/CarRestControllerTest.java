package com.balazssipos.oxe2;


import com.balazssipos.oxe2.controllers.CarRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CarRestController.class)
public class CarRestControllerTest {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

  @Autowired
  private MockMvc mockMvc;

  // if an additional service layer is used
  // - meaning not all logic is added to the controller and you have Autowired fields in it -
  // then you have to mock out the service class like below
  //
  //@MockBean
  //private UserService userService;

  @Test
  public void filterSuccesfull() throws Exception {
    mockMvc.perform(get("/api/search/Trabant}")
            .contentType(MediaType.APPLICATION_JSON)
            .content(""))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.result", is("ok")))
            .andExpect(jsonPath("$.data", is("[{\"plate\":\"DEF-456\",\"car_brand\":\"Trabant\"," +
                    "\"car_model\":\"601\",\"color\":\"White\",\"year\":1983},{\"plate\":\"RBC-789\"," +
                    "\"car_brand\":\"Trabant\",\"car_model\":\"601\",\"color\":\"Yellow\",\"year\":1979}]")));
  }

//  @Test
//  public void addNewUsermissingEmail() throws Exception {
//    mockMvc.perform(post("/users")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content("{\"password\": \"12345\"}"))
//            .andExpect(status().isBadRequest())
//            .andExpect(content().contentType(contentType))
//            .andExpect(jsonPath("$.response", is("fail")))
//            .andExpect(jsonPath("$.message", is("Email is missing")));
//  }
}
