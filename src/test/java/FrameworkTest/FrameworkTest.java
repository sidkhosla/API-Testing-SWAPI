package FrameworkTest;

import Connection.ConnectionManager;
import DTOs.*;
import Injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;


public class FrameworkTest {
    static FilmsDTO filmsDTO;
    static PeopleDTO peopleDTO;
    static PlanetDTO planetDTO;
    static SpeciesDTO speciesDTO;
    static StarshipsDTO starshipsDTO;
    static VehiclesDTO vehiclesDTO;

    @BeforeAll
    @DisplayName("Setup")
    static void setup() {
        filmsDTO = (FilmsDTO) Injector.injectDTO(
                ConnectionManager.getConnection("films/1/"));

        peopleDTO = (PeopleDTO) Injector.injectDTO(
                ConnectionManager.getConnection("people/1/"));

        planetDTO = (PlanetDTO) Injector.injectDTO(
                ConnectionManager.getConnection("planets/3/"));

        speciesDTO = (SpeciesDTO) Injector.injectDTO(
                ConnectionManager.getConnection("species/3/"));

        starshipsDTO = (StarshipsDTO) Injector.injectDTO(
                ConnectionManager.getConnection("starships/12/"));

        vehiclesDTO = (VehiclesDTO) Injector.injectDTO(
                ConnectionManager.getConnection("vehicles/4/"));
    }

    @Test
    @DisplayName("What headers do we get?")
    void whatHeadersDoWeGet() throws IOException, InterruptedException {
        List<String> allValues = ConnectionManager.getHeaders();
    }

    @Test
    @DisplayName("Is Luke's height 172?")
    void LukeHeight(){
        Assertions.assertEquals("172", peopleDTO.getHeight());
    }

    @Test
    @DisplayName("Is Luke's name correct")
    void LukeNameCheck(){
        Assertions.assertEquals("Luke Skywalker", peopleDTO.getName());
    }

    @Test
    @DisplayName("get the film title for Luke")
    void GetFilmTitle(){
        System.out.println(peopleDTO.getName());
        System.out.println(peopleDTO.getFilms().get(0));
        System.out.println(filmsDTO.getTitle());
        Assertions.assertEquals(peopleDTO.getFilms().get(0), filmsDTO.getUrl());
    }

    @Test
    @DisplayName("get the film title for Luke")
    void filmTitle(){
        System.out.println(filmsDTO.getTitle());
    }

    @Test
    @DisplayName("how fast is the starship?")
    void speedOfTheStarship(){
        System.out.println(starshipsDTO.getName());
        System.out.println(starshipsDTO.getMaxAtmospheringSpeed());
        Assertions.assertEquals("1050", starshipsDTO.getMaxAtmospheringSpeed());
    }

    @Test
    @DisplayName("can luke drive X-wing")
    void lukXWING(){
        Assertions.assertTrue(peopleDTO.getStarships().contains(starshipsDTO.getUrl()));
    }

    @Test
    @DisplayName("Person get name")
    void getName() {
        Assertions.assertEquals("Luke Skywalker", peopleDTO.getName());
    }

    @Test
    @DisplayName("Test response code")
    void testResponseCode() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode());
    }

    @Test
    @DisplayName("check status code for a specific page")
    void getStatusWithEndpoint() {
        Assertions.assertEquals(200, ConnectionManager.getStatusWithEndpoint("vehicles/4/"));
    }

}
