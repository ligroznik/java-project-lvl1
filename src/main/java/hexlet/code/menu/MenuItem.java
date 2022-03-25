package hexlet.code.menu;

final class MenuItem {
    private final String name;
    private final Runnable handler;

    MenuItem(String inputName, Runnable inputHandler) {
        name = inputName;
        handler = inputHandler;
    }

    public String getNameOfMenuItem() {
        return name;
    }

    public Runnable getHandler() {
        return handler;
    }
}
