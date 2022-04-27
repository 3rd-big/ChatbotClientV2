package chatbot.main.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MemberLoginRender implements Renderer {

    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();
        banner();

        String route = "";

        if (model.get("errorMessage") != null) {
            System.out.println(model.get("errorMessage"));
            model.remove("errorMessage");
        }
        if (model.get("successMessage") != null) {
            System.out.println(model.get("successMessage"));
        }

        Map<String, String> data = (Map<String, String>) model.get("render");
        data.forEach((key, value) -> System.out.println("[" + key + "] " + value));

        try {
            String input = keyBoard.readLine();

            String[] loginInfo = input.split(" ");

            if (loginInfo.length != 2) {
                model.put("errorMessage", "아이디와 비밀번호를 공백기준으로 입력해주세요");
                this.process(model, keyBoard, pw);
            } else {
                Map<String, String> requestParam = new HashMap<>();
                requestParam.put("id", loginInfo[0]);
                requestParam.put("password", loginInfo[1]);
                model.put("requestParam", requestParam);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "memberLogin";
    }
}
