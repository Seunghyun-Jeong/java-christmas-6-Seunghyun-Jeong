package christmas.controller;

import christmas.constant.menu.WootechcoMenu;
import christmas.exception.WootechcoIllegalArgumentException;
import christmas.model.Order;
import christmas.service.OrderCalculator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class WootechcoStore {

    OrderCalculator orderCalculator = new OrderCalculator();

    public void reserve() {
        Order order = new Order();
        printWelcome();
        order.setReservationDate(reserveDate());
        order.setOrderMenu(reserveOrderMenu());
        orderCalculator.calculateOrder(order);
        printNoticeDiscount(order);
        printReceipt(order);
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

    private Map<WootechcoMenu, Integer> reserveOrderMenu() {
        while (true) {
            try {
                return InputView.inputOrderMenu();
            } catch (WootechcoIllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printNoticeDiscount(Order order) {
        OutputView.printNoticeDiscount(order);
    }

    private void printReceipt(Order order) {
        OutputView.printReceiptTitle(order);
        OutputView.printOrderMenu(order);
        OutputView.printOrderTotalPrice(order);
        OutputView.printPresent(order);
        OutputView.printEventDetail(order);
        OutputView.printEventTotalDiscount(order);
        OutputView.printPaymentResult(order);
        OutputView.printEventBadge(order);
    }
}
