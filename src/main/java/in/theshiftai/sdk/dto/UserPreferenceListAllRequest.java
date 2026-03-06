package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Request body for listing all user preferences in the tenant.
 * limit: optional, default 50, max 500.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPreferenceListAllRequest {
    private Integer limit;

    public UserPreferenceListAllRequest() {}

    public UserPreferenceListAllRequest(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
