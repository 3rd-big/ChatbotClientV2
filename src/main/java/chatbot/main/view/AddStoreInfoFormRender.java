package chatbot.main.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AddStoreInfoFormRender implements Renderer {

    @Override
    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw) {
        clearScreen();
        banner();
        System.out.println(model.get("successMessage"));
        if (model.get("successMessage").toString().contains("실패")) return "adminForm";
        Map<String, String> requestParam = new HashMap<>();
        String stName = model.get("successMessage").toString();
        stName = stName.replace("입력한 [ ", "");
        stName = stName.replace(" ] 가게 제휴 등록 성공", "");

        model.put("requestStName", stName);
        try {
            while (true) {

                System.out.println("추가할 예약 시간과 그 예약시간에 가능한 총 인원 수 입력");
                System.out.println("ex) 00(시) 00(명)");
                String input = keyBoard.readLine();
                String str[] = input.split(" ");
                requestParam.put(str[0].replaceAll("[^0-9]", ""), str[1].replaceAll("[^0-9]", ""));


                while (true) {
                    System.out.println("예약시간을 더 추가하시려면 1 번, 추가가 끝났다면 2 번을 입력해 주세요.");
                    String select = keyBoard.readLine();
                    if (select.equals("1")) break;
                    if (select.equals("2")) {
                        model.put("requestParam", requestParam);
                        return "addStoreInfo";
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "adminForm";
    }
}
