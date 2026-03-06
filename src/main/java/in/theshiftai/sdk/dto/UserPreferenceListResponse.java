package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Response for list-by-email and list-all user preferences endpoints.
 * JSON key is "userpreferences" (lowercase).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPreferenceListResponse {
    @JsonProperty("userpreferences")
    private List<UserPreferenceItemResponse> userpreferences;

    public UserPreferenceListResponse() {
        this.userpreferences = new ArrayList<>();
    }

    public List<UserPreferenceItemResponse> getUserpreferences() { return userpreferences != null ? userpreferences : new ArrayList<>(); }
    public void setUserpreferences(List<UserPreferenceItemResponse> userpreferences) { this.userpreferences = userpreferences != null ? userpreferences : new ArrayList<>(); }
}
