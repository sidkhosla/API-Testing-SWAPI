package DTOs;

public class DTOFactory {
    public static StarWarsDTO dtoFactory(String endPoint) {
        int slash = endPoint.indexOf('/');
        String input = endPoint.substring(0,slash);

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

    public static void main(String[] args) {

        System.out.println(DTOFactory.dtoFactory("people/1/"));
        System.out.println(DTOFactory.dtoFactory("films/1/"));
        System.out.println(DTOFactory.dtoFactory("starships/12/"));


    }
}
