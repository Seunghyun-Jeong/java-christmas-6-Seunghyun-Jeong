package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.menu.WootechcoMenu;
import christmas.model.Order;
import christmas.service.OrderCalculator;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @DisplayName("디데이할인 테스트")
    @Test
    void ddayDiscountTest() {
        int expectedResult = 1000;

        Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();
        orderMenu.put(WootechcoMenu.CHAMPAGNE, 1);

        Order order = new Order();
        order.setReservationDate(1);
        order.setOrderMenu(orderMenu);

        OrderCalculator orderCalculator = new OrderCalculator();
        orderCalculator.calculateOrder(order);

        assertThat(order.getDdayDiscount()).isEqualTo(expectedResult);
    }

    @DisplayName("25일 이후 디데이할인 테스트")
    @Test
    void notDdayDiscountTest() {
        int expectedResult = 0;

        Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();
        orderMenu.put(WootechcoMenu.CHAMPAGNE, 1);

        Order order = new Order();
        order.setReservationDate(26);
        order.setOrderMenu(orderMenu);

        OrderCalculator orderCalculator = new OrderCalculator();
        orderCalculator.calculateOrder(order);

        assertThat(order.getDdayDiscount()).isEqualTo(expectedResult);
    }

    @DisplayName("평일 할인 테스트")
    @Test
    void weekdayDiscountTest() {
        int expectedResult = 4046;

        Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();
        orderMenu.put(WootechcoMenu.STAEK, 1);
        orderMenu.put(WootechcoMenu.BARBEQUE, 1);
        orderMenu.put(WootechcoMenu.CAKE, 2);
        orderMenu.put(WootechcoMenu.ZEROCOLA, 1);

        Order order = new Order();
        order.setReservationDate(3);
        order.setOrderMenu(orderMenu);

        OrderCalculator orderCalculator = new OrderCalculator();
        orderCalculator.calculateOrder(order);

        assertThat(order.getWeekDayDiscount()).isEqualTo(expectedResult);
    }

    @DisplayName("주말 할인 테스트")
    @Test
    void weekEndDiscountTest() {
        int expectedResult = 4046;

        Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();
        orderMenu.put(WootechcoMenu.SEAFOODPASTA, 2);
        orderMenu.put(WootechcoMenu.WINE, 1);
        orderMenu.put(WootechcoMenu.CAKE, 1);

        Order order = new Order();
        order.setReservationDate(1);
        order.setOrderMenu(orderMenu);

        OrderCalculator orderCalculator = new OrderCalculator();
        orderCalculator.calculateOrder(order);

        assertThat(order.getWeekEndDiscount()).isEqualTo(expectedResult);
    }

    @DisplayName("특별 할인 테스트")
    @Test
    void specialDiscountTest() {
        int expectedResult = 1000;

        Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();
        orderMenu.put(WootechcoMenu.SEAFOODPASTA, 2);
        orderMenu.put(WootechcoMenu.WINE, 1);
        orderMenu.put(WootechcoMenu.CAKE, 1);

        Order order = new Order();
        order.setReservationDate(25);
        order.setOrderMenu(orderMenu);

        OrderCalculator orderCalculator = new OrderCalculator();
        orderCalculator.calculateOrder(order);

        assertThat(order.getSpecialDiscount()).isEqualTo(expectedResult);
    }

    @DisplayName("총혜택 금액 테스트")
    @Test
    void totalDiscountTest() {
        int expectedResult = 31246;

        Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();
        orderMenu.put(WootechcoMenu.STAEK, 1);
        orderMenu.put(WootechcoMenu.BARBEQUE, 1);
        orderMenu.put(WootechcoMenu.CAKE, 2);
        orderMenu.put(WootechcoMenu.ZEROCOLA, 1);

        Order order = new Order();
        order.setReservationDate(3);
        order.setOrderMenu(orderMenu);

        OrderCalculator orderCalculator = new OrderCalculator();
        orderCalculator.calculateOrder(order);

        assertThat(order.getEventTotalDiscount()).isEqualTo(expectedResult);
    }

    @DisplayName("만원 이하 총혜택 금액 테스트")
    @Test
    void LowEventPriceTest() {
        int expectedResult = 0;

        Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();
        orderMenu.put(WootechcoMenu.ICECREAM, 1);

        Order order = new Order();
        order.setReservationDate(3);
        order.setOrderMenu(orderMenu);

        OrderCalculator orderCalculator = new OrderCalculator();
        orderCalculator.calculateOrder(order);

        assertThat(order.getEventTotalDiscount()).isEqualTo(expectedResult);
    }

    @DisplayName("할인 후 예상 결제 금액 테스트")
    @Test
    void paymentResultTest() {
        int expectedResult = 135754;

        Map<WootechcoMenu, Integer> orderMenu = new HashMap<>();
        orderMenu.put(WootechcoMenu.STAEK, 1);
        orderMenu.put(WootechcoMenu.BARBEQUE, 1);
        orderMenu.put(WootechcoMenu.CAKE, 2);
        orderMenu.put(WootechcoMenu.ZEROCOLA, 1);

        Order order = new Order();
        order.setReservationDate(3);
        order.setOrderMenu(orderMenu);

        OrderCalculator orderCalculator = new OrderCalculator();
        orderCalculator.calculateOrder(order);

        assertThat(order.getPaymentResult()).isEqualTo(expectedResult);
    }

}
