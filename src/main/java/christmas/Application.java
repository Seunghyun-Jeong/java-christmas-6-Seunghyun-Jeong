package christmas;

import christmas.controller.WootechcoStore;

public class Application {
    public static void main(String[] args) {
        WootechcoStore wootechcoStore = new WootechcoStore();
        wootechcoStore.reserve();
    }
}
