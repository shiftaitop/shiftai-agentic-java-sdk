package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO for feedback data returned by feedback retrieval API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedbackDTO {
    private UUID id;
    private String feedbackTitle;
    private String feedback;
    private Boolean liked;
    private Boolean disliked;
    private Boolean regeneration;
    private Instant submittedAt;

    public FeedbackDTO() {}

    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getFeedbackTitle() { return feedbackTitle; }
    public void setFeedbackTitle(String feedbackTitle) { this.feedbackTitle = feedbackTitle; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public Boolean getLiked() { return liked; }
    public void setLiked(Boolean liked) { this.liked = liked; }

    public Boolean getDisliked() { return disliked; }
    public void setDisliked(Boolean disliked) { this.disliked = disliked; }

    public Boolean getRegeneration() { return regeneration; }
    public void setRegeneration(Boolean regeneration) { this.regeneration = regeneration; }

    public Instant getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(Instant submittedAt) { this.submittedAt = submittedAt; }
}