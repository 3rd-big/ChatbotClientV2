package chatbot.main.common;

import com.google.gson.Gson;

import java.io.PrintWriter;
import java.util.Map;

public class Request {

    private String route;

    public Request(String route) {
        this.route = route;
    }

    public void send(Map<String, Object> model, PrintWriter pw){
        String requestData = modelToJsonString(model);
//        System.out.println("requestData = " + requestData);
        pw.println(requestData);
        pw.flush();
    }

    // Map -> Json 문자열
    private String modelToJsonString(Map<String, Object> model) {
        Gson gson = new Gson();
        model.put("route", route);
        return gson.toJson(model);
    }
}
