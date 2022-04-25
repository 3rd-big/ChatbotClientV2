package chatbot.main.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class AdminFormRender implements Renderer {

    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();
        banner();

        String route = "";

        if (model.get("errorMessage") != null) {
            System.out.println(model.get("errorMessage"));
        }
        if (model.get("successMessage") != null) {
            System.out.println(model.get("successMessage"));
        }

        Map<String, String> data = (Map<String, String>) model.get("render");
        data.forEach((key, value) -> System.out.println("[" + key + "] " + value));


        try {
            String input = keyBoard.readLine();

            if (input.equals("1")) return "lookStore";
            if (input.equals("2")) return "addStoreForm";
            if (input.equals("3")) return "deleteStore";
            if (input.equals("4")) return "exit";

            model.put("errorMessage", "번호를 다시 입력해주세요.");
            return this.process(model, keyBoard, pw);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
