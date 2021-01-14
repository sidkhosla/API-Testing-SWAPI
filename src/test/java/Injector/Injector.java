package Injector;

import Connection.ConnectionManager;
import DTOs.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Injector {

//    public static PeopleDTO injectPeopleDTO(String url){
//        PeopleDTO peopleDTO = new PeopleDTO();
//        ObjectMapper objectMapper = new ObjectMapper();
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
//
//        try {
//            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//            peopleDTO = objectMapper.readValue(httpResponse.body(), PeopleDTO.class);
//        }catch (IOException | InterruptedException e){
//            e.printStackTrace();
//        }
//        return peopleDTO;
//    }
//
//    public static FilmsDTO injectFilmsDTO(String url){
//        FilmsDTO filmsDTO = new FilmsDTO();
//        ObjectMapper objectMapper = new ObjectMapper();
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
//
//        try {
//            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//            filmsDTO = objectMapper.readValue(httpResponse.body(), FilmsDTO.class);
//        }catch (IOException | InterruptedException e){
//            e.printStackTrace();
//        }
//        return filmsDTO;
//    }
//
//    public static StarshipsDTO injectStarshipsDTO(String url){
//        StarshipsDTO starshipsDTO = new StarshipsDTO();
//        ObjectMapper objectMapper = new ObjectMapper();
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
//
//        try {
//            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//            starshipsDTO = objectMapper.readValue(httpResponse.body(), StarshipsDTO.class);
//        }catch (IOException | InterruptedException e){
//            e.printStackTrace();
//        }
//        return starshipsDTO;
//    }
//
//    public static VehiclesDTO injectVehiclesDTO(String url){
//        VehiclesDTO vehiclesDTO = new VehiclesDTO();
//        ObjectMapper objectMapper = new ObjectMapper();
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
//
//        try {
//            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//            vehiclesDTO = objectMapper.readValue(httpResponse.body(), VehiclesDTO.class);
//        }catch (IOException | InterruptedException e){
//            e.printStackTrace();
//        }
//        return vehiclesDTO;
//    }
    public static StarWarsDTO injectDTO(String url, String endPoint){
        StarWarsDTO starWarsDTO = DTOFactory.dtoFactory(endPoint);
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url + endPoint)).build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            starWarsDTO = objectMapper.readValue(httpResponse.body(), starWarsDTO.getClass());
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        return starWarsDTO;
    }

    public static void main(String[] args) {
        PeopleDTO peopleDTO = (PeopleDTO) injectDTO("https://swapi.dev/api/", "people/1/");
        System.out.println(peopleDTO.getHeight());
    }
}