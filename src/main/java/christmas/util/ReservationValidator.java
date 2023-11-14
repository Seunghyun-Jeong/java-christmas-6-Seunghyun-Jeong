package christmas.util;

import christmas.constant.menu.Message;
import christmas.constant.menu.WootechcoMenu;
import christmas.exception.WootechcoIllegalArgumentException;
import java.util.Map;

public class ReservationValidator {
    public static void validateReservationDate(int visitDate) {
        if (visitDate < 1 || visitDate > 31) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_DATE);
        }
    }

    public static void validateMenuInput(WootechcoMenu menu, int amount) {
        if (menu == null || amount == 0) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_ORDER_MENU);
        }
    }

    public static void validateDuplicatedOrderMenu(Map<WootechcoMenu, Integer> orderMenu, WootechcoMenu menu) {
        if (orderMenu.containsKey(menu)) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_ORDER_MENU);
        }
    }

    public static void validateLimitAmout(int limitamount) {
        if (limitamount > 20) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_ORDER_AMOUNT);
        }
    }
}
