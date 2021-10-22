package com.jun.mes.config;

import com.jun.mes.handler.DemoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class RouteConfig implements WebFluxConfigurer {

  @Bean
  public RouterFunction<ServerResponse> routes(DemoHandler handler) {
    return RouterFunctions.route().GET("/hello", handler::get).build();
  }

}
