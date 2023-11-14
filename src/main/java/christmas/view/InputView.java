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
        int limitamount = 0;
        System.out.println(Message.INPUT_ORDER_MENU);
        try {
            String[] orderInput = Console.readLine().split(",");
            for (String orderString : orderInput) {
                String[] orderResult = orderString.split("-");
                String menuString = orderResult[0];
                WootechcoMenu menu = WootechcoMenu.ofMenuName(menuString);
                int amount = Integer.parseInt(orderResult[1]);
                ReservationValidator.validateMenuInput(menu, amount);
                ReservationValidator.validateDuplicatedOrderMenu(orderMenu, menu);
                orderMenu.put(menu, amount);
                limitamount = limitamount + amount;
                if (limitamount > 20) {
                    throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_ORDER_AMOUNT);
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new WootechcoIllegalArgumentException(Message.ERROR_INVALID_ORDER_MENU);
        }
        return orderMenu;
    }
}
