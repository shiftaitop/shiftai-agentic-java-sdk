package in.theshiftai.sdk.api.internal;

import in.theshiftai.sdk.http.HttpClient;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * API for Eval metrics operations.
 *
 * This is an internal/admin API for observability and quality assessment.
 * Not part of normal client flows - use for monitoring and evaluation purposes only.
 */
public class EvalApi {
    private final HttpClient httpClient;

    public EvalApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Generate metrics for a specific completed session.
     *
     * POST /api/eval/sessions/{conversationId}/generate-metrics
     *
     * @param conversationId UUID of the completed conversation
     * @return CompletableFuture with processing status
     */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> generateMetricsForSession(UUID conversationId) {
        httpClient.ensureAuthenticated();
        return httpClient.post("/api/eval/sessions/" + conversationId + "/generate-metrics", Map.of(), Object.class)
                .thenApply(obj -> (Map<String, Object>) obj);
    }

    /**
     * Generate metrics for all completed sessions in the project.
     *
     * POST /api/eval/sessions/generate-metrics
     *
     * @return CompletableFuture with processing status
     */
    @SuppressWarnings("unchecked")
    public CompletableFuture<Map<String, Object>> generateMetricsForAllSessions() {
        httpClient.ensureAuthenticated();
        return httpClient.post("/api/eval/sessions/generate-metrics", Map.of(), Object.class)
                .thenApply(obj -> (Map<String, Object>) obj);
    }

    /**
     * Generate metrics for all conversations (admin - no auth required).
     *
     * POST /api/eval/sessions/generate-metrics-all
     *
     * @return CompletableFuture with job ID for progress tracking
     */
    public CompletableFuture<Map<String, Object>> generateMetricsForAllConversations() {
        return httpClient.postMapWithoutAuth("/api/eval/sessions/generate-metrics-all", Map.of());
    }

    /**
     * Get progress for a batch metrics generation job (admin - no auth required).
     *
     * GET /api/eval/sessions/generate-metrics-all/{jobId}/progress
     *
     * @param jobId The job ID returned from generateMetricsForAllConversations
     * @return CompletableFuture with current progress information
     */
    public CompletableFuture<Map<String, Object>> getBatchProgress(String jobId) {
        return httpClient.getMapWithoutAuth("/api/eval/sessions/generate-metrics-all/" + jobId + "/progress");
    }
}
