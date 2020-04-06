package com.learnreactivespring.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.learnreactivespring.handler.SampleHandlerFunction;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterFunctionConfig {

	@Bean
	public RouterFunction<ServerResponse> route(SampleHandlerFunction handlerFunction) {

		return RouterFunctions
				.route(GET("/funcational/flux").and(accept(MediaType.APPLICATION_JSON)), handlerFunction::flux)
				.andRoute(GET("/funcational/mono").and(accept(MediaType.APPLICATION_JSON)), handlerFunction::mono);
	}

}
