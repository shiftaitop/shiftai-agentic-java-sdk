package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * Platform message model.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformMessage {
    private UUID id;
    private String message;
    private String senderType;
    private String messageType;
    /**
     * Optional org knowledge context persisted with the message.
     * May be null if org knowledge is unavailable or not configured.
     */
    private String orgContext;

    public PlatformMessage() {}

    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getSenderType() { return senderType; }
    public void setSenderType(String senderType) { this.senderType = senderType; }

    public String getMessageType() { return messageType; }
    public void setMessageType(String messageType) { this.messageType = messageType; }

    /**
     * Optional org knowledge context persisted with the message.
     * May be null if org knowledge is unavailable or not configured.
     */
    public String getOrgContext() { return orgContext; }
    public void setOrgContext(String orgContext) { this.orgContext = orgContext; }
}
