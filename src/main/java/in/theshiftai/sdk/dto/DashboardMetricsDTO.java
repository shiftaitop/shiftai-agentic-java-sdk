package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dashboard metrics DTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardMetricsDTO {
    private Integer totalUsers;
    private Integer totalAgents;
    private Integer totalQueries;
    private Integer totalResponses;
    private Float avgResponseTimeSeconds;
    private Integer totalFeedback;
    private Integer likes;
    private Integer dislikes;
    private Integer regenerates;

    public DashboardMetricsDTO() {}

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
}
