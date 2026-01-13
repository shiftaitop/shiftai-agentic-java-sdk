package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO representing a vector entry in Weaviate.
 * Matches Python SDK WeaviateVector exactly.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeaviateVector {
    private String text;
    private String humanMessageId;
    private String botMessageId;
    private String conversationId;
    private String userId;
    private String agentId;
    private String timestamp;
    private String messageType;
    private String generatedContext;
    private Float confidence;
    private Float certainty;

    public WeaviateVector() {}

    // Getters and setters
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getHumanMessageId() { return humanMessageId; }
    public void setHumanMessageId(String humanMessageId) { this.humanMessageId = humanMessageId; }
    public String getBotMessageId() { return botMessageId; }
    public void setBotMessageId(String botMessageId) { this.botMessageId = botMessageId; }
    public String getConversationId() { return conversationId; }
    public void setConversationId(String conversationId) { this.conversationId = conversationId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getAgentId() { return agentId; }
    public void setAgentId(String agentId) { this.agentId = agentId; }
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public String getMessageType() { return messageType; }
    public void setMessageType(String messageType) { this.messageType = messageType; }
    public String getGeneratedContext() { return generatedContext; }
    public void setGeneratedContext(String generatedContext) { this.generatedContext = generatedContext; }
    public Float getConfidence() { return confidence; }
    public void setConfidence(Float confidence) { this.confidence = confidence; }
    public Float getCertainty() { return certainty; }
    public void setCertainty(Float certainty) { this.certainty = certainty; }
}
