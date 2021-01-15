package DTOs;

public class DTOFactory {
    public static StarWarsDTO dtoFactory(String url) {
        String[] parts = url.split("/");
        String input = parts[4];
        switch (input){
            case "films":
                return new FilmsDTO();
            case "people":
                return new PeopleDTO();
            case "planets":
                return new PlanetDTO();
            case "species":
                return new SpeciesDTO();
            case "starships":
                return new StarshipsDTO();
            case "vehicles":
                return new VehiclesDTO();
        }
        return null;
    }
}
