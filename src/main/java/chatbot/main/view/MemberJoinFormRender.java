package chatbot.main.view;

import chatbot.main.dto.MemberDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemberJoinFormRender implements Renderer {

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
            System.out.println("input = " + input);

            String[] joinInfo = input.split(" ");
            System.out.println("Arrays.stream(joinInfo).toArray() = " + Arrays.stream(joinInfo).toArray());

//            MemberDTO member = new MemberDTO(joinInfo[0], joinInfo[1], joinInfo[2], joinInfo[3]);
//            model.put("member", member); // 1방안

//            Gson gson = new Gson();
//            model.put("member", gson.toJson(member)); // 2방안
//
            Map<String, String> requestParam = new HashMap<>();
            requestParam.put("id", joinInfo[0]);
            requestParam.put("password", joinInfo[1]);
            requestParam.put("name", joinInfo[2]);
            requestParam.put("mobile", joinInfo[3]);
            model.put("requestParam", requestParam);

            route = "memberJoin";

        } catch (IOException e) {
            model.put("errorMessage", e.getMessage());
            route = "memberForm";
            e.printStackTrace();
        }

        return route;
    }
}
