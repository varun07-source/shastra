package in.shastra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class AiService {

    @Value("${ai.api-key:}")
    private String apiKey;

    @Value("${ai.base-url:https://generativelanguage.googleapis.com/v1beta}")
    private String baseUrl;

    @Value("${ai.model:gemini-3.8-flash}")
    private String model;

    public String reply(String message) {

        if (message == null || message.isBlank()) {
            return "Please type a question first.";
        }

        if (apiKey.isBlank()) {
            return "Gemini API key is missing. Please configure GEMINI_API_KEY.";
        }

        try {
            RestClient client = RestClient.builder()
                    .baseUrl(baseUrl)
                    .defaultHeader("x-goog-api-key", apiKey)
                    .build();

            Map<String, Object> body = Map.of(
                    "systemInstruction", Map.of(
                            "parts", List.of(
                                    Map.of(
                                            "text",
                                            "You are Shastra, a helpful student assistant. "
                                            + "Explain study and coding topics clearly "
                                            + "using beginner-friendly language. "
                                            + "For health questions, provide general "
                                            + "educational information only."
                                    )
                            )
                    ),
                    "contents", List.of(
                            Map.of(
                                    "parts", List.of(
                                            Map.of("text", message)
                                    )
                            )
                    )
            );

            Map<?, ?> response = client.post()
                    .uri("/models/{model}:generateContent", model)
                    .body(body)
                    .retrieve()
                    .body(Map.class);

            if (response == null) {
                return "Gemini returned an empty response. Please try again.";
            }

            List<?> candidates =
                    (List<?>) response.get("candidates");

            if (candidates == null || candidates.isEmpty()) {
                return "Gemini couldn't generate a response. Please try again.";
            }

            Map<?, ?> candidate =
                    (Map<?, ?>) candidates.get(0);

            Map<?, ?> content =
                    (Map<?, ?>) candidate.get("content");

            List<?> parts =
                    (List<?>) content.get("parts");

            StringBuilder answer = new StringBuilder();

            for (Object item : parts) {
                Map<?, ?> part = (Map<?, ?>) item;

                Object text = part.get("text");

                if (text instanceof String) {
                    answer.append(text);
                }
            }

            if (answer.isEmpty()) {
                return "Gemini returned no text. Please try another question.";
            }

            return answer.toString();

        } catch (Exception ex) {
            System.err.println(
                    "Gemini API request failed: "
                    + ex.getMessage()
            );

            return "I couldn't connect to Gemini. "
                    + "Please check your API key, model, and internet connection.";
        }
    }
}