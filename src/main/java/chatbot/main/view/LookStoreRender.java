package chatbot.main.view;

import chatbot.main.dto.StoreDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class LookStoreRender implements Renderer {

    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();
        banner();

        List<Object> data = (List<Object>) model.get("render");
        data.forEach(System.out::println);

        try {
            keyBoard.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "adminForm";
    }
}
