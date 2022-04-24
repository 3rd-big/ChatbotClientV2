package chatbot.main.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

public interface Renderer {

    public String process(Map<String, Object> model, BufferedReader keyBoard, PrintWriter pw);

    default void banner() {
        System.out.println("\n" +
                "██████╗  ██████╗ ██████╗  ██████╗ ██████╗ ██████╗ ███████╗\n" +
                "██╔══██╗██╔═══██╗██╔══██╗██╔════╝██╔═══██╗██╔══██╗██╔════╝\n" +
                "██████╔╝██║   ██║██████╔╝██║     ██║   ██║██║  ██║█████╗  \n" +
                "██╔══██╗██║   ██║██╔═══╝ ██║     ██║   ██║██║  ██║██╔══╝  \n" +
                "██████╔╝╚██████╔╝██║     ╚██████╗╚██████╔╝██████╔╝███████╗\n" +
                "╚═════╝  ╚═════╝ ╚═╝      ╚═════╝ ╚═════╝ ╚═════╝ ╚══════╝\n" +
                "                                                          \n");
    }

    default void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
