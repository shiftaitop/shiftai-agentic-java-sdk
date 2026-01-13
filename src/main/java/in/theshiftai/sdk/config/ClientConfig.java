package in.theshiftai.sdk.config;

/**
 * Configuration for the Communication Infrastructure client.
 * Uses builder pattern for initialization.
 */
public class ClientConfig {
    private final String baseUrl;
    private final String apiKey;

    public ClientConfig(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getApiKey() {
        return apiKey;
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

        public ClientConfig build() {
            if (baseUrl == null || baseUrl.trim().isEmpty()) {
                throw new IllegalArgumentException("baseUrl is required");
            }
            return new ClientConfig(baseUrl, apiKey);
        }
    }
}
