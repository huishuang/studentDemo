package ccut.qinrushi.util;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ShowData {
    public String showData(Boolean status, Object data){
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("status", status);
        jsonObject.accumulate("data", data);
        return jsonObject.toString();
    }
}
