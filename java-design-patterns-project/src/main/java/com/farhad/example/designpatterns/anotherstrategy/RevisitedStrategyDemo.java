package com.farhad.example.designpatterns.anotherstrategy;

import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class RevisitedStrategyDemo {
	

	public static void main(String[] args) {
		GoogleWalletEndpoint endpoint = getEndpoint();
		PassInformation passInformation = new PassInformation(new UserProfile(true, true, true));
		String jwt = endpoint.get(passInformation);
		System.out.println(jwt);

		GoogleWalletEndpoint endpoint2 = getEndpoint2();
		System.out.println(endpoint2.get(passInformation));
		
		
	}

	public static GoogleWalletEndpoint getEndpoint() {
		GoogleWalletEndpoint endpoint = new GoogleWalletEndpoint();
		endpoint.setStrategy(p -> "abc");
		return endpoint;
	}

	public static GoogleWalletEndpoint getEndpoint2() {
		GoogleWalletEndpoint endpoint = new GoogleWalletEndpoint();
		endpoint.setStrategy(new AddToGoogleWalletLink()::complate);
		return endpoint;
	}

	public static GoogleWalletEndpoint getEndpoint3() {
		GoogleWalletEndpoint endpoint = new GoogleWalletEndpoint();
		endpoint.setStrategy(new AddToGoogleWalletLink()::preCreated);
		return endpoint;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	static class GoogleWalletEndpoint {
		private Function<PassInformation, String> strategy;

		public String get(PassInformation passInformation) {
			return strategy.apply(passInformation);
		}

	}

	static class AddToGoogleWalletLink {

		public String complate(PassInformation passInformation) {
			return "JWT with complete information.";
		}

		public String preCreated(PassInformation passInformation) {
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
