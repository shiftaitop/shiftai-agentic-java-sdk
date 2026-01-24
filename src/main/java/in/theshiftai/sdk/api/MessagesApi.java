package in.theshiftai.sdk.api;

import in.theshiftai.sdk.dto.*;
import in.theshiftai.sdk.http.HttpClient;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for platform message operations.
 * Provides methods for submitting messages and retrieving message history.
 */
public class MessagesApi {
    private final HttpClient httpClient;

    public MessagesApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Send a human message using builder pattern.
     * Automatically sets senderType=HUMAN and messageType=TEXT.
     *
     * @return HumanMessageBuilder for fluent API
     */
    public HumanMessageBuilder sendHumanMessage() {
        return new HumanMessageBuilder();
    }

    /**
     * Send a bot message using builder pattern.
     * Automatically sets senderType=BOT and messageType=TEXT.
     * Requires replyMessageId and ragContext.
     *
     * @return BotMessageBuilder for fluent API
     */
    public BotMessageBuilder sendBotMessage() {
        return new BotMessageBuilder();
    }


    /**
     * Builder for human message requests.
     * Automatically sets senderType=HUMAN and messageType=TEXT.
     */
    public class HumanMessageBuilder {
        private String username;
        private String message;
        private String agentName;
        private String agentPlatform;
        private String userEmail;
        private Map<String, Object> userMetadata;
        private String intent;
        private Map<String, Object> entities;
        private Map<String, Object> annotations;
        private Map<String, Object> sourceEvent;
        private String agentVersion;
        private Map<String, Object> agentMetadata;
        private String mode;
        private UUID conversationId;

        public HumanMessageBuilder username(String username) {
            this.username = username;
            return this;
        }

        public HumanMessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        public HumanMessageBuilder agentName(String agentName) {
            this.agentName = agentName;
            return this;
        }

        public HumanMessageBuilder agentPlatform(String agentPlatform) {
            this.agentPlatform = agentPlatform;
            return this;
        }

        public HumanMessageBuilder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public HumanMessageBuilder userMetadata(Map<String, Object> userMetadata) {
            this.userMetadata = userMetadata;
            return this;
        }

        public HumanMessageBuilder intent(String intent) {
            this.intent = intent;
            return this;
        }

        public HumanMessageBuilder entities(Map<String, Object> entities) {
            this.entities = entities;
            return this;
        }

        public HumanMessageBuilder annotations(Map<String, Object> annotations) {
            this.annotations = annotations;
            return this;
        }

        public HumanMessageBuilder sourceEvent(Map<String, Object> sourceEvent) {
            this.sourceEvent = sourceEvent;
            return this;
        }

        public HumanMessageBuilder agentVersion(String agentVersion) {
            this.agentVersion = agentVersion;
            return this;
        }

        public HumanMessageBuilder agentMetadata(Map<String, Object> agentMetadata) {
            this.agentMetadata = agentMetadata;
            return this;
        }

        public HumanMessageBuilder mode(String mode) {
            this.mode = mode;
            return this;
        }

        public HumanMessageBuilder conversationId(UUID conversationId) {
            this.conversationId = conversationId;
            return this;
        }

        /**
         * Build and submit the human message.
         * Validates required fields and automatically sets senderType=HUMAN, messageType=TEXT.
         *
         * @return CompletableFuture with submission response
         * @throws IllegalArgumentException if required fields are missing
         */
        public CompletableFuture<PlatformMessageSubmissionResponse> build() {
            // Validate required fields
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("username is required");
            }
            if (message == null || message.trim().isEmpty()) {
                throw new IllegalArgumentException("message is required");
            }
            if (agentName == null || agentName.trim().isEmpty()) {
                throw new IllegalArgumentException("agentName is required");
            }
            if (agentPlatform == null || agentPlatform.trim().isEmpty()) {
                throw new IllegalArgumentException("agentPlatform is required");
            }
            if (agentVersion == null || agentVersion.trim().isEmpty()) {
                throw new IllegalArgumentException("agentVersion is required");
            }
            if (userEmail == null || userEmail.trim().isEmpty()) {
                throw new IllegalArgumentException("userEmail is required");
            }

            // Build request
            PlatformMessageSubmissionRequest request = new PlatformMessageSubmissionRequest();
            request.setUserName(username);
            request.setUserEmail(userEmail);
            request.setUserMetadata(userMetadata);
            request.setMessage(message);
            request.setIntent(intent);
            request.setEntities(entities);
            request.setAnnotations(annotations);
            request.setSourceEvent(sourceEvent);
            request.setMode(mode);
            request.setConversationId(conversationId);

            // Automatically set senderType and messageType
            request.setSenderType(SenderType.HUMAN);
            request.setMessageType(MessageType.TEXT);

            // Build agent data
            AgentData agentData = AgentData.builder()
                .name(agentName)
                .platform(agentPlatform)
                .version(agentVersion)
                .metadata(agentMetadata)
                .build();
            request.setAgentData(agentData);

            // Submit request
            return httpClient.post("/api/platform/messages/submit", request,
                PlatformMessageSubmissionResponse.class);
        }
    }

    /**
     * Builder for bot message requests.
     * Automatically sets senderType=BOT and messageType=TEXT.
     * Requires replyMessageId and ragContext.
     */
    public class BotMessageBuilder {
        private String username;
        private String message;
        private String agentName;
        private String agentPlatform;
        private UUID replyMessageId;
        private String ragContext;
        private String userEmail;
        private Map<String, Object> userMetadata;
        private String intent;
        private Map<String, Object> entities;
        private Map<String, Object> annotations;
        private Map<String, Object> sourceEvent;
        private String agentVersion;
        private Map<String, Object> agentMetadata;
        private String mode;
        private UUID conversationId;

        public BotMessageBuilder username(String username) {
            this.username = username;
            return this;
        }

        public BotMessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        public BotMessageBuilder agentName(String agentName) {
            this.agentName = agentName;
            return this;
        }

        public BotMessageBuilder agentPlatform(String agentPlatform) {
            this.agentPlatform = agentPlatform;
            return this;
        }

        public BotMessageBuilder replyMessageId(UUID replyMessageId) {
            this.replyMessageId = replyMessageId;
            return this;
        }

        public BotMessageBuilder ragContext(String ragContext) {
            this.ragContext = ragContext;
            return this;
        }

        public BotMessageBuilder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public BotMessageBuilder userMetadata(Map<String, Object> userMetadata) {
            this.userMetadata = userMetadata;
            return this;
        }

        public BotMessageBuilder intent(String intent) {
            this.intent = intent;
            return this;
        }

        public BotMessageBuilder entities(Map<String, Object> entities) {
            this.entities = entities;
            return this;
        }

        public BotMessageBuilder annotations(Map<String, Object> annotations) {
            this.annotations = annotations;
            return this;
        }

        public BotMessageBuilder sourceEvent(Map<String, Object> sourceEvent) {
            this.sourceEvent = sourceEvent;
            return this;
        }

        public BotMessageBuilder agentVersion(String agentVersion) {
            this.agentVersion = agentVersion;
            return this;
        }

        public BotMessageBuilder agentMetadata(Map<String, Object> agentMetadata) {
            this.agentMetadata = agentMetadata;
            return this;
        }

        public BotMessageBuilder mode(String mode) {
            this.mode = mode;
            return this;
        }

        public BotMessageBuilder conversationId(UUID conversationId) {
            this.conversationId = conversationId;
            return this;
        }

        /**
         * Build and submit the bot message.
         * Validates required fields and automatically sets senderType=BOT, messageType=TEXT.
         *
         * @return CompletableFuture with submission response
         * @throws IllegalArgumentException if required fields are missing
         */
        public CompletableFuture<PlatformMessageSubmissionResponse> build() {
            // Validate required fields
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("username is required");
            }
            if (message == null || message.trim().isEmpty()) {
                throw new IllegalArgumentException("message is required");
            }
            if (agentName == null || agentName.trim().isEmpty()) {
                throw new IllegalArgumentException("agentName is required");
            }
            if (agentPlatform == null || agentPlatform.trim().isEmpty()) {
                throw new IllegalArgumentException("agentPlatform is required");
            }
            if (agentVersion == null || agentVersion.trim().isEmpty()) {
                throw new IllegalArgumentException("agentVersion is required");
            }
            if (replyMessageId == null) {
                throw new IllegalArgumentException("replyMessageId is required for bot messages");
            }
            if (userEmail == null || userEmail.trim().isEmpty()) {
                throw new IllegalArgumentException("userEmail is required");
            }
            if (ragContext == null || ragContext.trim().isEmpty()) {
                throw new IllegalArgumentException("ragContext is required for bot messages");
            }

            // Build request
            PlatformMessageSubmissionRequest request = new PlatformMessageSubmissionRequest();
            request.setUserName(username);
            request.setUserEmail(userEmail);
            request.setUserMetadata(userMetadata);
            request.setMessage(message);
            request.setIntent(intent);
            request.setEntities(entities);
            request.setAnnotations(annotations);
            request.setSourceEvent(sourceEvent);
            request.setReplyMessageId(replyMessageId);
            request.setRagContext(ragContext);
            request.setMode(mode);
            request.setConversationId(conversationId);

            // Automatically set senderType and messageType
            request.setSenderType(SenderType.BOT);
            request.setMessageType(MessageType.TEXT);

            // Build agent data
            AgentData agentData = AgentData.builder()
                .name(agentName)
                .platform(agentPlatform)
                .version(agentVersion)
                .metadata(agentMetadata)
                .build();
            request.setAgentData(agentData);

            // Submit request
            return httpClient.post("/api/platform/messages/submit", request,
                PlatformMessageSubmissionResponse.class);
        }
    }

    /**
     * Get all platform messages for the authenticated project.
     * GET /api/platform/messages
     *
     * @return CompletableFuture with list of all messages
     */
    public CompletableFuture<List<PlatformMessage>> getAll() {
        return httpClient.getList("/api/platform/messages", PlatformMessage.class);
    }

    /**
     * Get platform message by ID.
     * GET /api/platform/messages/{messageId}
     *
     * @param messageId UUID of the message
     * @return CompletableFuture with the message
     */
    public CompletableFuture<PlatformMessage> getById(UUID messageId) {
        return httpClient.get("/api/platform/messages/" + messageId, PlatformMessage.class);
    }

    /**
     * Submit a platform message with full request object (low-level method).
     *
     * POST /api/platform/messages/submit
     *
     * @param request Complete message submission request object
     * @return CompletableFuture with submission response
     */
    public CompletableFuture<PlatformMessageSubmissionResponse> submit(PlatformMessageSubmissionRequest request) {
        httpClient.ensureAuthenticated();
        return httpClient.post("/api/platform/messages/submit", request, PlatformMessageSubmissionResponse.class);
    }

    /**
     * Get platform messages by agent.
     * GET /api/platform/messages/agent/{agentId}
     *
     * @param agentId UUID of the agent
     * @return CompletableFuture with list of messages from the agent
     */
    public CompletableFuture<List<PlatformMessage>> getByAgent(UUID agentId) {
        httpClient.ensureAuthenticated();
        return httpClient.getList("/api/platform/messages/agent/" + agentId, PlatformMessage.class);
    }
}
