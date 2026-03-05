package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * Single feedback item in the latest feedbacks response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestFeedbackItemResponse {
    private UUID messageId;
    private String username;
    private String agentName;
    private UUID conversationId;
    private String sender;
    private String message;
    private String feedbackTitle;
    private String feedback;
    private String context;
    private String time;

    public LatestFeedbackItemResponse() {}

    public UUID getMessageId() { return messageId; }
    public void setMessageId(UUID messageId) { this.messageId = messageId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getAgentName() { return agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }

    public UUID getConversationId() { return conversationId; }
    public void setConversationId(UUID conversationId) { this.conversationId = conversationId; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getFeedbackTitle() { return feedbackTitle; }
    public void setFeedbackTitle(String feedbackTitle) { this.feedbackTitle = feedbackTitle; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public String getContext() { return context; }
    public void setContext(String context) { this.context = context; }

    /** ISO 8601 submission time. */
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
}
