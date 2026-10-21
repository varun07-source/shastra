
package in.shastra;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/db-health")
    public String checkDatabase() {
        Integer result = jdbcTemplate.queryForObject(
            "SELECT 1", Integer.class
        );

        if (result != null && result == 1) {
            return "Database connected successfully!";
        }

        throw new IllegalStateException("Database test failed");
    }
}
