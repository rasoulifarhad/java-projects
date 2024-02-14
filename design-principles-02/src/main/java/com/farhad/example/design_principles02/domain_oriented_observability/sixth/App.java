package com.farhad.example.design_principles02.domain_oriented_observability.sixth;

// +--------------+                                    +----------------+  observes  +------------------+            +------------------+ 
// |              |   ApplyingDiscountCode Event       |                |----------> | LoggingMonitor   |----------> |  Logging system  |
// |              |----------------------------------->|                |            +------------------+            +------------------+
// |              |                                    |  Observation   |  observes  +------------------+            +------------------+
// | ShoppingCart | DiscountCodeLookupSucceeded Event  |   Announcer    |----------> | MetricsMonitor   |----------> |  Metrics system  |
// |              |----------------------------------->|                |            +------------------+            +------------------+
// |              |                                    |                |  observes  +------------------+            +------------------+
// |              |   DiscountApplied Event            |                |----------> | AnalyticsMonitor |----------> | Analytics system |
// |              |----------------------------------->|                |            +------------------+            +------------------+
// +--------------+                                    +----------------+            
//
// +--------------+                                    +-----------------+            +------------------+ 
// |              |   applyingDiscountCode             |                 |----------> |  Logging system  |
// |              |--------------------------------->  |                 |            +------------------+
// |              |                                    |                 |            +------------------+
// | ShoppingCart |   discountCodeLookupSucceeded      |  Domain Probe   |----------> |  Metrics system  |
// |              |--------------------------------->  |                 |            +------------------+
// |              |                                    |                 |            +------------------+
// |              |   discountApplied                  |                 |----------> | Analytics system |
// |              |--------------------------------->  |                 |            +------------------+
// +--------------+                                    +-----------------+

public class App {

	public static void main(String[] args) {
		
	}
}
