package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.UUID;

/**
 * Conversation summary response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationSummaryResponse {
    private UUID conversationId;
    private String username;
    private String agentName;

    @JsonProperty("startedAt")
    private Instant startTime;

    @JsonProperty("endedAt")
    private Instant endTime;
    private String conversationTitle;  // LLM-generated conversation title

    public ConversationSummaryResponse() {}

    // Getters and setters
    public UUID getConversationId() { return conversationId; }
    public void setConversationId(UUID conversationId) { this.conversationId = conversationId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getAgentName() { return agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }

    public Instant getStartTime() { return startTime; }
    public void setStartTime(Instant startTime) { this.startTime = startTime; }

    public Instant getEndTime() { return endTime; }
    public void setEndTime(Instant endTime) { this.endTime = endTime; }

    public String getConversationTitle() { return conversationTitle; }
    public void setConversationTitle(String conversationTitle) { this.conversationTitle = conversationTitle; }
}
