package com.farhad.example.design_principles02.srp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.farhad.example.design_principles02.srp.FunctionalSrpDemo.FunctionalCombinatorSrp.Artist;
import com.farhad.example.design_principles02.srp.FunctionalSrpDemo.FunctionalCombinatorSrp.ArtistService;;

public class SrpDemoTest {

	    @Test
    public void artist_with_empty_name_should_not_be_valid(){
        final ArtistService service = new ArtistService();

        Optional<Artist> artist = service.createArtistWithValidatedEmailAndName("", "anyEmail@example.com");

        assertThat(artist).isEmpty();
    }

    @Test
    public void artist_with_invalid_mail_should_not_be_valid(){
        final ArtistService service = new ArtistService();

        Optional<Artist> artist = service.createArtistWithValidatedEmailAndName("anyName", "anyName");

        assertThat(artist).isEmpty();
    }

    @Test
    public void artist_with_valid_mail_and_valid_name_should_be_valid(){
        final ArtistService service = new ArtistService();

        Optional<Artist> artist = service.createArtistWithValidatedEmailAndName("anyName", "anyEmail@example.com");
        assertTrue(artist.isPresent());
        assertThat(artist.get().getName()).isEqualTo("anyName");
        assertThat(artist.get().getEmail()).isEqualTo("anyEmail@example.com");
    }
}
