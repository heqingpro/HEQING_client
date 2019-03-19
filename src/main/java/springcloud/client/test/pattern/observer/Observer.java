package springcloud.client.test.pattern.observer;

/**
 * 所有的观察者需要实现此接口
 * @program: HEQING_client
 * @description: Observer
 * @author: hezy
 * @create: 2019-03-18 09:52
 **/
public interface Observer {

    public void update(String msg);
}
