package chatbot.main.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ReservationFormRender implements Renderer {

    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();
        banner();
        String route = null;

        if (model.get("errorMessage") != null) {
            System.out.println(model.get("errorMessage"));
        }

        if (model.get("successMessage") != null) {
            System.out.println(model.get("successMessage"));
            model.remove("successMessage");
        }

        Map<String, String> data = (Map<String, String>) model.get("render");
//        data.forEach((key, value) -> System.out.println("<"+value+" --> "+key+">")); //식당 목록
        data.forEach((key, value) -> System.out.println("["+key+"] "+value)); //식당 목록
        System.out.println("예약을 원하는 식당 번호를 입력하세요(숫자만 입력)");

        try {
            String input = keyBoard.readLine();
            if (input == null) {
                model.put("errorMessage", "다시 입력해주세요");
                route = this.process(model, keyBoard, pw);
            }
            String requestParam = input;
            model.put("requestParam", requestParam);

            route = "reservationList";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }
}