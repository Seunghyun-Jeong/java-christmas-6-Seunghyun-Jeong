package christmas.controller;

import christmas.exception.WootechcoIllegalArgumentException;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class WootechcoStore {
    public void reserve() {
        Order order = new Order();
        printWelcome();
        order.setReservationDate(reserveDate());
    }

    private void printWelcome() {
        OutputView.printWelcomeMessage();
    }

    private int reserveDate() {
        while (true) {
            try {
                return InputView.inputReservationDate();
            } catch (WootechcoIllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
