package christmas.constant.menu;

public enum Message {
    OUTPUT_WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    OUTPUT_RECEIPT_TITLE_PREFIX("12월 "),
    OUTPUT_RECEIPT_TITLE_SUFFIX("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_RECEIPT_ORDER_MENU_TITLE("<주문 메뉴>"),

    INPUT_RESERVATION_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_ORDER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    ERROR_INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_INVALID_ORDER_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
