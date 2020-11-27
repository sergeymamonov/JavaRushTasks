package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        int amount;
        Map<Integer, Integer> withdrawMap = null;
        while (true){
            ConsoleHelper.writeMessage("Insert amount");
            try
            {
                amount = Integer.parseInt(ConsoleHelper.readString());
            }
            catch (NumberFormatException nfe){
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                continue;
            }
            if (amount <= 0) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (!currencyManipulator.isAmountAvailable(amount)){
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            try
            {
                withdrawMap = currencyManipulator.withdrawAmount(amount);
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            for (Map.Entry<Integer, Integer> pair : withdrawMap.entrySet()) {
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, code));
            break;
        }
    }
}
