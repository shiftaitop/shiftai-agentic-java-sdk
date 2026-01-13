package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * User analytics DTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAnalyticsDTO {
    private String username;
    private String email;
    private UUID userId;
    private Integer queries;
    private Integer responses;
    private Float avgResponseTimeSeconds;
    private Integer likes;
    private Integer dislikes;
    private Integer regenerates;

    public UserAnalyticsDTO() {}

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public Integer getQueries() { return queries; }
    public void setQueries(Integer queries) { this.queries = queries; }

    public Integer getResponses() { return responses; }
    public void setResponses(Integer responses) { this.responses = responses; }

    public Float getAvgResponseTimeSeconds() { return avgResponseTimeSeconds; }
    public void setAvgResponseTimeSeconds(Float avgResponseTimeSeconds) { this.avgResponseTimeSeconds = avgResponseTimeSeconds; }

    public Integer getLikes() { return likes; }
    public void setLikes(Integer likes) { this.likes = likes; }

    public Integer getDislikes() { return dislikes; }
    public void setDislikes(Integer dislikes) { this.dislikes = dislikes; }

    public Integer getRegenerates() { return regenerates; }
    public void setRegenerates(Integer regenerates) { this.regenerates = regenerates; }
}
