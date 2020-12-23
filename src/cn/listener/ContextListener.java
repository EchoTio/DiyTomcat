package cn.listener;

public class ContextListener implements Listener{

    @Override
    public void destroyed(Event event) {
        System.out.println("监听到在源" + event.getSource() + "上的销毁事件");
    }

    @Override
    public void initialized(Event event){
        System.out.println("监听到在源" +event.getSource()+"上的初始化事件");
    }
}
