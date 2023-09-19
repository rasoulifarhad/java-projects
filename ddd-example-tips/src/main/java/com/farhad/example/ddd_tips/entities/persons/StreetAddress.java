package com.farhad.example.ddd_tips.entities.persons;
import java.io.Serializable;
import java.util.Objects;

import com.farhad.example.ddd_tips.vclue_objects.street_address.Country;
import com.farhad.example.ddd_tips.vclue_objects.street_address.PostalCode;

import lombok.Value;

@Value
public class StreetAddress implements Serializable, Comparable<StreetAddress> {
	
	private final String streetAddress;
	private final PostalCode postalCode;
	private final String city;
	private final Country country;

	public StreetAddress(String streetAddress, PostalCode postalCode, String city, Country country) {
		this.streetAddress = Objects.requireNonNull(streetAddress);
		this.postalCode = Objects.requireNonNull(postalCode);
		this.city = Objects.requireNonNull(city);
		this.country = Objects.requireNonNull(country);
	}

	public static class Builder {

		private String streetAddress;
		private PostalCode postalCode;
		private String city;
		private Country country;

		public Builder() {

		}

		public Builder(StreetAddress original) {
			streetAddress = original.streetAddress;
			postalCode = original.postalCode;
			city = original.city;
			country = original.country;
		}

		public Builder withStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
			return this;
		}

		public Builder withPostalCode(PostalCode postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public Builder withCity(String city) {
			this.city = city;
			return this;
		}

		public Builder withCountry(Country country) {
			this.country = country;
			return this;
		}

		public StreetAddress build() {
			return new StreetAddress(streetAddress, postalCode, city, country);
		}
	}

	@Override
	public int compareTo(StreetAddress o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
	}
}


