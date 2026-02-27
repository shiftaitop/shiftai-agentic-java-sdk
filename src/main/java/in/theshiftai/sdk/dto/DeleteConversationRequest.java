package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * Request body for deleting a conversation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteConversationRequest {
    private UUID conversationId;

    public DeleteConversationRequest() {}

    public DeleteConversationRequest(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public UUID getConversationId() { return conversationId; }
    public void setConversationId(UUID conversationId) { this.conversationId = conversationId; }
}
