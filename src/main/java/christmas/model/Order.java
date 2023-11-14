package christmas.model;

import christmas.constant.menu.WootechcoMenu;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private int reservationDate;
    private Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();

    public Order() {
    }

    public int getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(int reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Map<WootechcoMenu, Integer> getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(Map<WootechcoMenu, Integer> orderMenu) {
        this.orderMenu = orderMenu;
    }
}
