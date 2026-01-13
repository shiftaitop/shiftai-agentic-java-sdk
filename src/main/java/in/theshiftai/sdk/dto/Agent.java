package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import java.util.UUID;

/**
 * Agent DTO for SDK responses.
 * Matches Python SDK Agent model exactly.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {
    private UUID id;
    private String name;
    private String platform;
    private String version;
    private String projectName;
    private Map<String, Object> metadata;

    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }

    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
}
