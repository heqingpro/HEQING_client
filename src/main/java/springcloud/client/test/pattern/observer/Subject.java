package springcloud.client.test.pattern.observer;


/**主题接口，所有的主题必须实现此接口
 * @program: HEQING_client
 * @description: observe
 * @author: hezy
 * @create: 2019-03-18 09:46
 **/
public interface Subject {
    /**
     * 注册一个观察者
     * @param observer
     */
    public void registerObserver(Observer observer);

    /**
     * 移除一个观察者
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    public void notifyObservers();
}
