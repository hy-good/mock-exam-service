package com.jun.mes.config;

import com.jun.mes.handler.DemoHandler;
import com.jun.mes.model.HelloWorld;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@WebFluxTest
@Import(value = DemoHandler.class)
class RouteConfigTest {

  @Autowired
  private WebTestClient webClient;

  @Test
  public void test_HelloWorldRouter() {
    HelloWorld responseBody = webClient.get().uri("/hello").exchange()
      .expectStatus().isOk()
      .expectBody(HelloWorld.class)
      .returnResult().getResponseBody();

    assert responseBody != null;
    assertThat(responseBody.getId()).isEqualTo("hy123");
    assertThat(responseBody.getName()).isEqualTo("hyeong jun");
  }

}