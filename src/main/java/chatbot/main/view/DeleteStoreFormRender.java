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

        Map<String, String> data = (Map<String, String>) model.get("successMessage");
        data.forEach((key, value) -> System.out.println("[가게고유번호 " + key + ", 가게이름: " + value + "]"));

        System.out.println(model.get("render"));
        String input;
        try {
            while (true) {
                input = keyBoard.readLine();
                for (String key : data.keySet()
                ) {
                    if (input.equals(key)) {
                        model.put("requestParam", input);
                        return "deleteStore";
                    }
                }
                System.out.println("삭제할 가게번호를 다시 입력해주세요.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "deleteStore";
    }
}
