package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");


    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String insertedCardNumber = ConsoleHelper.readString();
            String insertedPin = ConsoleHelper.readString();

            if (!insertedCardNumber.matches("\\d{12}") || !insertedPin.matches("\\d{4}")) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            if (validCreditCards.containsKey(insertedCardNumber)) {
                if (validCreditCards.getString(insertedCardNumber).equals(insertedPin)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), insertedCardNumber));
                    break;
                }
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), insertedCardNumber));
            }
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
    }
}
