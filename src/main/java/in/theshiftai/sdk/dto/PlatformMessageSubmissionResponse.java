package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Response object for platform message submission.
 * SDK-owned DTO - matches backend payload exactly.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformMessageSubmissionResponse {
    private boolean success;
    private UUID messageId;
    private UUID conversationId;
    private String message;
    private Map<String, Object> contextualPrompt;
    private String humanQuery;  // Only present when senderType is HUMAN
    private List<List<ConversationMessage>> previousKConversations;
    private List<WeaviateVector> similarConversations;  // Only present when senderType is HUMAN
    private Map<String, Boolean> operationStatus;  // Only present when senderType is BOT
    private String conversationTitle;  // LLM-generated conversation title

    public PlatformMessageSubmissionResponse() {}

    // Builder pattern
    public static PlatformMessageSubmissionResponseBuilder builder() {
        return new PlatformMessageSubmissionResponseBuilder();
    }

    public static class PlatformMessageSubmissionResponseBuilder {
        private boolean success;
        private UUID messageId;
        private UUID conversationId;
        private String message;
        private Map<String, Object> contextualPrompt;
        private String humanQuery;
        private List<List<ConversationMessage>> previousKConversations;
        private List<WeaviateVector> similarConversations;
        private Map<String, Boolean> operationStatus;
        private String conversationTitle;

        public PlatformMessageSubmissionResponseBuilder success(boolean success) { this.success = success; return this; }
        public PlatformMessageSubmissionResponseBuilder messageId(UUID messageId) { this.messageId = messageId; return this; }
        public PlatformMessageSubmissionResponseBuilder conversationId(UUID conversationId) { this.conversationId = conversationId; return this; }
        public PlatformMessageSubmissionResponseBuilder message(String message) { this.message = message; return this; }
        public PlatformMessageSubmissionResponseBuilder contextualPrompt(Map<String, Object> contextualPrompt) { this.contextualPrompt = contextualPrompt; return this; }
        public PlatformMessageSubmissionResponseBuilder humanQuery(String humanQuery) { this.humanQuery = humanQuery; return this; }
        public PlatformMessageSubmissionResponseBuilder previousKConversations(List<List<ConversationMessage>> previousKConversations) { this.previousKConversations = previousKConversations; return this; }
        public PlatformMessageSubmissionResponseBuilder similarConversations(List<WeaviateVector> similarConversations) { this.similarConversations = similarConversations; return this; }
        public PlatformMessageSubmissionResponseBuilder operationStatus(Map<String, Boolean> operationStatus) { this.operationStatus = operationStatus; return this; }
        public PlatformMessageSubmissionResponseBuilder conversationTitle(String conversationTitle) { this.conversationTitle = conversationTitle; return this; }

        public PlatformMessageSubmissionResponse build() {
            PlatformMessageSubmissionResponse response = new PlatformMessageSubmissionResponse();
            response.success = this.success;
            response.messageId = this.messageId;
            response.conversationId = this.conversationId;
            response.message = this.message;
            response.contextualPrompt = this.contextualPrompt;
            response.humanQuery = this.humanQuery;
            response.previousKConversations = this.previousKConversations;
            response.similarConversations = this.similarConversations;
            response.operationStatus = this.operationStatus;
            response.conversationTitle = this.conversationTitle;
            return response;
        }
    }

    // Getters and setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public UUID getMessageId() { return messageId; }
    public void setMessageId(UUID messageId) { this.messageId = messageId; }

    public UUID getConversationId() { return conversationId; }
    public void setConversationId(UUID conversationId) { this.conversationId = conversationId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Map<String, Object> getContextualPrompt() { return contextualPrompt; }
    public void setContextualPrompt(Map<String, Object> contextualPrompt) { this.contextualPrompt = contextualPrompt; }

    public String getHumanQuery() { return humanQuery; }
    public void setHumanQuery(String humanQuery) { this.humanQuery = humanQuery; }

    public List<List<ConversationMessage>> getPreviousKConversations() { return previousKConversations; }
    public void setPreviousKConversations(List<List<ConversationMessage>> previousKConversations) { this.previousKConversations = previousKConversations; }

    public List<WeaviateVector> getSimilarConversations() { return similarConversations; }
    public void setSimilarConversations(List<WeaviateVector> similarConversations) { this.similarConversations = similarConversations; }

    public Map<String, Boolean> getOperationStatus() { return operationStatus; }
    public void setOperationStatus(Map<String, Boolean> operationStatus) { this.operationStatus = operationStatus; }

    public String getConversationTitle() { return conversationTitle; }
    public void setConversationTitle(String conversationTitle) { this.conversationTitle = conversationTitle; }
}
