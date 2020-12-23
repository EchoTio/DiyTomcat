package cn.listener;

public class TestListener {
    public static void main(String[] args) {
        Context context = new Context();
        ContextListener listener = new ContextListener();
        context.addListener(listener);

        context.init();

        context.destroy();

    }
}
