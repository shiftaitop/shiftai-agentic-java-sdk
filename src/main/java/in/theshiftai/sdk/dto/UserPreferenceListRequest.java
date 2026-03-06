package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Request body for listing user preferences by email.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPreferenceListRequest {
    private String email;

    public UserPreferenceListRequest() {}

    public UserPreferenceListRequest(String email) {
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
