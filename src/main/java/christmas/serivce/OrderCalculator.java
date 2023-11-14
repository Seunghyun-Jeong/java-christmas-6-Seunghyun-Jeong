package christmas.serivce;

import static christmas.constant.menu.MenuType.DESSERT;
import static christmas.constant.menu.MenuType.MAIN;

import christmas.constant.StoreConstant;
import christmas.model.Order;
import christmas.util.DateUtil;

public class OrderCalculator {

    public void calculateOrder(Order order) {
        calculateOrderTotalPrice(order);
        if (order.getOrderTotalPrice() > StoreConstant.DISCOUNT_MIN_PRICE) {
            calculateDdayDiscount(order);
            calculateWeekDayDiscount(order);
            calculateWeekEndDiscount(order);
            calculateSpecialDiscount(order);
            calculateTotalDiscount(order);
        }
    }

    private void calculateOrderTotalPrice(Order order) {
        order.setOrderTotalPrice(
                order.getOrderMenu().entrySet().stream().mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                        .sum());
    }

    private void calculateDdayDiscount(Order order) {
        int ddayDiscount = 0;
        if (DateUtil.isBeforeDayChristmas(order.getReservationDate())) {
            ddayDiscount = StoreConstant.DISCOUNT_DDAY_BASE_PRICE;
            for (int i = 1; i < order.getReservationDate(); i++) {
                ddayDiscount += StoreConstant.DISCOUNT_DDAY_ADD_PRICE;
            }
        }
        order.setDdayDiscount(ddayDiscount);
    }

    private void calculateWeekDayDiscount(Order order) {
        if (DateUtil.isWeekDay(order.getReservationDate())) {
            int dessertCount = order.getOrderMenu().entrySet().stream()
                    .filter(entry -> entry.getKey().getType() == DESSERT).mapToInt(entry -> entry.getValue()).sum();
            order.setWeekDayDiscount(dessertCount * StoreConstant.DISCOUNT_PRICE);
        }
    }

    private void calculateWeekEndDiscount(Order order) {
        if (DateUtil.isWeekEnd(order.getReservationDate())) {
            int mainCount = order.getOrderMenu().entrySet().stream().filter(entry -> entry.getKey().getType() == MAIN)
                    .mapToInt(entry -> entry.getValue()).sum();
            order.setWeekEndDiscount(mainCount * StoreConstant.DISCOUNT_PRICE);
        }
    }

    private void calculateSpecialDiscount(Order order) {
        if (DateUtil.isStarDayOrChristmas((order.getReservationDate()))) {
            order.setSpecialDiscount(StoreConstant.DISCOUNT_SPECIAL_PRICE);
        }
    }

    private void calculateTotalDiscount(Order order) {
        int totalDiscount = (order.getDdayDiscount() + order.getWeekDayDiscount() + order.getWeekEndDiscount()
                + order.getSpecialDiscount());
        order.setTotalDiscount(totalDiscount);
    }

}
