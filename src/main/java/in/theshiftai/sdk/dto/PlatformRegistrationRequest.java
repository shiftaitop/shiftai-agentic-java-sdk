package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * Request object for platform registration.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformRegistrationRequest {
    private String projectName;
    private Map<String, Object> metadata;

    public PlatformRegistrationRequest() {}

    public PlatformRegistrationRequest(String projectName, Map<String, Object> metadata) {
        this.projectName = projectName;
        this.metadata = metadata;
    }

    // Getters and setters
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
}
