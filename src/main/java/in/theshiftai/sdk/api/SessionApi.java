package in.theshiftai.sdk.api;

import in.theshiftai.sdk.dto.EndConversationRequest;
import in.theshiftai.sdk.dto.EndConversationResponse;
import in.theshiftai.sdk.dto.InitiateSessionResponse;
import in.theshiftai.sdk.http.HttpClient;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for session management operations.
 * Provides methods for initiating and ending conversation sessions.
 */
public class SessionApi {
    private final HttpClient httpClient;

    public SessionApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Initiate a new conversation session.
     * POST /api/platformsession/initiate
     *
     * Creates a new conversation and returns the conversation ID.
     * This is useful when you want to explicitly start a conversation
     * before sending the first message.
     *
     * @return CompletableFuture with session initiation response
     */
    public CompletableFuture<InitiateSessionResponse> initiateSession() {
        return httpClient.post("/api/platformsession/initiate", null, InitiateSessionResponse.class);
    }

    /**
     * End a conversation session.
     * POST /api/platformsession/endconversation
     *
     * Marks the conversation as ended and triggers evaluation metrics.
     * Only the conversation owner (tenant) can end their conversations.
     *
     * @param conversationId UUID of the conversation to end (required)
     * @return CompletableFuture with conversation ending response
     * @throws IllegalArgumentException if conversationId is null
     */
    public CompletableFuture<EndConversationResponse> endConversation(UUID conversationId) {
        if (conversationId == null) {
            throw new IllegalArgumentException("conversationId is required");
        }

        EndConversationRequest request = new EndConversationRequest();
        request.setConversationId(conversationId);
        return httpClient.post("/api/platformsession/endconversation", request, EndConversationResponse.class);
    }
}