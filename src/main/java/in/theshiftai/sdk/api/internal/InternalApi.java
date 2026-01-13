package in.theshiftai.sdk.api.internal;

import in.theshiftai.sdk.http.HttpClient;

/**
 * Internal API wrapper for admin/observability operations.
 */
public class InternalApi {
    public final EvalApi eval;

    public InternalApi(HttpClient httpClient) {
        this.eval = new EvalApi(httpClient);
    }
}
