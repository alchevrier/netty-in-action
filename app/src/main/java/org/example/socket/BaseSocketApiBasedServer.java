package org.example.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BaseSocketApiBasedServer {
    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String request, response;
            while ((request = in.readLine()) != null) {
                if ("Done".equals(request)) {
                    return;
                }
                response = processRequest(request);
                out.println(response);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String processRequest(String request) {
        return request;
    }
}
