package chatbot.main.client;

import chatbot.main.common.Request;
import chatbot.main.view.MemberListRender;
import chatbot.main.view.MemberLoginRender;
import chatbot.main.view.Renderer;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class CjatbotClient {

    final private String IP;
    final private int PORT;

    private final Map<String, Renderer> remdererMap = new HashMap<>();

    public CjatbotClient(String IP, int PORT) {
        this.IP = IP;
        this.PORT = PORT;

        remdererMap.put("loginForm", new MemberLoginRender());
        remdererMap.put("memberList", new MemberListRender());
//        remdererMap.put("memberSave", new MemberSaveController());
    }

    void start() {

        try (Socket clientSocket = new Socket(this.IP, this.PORT);) {

            InputStreamReader ink = new InputStreamReader(System.in);
            BufferedReader keyBoard = new BufferedReader(ink);

            OutputStream out = clientSocket.getOutputStream();
            OutputStreamWriter outW = new OutputStreamWriter(out);
            PrintWriter pw = new PrintWriter(outW);

            InputStream in = clientSocket.getInputStream();
            InputStreamReader inR = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inR);



            // test connect start
            Gson gs = new Gson();
            Map<String, Object> connect = new HashMap<>();
            connect.put("route", "memberForm");
            String connectJsonString = gs.toJson(connect);
            System.out.println("connectJsonString = " + connectJsonString);

            pw.println(connectJsonString);
            pw.flush();
            // test connect end


            Gson gson = new Gson();


            while (true) {
                String receivedJsonString = br.readLine();
                System.out.println("receivedJsonString = " + receivedJsonString);

                // json 문열 -> Map
                Map<String, Object> model = gson.fromJson(receivedJsonString, HashMap.class);
                Object screenName = model.get("screenName");
                if (screenName == null) {
                    System.out.println("screenName 값이 없음");
                    return;
                }
                System.out.println("screenName = " + screenName);

                Renderer renderer = remdererMap.get((String) screenName);
                String route = renderer.process(model, keyBoard, pw);
                System.out.println("route = " + route);

                Request request = new Request(route);

                request.send(model, pw);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}