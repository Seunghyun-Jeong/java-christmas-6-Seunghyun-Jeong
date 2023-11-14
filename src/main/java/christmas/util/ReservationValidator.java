package christmas.util;

import static christmas.constant.menu.MenuType.BEVERAGE;

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

    public static void validateSingleMenuInput(Map<WootechcoMenu, Integer> orderMenu, WootechcoMenu menu, int amount) {
        if (menu == null || amount == 0 || orderMenu.containsKey(menu)) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_ORDER_MENU);
        }
    }

    public static void validateOrderMenu(Map<WootechcoMenu, Integer> orderMenu) {
        if (orderMenu.values().stream().mapToInt(value -> value).sum() > 20) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_ORDER_AMOUNT);
        }
        if (orderMenu.entrySet().stream().noneMatch(entry -> entry.getKey().getType() != BEVERAGE)) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_ORDER_ONLY_BERVARGE);
        }
    }

}
