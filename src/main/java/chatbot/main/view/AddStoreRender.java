package chatbot.main.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AddStoreRender implements Renderer {

    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();
        banner();
        String route = "";
        System.out.println(model.get("render"));
        String input = null;
        try {
            input = keyBoard.readLine();
            System.out.println("input = " + input);

            Map<String, String> requestParam = new HashMap<>();
            requestParam.put("stName", input);
            model.put("requestParam", requestParam);

            route = "addStore";
        } catch (IOException e) {
            model.put("errorMessage", e.getMessage());
            route = "adminForm";
            e.printStackTrace();
        }
        return route;
    }
}
