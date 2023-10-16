package com.farhad.example.design_principles02.srp;

import java.util.Optional;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

public class SrpDemo {
	
	public interface NoSrp {

		@Data
		@RequiredArgsConstructor
		class Artist {
			private final String name;
			private final String email;
			
			public boolean isValid() {
				return email.contains("@");
			}
		}
	}

	public interface Srp {

		@Data
		@RequiredArgsConstructor
		class Artist {
			private final String name;
			private final Email email;
		}

		@Value
		class Email {
			private final String value;
			
			public Email(String value) {
				if (!isValid()) {
					throw new IllegalArgumentException("email is not valid");
				}
				this.value = value;
			}

			public boolean isValid() {
				return value.contains("@");
			}
		} 

		class ArtistService {
			public Optional<Artist> createValidArtist(String name, String emailString) {
				try {
					Email email = new Email(emailString);
					return Optional.of(new Artist(name, email));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					return Optional.empty();
				}
			}
		}
	}
}