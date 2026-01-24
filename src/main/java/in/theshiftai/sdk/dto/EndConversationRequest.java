package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * Request DTO for ending conversations.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndConversationRequest {
    private UUID conversationId;

    public EndConversationRequest() {}

    // Getters and setters
    public UUID getConversationId() { return conversationId; }
    public void setConversationId(UUID conversationId) { this.conversationId = conversationId; }
}