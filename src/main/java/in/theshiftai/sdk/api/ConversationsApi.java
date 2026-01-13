package in.theshiftai.sdk.api;

import in.theshiftai.sdk.dto.ConversationSummaryResponse;
import in.theshiftai.sdk.dto.ConversationMessageResponse;
import in.theshiftai.sdk.http.HttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for platform conversation operations.
 * Provides methods for retrieving conversation messages and listing conversations.
 */
public class ConversationsApi {
    private final HttpClient httpClient;

    public ConversationsApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Get all messages for a specific conversation.
     * POST /api/platform/conversation/getmessages
     *
     * Returns simplified message format with essential fields only (no deeply nested objects).
     * Each message includes generatedContext (for all messages) and ragContext (for BOT messages only).
     *
     * @param conversationId UUID of the conversation
     * @return CompletableFuture with list of simplified message responses for the conversation
     * @throws IllegalArgumentException if conversationId is null
     */
    public CompletableFuture<List<ConversationMessageResponse>> getMessagesByConversationId(UUID conversationId) {
        if (conversationId == null) {
            throw new IllegalArgumentException("conversationId is required");
        }

        Map<String, Object> request = new HashMap<>();
        request.put("conversationId", conversationId.toString());

        return httpClient.postList("/api/platform/conversation/getmessages", request, ConversationMessageResponse.class);
    }

    /**
     * Get all conversation IDs for the authenticated project.
     * GET /api/platform/conversations/all
     *
     * @return CompletableFuture with list of conversation summaries
     */
    public CompletableFuture<List<ConversationSummaryResponse>> getAllConversations() {
        return httpClient.getList("/api/platform/conversations/all", ConversationSummaryResponse.class);
    }

    /**
     * Get all conversations for a specific user within the authenticated project.
     * POST /api/platform/conversations/user
     *
     * Retrieves all conversations associated with a username in your project.
     * Each conversation includes conversation ID, username, agent name, start time, and end time.
     *
     * @param username Username to retrieve conversations for (required)
     * @return CompletableFuture with list of conversation summaries for the user
     * @throws IllegalArgumentException if username is null or empty
     */
    public CompletableFuture<List<ConversationSummaryResponse>> getUserConversations(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("username is required");
        }

        Map<String, Object> request = new HashMap<>();
        request.put("username", username.trim());

        return httpClient.postList("/api/platform/conversations/user", request, ConversationSummaryResponse.class);
    }
}
