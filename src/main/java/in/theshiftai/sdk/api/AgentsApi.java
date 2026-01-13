package in.theshiftai.sdk.api;

import in.theshiftai.sdk.dto.CreateAgentRequest;
import in.theshiftai.sdk.dto.Agent;
import in.theshiftai.sdk.http.HttpClient;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * API for agent operations.
 * Provides methods for creating and managing AI agents.
 */
public class AgentsApi {
    private final HttpClient httpClient;

    public AgentsApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Create a new agent using builder pattern.
     * POST /api/agents
     *
     * @return AgentBuilder for fluent API
     */
    public AgentBuilder create() {
        return new AgentBuilder();
    }

    /**
     * Register a new agent (legacy method - kept for backward compatibility).
     * POST /api/agents
     *
     * @param request Agent creation request
     * @return CompletableFuture with created agent
     */
    public CompletableFuture<Agent> create(CreateAgentRequest request) {
        return httpClient.post("/api/agents", request, Agent.class);
    }

    /**
     * Builder for agent creation requests.
     */
    public class AgentBuilder {
        private String name;
        private String platform;
        private String version;
        private Map<String, Object> metadata;

        public AgentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AgentBuilder platform(String platform) {
            this.platform = platform;
            return this;
        }

        public AgentBuilder version(String version) {
            this.version = version;
            return this;
        }

        public AgentBuilder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Build and submit the agent creation request.
         * Validates required fields.
         *
         * @return CompletableFuture with created agent
         * @throws IllegalArgumentException if required fields are missing
         */
        public CompletableFuture<Agent> build() {
            // Validate required fields
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("name is required");
            }
            if (platform == null || platform.trim().isEmpty()) {
                throw new IllegalArgumentException("platform is required");
            }

            // Build request
            CreateAgentRequest request = new CreateAgentRequest();
            request.setName(name);
            request.setPlatform(platform);
            request.setVersion(version);
            request.setMetadata(metadata);

            // Submit request
            return httpClient.post("/api/agents", request, Agent.class);
        }
    }
}
