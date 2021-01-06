package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Insert your name"));
                Message message = connection.receive();
                if (message.getType() != null
                        && message.getType().equals(MessageType.USER_NAME)
                        && message.getData() != null
                        && !message.getData().isEmpty()
                        && !connectionMap.containsKey(message.getData())) {
                    String result = message.getData();
                    connectionMap.put(result, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return result;
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String user : connectionMap.keySet()) {
                if (!user.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, user));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Message messageFull = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(messageFull);
                } else {
                    ConsoleHelper.writeMessage("Unexpected message format");
                }
            }
        }

        public void run() {
            ConsoleHelper.writeMessage("New connection with " + socket.getRemoteSocketAddress());

            try {
                Connection connection = new Connection(socket);
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (String user : connectionMap.keySet()) {
            try {
                connectionMap.get(user).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Message hasn't sent");
            }
        }
    }

    public static void main(String[] args) {

        ConsoleHelper.writeMessage("Insert port");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Server has started");

            while (true) {
                Thread thread = new Server.Handler(serverSocket.accept());
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
