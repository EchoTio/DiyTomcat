package cn.listener;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private List<Listener> listeners = new ArrayList<Listener>();

    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void removeListener(Listener listener){
        listeners.remove(listener);
    }

    public Context(){

    }

    public void init(){
        System.out.println(this+"init()");
        fireEvent("init");
    }

    public void destroy(){
        System.out.println(this + "destroy()");
    }

    private void fireEvent(String type){
        Event event = new Event(this);
        for (Listener listener : listeners) {
            if ("init".equals(type))
                listener.initialized(event);
            if ("destroyed".equals(type))
                listener.destroyed(event);
        }
    }
}
