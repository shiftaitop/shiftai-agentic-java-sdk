package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Conversation message response.
 *
 * This DTO is intended to mirror the platform endpoint payload for
 * POST /api/platform/conversation/getmessages as closely as possible.
 *
 * Any additional fields returned by the backend (e.g., feedback / eval fields)
 * that are not explicitly modeled here will be captured in {@code additionalProperties}.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationMessageResponse {
    private UUID id;
    private String message;
    private Instant timestamp;
    private String sender;
    private String messageType;
    private UUID userId;
    private String username;
    private UUID agentId;
    private String agentName;
    private String intent;
    private Map<String, Object> entities;
    private Map<String, Object> annotations;
    private Map<String, Object> sourceEvent;
    private UUID replyToMessageId;
    private String generatedContext;
    private String ragContext;
    private String conversationTitle;  // LLM-generated conversation title
    private Map<String, Object> additionalProperties = new HashMap<>();

    public ConversationMessageResponse() {}

    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }

    public String getMessageType() { return messageType; }
    public void setMessageType(String messageType) { this.messageType = messageType; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public UUID getAgentId() { return agentId; }
    public void setAgentId(UUID agentId) { this.agentId = agentId; }

    public String getAgentName() { return agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }

    public String getIntent() { return intent; }
    public void setIntent(String intent) { this.intent = intent; }

    public Map<String, Object> getEntities() { return entities; }
    public void setEntities(Map<String, Object> entities) { this.entities = entities; }

    public Map<String, Object> getAnnotations() { return annotations; }
    public void setAnnotations(Map<String, Object> annotations) { this.annotations = annotations; }

    public Map<String, Object> getSourceEvent() { return sourceEvent; }
    public void setSourceEvent(Map<String, Object> sourceEvent) { this.sourceEvent = sourceEvent; }

    public UUID getReplyToMessageId() { return replyToMessageId; }
    public void setReplyToMessageId(UUID replyToMessageId) { this.replyToMessageId = replyToMessageId; }

    public String getGeneratedContext() { return generatedContext; }
    public void setGeneratedContext(String generatedContext) { this.generatedContext = generatedContext; }

    public String getRagContext() { return ragContext; }
    public void setRagContext(String ragContext) { this.ragContext = ragContext; }

    public String getConversationTitle() { return conversationTitle; }
    public void setConversationTitle(String conversationTitle) { this.conversationTitle = conversationTitle; }

    /**
     * Captures any additional backend fields not explicitly modeled.
     */
    @JsonAnySetter
    public void putAdditionalProperty(String key, Object value) {
        additionalProperties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties != null ? additionalProperties : new HashMap<>();
    }
}
