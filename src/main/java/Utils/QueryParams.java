package Utils;

import java.util.HashMap;

public class QueryParams {

    public static HashMap<String, String> generalQueryParams(String id) {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return queryParams;
    }
}
