package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message == null || !message.contains(": ")) {
                return;
            }
            String[] params = message.split(": ");
            String userName = params[0];
            String text = params[1];
            String commonResponse = "Информация для " + userName + ": ";
            String response = "";

            switch (text) {
                case "дата":
                    response = new SimpleDateFormat("d.MM.YYYY").format(new GregorianCalendar().getTime());
                    break;
                case "день":
                    response = new SimpleDateFormat("d").format(new GregorianCalendar().getTime());
                    break;
                case "месяц":
                    response = new SimpleDateFormat("MMMM").format(new GregorianCalendar().getTime());
                    break;
                case "год":
                    response = new SimpleDateFormat("YYYY").format(new GregorianCalendar().getTime());
                    break;
                case "время":
                    response = new SimpleDateFormat("H:mm:ss").format(new GregorianCalendar().getTime());
                    break;
                case "час":
                    response = new SimpleDateFormat("H").format(new GregorianCalendar().getTime());
                    break;
                case "минуты":
                    response = new SimpleDateFormat("m").format(new GregorianCalendar().getTime());
                    break;
                case "секунды":
                    response = new SimpleDateFormat("s").format(new GregorianCalendar().getTime());
                    break;
                default:
                    return;
            }

            sendTextMessage(commonResponse + response);
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
