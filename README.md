# Shiftai Agentic Infra Java SDK

This SDK is the official gateway to the Shift AI Agentic Infra services, enabling developers to directly integrate and use agentic capabilities in their applications.


## Usage

```java
import in.theshiftai.sdk.ShiftaiagenticinfraClient;
import java.util.Map;


ShiftaiagenticinfraClient client = ShiftaiagenticinfraClient
    .builder()
    .baseUrl("http://localhost:8081")
    .apiKey("pk_your_api_key") 
    .build();

// Register a project (no API key required)
PlatformRegistrationResponse response = client.platform()
    .registerPlatform("my-project", Map.of("env", "production"))
    .get();

System.out.println("API Key: " + response.getApiKey());

// Send a human message
PlatformMessageSubmissionResponse msgResponse = client.messages()
    .sendHumanMessage()
    .username("john")
    .message("Hello")
    .agentName("Bot")
    .agentPlatform("OpenAI")
    .agentVersion("1.0.0")  // Required: Agent version (NOT NULL in database)
    .build()
    .get();

System.out.println("Message ID: " + msgResponse.getMessageId());
```

## Features

- Builder pattern for message submission
- Async support with CompletableFuture
- Thread-safe and stateless
- Comprehensive error handling
- Complete DTO coverage with @JsonIgnoreProperties


## API Reference

### Platform API

#### `registerPlatform(String projectName, Map<String, Object> metadata)`
Register a new project and get API key.

**Parameters:**
- `projectName` (String, required): Unique project identifier
- `metadata` (Map, optional): Additional project metadata

**Return Type:** `CompletableFuture<PlatformRegistrationResponse>`

**Example:**
```java
PlatformRegistrationResponse response = client.platform()
    .registerPlatform("my-project", Map.of("env", "production"))
    .get();
System.out.println("API Key: " + response.getApiKey());
```

### Messages API

#### `sendHumanMessage().[builder methods].build()`
Send a human message using the builder pattern.

**Builder Methods:**
- `username(String username)` - **Required**: User identifier (e.g., "john_doe", "user123")
- `message(String message)` - **Required**: The actual message content (e.g., "Hello, how can I help you?")
- `agentName(String agentName)` - **Required**: Target agent name (e.g., "SupportBot", "GPT-4")
- `agentPlatform(String agentPlatform)` - **Required**: Agent platform/provider (e.g., "OpenAI", "Azure", "Anthropic")
- `userEmail(String userEmail)` - **Required**: User's email address for identification (e.g., "john@example.com")
- `userMetadata(Map<String, Object> userMetadata)` - **Optional**: Custom user attributes (e.g., `Map.of("role", "premium", "subscription", "gold")`)
- `intent(String intent)` - **Optional**: Message intent classification (e.g., "question", "complaint", "request")
- `entities(Map<String, Object> entities)` - **Optional**: Extracted named entities (e.g., `Map.of("person", "John", "location", "New York")`)
- `annotations(Map<String, Object> annotations)` - **Optional**: Additional message annotations (e.g., `Map.of("priority", "high", "tags", List.of("urgent"))`)
- `sourceEvent(Map<String, Object> sourceEvent)` - **Optional**: Original event data from source system
- `agentVersion(String agentVersion)` - **Optional**: Agent version/model (e.g., "gpt-4", "claude-2") - **Required in database**
- `agentMetadata(Map<String, Object> agentMetadata)` - **Optional**: Agent configuration data (e.g., `Map.of("temperature", 0.7, "max_tokens", 1000)`)
- `mode(String mode)` - **Optional**: Mode identifier for the message. Allowed values: `"SIMPLE"` or `"EXPAND"`

**Return Type:** `CompletableFuture<PlatformMessageSubmissionResponse>`

**Example:**
```java
client.messages().sendHumanMessage()
    .username("john_doe")
    .message("Hello, how can I help you?")
    .agentName("SupportBot")
    .agentPlatform("OpenAI")
    .agentVersion("gpt-4")
    .userEmail("john@example.com")
    .userMetadata(Map.of("role", "premium"))
    .build()
    .thenAccept(response -> {
        System.out.println("Message ID: " + response.getMessageId());
    });
```

#### `submit(PlatformMessageSubmissionRequest request)`
Low-level message submission with full control.

**Parameters:**
- `request` (PlatformMessageSubmissionRequest, **required**): Complete message request object with all required fields

**Return Type:** `CompletableFuture<PlatformMessageSubmissionResponse>`

#### `sendBotMessage().[builder methods].build()`
Send a bot response using the builder pattern.

**Builder Methods:**
- `username(String username)` - **Required**: User identifier (must match the human message sender)
- `message(String message)` - **Required**: Bot response content (e.g., "I can help you with that!")
- `agentName(String agentName)` - **Required**: Agent name (must match the human message agent)
- `agentPlatform(String agentPlatform)` - **Required**: Agent platform (must match the human message platform)
- `replyMessageId(UUID replyMessageId)` - **Required**: ID of the human message being replied to
- `ragContext(String ragContext)` - **Required**: RAG context used for generating the response
- `userEmail(String userEmail)` - **Required**: User's email address for identification
- `userMetadata(Map<String, Object> userMetadata)` - **Optional**: User metadata
- `intent(String intent)` - **Optional**: Response intent
- `entities(Map<String, Object> entities)` - **Optional**: Extracted entities from response
- `annotations(Map<String, Object> annotations)` - **Optional**: Response annotations
- `sourceEvent(Map<String, Object> sourceEvent)` - **Optional**: Source event data
- `agentVersion(String agentVersion)` - **Optional**: Agent version/model - **Required in database**
- `agentMetadata(Map<String, Object> agentMetadata)` - **Optional**: Agent configuration
- `mode(String mode)` - **Optional**: Mode identifier for the message. Allowed values: `"SIMPLE"` or `"EXPAND"`

**Return Type:** `CompletableFuture<PlatformMessageSubmissionResponse>`

#### `getAll()`
Get all messages for the authenticated project.

**Return Type:** `CompletableFuture<List<PlatformMessage>>`

#### `getById(UUID messageId)`
Get a specific message by ID.

**Parameters:**
- `messageId` (UUID, **required**): Message identifier

**Return Type:** `CompletableFuture<PlatformMessage>`

#### `getByAgent(UUID agentId)`
Get all messages sent by a specific agent.

**Parameters:**
- `agentId` (UUID, **required**): Agent identifier

**Return Type:** `CompletableFuture<List<PlatformMessage>>`

### Users API

#### `createUser(CreateUserRequest request)`
Create a new user.

**Parameters:**
- `request` (CreateUserRequest, **required**): User creation request with:
  - `username` (String, **required**): Unique username (e.g., "john_doe")
  - `email` (String, **required**): User email address (e.g., "john@example.com")
  - `metadata` (Map<String, Object>, **optional**): Custom user attributes (e.g., `Map.of("role", "premium")`)

**Return Type:** `CompletableFuture<User>`

### Agents API

#### `createAgent(CreateAgentRequest request)`
Create a new AI agent.

**Parameters:**
- `request` (CreateAgentRequest, **required**): Agent creation request with:
  - `name` (String, **required**): Display name for the agent (e.g., "CustomerSupportBot", "CodeAssistant")
  - `platform` (String, **required**): Platform/provider (e.g., "OpenAI", "Azure", "Anthropic")
  - `version` (String, **optional**): Model version (e.g., "gpt-4", "claude-2", "gpt-3.5-turbo")
  - `metadata` (Map<String, Object>, **optional**): Agent configuration (e.g., `Map.of("temperature", 0.7, "max_tokens", 2000, "system_prompt", "You are a helpful assistant")`)

**Return Type:** `CompletableFuture<Agent>`

### Analytics API

#### `submitFeedback(FeedbackSubmissionRequest request)`
Submit feedback on a bot message.

**Parameters:**
- `request` (FeedbackSubmissionRequest, **required**): Feedback request with:
  - `messageId` (UUID, **required**): Bot message ID receiving feedback
  - `like` (Integer, **optional**): Like indicator (1/0/null)
  - `dislike` (Integer, **optional**): Dislike indicator (1/0/null)
  - `feedback` (String, **optional**): Text feedback (e.g., "Too verbose")
  - `regeneration` (Boolean, **optional**): Regeneration requested

**Return Type:** `CompletableFuture<FeedbackSubmissionResponse>`

#### `getDashboard()`
Get project dashboard metrics.

**Return Type:** `CompletableFuture<DashboardMetricsDTO>`

#### `getTopAgents(int limit)`
Get top-performing agents by usage.

**Parameters:**
- `limit` (int, **optional**): Maximum results (default: 5, max: 100)

**Return Type:** `CompletableFuture<List<TopAgentDTO>>`

#### `getTopUsers(int limit)`
Get most active users.

**Parameters:**
- `limit` (int, **optional**): Maximum results (default: 5, max: 100)

**Return Type:** `CompletableFuture<List<TopUserDTO>>`

#### `getUserAnalytics()`
Get analytics for all users.

**Return Type:** `CompletableFuture<List<UserAnalyticsDTO>>`

#### `getProjectData(int topLimit)`
Get project-level analytics data.

**Parameters:**
- `topLimit` (int, **optional**): Limit for top results (default: 10, max: 100)

**Return Type:** `CompletableFuture<ProjectAnalyticsResponseDTO>`

#### `getAll(int topLimit)`
Get comprehensive analytics data.

**Parameters:**
- `topLimit` (int, **optional**): Limit for top results (default: 5, max: 100)

**Return Type:** `CompletableFuture<Map<String, Object>>`

#### `initialize()`
Initialize analytics for the project.

**Return Type:** `CompletableFuture<Map<String, Object>>`

### Conversations API

#### `getMessagesByConversationId(UUID conversationId)`
Get all messages in a conversation.

**Parameters:**
- `conversationId` (UUID, **required**): Conversation identifier

**Return Type:** `CompletableFuture<List<ConversationMessageResponse>>`

#### `getAllConversations()`
Get all conversations for the project.

**Return Type:** `CompletableFuture<List<ConversationSummaryResponse>>`

#### `getUserConversations(String username)`
Get all conversations for a specific user.

**Parameters:**
- `username` (String, **required**): Username to filter conversations by

**Return Type:** `CompletableFuture<List<ConversationSummaryResponse>>`

### Internal API (TruLens)

#### `generateMetricsForSession(UUID conversationId)`
Generate metrics for a specific completed session.

**Parameters:**
- `conversationId` (UUID, **required**): UUID of the completed conversation

**Return Type:** `CompletableFuture<Map<String, Object>>`

#### `generateMetricsForAllSessions()`
Generate metrics for all completed sessions in the project.

**Parameters:** None

**Return Type:** `CompletableFuture<Map<String, Object>>`

#### `generateMetricsForAllConversations()`
Generate metrics for all conversations (admin - no auth required).

**Parameters:** None

**Return Type:** `CompletableFuture<Map<String, Object>>`

#### `getBatchProgress(String jobId)`
Get progress for a batch metrics generation job (admin - no auth required).

**Parameters:**
- `jobId` (String, **required**): The job ID returned from `generateMetricsForAllConversations`

**Return Type:** `CompletableFuture<Map<String, Object>>`

## Note

This SDK is built to enable developers to easily integrate and use the Shift AI Agentic Infra in their own applications

