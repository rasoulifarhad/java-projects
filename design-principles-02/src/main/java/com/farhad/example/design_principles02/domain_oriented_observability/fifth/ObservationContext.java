package com.farhad.example.design_principles02.domain_oriented_observability.fifth;

import java.util.Collections;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class ObservationContext {

	private final RequestContext requestContext;
	private final StandardContext standardContext;

	public ShoppingCartInstrumentation createShoppingCartInstrumentation(Map<String, Object> extraParams) {
		return new ShoppingCartInstrumentation(mergeParams(requestContext, standardContext, extraParams));
	}

	private Map<String, Object> mergeParams(RequestContext requestContext2, StandardContext standardContext2,
			Map<String, Object> extraParams) {
		return Collections.emptyMap();
	}
}
