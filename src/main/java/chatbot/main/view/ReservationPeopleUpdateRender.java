package chatbot.main.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

public class ReservationPeopleUpdateRender implements Renderer {

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

        Map<String, String> data = (Map<String, String>) model.get("reservationInfo");
        String store = data.get("stname");
        String resDate = data.get("resdate");
        String resPeople = data.get("respeople");
        System.out.println("<"+store+"> "+resDate+"시 / "+resPeople+"명 예약이 완료 되었습니다.");

        try {
            String input = keyBoard.readLine();
            if (input == null) {
                model.put("errorMessage", "입력없음 : 다시 입력해주세요");
                route = this.process(model, keyBoard, pw);
            }
            model.remove("errorMessage");
            String requestParam = input;
            model.put("requestParam", requestParam);
            route = "reservationSmsSend";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }
}