package chatbot.main.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class DeleteStoreFormRender implements Renderer {
    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();
        banner();

        System.out.println(model.get("render"));

        try {
            String input = keyBoard.readLine();
            model.put("requestParam", input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "deleteStore";
    }
}
