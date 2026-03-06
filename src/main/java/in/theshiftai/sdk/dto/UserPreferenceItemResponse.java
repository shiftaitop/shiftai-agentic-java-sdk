package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Single user preference profile (update 200 response and item in list responses).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPreferenceItemResponse {
    private UUID profileId;
    private String username;
    private String userEmail;
    private String botName;
    private UserPreferencesPayload userPreferences;
    private Instant createdAt;
    private Instant updatedAt;

    public UserPreferenceItemResponse() {}

    public UUID getProfileId() { return profileId; }
    public void setProfileId(UUID profileId) { this.profileId = profileId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getBotName() { return botName; }
    public void setBotName(String botName) { this.botName = botName; }

    public UserPreferencesPayload getUserPreferences() { return userPreferences; }
    public void setUserPreferences(UserPreferencesPayload userPreferences) { this.userPreferences = userPreferences; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    /**
     * Nested payload: USER_PERSONAL, METRICS, CALCULATION feedback lists.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserPreferencesPayload {
        private List<String> userPersonalFeedbacks;
        private List<String> metricsFeedbacks;
        private List<String> calculationFeedbacks;

        public UserPreferencesPayload() {
            this.userPersonalFeedbacks = new ArrayList<>();
            this.metricsFeedbacks = new ArrayList<>();
            this.calculationFeedbacks = new ArrayList<>();
        }

        public List<String> getUserPersonalFeedbacks() { return userPersonalFeedbacks != null ? userPersonalFeedbacks : new ArrayList<>(); }
        public void setUserPersonalFeedbacks(List<String> userPersonalFeedbacks) { this.userPersonalFeedbacks = userPersonalFeedbacks != null ? userPersonalFeedbacks : new ArrayList<>(); }

        public List<String> getMetricsFeedbacks() { return metricsFeedbacks != null ? metricsFeedbacks : new ArrayList<>(); }
        public void setMetricsFeedbacks(List<String> metricsFeedbacks) { this.metricsFeedbacks = metricsFeedbacks != null ? metricsFeedbacks : new ArrayList<>(); }

        public List<String> getCalculationFeedbacks() { return calculationFeedbacks != null ? calculationFeedbacks : new ArrayList<>(); }
        public void setCalculationFeedbacks(List<String> calculationFeedbacks) { this.calculationFeedbacks = calculationFeedbacks != null ? calculationFeedbacks : new ArrayList<>(); }
    }
}
