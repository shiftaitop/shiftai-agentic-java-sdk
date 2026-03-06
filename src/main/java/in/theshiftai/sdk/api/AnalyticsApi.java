package in.theshiftai.sdk.api;

import in.theshiftai.sdk.dto.*;
import in.theshiftai.sdk.http.HttpClient;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for analytics operations.
 * Provides methods for submitting feedback and retrieving analytics data.
 */
public class AnalyticsApi {
    private final HttpClient httpClient;

    public AnalyticsApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Submit feedback for a BOT message using builder pattern.
     * POST /api/analytics/data
     *
     * @return FeedbackBuilder for fluent API
     */
    public FeedbackBuilder submitFeedback() {
        return new FeedbackBuilder();
    }

    /**
     * Submit feedback for a BOT message (legacy method - kept for backward compatibility).
     * POST /api/analytics/data
     *
     * @param request Feedback submission request
     * @return CompletableFuture with feedback submission response
     */
    public CompletableFuture<FeedbackSubmissionResponse> submitFeedback(FeedbackSubmissionRequest request) {
        return httpClient.post("/api/analytics/data", request, FeedbackSubmissionResponse.class);
    }

    /**
     * Builder for feedback submission requests.
     */
    public class FeedbackBuilder {
        private UUID messageId;
        private String feedbackTitle;
        private String feedback;
        private Boolean liked;
        private Boolean disliked;
        private Boolean regeneration;

        public FeedbackBuilder messageId(UUID messageId) {
            this.messageId = messageId;
            return this;
        }

        public FeedbackBuilder feedbackTitle(String feedbackTitle) {
            this.feedbackTitle = feedbackTitle;
            return this;
        }

        public FeedbackBuilder feedback(String feedback) {
            this.feedback = feedback;
            return this;
        }

        public FeedbackBuilder liked(Boolean liked) {
            this.liked = liked;
            return this;
        }

        public FeedbackBuilder disliked(Boolean disliked) {
            this.disliked = disliked;
            return this;
        }

        public FeedbackBuilder regeneration(Boolean regeneration) {
            this.regeneration = regeneration;
            return this;
        }

        /**
         * Build and submit the feedback request.
         * Validates required fields.
         *
         * @return CompletableFuture with feedback submission response
         * @throws IllegalArgumentException if required fields are missing
         */
        public CompletableFuture<FeedbackSubmissionResponse> build() {
            // Validate required fields
            if (messageId == null) {
                throw new IllegalArgumentException("messageId is required");
            }
            if (feedbackTitle == null || feedbackTitle.trim().isEmpty()) {
                throw new IllegalArgumentException("feedbackTitle is required");
            }
            if (feedback == null || feedback.trim().isEmpty()) {
                throw new IllegalArgumentException("feedback is required");
            }

            // Build request
            FeedbackSubmissionRequest request = new FeedbackSubmissionRequest();
            request.setMessageId(messageId);
            request.setFeedbackTitle(feedbackTitle);
            request.setFeedback(feedback);
            request.setLiked(liked);
            request.setDisliked(disliked);
            request.setRegeneration(regeneration);

            // Submit request
            return httpClient.post("/api/analytics/data", request, FeedbackSubmissionResponse.class);
        }
    }

    /**
     * Get dashboard metrics.
     * GET /api/analytics/dashboard
     *
     * @return CompletableFuture with dashboard metrics
     */
    public CompletableFuture<DashboardMetricsDTO> getDashboard() {
        httpClient.ensureAuthenticated();
        return httpClient.get("/api/analytics/dashboard", DashboardMetricsDTO.class);
    }

    /**
     * Get top agents by query count.
     * GET /api/analytics/top-agents?limit={limit}
     *
     * @param limit Maximum number of results to return (default: 5)
     * @return CompletableFuture with list of top agents
     */
    public CompletableFuture<List<TopAgentDTO>> getTopAgents(int limit) {
        httpClient.ensureAuthenticated();
        return httpClient.getList("/api/analytics/top-agents?limit=" + limit, TopAgentDTO.class);
    }

    /**
     * Get top users by activity.
     * GET /api/analytics/top-users?limit={limit}
     *
     * @param limit Maximum number of results to return (default: 5)
     * @return CompletableFuture with list of top users
     */
    public CompletableFuture<List<TopUserDTO>> getTopUsers(int limit) {
        httpClient.ensureAuthenticated();
        return httpClient.getList("/api/analytics/top-users?limit=" + limit, TopUserDTO.class);
    }

    /**
     * Get user analytics table.
     * GET /api/analytics/user-analytics
     *
     * @return CompletableFuture with list of user analytics
     */
    public CompletableFuture<List<UserAnalyticsDTO>> getUserAnalytics() {
        httpClient.ensureAuthenticated();
        return httpClient.getList("/api/analytics/user-analytics", UserAnalyticsDTO.class);
    }

    /**
     * Get project analytics data.
     * GET /api/analytics/project-data?topLimit={topLimit}
     *
     * @param topLimit Maximum number of top users/agents to return (default: 10)
     * @return CompletableFuture with project analytics response
     */
    public CompletableFuture<ProjectAnalyticsResponseDTO> getProjectData(int topLimit) {
        httpClient.ensureAuthenticated();
        return httpClient.get("/api/analytics/project-data?topLimit=" + topLimit, ProjectAnalyticsResponseDTO.class);
    }

    /**
     * Get all analytics (admin - no auth required).
     * GET /api/analytics/all?topLimit={topLimit}
     *
     * @param topLimit Maximum number of results to return (default: 5)
     * @return CompletableFuture with dictionary of all analytics data
     */
    public CompletableFuture<Map<String, Object>> getAll(int topLimit) {
        return httpClient.getMapWithoutAuth("/api/analytics/all?topLimit=" + topLimit);
    }

    /**
     * Initialize analytics (admin - no auth required).
     * POST /api/analytics/initialize
     *
     * @return CompletableFuture with initialization result
     */
    public CompletableFuture<Map<String, Object>> initialize() {
        return httpClient.postMapWithoutAuth("/api/analytics/initialize", null);
    }

    /**
     * Get all feedback submissions for a specific BOT message.
     * GET /api/analytics/messages/{messageId}/feedback
     *
     * @param messageId UUID of the BOT message
     * @return CompletableFuture with list of feedback entries, ordered by most recent first
     */
    public CompletableFuture<List<FeedbackDTO>> getMessageFeedback(UUID messageId) {
        httpClient.ensureAuthenticated();
        return httpClient.getList("/api/analytics/messages/" + messageId + "/feedback", FeedbackDTO.class);
    }

    /**
     * Get latest feedbacks. Backend may return either an object or a raw array; response is normalized to one shape.
     * POST /api/platform/feedbacks/latest
     *
     * @param timeperiodHours null = all feedbacks; N = last N hours (e.g. 24)
     * @return CompletableFuture with message (optional) and feedbacks list (empty if none)
     */
    public CompletableFuture<LatestFeedbacksResponse> getLatestFeedbacks(Integer timeperiodHours) {
        httpClient.ensureAuthenticated();
        Object body = timeperiodHours == null ? Map.of() : Map.of("timeperiod", timeperiodHours);
        return httpClient.postForLatestFeedbacks("/api/platform/feedbacks/latest", body);
    }

    // ---------- User preferences (tenant-isolated, Api-Key required) ----------

    /**
     * Update one user preference item. Use value "DELETE" (case-insensitive) to remove the item at the given index.
     * POST /api/analytics/user-preferences/update
     *
     * @param request profileId (required), category (USER_PERSONAL, METRICS, CALCULATION), index (0-based), value (new text or "DELETE")
     * @return CompletableFuture with updated profile (UserPreferenceItemResponse)
     */
    public CompletableFuture<UserPreferenceItemResponse> updateUserPreference(UserPreferenceUpdateRequest request) {
        httpClient.ensureAuthenticated();
        return httpClient.post("/api/analytics/user-preferences/update", request, UserPreferenceItemResponse.class);
    }

    /**
     * List user preferences for one user by email.
     * POST /api/analytics/user-preferences/list
     *
     * @param email User email in the tenant (required, non-blank)
     * @return CompletableFuture with userpreferences list (may be empty)
     */
    public CompletableFuture<UserPreferenceListResponse> listUserPreferencesByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("email is required");
        }
        httpClient.ensureAuthenticated();
        UserPreferenceListRequest request = new UserPreferenceListRequest(email.trim());
        return httpClient.post("/api/analytics/user-preferences/list", request, UserPreferenceListResponse.class);
    }

    /**
     * List all user preferences in the tenant with optional limit.
     * POST /api/analytics/user-preferences/list/all
     *
     * @param limit Optional; max profiles to return. Default 50, must be between 1 and 500 if set.
     * @return CompletableFuture with userpreferences list
     */
    public CompletableFuture<UserPreferenceListResponse> listAllUserPreferences(Integer limit) {
        httpClient.ensureAuthenticated();
        if (limit != null && (limit < 1 || limit > 500)) {
            throw new IllegalArgumentException("limit must be a positive integer between 1 and 500");
        }
        UserPreferenceListAllRequest request = limit == null ? new UserPreferenceListAllRequest() : new UserPreferenceListAllRequest(limit);
        return httpClient.post("/api/analytics/user-preferences/list/all", request, UserPreferenceListResponse.class);
    }
}
