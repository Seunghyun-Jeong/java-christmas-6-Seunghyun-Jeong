package christmas.view;

import christmas.constant.StoreConstant;
import christmas.constant.menu.Message;
import christmas.model.Order;
import java.text.DecimalFormat;

public class OutputView {
    private final static String MESSAGE_PREFIX_ERROR = "[ERROR] ";
    private final static String MESSAGE_SUFFIX_COUNT = "개";
    private final static String MESSAGE_SUFFIX_PRICE = "원";
    private final static DecimalFormat PRICE_THOUSAND_FORMAT = new DecimalFormat("###,###");

    public static void printWelcomeMessage() {
        System.out.println(Message.OUTPUT_WELCOME);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(MESSAGE_PREFIX_ERROR + errorMessage);
    }

    public static void printReceiptTitle(Order order) {
        System.out.print(Message.OUTPUT_RECEIPT_TITLE_PREFIX);
        System.out.print(order.getReservationDate());
        System.out.println(Message.OUTPUT_RECEIPT_TITLE_SUFFIX);
        System.out.println();
    }

    public static void printOrderMenu(Order order) {
        System.out.println(Message.OUTPUT_RECEIPT_ORDER_MENU_TITLE);
        order.getOrderMenu().forEach(
                (menu, integer) -> System.out.println(menu.getMenuName() + " " + integer + MESSAGE_SUFFIX_COUNT));
        System.out.println();
    }

    public static void printOrderTotalPrice(Order order) {
        System.out.println(Message.OUTPUT_RECEIPT_TOTAL_PRICE_TITLE);
        System.out.println(PRICE_THOUSAND_FORMAT.format(order.getOrderTotalPrice()) + MESSAGE_SUFFIX_PRICE);
        System.out.println();
    }

    public static void printPresent(Order order) {
        System.out.println(Message.OUTPUT_RECEIPT_PRESENT_TITLE);
        if (order.getOrderTotalPrice() >= StoreConstant.PRESENT_PAYMENT) {
            System.out.println(Message.OUTPUT_RECEIPT_PRESENT);
            System.out.println();
            return;
        }
        System.out.println(Message.OUTPUT_RECEIPT_EMPTY);
        System.out.println();
    }
}
