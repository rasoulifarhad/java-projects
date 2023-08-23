package com.farhad.example.designpatterns.anotherstrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// See https://github.com/yanaga/revisiting-design-patterns/blob/main/src/main/java/com/google/developers/wallet/strategy/legacy/LegacyStrategy.java
public class LegacyStrategyDemo {
	
	public static void main(String[] args) {
		GoogleWalletEndpoint endpoint = getEndpoint();
		PassInformation passInformation = new PassInformation(new UserProfile(true, true, true));
		String jwt = endpoint.get(passInformation);
		System.out.println(jwt);
	}

	public static GoogleWalletEndpoint getEndpoint() {
		GoogleWalletEndpoint endpoint = new GoogleWalletEndpoint();
		endpoint.setStrategy(new ComplateJwtAddToGoogleWalletStrategy());
		return endpoint;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	static class GoogleWalletEndpoint {
		private AddToGoogleWalletStrategy strategy;

		public String get(PassInformation passInformation) {
			return strategy.createLink(passInformation);
		}

	}

	interface AddToGoogleWalletStrategy {
		String createLink(PassInformation information);
	}

	static class ComplateJwtAddToGoogleWalletStrategy implements AddToGoogleWalletStrategy {

		@Override
		public String createLink(PassInformation information) {
			return "JWT with complete information.";
		}

	}

	static class PreCreatedJwtAddToGoogleWalletStrategy implements AddToGoogleWalletStrategy {

		@Override
		public String createLink(PassInformation information) {
			return "JWT with just the IDs of the objects.";
		}

	}

	@RequiredArgsConstructor
	@Data
	static class UserProfile {
		private final boolean hasGoogleWalletPass;
		private final boolean allowsEmail;
		private final boolean allowsSms;
	}

	@RequiredArgsConstructor
	@Data
	static class PassInformation {
		private final UserProfile userProfile;
	}
}
