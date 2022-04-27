package chatbot.main.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
            model.remove("successMessage");
        }

        Map<Object, Object> data = (Map<Object, Object>) model.get("render");
        System.out.println("<예약 가능한 시간 및 인원>");
        AtomicInteger num = new AtomicInteger(1);
        data.forEach((key, value) -> System.out.printf("[" + num.getAndIncrement() + "] " + key+"시 %.0f명\n", value));
        System.out.println("예약 시간을 입력하세요(숫자만 입력)");
        try {
            String input = keyBoard.readLine();
            if (input == null || input.equals("0")) {
                model.put("errorMessage", "입력없음 : 다시 입력해주세요");
                route = this.process(model, keyBoard, pw);
            }
            String requestParam = input;
            model.put("requestParam", requestParam);

            route = "reservationTimeUpdate";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }
}