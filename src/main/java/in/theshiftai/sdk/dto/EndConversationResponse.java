package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Instant;
import java.util.UUID;

/**
 * Response DTO for ending conversations.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndConversationResponse {
    private boolean success;
    private String message;
    private UUID conversationId;
    private String conversationExternalId;
    private Instant endedAt;

    public EndConversationResponse() {}

    // Getters and setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public UUID getConversationId() { return conversationId; }
    public void setConversationId(UUID conversationId) { this.conversationId = conversationId; }

    public String getConversationExternalId() { return conversationExternalId; }
    public void setConversationExternalId(String conversationExternalId) { this.conversationExternalId = conversationExternalId; }

    public Instant getEndedAt() { return endedAt; }
    public void setEndedAt(Instant endedAt) { this.endedAt = endedAt; }
}