package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.UUID;

/**
 * Request object for submitting platform messages.
 * SDK-owned DTO - independent of server codebase.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformMessageSubmissionRequest {
    @JsonProperty("username")
    private String userName;

    @JsonProperty("email")
    private String userEmail;

    @JsonProperty("metadata")
    private Map<String, Object> userMetadata;

    private AgentData agentData;

    private SenderType senderType;

    private String message;

    private String intent;

    private Map<String, Object> entities;

    private Map<String, Object> annotations;

    private MessageType messageType;

    private Map<String, Object> sourceEvent;

    private String ragContext;

    private UUID replyMessageId;

    private String mode;

    // Getters and setters
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public Map<String, Object> getUserMetadata() { return userMetadata; }
    public void setUserMetadata(Map<String, Object> userMetadata) { this.userMetadata = userMetadata; }

    public AgentData getAgentData() { return agentData; }
    public void setAgentData(AgentData agentData) { this.agentData = agentData; }

    public SenderType getSenderType() { return senderType; }
    public void setSenderType(SenderType senderType) { this.senderType = senderType; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getIntent() { return intent; }
    public void setIntent(String intent) { this.intent = intent; }

    public Map<String, Object> getEntities() { return entities; }
    public void setEntities(Map<String, Object> entities) { this.entities = entities; }

    public Map<String, Object> getAnnotations() { return annotations; }
    public void setAnnotations(Map<String, Object> annotations) { this.annotations = annotations; }

    public MessageType getMessageType() { return messageType; }
    public void setMessageType(MessageType messageType) { this.messageType = messageType; }

    public Map<String, Object> getSourceEvent() { return sourceEvent; }
    public void setSourceEvent(Map<String, Object> sourceEvent) { this.sourceEvent = sourceEvent; }

    public String getRagContext() { return ragContext; }
    public void setRagContext(String ragContext) { this.ragContext = ragContext; }

    public UUID getReplyMessageId() { return replyMessageId; }
    public void setReplyMessageId(UUID replyMessageId) { this.replyMessageId = replyMessageId; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }
}
