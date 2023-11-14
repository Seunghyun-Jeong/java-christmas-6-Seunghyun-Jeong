package christmas.model;

import static christmas.constant.menu.MenuType.DESSERT;
import static christmas.constant.menu.MenuType.MAIN;

import christmas.constant.StoreConstant;
import christmas.constant.menu.WootechcoMenu;
import christmas.util.DateUtil;
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

    public int getOrderTotalPrice() {
        return orderMenu.entrySet().stream().mapToInt(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }

    public int getDdayDiscount() {
        int ddayDiscount = 0;
        if (this.reservationDate <= 25) {
            ddayDiscount = 1000;
            for (int i = 1; i < this.reservationDate; i++) {
                ddayDiscount += 100;
            }
        }
        return ddayDiscount;
    }

    public int getWeekDayDiscount() {
        int weekDayDiscount = StoreConstant.DISCOUNT_PRICE;
        int WeekDayDiscountResult = 0;
        if (DateUtil.isWeekDay(this.reservationDate)) {
            int dessertCount = (int) orderMenu.entrySet().stream().filter(entry -> entry.getKey().getType() == DESSERT)
                    .count();
            WeekDayDiscountResult = dessertCount * weekDayDiscount;
        }
        return WeekDayDiscountResult;
    }

    public int getWeekEndDiscount() {
        int weekEndDiscount = StoreConstant.DISCOUNT_PRICE;
        int WeekEndDiscountResult = 0;
        if (DateUtil.isWeekEnd(this.reservationDate)) {
            int dessertCount = (int) orderMenu.entrySet().stream().filter(entry -> entry.getKey().getType() == MAIN)
                    .count();
            WeekEndDiscountResult = dessertCount * weekEndDiscount;
        }
        return WeekEndDiscountResult;
    }

    public int getSpecialDiscount() {
        int specialDiscount = 0;
        if (DateUtil.isStarDayOrChirstmas(this.reservationDate)) {
            specialDiscount = 1000;
        }
        return specialDiscount;
    }

    public int getTotalDiscount() {
        int ddayDiscount = getDdayDiscount();
        int WeekDayDiscountResult = getWeekDayDiscount();
        int WeekEndDiscountResult = getWeekEndDiscount();
        int specialDiscount = getSpecialDiscount();
        int totalDiscount = (ddayDiscount + WeekDayDiscountResult + WeekEndDiscountResult + specialDiscount);
        if (orderMenu.entrySet().stream().mapToInt(entry -> entry.getKey().getPrice() * entry.getValue()).sum()
                >= StoreConstant.PRESENT_PAYMENT) {
            totalDiscount += 25000;
        }
        return totalDiscount;
    }
}
