package christmas.constant.menu;

public enum Message {
    OUTPUT_WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    OUTPUT_RECEIPT_TITLE_PREFIX("12월 "),
    OUTPUT_RECEIPT_TITLE_SUFFIX("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_RECEIPT_ORDER_MENU_TITLE("<주문 메뉴>"),
    OUTPUT_RECEIPT_TOTAL_PRICE_TITLE("<할인 전 총주문 금액>"),
    OUTPUT_RECEIPT_PRESENT_TITLE("<증정 메뉴>"),
    OUTPUT_RECEIPT_PRESENT("샴페인 1개"),
    OUTPUT_RECEIPT_EMPTY("없음"),
    OUTPUT_RECEIPT_EVENT_TITLE("<혜택 내역>"),
    OUTPUT_RECEIPT_EVENT_CHRISTMAS("크리스마스 디데이 할인: "),
    OUTPUT_RECEIPT_EVENT_WEEKDAY("평일 할인: "),
    OUTPUT_RECEIPT_EVENT_WEEKEND("주말 할인: "),
    OUTPUT_RECEIPT_EVENT_SPECIAL("특별 할인: "),
    OUTPUT_RECEIPT_EVENT_PRESENT("증정 할인: -25,000원"),
    OUTPUT_RECEIPT_EVENT_TOTAL_TITLE("<총혜택 금액>"),
    OUTPUT_RECEIPT_PAYMENT_TITLE("<할인 후 예상 결제 금액>"),
    OUTPUT_RECEIPT_BADGE_TITLE("<12월 이벤트 배지>"),
    OUTPUT_RECEIPT_BADGE_STAR("별"),
    OUTPUT_RECEIPT_BADGE_TREE("트리"),
    OUTPUT_RECEIPT_BADGE_SANTA("산타"),

    INPUT_RESERVATION_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_ORDER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    WARN_ORDER_MENU("[주의] 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다."),

    ERROR_INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_INVALID_ORDER_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_INVALID_ORDER_AMOUNT("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요."),
    ERROR_INVALID_ORDER_ONLY_BERVARGE("메인 메뉴와 디저트를 추가해서 다시 입력해 주세요.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
