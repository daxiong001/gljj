package comments;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class Response {
    private String httpCode = "";
    private String resultCode = "";
    private String jsonString = "";
    private Map<String, Object> paramtersMap = Maps.newHashMap();

    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String statusLine) {
        String[] tokens = StringUtils.split(statusLine.trim(), " ");
        this.httpCode = tokens[tokens.length - 1];
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public Map<String, Object> getParamtersMap() {
        return paramtersMap;
    }

    public void setParamtersMap(Map<String, Object> paramtersMap) {
        this.paramtersMap = paramtersMap;
    }

}
