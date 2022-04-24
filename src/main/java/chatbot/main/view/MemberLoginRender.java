package chatbot.main.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class MemberLoginRender implements Renderer {

    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();
        banner();

        String route = "";

        if (model.get("errorMessage") != null) {
            System.out.println(model.get("errorMessage"));
        }

        Map<String, String> data = (Map<String, String>) model.get("render");
        data.forEach((key, value) -> System.out.println("[" + key + "] " + value));

        try {
            String input = keyBoard.readLine();

            if (input.equals("1")) {
                route = "memberList";
            } else if (input.equals("2")) {
                route = "memberSave";
            } else {
                model.put("errorMessage", "번호를 다시 입력해주세요");
                route = this.process(model, keyBoard, pw);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return route;
    }

}
