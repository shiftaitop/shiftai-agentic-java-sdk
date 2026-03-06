package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

/**
 * Request body for updating one user preference item.
 * Use value "DELETE" (case-insensitive) to remove the item at the given index.
 * Backend expects category to be exactly one of: USER_PERSONAL, METRICS, CALCULATION (uppercase is safe).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPreferenceUpdateRequest {
    private UUID profileId;
    private String category;  // USER_PERSONAL, METRICS, CALCULATION
    private Integer index;
    private String value;

    public UserPreferenceUpdateRequest() {}

    public UserPreferenceUpdateRequest(UUID profileId, String category, Integer index, String value) {
        this.profileId = profileId;
        this.category = category;
        this.index = index;
        this.value = value;
    }

    public UUID getProfileId() { return profileId; }
    public void setProfileId(UUID profileId) { this.profileId = profileId; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getIndex() { return index; }
    public void setIndex(Integer index) { this.index = index; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
