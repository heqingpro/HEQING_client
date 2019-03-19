package springcloud.client.test.pattern.observer;

import java.util.Observable;

/**
 * @program: HEQING_client
 * @description: 双色球服务号
 * @author: hezy
 * @create: 2019-03-18 11:01
 **/
public class SubjectForSSQ extends Observable {

    private String msg;

    public String getMsg(){
        return msg;
    }

    /**
     * 主题更新消息
     * @param msg
     */
    public void  setMsg(String msg){
        this.msg = msg;
        setChanged();
        notifyObservers();
    }
}
