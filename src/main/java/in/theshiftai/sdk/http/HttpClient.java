package in.theshiftai.sdk.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * HTTP client wrapper for making async API calls.
 */
public class HttpClient {
    private static final Logger log = LoggerFactory.getLogger(HttpClient.class);
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private final OkHttpClient client;
    private final ObjectMapper objectMapper;
    private final String baseUrl;
    private final String apiKey;

    public HttpClient(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        this.apiKey = apiKey;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    /**
     * Ensure that an API key is available for authenticated operations.
     */
    public void ensureAuthenticated() {
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalStateException("API key is required for this operation.");
        }
    }

    /**
     * Execute POST request without API key authentication
     */
    public <T> CompletableFuture<T> postWithoutAuth(String path, Object requestBody, Class<T> responseType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String jsonBody = requestBody != null ? objectMapper.writeValueAsString(requestBody) : "{}";
                RequestBody body = RequestBody.create(jsonBody, JSON);
                Request request = new Request.Builder()
                        .url(baseUrl + path)
                        .post(body)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new RuntimeException("HTTP error: " + response.code());
                    }
                    if (response.body() != null) {
                        String json = response.body().string();
                        return objectMapper.readValue(json, responseType);
                    }
                    return null;
                }
            } catch (Exception e) {
                log.error("Error executing POST request to {}", path, e);
                throw new RuntimeException("IO error: " + e.getMessage(), e);
            }
        });
    }

    /**
     * Execute GET request with API key authentication
     */
    public <T> CompletableFuture<T> get(String path, Class<T> responseType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Request request = new Request.Builder()
                        .url(baseUrl + path)
                        .addHeader("Api-Key", apiKey != null ? apiKey : "")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new RuntimeException("HTTP error: " + response.code());
                    }
                    if (response.body() != null) {
                        String json = response.body().string();
                        return objectMapper.readValue(json, responseType);
                    }
                    return null;
                }
            } catch (Exception e) {
                log.error("Error executing GET request to {}", path, e);
                throw new RuntimeException("IO error: " + e.getMessage(), e);
            }
        });
    }

    /**
     * Execute GET request for List responses with API key authentication
     */
    public <T> CompletableFuture<List<T>> getList(String path, Class<T> elementType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Request request = new Request.Builder()
                        .url(baseUrl + path)
                        .addHeader("Api-Key", apiKey != null ? apiKey : "")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new RuntimeException("HTTP error: " + response.code());
                    }
                    if (response.body() != null) {
                        String json = response.body().string();
                        return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, elementType));
                    }
                    return List.of();
                }
            } catch (Exception e) {
                log.error("Error executing GET request to {}", path, e);
                throw new RuntimeException("IO error: " + e.getMessage(), e);
            }
        });
    }

    /**
     * Execute GET request returning raw Map (admin - no auth required)
     */
    public CompletableFuture<Map<String, Object>> getMapWithoutAuth(String path) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Request request = new Request.Builder()
                        .url(baseUrl + path)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new RuntimeException("HTTP error: " + response.code());
                    }
                    if (response.body() != null) {
                        String json = response.body().string();
                        return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
                    }
                    return Map.of();
                }
            } catch (Exception e) {
                log.error("Error executing GET request to {}", path, e);
                throw new RuntimeException("IO error: " + e.getMessage(), e);
            }
        });
    }

    /**
     * Execute POST request returning raw Map (admin - no auth required)
     */
    public CompletableFuture<Map<String, Object>> postMapWithoutAuth(String path, Object requestBody) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String jsonBody = requestBody != null ? objectMapper.writeValueAsString(requestBody) : "{}";
                RequestBody body = RequestBody.create(jsonBody, JSON);
                Request request = new Request.Builder()
                        .url(baseUrl + path)
                        .post(body)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new RuntimeException("HTTP error: " + response.code());
                    }
                    if (response.body() != null) {
                        String json = response.body().string();
                        return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
                    }
                    return Map.of();
                }
            } catch (Exception e) {
                log.error("Error executing POST request to {}", path, e);
                throw new RuntimeException("IO error: " + e.getMessage(), e);
            }
        });
    }

    /**
     * Execute POST request for List responses with API key authentication
     */
    public <T> CompletableFuture<List<T>> postList(String path, Object requestBody, Class<T> elementType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String jsonBody = requestBody != null ? objectMapper.writeValueAsString(requestBody) : "{}";
                RequestBody body = RequestBody.create(jsonBody, JSON);
                Request request = new Request.Builder()
                        .url(baseUrl + path)
                        .addHeader("Api-Key", apiKey != null ? apiKey : "")
                        .post(body)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new RuntimeException("HTTP error: " + response.code());
                    }
                    if (response.body() != null) {
                        String json = response.body().string();
                        return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, elementType));
                    }
                    return List.of();
                }
            } catch (Exception e) {
                log.error("Error executing POST request to {}", path, e);
                throw new RuntimeException("IO error: " + e.getMessage(), e);
            }
        });
    }

    /**
     * Execute POST request with API key authentication
     */
    public <T> CompletableFuture<T> post(String path, Object requestBody, Class<T> responseType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String jsonBody = requestBody != null ? objectMapper.writeValueAsString(requestBody) : "{}";
                RequestBody body = RequestBody.create(jsonBody, JSON);
                Request request = new Request.Builder()
                        .url(baseUrl + path)
                        .addHeader("Api-Key", apiKey != null ? apiKey : "")
                        .post(body)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new RuntimeException("HTTP error: " + response.code());
                    }
                    if (response.body() != null) {
                        String json = response.body().string();
                        return objectMapper.readValue(json, responseType);
                    }
                    return null;
                }
            } catch (Exception e) {
                log.error("Error executing POST request to {}", path, e);
                throw new RuntimeException("IO error: " + e.getMessage(), e);
            }
        });
    }
}
