package chatbot.main.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

public class DeleteStoreResultRender implements Renderer {
    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();
        banner();
        //System.out.println(model.get("render"));
        System.out.println(model.get("successMessage"));
        return "adminForm";
    }
}
