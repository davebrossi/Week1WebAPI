package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FetchJeepTest extends FetchJeepTestSupport {

  @Test
 
    void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
      //given a valid model, trim, and URI
      JeepModel model = JeepModel.WRANGLER;
      String trim = "Sport";
      String Uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);

      //when: a connection is made to the URI
      ResponseEntity<Jeep> response =
          getRestTemplate().getForEntity(Uri, Jeep.class);
      
      //Then: a success (OK - 200) is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

}
