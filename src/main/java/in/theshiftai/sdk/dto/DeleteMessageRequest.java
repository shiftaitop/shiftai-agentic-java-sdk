package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * Request body for soft-deleting a BOT message (and its paired HUMAN message).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteMessageRequest {
    private UUID messageId;

    public DeleteMessageRequest() {}

    public DeleteMessageRequest(UUID messageId) {
        this.messageId = messageId;
    }

    public UUID getMessageId() { return messageId; }
    public void setMessageId(UUID messageId) { this.messageId = messageId; }
}
