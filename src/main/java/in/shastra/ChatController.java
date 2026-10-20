package in.shastra;

import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ChatController {
    private final AiService aiService;
    public ChatController(AiService aiService) { this.aiService = aiService; }

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody ChatRequest request) {
        String answer = aiService.reply(request.message());
        return Map.of("answer", answer);
    }

    @PostMapping("/feedback")
    public Map<String, String> feedback(@RequestBody FeedbackRequest request) {
        // Starter implementation: logs feedback. Add JDBC persistence before deployment.
        System.out.printf("Feedback received | rating=%s | comment=%s%n",
                request.rating(), request.comment());
        return Map.of("status", "received", "message", "Thanks for helping improve Shastra!");
    }

    public record ChatRequest(String message, String branchId) {}
    public record FeedbackRequest(String rating, String comment, String question, String answer) {}
}
