package christmas.model;

import christmas.constant.StoreConstant;
import christmas.constant.menu.WootechcoMenu;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private int reservationDate;
    private Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();

    private int orderTotalPrice;
    private int ddayDiscount;
    private int weekDayDiscount;
    private int weekEndDiscount;
    private int specialDiscount;
    private int totalDiscount;

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

    public int getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public int getDdayDiscount() {
        return ddayDiscount;
    }

    public int getWeekDayDiscount() {
        return weekDayDiscount;
    }

    public int getWeekEndDiscount() {
        return weekEndDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public void setDdayDiscount(int ddayDiscount) {
        this.ddayDiscount = ddayDiscount;
    }

    public void setWeekDayDiscount(int weekDayDiscount) {
        this.weekDayDiscount = weekDayDiscount;
    }

    public void setWeekEndDiscount(int weekEndDiscount) {
        this.weekEndDiscount = weekEndDiscount;
    }

    public void setSpecialDiscount(int specialDiscount) {
        this.specialDiscount = specialDiscount;
    }

    public void setTotalDiscount(int totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public void setOrderTotalPrice(int orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public boolean isNotZeroDdayDiscount() {
        return ddayDiscount > 0;
    }

    public boolean isNotZeroWeekDayDiscount() {
        return weekDayDiscount > 0;
    }

    public boolean isNotZeroWeekEndDiscount() {
        return weekEndDiscount > 0;
    }

    public boolean isNotZeroSpecialDiscount() {
        return specialDiscount > 0;
    }

    public boolean isPresentOffer() {
        return orderTotalPrice >= StoreConstant.PRESENT_PAYMENT;
    }

    public boolean isEmptyEventDetail() {
        return !isNotZeroDdayDiscount() && !isNotZeroWeekDayDiscount()
                && !isNotZeroWeekEndDiscount() && !isNotZeroSpecialDiscount()
                && !isPresentOffer();
    }

    public boolean isApplyDiscount() {
        return orderTotalPrice >= StoreConstant.DISCOUNT_MIN_PRICE;
    }

    public int getPaymentResult() {
        return orderTotalPrice - totalDiscount;
    }

    public int getEventTotalDiscount() {
        int eventTotalDiscount = totalDiscount;
        if (isPresentOffer()) {
            eventTotalDiscount += WootechcoMenu.CHAMPAGNE.getPrice();
        }
        return eventTotalDiscount;
    }
}
