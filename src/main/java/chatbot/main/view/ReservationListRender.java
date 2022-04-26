package chatbot.main.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

public class ReservationListRender implements Renderer {

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
        data.forEach((key, value) -> System.out.println("예약 가능한 시간은 "+key+"시"+value+"명 입니다."));

        try {
            String input = keyBoard.readLine();
            if (input == null) {
                model.put("errorMessage", "입력없음 : 다시 입력해주세요");
                route = this.process(model, keyBoard, pw);
            }
            route = "???????????????";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }
}