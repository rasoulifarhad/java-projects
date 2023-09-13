package com.farhad.example.design_principles02.srp;

import java.util.Optional;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class FunctionalSrpDemo {
	public interface FunctionalSrp {

		@Data
		@RequiredArgsConstructor
		class Artist {
			private final String name;
			private final String email;
		}

		class ArtistService {

			public Optional<Artist> createArtistWithValidatedEmail(String name, String emailString) {
				return Optional
							.of(new Artist(name, emailString))
							.flatMap(this::mailContainsAtSign);
			}
			public Optional<Artist> createArtistWithValidatedEmailAndName(String name, String emailString) {
				return Optional
							.of(new Artist(name, emailString))
							.flatMap(this::mailContainsAtSign)
							.flatMap(this::nameIsNotEmpty);
			}
			private Optional<Artist> mailContainsAtSign(Artist artist) {
				return artist.email.contains("@") ? Optional.of(artist) : Optional.empty(); 
			}

			private Optional<Artist> nameIsNotEmpty(Artist artist) {
				return artist.name.trim().isEmpty() ?  Optional.empty() : Optional.of(artist);
			}
		}

	}

	public interface FunctionalCombinatorSrp {

		@Data
		@RequiredArgsConstructor
		class Artist {
			private final String name;
			private final String email;
		}

		class ArtistService {

			// public Optional<Artist> createArtistWithValidatedEmailAndName(String name, String emailString){
			// }
		}
	}
}
