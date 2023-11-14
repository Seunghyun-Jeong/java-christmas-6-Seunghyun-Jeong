package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.menu.Message;
import christmas.exception.WootechcoIllegalArgumentException;
import christmas.util.ReservationValidator;

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
}
