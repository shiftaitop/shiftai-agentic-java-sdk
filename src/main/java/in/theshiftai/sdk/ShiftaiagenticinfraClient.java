package in.theshiftai.sdk;

import in.theshiftai.sdk.api.*;
import in.theshiftai.sdk.api.internal.InternalApi;
import in.theshiftai.sdk.config.ClientConfig;
import in.theshiftai.sdk.http.HttpClient;

/**
 * Main client for Shiftai Agentic Infra SDK.
 * Provides fluent API access to all platform operations.
 */
public class ShiftaiagenticinfraClient {
    private final HttpClient httpClient;
    private final PlatformApi platformApi;
    private final MessagesApi messagesApi;
    private final UsersApi usersApi;
    private final AgentsApi agentsApi;
    private final AnalyticsApi analyticsApi;
    private final ConversationsApi conversationsApi;
    private final InternalApi internalApi;

    private ShiftaiagenticinfraClient(ClientConfig config) {
        this.httpClient = new HttpClient(config.getBaseUrl(), config.getApiKey());
        this.platformApi = new PlatformApi(httpClient);
        this.messagesApi = new MessagesApi(httpClient);
        this.usersApi = new UsersApi(httpClient);
        this.agentsApi = new AgentsApi(httpClient);
        this.analyticsApi = new AnalyticsApi(httpClient);
        this.conversationsApi = new ConversationsApi(httpClient);
        this.internalApi = new InternalApi(httpClient);
    }

    /**
     * Get platform API for registration operations.
     */
    public PlatformApi platform() {
        return platformApi;
    }

    /**
     * Get messages API for message operations.
     */
    public MessagesApi messages() {
        return messagesApi;
    }

    /**
     * Get users API for user management.
     */
    public UsersApi users() {
        return usersApi;
    }

    /**
     * Get agents API for agent management.
     */
    public AgentsApi agents() {
        return agentsApi;
    }

    /**
     * Get analytics API for analytics operations.
     */
    public AnalyticsApi analytics() {
        return analyticsApi;
    }

    /**
     * Get conversations API for conversation operations.
     */
    public ConversationsApi conversations() {
        return conversationsApi;
    }

    /**
     * Get internal API for admin/observability operations.
     */
    public InternalApi internal() {
        return internalApi;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String baseUrl;
        private String apiKey;

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public ShiftaiagenticinfraClient build() {
            if (baseUrl == null || baseUrl.trim().isEmpty()) {
                throw new IllegalArgumentException("baseUrl is required");
            }
            ClientConfig config = new ClientConfig(baseUrl, apiKey);
            return new ShiftaiagenticinfraClient(config);
        }
    }
}
