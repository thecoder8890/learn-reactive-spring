package com.learnreactivespring.fulxandmonoplayground;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.ParallelFlux;
import reactor.test.StepVerifier;

public class FluxMonoFilterTest {

	List<String> names = Arrays.asList("Mayur", "Rajiv", "Pankaj", "Amit");

	@Test
	public void filterTest() {
		Flux<String> nameFlux = Flux.fromIterable(names).filter(s->s.startsWith("A")).log();
		
		StepVerifier.create(nameFlux).expectNext("Amit").verifyComplete();
		

	}
	
	@Test
	public void transfromUsingMap() {
		
		Flux<String> nameFlux = Flux.fromIterable(names).map(s->s.toUpperCase()).log();
		
		StepVerifier.create(nameFlux).expectNext("MAYUR", "RAJIV", "PANKAJ", "AMIT").verifyComplete();
		
		
		
	}
	
	@Test
	public void transfromUsingFlatMap() {
		
		Flux<String> stringFlux = Flux.fromIterable(Arrays.asList("A","B","C","D","E")).flatMap(
				s->{
					return Flux.fromIterable(convertToList(s));
				}
				).log();
		
		
		
		StepVerifier.create(stringFlux).expectNextCount(12).verifyComplete();
		
		
		
	}

	private List<String> convertToList(String s) {
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Arrays.asList(s, "newValue");
		}


	
}
