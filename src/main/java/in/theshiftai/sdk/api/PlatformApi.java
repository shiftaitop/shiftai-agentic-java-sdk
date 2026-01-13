package in.theshiftai.sdk.api;

import in.theshiftai.sdk.dto.PlatformRegistrationRequest;
import in.theshiftai.sdk.dto.PlatformRegistrationResponse;
import in.theshiftai.sdk.http.HttpClient;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * API for platform registration.
 */
public class PlatformApi {
    private final HttpClient httpClient;

    public PlatformApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CompletableFuture<PlatformRegistrationResponse> registerPlatform(
            String projectName,
            Map<String, Object> metadata) {
        if (projectName == null || projectName.trim().isEmpty()) {
            throw new IllegalArgumentException("projectName is required");
        }

        PlatformRegistrationRequest request = new PlatformRegistrationRequest(projectName, metadata);
        return httpClient.postWithoutAuth("/api/platform/register", request, PlatformRegistrationResponse.class);
    }
}
