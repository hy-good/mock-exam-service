package com.jun.mes.handler;

import com.jun.mes.model.HelloWorld;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DemoHandler {

  public Mono<ServerResponse> get(ServerRequest serverRequest) {
    Mono<HelloWorld> mono = Mono.just(HelloWorld.builder().id("hy123").name("hyeong jun").build());
    return ServerResponse.ok().body(mono, HelloWorld.class);
  }

}
