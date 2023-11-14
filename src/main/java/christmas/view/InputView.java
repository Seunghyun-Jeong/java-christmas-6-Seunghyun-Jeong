package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.menu.Message;
import christmas.constant.menu.WootechcoMenu;
import christmas.exception.WootechcoIllegalArgumentException;
import christmas.util.ReservationValidator;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    public static int inputReservationDate() {
        System.out.println(Message.INPUT_RESERVATION_DATE);
        try {
            int reservationDate = Integer.parseInt(Console.readLine());
            ReservationValidator.validateReservationDate(reservationDate);
            return reservationDate;
        } catch (NumberFormatException e) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_DATE);
        }
    }

    public static Map<WootechcoMenu, Integer> inputOrderMenu() {
        Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();
        System.out.println(Message.INPUT_ORDER_MENU);
        try {
            String[] orderInput = Console.readLine().split(",");
            for (String orderString : orderInput) {
                String[] orderResult = orderString.split("-");
                WootechcoMenu menu = WootechcoMenu.ofMenuName(orderResult[0]);
                int amount = Integer.parseInt(orderResult[1]);
                ReservationValidator.validateSingleMenuInput(orderMenu, menu, amount);
                orderMenu.put(menu, amount);
            }
            ReservationValidator.validateOrderMenu(orderMenu);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_ORDER_MENU);
        }
        return orderMenu;
    }
}
