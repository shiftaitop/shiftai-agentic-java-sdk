package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * Top user DTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopUserDTO {
    private Integer rank;
    private String username;
    private String email;
    private UUID userId;
    private Integer queryCount;
    private Float avgResponseTimeSeconds;

    public TopUserDTO() {}

    // Getters and setters
    public Integer getRank() { return rank; }
    public void setRank(Integer rank) { this.rank = rank; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public Integer getQueryCount() { return queryCount; }
    public void setQueryCount(Integer queryCount) { this.queryCount = queryCount; }

    public Float getAvgResponseTimeSeconds() { return avgResponseTimeSeconds; }
    public void setAvgResponseTimeSeconds(Float avgResponseTimeSeconds) { this.avgResponseTimeSeconds = avgResponseTimeSeconds; }
}
