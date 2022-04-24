package chatbot.main.client;

public class Main {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java -jar ChatbotClient.jar [Server IP] [port]");
            return;
        }

        String ip = args[0];
        int port = Integer.parseInt(args[1]);

        new CjatbotClient(ip, port).start();
    }
}
