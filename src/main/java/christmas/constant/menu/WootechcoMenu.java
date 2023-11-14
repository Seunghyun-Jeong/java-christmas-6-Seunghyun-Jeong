package christmas.constant.menu;

import java.util.Objects;

public enum WootechcoMenu {
    SOUP(MenuType.APPETIZER, 6000, "양송이수프"),
    TAPAS(MenuType.APPETIZER, 5500, "타파스"),
    SALAD(MenuType.APPETIZER, 8000, "시저샐러드"),
    STAEK(MenuType.MAIN, 55000, "티본스테이크"),
    BARBEQUE(MenuType.MAIN, 54000, "바비큐립"),
    SEAFOODPASTA(MenuType.MAIN, 35000, "해산물파스타"),
    CHRISTMASPASTA(MenuType.MAIN, 25000, "크리스마스파스타"),
    CAKE(MenuType.DESSERT, 15000, "초코케이크"),
    ICECREAM(MenuType.DESSERT, 5000, "아이스크림"),
    ZEROCOLA(MenuType.BEVERAGE, 3000, "제로콜라"),
    WINE(MenuType.BEVERAGE, 60000, "레드와인"),
    CHAMPAGNE(MenuType.BEVERAGE, 25000, "샴페인");


    private MenuType type;
    private int price;
    private String menuName;

    WootechcoMenu(MenuType type, int price, String menuName) {
        this.type = type;
        this.price = price;
        this.menuName = menuName;
    }

    public static WootechcoMenu ofMenuName(String menuName) {
        for (WootechcoMenu value : WootechcoMenu.values()) {
            if (Objects.equals(value.menuName, menuName)) {
                return value;
            }
        }
        return null;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }
}
