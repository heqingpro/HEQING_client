package springcloud.client.test.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟一个微信3D服务号
 * @program: HEQING_client
 * @description:
 * @author: hezy
 * @create: 2019-03-18 09:54
 **/
public class ObjectFor3D implements Subject {

    public List<Observer> observers = new ArrayList<Observer>();
    /**
     * 3D彩票的号码
     */
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers(); 
    }

    @Override
    public void registerObserver(Observer observer){
        observers.add(observer);

    }
    @Override
    public void removeObserver(Observer observer){
        int index = observers.indexOf(observer);
        if(index>=0){
            observers.remove(index);
        }
    }
    @Override
    public void notifyObservers() {
        for(Observer observer:observers){
            observer.update(msg);
        }
    }

}
