package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Instant;
import java.util.UUID;

/**
 * Response for feedback submission.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedbackSubmissionResponse {
    private boolean success;
    private UUID feedbackId;
    private String message;
    private Instant submittedAt;

    public FeedbackSubmissionResponse() {}

    // Getters and setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public UUID getFeedbackId() { return feedbackId; }
    public void setFeedbackId(UUID feedbackId) { this.feedbackId = feedbackId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Instant getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(Instant submittedAt) { this.submittedAt = submittedAt; }
}
