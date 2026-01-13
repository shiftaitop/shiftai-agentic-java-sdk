package in.theshiftai.sdk.api;

import in.theshiftai.sdk.dto.CreateUserRequest;
import in.theshiftai.sdk.dto.User;
import in.theshiftai.sdk.http.HttpClient;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * API for user operations.
 * Provides methods for creating and managing users.
 */
public class UsersApi {
    private final HttpClient httpClient;

    public UsersApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Create a new user using builder pattern.
     * POST /api/users
     *
     * @return UserBuilder for fluent API
     */
    public UserBuilder create() {
        return new UserBuilder();
    }

    /**
     * Register a new user (legacy method - kept for backward compatibility).
     * POST /api/users
     *
     * @param request User creation request
     * @return CompletableFuture with created user
     */
    public CompletableFuture<User> create(CreateUserRequest request) {
        return httpClient.post("/api/users", request, User.class);
    }

    /**
     * Builder for user creation requests.
     */
    public class UserBuilder {
        private String username;
        private String email;
        private Map<String, Object> metadata;

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Build and submit the user creation request.
         * Validates required fields.
         *
         * @return CompletableFuture with created user
         * @throws IllegalArgumentException if required fields are missing
         */
        public CompletableFuture<User> build() {
            // Validate required fields
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("username is required");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("email is required");
            }

            // Build request
            CreateUserRequest request = new CreateUserRequest();
            request.setUsername(username);
            request.setEmail(email);
            request.setMetadata(metadata);

            // Submit request
            return httpClient.post("/api/users", request, User.class);
        }
    }
}
