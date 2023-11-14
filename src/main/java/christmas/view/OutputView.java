package christmas.view;

import christmas.constant.menu.Message;

public class OutputView {
    private final static String MESSAGE_PREFIX_ERROR = "[ERROR] ";

    public static void printWelcomeMessage() {
        System.out.println(Message.OUTPUT_WELCOME);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(MESSAGE_PREFIX_ERROR + errorMessage);
    }
}
