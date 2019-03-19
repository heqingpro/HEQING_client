package springcloud.client.test.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: HEQING_client
 * @description: 观察者1
 * @author: hezy
 * @create: 2019-03-18 11:06
 **/
public class SSQObserver1 implements Observer{

    public void registerSubject(Observable observable){
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o,Object arg){
        if(o instanceof SubjectForSSQ){
            SubjectForSSQ subjectForSSQ = (SubjectForSSQ) o;
            System.out.println("subjectForSSQ's msg -->"+subjectForSSQ.getMsg());
        }
    }
}
