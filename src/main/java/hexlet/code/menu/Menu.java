package hexlet.code.menu;

import java.util.LinkedHashMap;

public final class Menu {
    private final LinkedHashMap<Integer, MenuItem> menuItemsMap = new LinkedHashMap<>();

    public void addMenuItem(Integer key, String name, Runnable handler) {
        menuItemsMap.put(key, new MenuItem(name, handler));
    }

    public void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        for (var menuItem : menuItemsMap.entrySet()) {
            System.out.println((menuItem.getKey()) + " - " + menuItem.getValue().getNameOfMenuItem());
        }
    }

    public int getMenuItemSize() {
        return menuItemsMap.size();
    }

    public void runSelectedMenuItemHandle(int menuKey) {
        menuItemsMap.get(menuKey).getHandler().run();
    }

    public boolean hasMenuItem(int menuKey) {
        return menuKey >= 0 && menuKey <= menuItemsMap.size();
    }
}
