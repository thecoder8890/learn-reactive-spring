package com.learnreactivespring.fulxandmonoplayground;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {

	@Test
	public void fluxTest() {
		Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive spring").log();

		stringFlux.subscribe(System.out::println, (e) -> System.err.println(e), () -> System.out.println("Complterd"));
	}

	@Test
	public void fluxTestElement() {
		Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive spring").log();

		StepVerifier.create(stringFlux).expectNext("Spring").expectNext("Spring Boot").expectNext("Reactive spring")
				.verifyComplete();
	}

	@Test
	public void monoTest() {
		Mono<String> stringMono = Mono.just("Spring");
		StepVerifier.create(stringMono.log()).expectNext("Spring").verifyComplete();
	}

}
