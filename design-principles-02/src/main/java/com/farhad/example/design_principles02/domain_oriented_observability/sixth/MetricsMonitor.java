package com.farhad.example.design_principles02.domain_oriented_observability.sixth;

import java.util.Collections;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MetricsMonitor {

	private final Metrics metrics;

	public void handleAnnouncement(Announcement announcement) {

		if (announcement instanceof DiscountCodeLookupFailed) {
			log.error("discount lookup failed", ((DiscountCodeLookupFailed) announcement).getEx());
			this.metrics.increment("discount-lookup-failure", Collections.singletonMap("code", ((DiscountCodeLookupFailed)announcement).getDiscountCode()));

		}

		if (announcement instanceof DiscountCodeLookupSucceeded) {
		this.metrics.increment("discount-lookup-success", Collections.singletonMap("code", 
				((DiscountCodeLookupSucceeded) announcement).getDiscountCode()));

		}

	}

}
