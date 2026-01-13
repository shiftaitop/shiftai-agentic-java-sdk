package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Instant;

/**
 * Simplified conversation message response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationMessageResponse {
    private String sender;
    private String message;
    private Instant timestamp;
    private String generatedContext;
    private String ragContext;
    private String conversationTitle;  // LLM-generated conversation title

    public ConversationMessageResponse() {}

    // Getters and setters
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }

    public String getGeneratedContext() { return generatedContext; }
    public void setGeneratedContext(String generatedContext) { this.generatedContext = generatedContext; }

    public String getRagContext() { return ragContext; }
    public void setRagContext(String ragContext) { this.ragContext = ragContext; }

    public String getConversationTitle() { return conversationTitle; }
    public void setConversationTitle(String conversationTitle) { this.conversationTitle = conversationTitle; }
}
