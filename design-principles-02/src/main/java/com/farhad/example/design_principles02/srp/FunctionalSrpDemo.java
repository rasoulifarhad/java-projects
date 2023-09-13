package com.farhad.example.design_principles02.srp;

import static com.farhad.example.design_principles02.srp.FunctionalSrpDemo.FunctionalCombinatorSrp.ArtistValidator.hasEmailWithAtSign;
import static com.farhad.example.design_principles02.srp.FunctionalSrpDemo.FunctionalCombinatorSrp.ArtistValidator.nameIsNotEmpty;

import java.util.Optional;
import java.util.function.Function;

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

		interface ArtistValidator extends Function<Artist, Optional<Artist>> {
			static ArtistValidator hasEmailWithAtSign() {
				return holds(artist -> artist.email.contains("@"));
			}

			static ArtistValidator nameIsNotEmpty() {
				return holds(artist -> !artist.name.trim().isEmpty()); 
			}

			static ArtistValidator holds(Function<Artist, Boolean> func) {
				return artist ->  func.apply(artist) ? Optional.of(artist) : Optional.empty();
			} 

			default ArtistValidator and(ArtistValidator other) {
				return artist -> apply(artist).flatMap(other);
			}
		}

		class ArtistService {

			public Optional<Artist> createArtistWithValidatedEmailAndName(String name, String emailString){
				final ArtistValidator validator = nameIsNotEmpty().and(hasEmailWithAtSign());
				return validator.apply(new Artist(name, emailString));
			}
		}
	}
}
