package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

/**
 * Project analytics response DTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectAnalyticsResponseDTO {
    private Integer totalUsers;
    private Integer totalAgents;
    private Integer totalQueries;
    private Integer totalResponses;
    private Float avgResponseTimeSeconds;
    private Integer totalFeedback;
    private Integer likes;
    private Integer dislikes;
    private Integer regenerates;
    private List<Map<String, Object>> topUserActivity;
    private List<Map<String, Object>> topDevicesByUsage;

    public ProjectAnalyticsResponseDTO() {}

    // Getters and setters
    public Integer getTotalUsers() { return totalUsers; }
    public void setTotalUsers(Integer totalUsers) { this.totalUsers = totalUsers; }

    public Integer getTotalAgents() { return totalAgents; }
    public void setTotalAgents(Integer totalAgents) { this.totalAgents = totalAgents; }

    public Integer getTotalQueries() { return totalQueries; }
    public void setTotalQueries(Integer totalQueries) { this.totalQueries = totalQueries; }

    public Integer getTotalResponses() { return totalResponses; }
    public void setTotalResponses(Integer totalResponses) { this.totalResponses = totalResponses; }

    public Float getAvgResponseTimeSeconds() { return avgResponseTimeSeconds; }
    public void setAvgResponseTimeSeconds(Float avgResponseTimeSeconds) { this.avgResponseTimeSeconds = avgResponseTimeSeconds; }

    public Integer getTotalFeedback() { return totalFeedback; }
    public void setTotalFeedback(Integer totalFeedback) { this.totalFeedback = totalFeedback; }

    public Integer getLikes() { return likes; }
    public void setLikes(Integer likes) { this.likes = likes; }

    public Integer getDislikes() { return dislikes; }
    public void setDislikes(Integer dislikes) { this.dislikes = dislikes; }

    public Integer getRegenerates() { return regenerates; }
    public void setRegenerates(Integer regenerates) { this.regenerates = regenerates; }

    public List<Map<String, Object>> getTopUserActivity() { return topUserActivity; }
    public void setTopUserActivity(List<Map<String, Object>> topUserActivity) { this.topUserActivity = topUserActivity; }

    public List<Map<String, Object>> getTopDevicesByUsage() { return topDevicesByUsage; }
    public void setTopDevicesByUsage(List<Map<String, Object>> topDevicesByUsage) { this.topDevicesByUsage = topDevicesByUsage; }
}
