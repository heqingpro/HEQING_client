package springcloud.client.test.pattern.observer;

/**
 * @program: HEQING_client
 * @description:
 * @author: hezy
 * @create: 2019-03-18 10:07
 **/
public class Oserver2 implements Observer{
    private Subject subject;

    public Oserver2(Subject subject){
        this.subject =subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg){
        System.out.println("observer2 得到 3D 号码 -->"+msg+"我要告诉舍友们。");
    }
}
