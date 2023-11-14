package christmas.exception;

import christmas.constant.menu.Message;

public class WootechcoIllegalArgumentException extends IllegalArgumentException {
    public WootechcoIllegalArgumentException(Message message) {
        super(message.toString());
    }
}