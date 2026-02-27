package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Request body for fetching conversations by user email.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetConversationsByEmailRequest {
    private String email;

    public GetConversationsByEmailRequest() {}

    public GetConversationsByEmailRequest(String email) {
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
