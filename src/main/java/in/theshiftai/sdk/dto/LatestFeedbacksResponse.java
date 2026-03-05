package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

/**
 * Response for latest feedbacks API. Backend may return either an object
 * { message, feedbacks } or a raw array; the SDK normalizes to this shape.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestFeedbacksResponse {
    private String message;
    private List<LatestFeedbackItemResponse> feedbacks;

    public LatestFeedbacksResponse() {
        this.feedbacks = new ArrayList<>();
    }

    public LatestFeedbacksResponse(String message, List<LatestFeedbackItemResponse> feedbacks) {
        this.message = message;
        this.feedbacks = feedbacks != null ? feedbacks : new ArrayList<>();
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public List<LatestFeedbackItemResponse> getFeedbacks() { return feedbacks; }
    public void setFeedbacks(List<LatestFeedbackItemResponse> feedbacks) { this.feedbacks = feedbacks != null ? feedbacks : new ArrayList<>(); }
}
