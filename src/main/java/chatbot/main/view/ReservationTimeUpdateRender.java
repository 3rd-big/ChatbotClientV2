package chatbot.main.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

public class ReservationTimeUpdateRender implements Renderer {

    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();


        String route = "";

        if (model.get("errorMessage") != null) {
            System.out.println(model.get("errorMessage"));
        }
        if (model.get("successMessage") != null) {
            System.out.println(model.get("successMessage"));
        }
        System.out.println("예약 인원을 입력하세요(숫자만 입력)");
        try {
            String input = keyBoard.readLine();
            if (input == null) {
                model.put("errorMessage", "입력없음 : 다시 입력해주세요");
                route = this.process(model, keyBoard, pw);
            }
            String requestParam = input;
            model.put("requestParam", requestParam);
            route = "reservationPeopleUpdate";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }
}