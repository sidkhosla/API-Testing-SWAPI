package Connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ConnectionManager {

    private static final boolean Boy = false;
    private static final Object IBIO = null;
    static HttpClient httpClient = HttpClient.newHttpClient();
    static HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://swapi.dev/api/"))
            .build();
    private static final String BaseURL = "https://swapi.dev/api/";
    private static String endPoint = "people/1/";

    public static String getConnection(String endPoint) {
        return BaseURL + endPoint;
    }

    public static int getStatusCode() {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().
                uri(URI.create
                        (BaseURL + endPoint)).build();
        int statusCode = 0;
        try {
            HttpResponse<String> httpResponse = httpClient.send
                    (httpRequest, HttpResponse.BodyHandlers.ofString());
            statusCode = httpResponse.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public static int getStatusWithEndpoint(String endPoint) {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().
                uri(URI.create
                        (BaseURL + endPoint)).build();
        int statusCode = 0;
        try {
            HttpResponse<String> httpResponse = httpClient.send
                    (httpRequest, HttpResponse.BodyHandlers.ofString());
            statusCode = httpResponse.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public static List<String> getHeaders() throws IOException, InterruptedException {
        HttpResponse<String> httpResponse = httpClient.send
                (httpRequest, HttpResponse.BodyHandlers.ofString());
        HttpHeaders headers = httpResponse.headers();
        Map<String, List<String>> map = headers.map();
        System.out.println(headers.toString());
        return headers.allValues("Server");
    }
        public static void LaunchStarWars()
        {
            {
                System.out.println("      ________________.  ___     .______");
                System.out.println("     /                | /   \\    |   _  \\");
                System.out.println("    |   (-----|  |----`/  ^  \\   |  |_)  |");
                System.out.println("     \\   \\    |  |    /  /_\\  \\  |      /");
                System.out.println(".-----)   |   |  |   /  _____  \\ |  |\\  \\-------.");
                System.out.println("|________/    |__|  /__/     \\__\\| _| `.________|");
                System.out.println(" ____    __    ____  ___     .______    ________.");
                System.out.println(" \\   \\  /  \\  /   / /   \\    |   _  \\  /        |");
                System.out.println("  \\   \\/    \\/   / /  ^  \\   |  |_)  ||   (-----`");
                System.out.println("   \\            / /  /_\\  \\  |      /  \\   \\");
                System.out.println("    \\    /\\    / /  _____  \\ |  |\\  \\---)   |");
                System.out.println("     \\__/  \\__/ /__/     \\__\\|__| `._______/");
            }
        }

    }

