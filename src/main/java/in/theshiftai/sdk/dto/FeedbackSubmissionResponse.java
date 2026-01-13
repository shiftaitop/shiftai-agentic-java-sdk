package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Response for feedback submission.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedbackSubmissionResponse {
    private boolean success;
    private String message;

    public FeedbackSubmissionResponse() {}

    // Getters and setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
