/**
 * 
 */
package com.learnreactivespring.fulxandmonoplayground;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * @author mingle
 *
 */
public class FluxMonoFactoryTest {

	List<String> names = Arrays.asList("Mayur", "Rajiv", "Pankaj", "Amit");

	@Test
	public void fluxUsingIterable() {

		Flux<String> nameFlux = Flux.fromIterable(names).log();

		StepVerifier.create(nameFlux).expectNext("Mayur", "Rajiv", "Pankaj", "Amit").verifyComplete();
	}

	@Test
	public void fluxUsingArray() {

		String[] names = new String[] { "Mayur", "Rajiv", "Pankaj", "Amit" };

		Flux<String> nameFlux = Flux.fromArray(names).log();

		StepVerifier.create(nameFlux).expectNext("Mayur", "Rajiv", "Pankaj", "Amit").verifyComplete();

	}

	@Test
	public void fluxUsingStream() {

		Flux<String> nameFlux = Flux.fromStream(names.stream());
		
		StepVerifier.create(nameFlux).expectNext("Mayur", "Rajiv", "Pankaj", "Amit").verifyComplete();
	}
	
	@Test
	public void monoUsingJustOrEmpty() {
		
		Mono<String> mono = Mono.justOrEmpty(null);
		
		StepVerifier.create(mono).verifyComplete();
		
		
	}

	@Test
	public void monoUsingSupplier() {
			Supplier<String> stringSuplier = () -> "Mayur";
			Mono<String> mono = Mono.fromSupplier(stringSuplier);
			
			StepVerifier.create(mono).expectNext("Mayur").verifyComplete();
	}
	
	
}
