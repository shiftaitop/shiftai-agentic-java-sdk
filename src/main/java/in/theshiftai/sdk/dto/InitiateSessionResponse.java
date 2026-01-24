package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * Response DTO for initiating conversation sessions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InitiateSessionResponse {
    private UUID conversationId;
    private String status;

    public InitiateSessionResponse() {}

    // Getters and setters
    public UUID getConversationId() { return conversationId; }
    public void setConversationId(UUID conversationId) { this.conversationId = conversationId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}