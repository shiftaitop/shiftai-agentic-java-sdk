package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple DTO representing a conversation message with sender and message content.
 * Used in PlatformMessageSubmissionResponse.previousKConversations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationMessage {
    private String sender;
    private String message;

    public ConversationMessage() {}

    public ConversationMessage(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    // Getters and setters
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
