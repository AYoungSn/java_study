package prob17;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Pr2_Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9000);
            Socket connection = server.accept();
            PrintWriter pw = new PrintWriter(connection.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            List<String> str=Files.readAllLines(Path.of(br.readLine()));
            for (String line : str) {
                pw.println(line);
            }

            server.close();
            connection.close();
            pw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}
