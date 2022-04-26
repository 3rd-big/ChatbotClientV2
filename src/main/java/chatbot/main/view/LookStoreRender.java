package chatbot.main.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class LookStoreRender implements Renderer {

    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();
        banner();

        //List<Object> data = (List<Object>) model.get("render");
        Map<String, String> data = (Map<String, String>) model.get("render");
        data.forEach((key, value) -> System.out.println("[가게고유번호 " + key + ", 가게이름: " + value + "]"));

        try {
            System.out.println("계속 진행하시려면 아무키나 눌러주세요.");
            keyBoard.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "adminForm";
    }
}
