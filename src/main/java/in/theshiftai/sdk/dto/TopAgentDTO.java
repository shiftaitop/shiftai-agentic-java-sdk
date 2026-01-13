package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * Top agent DTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopAgentDTO {
    private Integer rank;
    private String agentName;
    private UUID agentId;
    private Integer queryCount;
    private Float satisfactionPercentage;

    public TopAgentDTO() {}

    // Getters and setters
    public Integer getRank() { return rank; }
    public void setRank(Integer rank) { this.rank = rank; }

    public String getAgentName() { return agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }

    public UUID getAgentId() { return agentId; }
    public void setAgentId(UUID agentId) { this.agentId = agentId; }

    public Integer getQueryCount() { return queryCount; }
    public void setQueryCount(Integer queryCount) { this.queryCount = queryCount; }

    public Float getSatisfactionPercentage() { return satisfactionPercentage; }
    public void setSatisfactionPercentage(Float satisfactionPercentage) { this.satisfactionPercentage = satisfactionPercentage; }
}
