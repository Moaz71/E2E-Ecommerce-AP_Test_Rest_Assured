package Utils;

import java.util.HashMap;

public class Headers {

    public static HashMap<String, String> standardHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public static HashMap<String, String> withAuthHeaders(String token, String contentType) {

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", contentType);
        headers.put("Authorization", token);
        return headers;
    }
}
