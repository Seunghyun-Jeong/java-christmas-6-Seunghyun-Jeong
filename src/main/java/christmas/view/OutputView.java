package christmas.view;

import christmas.constant.StoreConstant;
import christmas.constant.menu.Message;
import christmas.model.Order;
import java.text.DecimalFormat;

public class OutputView {
    private final static String MESSAGE_PREFIX_ERROR = "[ERROR] ";
    private final static String MESSAGE_SUFFIX_COUNT = "개";
    private final static String MESSAGE_SUFFIX_PRICE = "원";
    private final static int MESSAGE_DISCOUNT_PRICE_MARK_NEGATIVE = -1;
    private final static DecimalFormat PRICE_THOUSAND_FORMAT = new DecimalFormat("###,###");

    public static void printWelcomeMessage() {
        System.out.println(Message.OUTPUT_WELCOME);
    }

    public static void printNoticeDiscount(Order order) {
        if (!order.isApplyDiscount()) {
            System.out.println(Message.WARN_ORDER_MENU);
        }
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
        if (order.isPresentOffer()) {
            System.out.println(Message.OUTPUT_RECEIPT_PRESENT);
            System.out.println();
            return;
        }
        System.out.println(Message.OUTPUT_RECEIPT_EMPTY);
        System.out.println();
    }

    public static void printEventDetail(Order order) {
        System.out.println(Message.OUTPUT_RECEIPT_EVENT_TITLE);
        if (!order.isApplyDiscount()) {
            System.out.println(Message.OUTPUT_RECEIPT_EMPTY);
            System.out.println();
            return;
        }
        printDdayDiscount(order);
        printWeekDayDiscount(order);
        printWeekEndDiscount(order);
        printSpecialDiscount(order);
        printPresentDiscount(order);
        printEmptyDiscount(order);
        System.out.println();
    }

    private static void printDdayDiscount(Order order) {
        if (order.isNotZeroDdayDiscount()) {
            System.out.println(
                    Message.OUTPUT_RECEIPT_EVENT_CHRISTMAS + PRICE_THOUSAND_FORMAT.format(
                            order.getDdayDiscount() * MESSAGE_DISCOUNT_PRICE_MARK_NEGATIVE)
                            + MESSAGE_SUFFIX_PRICE);
        }
    }

    private static void printWeekDayDiscount(Order order) {
        if (order.isNotZeroWeekDayDiscount()) {
            System.out.println(
                    Message.OUTPUT_RECEIPT_EVENT_WEEKDAY + PRICE_THOUSAND_FORMAT.format(
                            order.getWeekDayDiscount() * MESSAGE_DISCOUNT_PRICE_MARK_NEGATIVE)
                            + MESSAGE_SUFFIX_PRICE);
        }
    }

    private static void printWeekEndDiscount(Order order) {
        if (order.isNotZeroWeekEndDiscount()) {
            System.out.println(
                    Message.OUTPUT_RECEIPT_EVENT_WEEKEND + PRICE_THOUSAND_FORMAT.format(
                            order.getWeekEndDiscount() * MESSAGE_DISCOUNT_PRICE_MARK_NEGATIVE)
                            + MESSAGE_SUFFIX_PRICE);
        }
    }

    private static void printSpecialDiscount(Order order) {
        if (order.isNotZeroSpecialDiscount()) {
            System.out.println(
                    Message.OUTPUT_RECEIPT_EVENT_SPECIAL + PRICE_THOUSAND_FORMAT.format(
                            order.getSpecialDiscount() * MESSAGE_DISCOUNT_PRICE_MARK_NEGATIVE)
                            + MESSAGE_SUFFIX_PRICE);
        }
    }

    private static void printPresentDiscount(Order order) {
        if (order.isPresentOffer()) {
            System.out.println(Message.OUTPUT_RECEIPT_EVENT_PRESENT);
        }
    }

    private static void printEmptyDiscount(Order order) {
        if (order.isEmptyEventDetail()) {
            System.out.println(Message.OUTPUT_RECEIPT_EMPTY);
        }
    }

    public static void printEventTotalDiscount(Order order) {
        System.out.println(Message.OUTPUT_RECEIPT_EVENT_TOTAL_TITLE);

        String eventTotalDiscountMessage =
                PRICE_THOUSAND_FORMAT.format(order.getEventTotalDiscount() * MESSAGE_DISCOUNT_PRICE_MARK_NEGATIVE)
                        + MESSAGE_SUFFIX_PRICE;
        System.out.println(eventTotalDiscountMessage);
        System.out.println();
    }

    public static void printPaymentResult(Order order) {
        System.out.println(Message.OUTPUT_RECEIPT_PAYMENT_TITLE);
        System.out.println(PRICE_THOUSAND_FORMAT.format(order.getPaymentResult()) + MESSAGE_SUFFIX_PRICE);
        System.out.println();
    }

    public static void printEventBadge(Order order) {
        System.out.println(Message.OUTPUT_RECEIPT_BADGE_TITLE);
        int eventTotalDiscount = order.getEventTotalDiscount();
        if (eventTotalDiscount >= StoreConstant.BADGE_SANTA) {
            System.out.println(Message.OUTPUT_RECEIPT_BADGE_SANTA);
            return;
        }
        if (eventTotalDiscount >= StoreConstant.BADGE_TREE) {
            System.out.println(Message.OUTPUT_RECEIPT_BADGE_TREE);
            return;
        }
        if (eventTotalDiscount >= StoreConstant.BADGE_STAR) {
            System.out.println(Message.OUTPUT_RECEIPT_BADGE_STAR);
            return;
        }
        System.out.println(Message.OUTPUT_RECEIPT_EMPTY);
    }
}
