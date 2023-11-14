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

    public static void printEventDetail(Order order) {
        System.out.println(Message.OUTPUT_RECEIPT_EVENT_TITLE);
        printDdayDiscount(order);
        printWeekDayDiscount(order);
        printWeekEndDiscount(order);
        printSpecialDiscount(order);
        printPresentDiscount(order);
        printEmptyDiscount(order);
        System.out.println();
    }

    private static void printDdayDiscount(Order order) {
        if (order.getDdayDiscount() > 0) {
            System.out.println(
                    Message.OUTPUT_RECEIPT_EVENT_CHRISTMAS + PRICE_THOUSAND_FORMAT.format(order.getDdayDiscount())
                            + MESSAGE_SUFFIX_PRICE);
        }
    }

    private static void printWeekDayDiscount(Order order) {
        if (order.getWeekDayDiscount() > 0) {
            System.out.println(
                    Message.OUTPUT_RECEIPT_EVENT_WEEKDAY + PRICE_THOUSAND_FORMAT.format(order.getWeekDayDiscount())
                            + MESSAGE_SUFFIX_PRICE);
        }
    }

    private static void printWeekEndDiscount(Order order) {
        if (order.getWeekEndDiscount() > 0) {
            System.out.println(
                    Message.OUTPUT_RECEIPT_EVENT_WEEKEND + PRICE_THOUSAND_FORMAT.format(order.getWeekEndDiscount())
                            + MESSAGE_SUFFIX_PRICE);
        }
    }

    private static void printSpecialDiscount(Order order) {
        if (order.getSpecialDiscount() > 0) {
            System.out.println(
                    Message.OUTPUT_RECEIPT_EVENT_SPECIAL + PRICE_THOUSAND_FORMAT.format(order.getSpecialDiscount())
                            + MESSAGE_SUFFIX_PRICE);
        }
    }

    private static void printPresentDiscount(Order order) {
        if (order.getOrderTotalPrice() >= StoreConstant.PRESENT_PAYMENT) {
            System.out.println(Message.OUTPUT_RECEIPT_EVENT_PRESENT);
        }
    }

    private static void printEmptyDiscount(Order order) {
        if (order.getDdayDiscount() == 0 && order.getWeekDayDiscount() == 0 && order.getWeekEndDiscount() == 0
                && order.getSpecialDiscount() == 0
                && order.getOrderTotalPrice() <= StoreConstant.PRESENT_PAYMENT) {
            System.out.println(Message.OUTPUT_RECEIPT_EMPTY);
        }
    }

    public static void printEventTotalDiscount(Order order) {
        System.out.println(Message.OUTPUT_RECEIPT_EVENT_TOTAL_TITLE);
        System.out.println("-" + PRICE_THOUSAND_FORMAT.format(order.getTotalDiscount()) + MESSAGE_SUFFIX_PRICE);
        System.out.println();
    }
}
