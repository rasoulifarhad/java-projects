package com.farhad.example.functional.patterns;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.farhad.example.functional.patterns.TypeSpecificFunctionalityDemo.Movie.Type;
import com.farhad.example.functional.patterns.TypeSpecificFunctionalityDemo.NewReleasePriceRepository;
import com.farhad.example.functional.patterns.TypeSpecificFunctionalityDemo.PriceService;

public class TypeSpecificFunctionalityDemoTest {

	@Test
	public void  testTypeSpecificFunctionality() {

		NewReleasePriceRepository repository = mock(NewReleasePriceRepository.class);
		when(repository.getFactor()).thenReturn(2D);

		PriceService priceService = new PriceService(repository);
		System.out.println(priceService.computePrice(Type.REGULAR, 2));
		System.out.println(priceService.computePrice(Type.NEW_RELEASE, 2));
		System.out.println(priceService.computePrice(Type.CHILDREN, 2));
	}
}

