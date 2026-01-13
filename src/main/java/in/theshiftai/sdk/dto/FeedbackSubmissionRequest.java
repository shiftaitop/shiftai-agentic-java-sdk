package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * Request body for submitting feedback on a BOT message.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedbackSubmissionRequest {
    private UUID messageId;
    private Boolean like;
    private Boolean dislike;
    private String feedback;
    private Boolean regeneration;

    public FeedbackSubmissionRequest() {}

    // Getters and setters
    public UUID getMessageId() { return messageId; }
    public void setMessageId(UUID messageId) { this.messageId = messageId; }

    public Boolean getLike() { return like; }
    public void setLike(Boolean like) { this.like = like; }

    public Boolean getDislike() { return dislike; }
    public void setDislike(Boolean dislike) { this.dislike = dislike; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public Boolean getRegeneration() { return regeneration; }
    public void setRegeneration(Boolean regeneration) { this.regeneration = regeneration; }
}
