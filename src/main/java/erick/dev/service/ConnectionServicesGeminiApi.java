package erick.dev.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

@Service
public class ConnectionServicesGeminiApi {

    private static final String URL_API = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=AIzaSyDnvakt0-t6YiF0_gZ3EPBbEDeIhCa7vjM";

    /**
     * @param body
     * @return
     */
    public String sendMessageGemini(String body) {

        String reponse = null;

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(URL_API))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
            reponse = resp.body();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return reponse;

    }

}
