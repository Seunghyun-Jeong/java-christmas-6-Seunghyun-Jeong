package christmas.util;

import christmas.constant.menu.Message;
import christmas.exception.WootechcoIllegalArgumentException;

public class ReservationValidator {
    public static void validateReservationDate(int visitDate) {
        if (visitDate < 1 || visitDate > 31) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_DATE);
        }
    }
}