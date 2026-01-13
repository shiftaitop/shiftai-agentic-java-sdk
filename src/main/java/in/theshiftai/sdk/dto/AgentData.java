package in.theshiftai.sdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * Agent information for message submission.
 * SDK-owned DTO - independent of server implementation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentData {
    private String name;
    private String platform;
    private String version;
    private Map<String, Object> metadata;

    public AgentData() {}

    public AgentData(String name, String platform, String version, Map<String, Object> metadata) {
        this.name = name;
        this.platform = platform;
        this.version = version;
        this.metadata = metadata;
    }

    // Builder pattern
    public static AgentDataBuilder builder() {
        return new AgentDataBuilder();
    }

    public static class AgentDataBuilder {
        private String name;
        private String platform;
        private String version;
        private Map<String, Object> metadata;

        public AgentDataBuilder name(String name) { this.name = name; return this; }
        public AgentDataBuilder platform(String platform) { this.platform = platform; return this; }
        public AgentDataBuilder version(String version) { this.version = version; return this; }
        public AgentDataBuilder metadata(Map<String, Object> metadata) { this.metadata = metadata; return this; }

        public AgentData build() {
            AgentData agentData = new AgentData();
            agentData.name = this.name;
            agentData.platform = this.platform;
            agentData.version = this.version;
            agentData.metadata = this.metadata;
            return agentData;
        }
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
}
