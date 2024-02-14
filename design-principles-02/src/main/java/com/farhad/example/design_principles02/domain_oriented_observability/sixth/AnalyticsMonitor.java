package com.farhad.example.design_principles02.domain_oriented_observability.sixth;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnalyticsMonitor {

	private final Analytics analytics;

	public void handleAnnouncement(Announcement announcement) {
		
		if (announcement instanceof DiscountCodeLookupFailed) {

		}
		
		if (announcement instanceof DiscountCodeLookupSucceeded) {
			
		}
	}

}
