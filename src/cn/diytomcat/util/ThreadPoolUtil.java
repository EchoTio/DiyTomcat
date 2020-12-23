package cn.diytomcat.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {

    //第一个参数表示初始有20根线程，第二个表示最多有100根线程，
    //第三、四个表示超过60秒未被利用超过20根的线程会被回收，
    //第五个表示当收到大量请求时不会马上申请新线程而是放入队列中，队列超过10个以上会增加线程来处理
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(20,100,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(10));

    public static void run (Runnable r){
        threadPool.execute(r);
    }
}
