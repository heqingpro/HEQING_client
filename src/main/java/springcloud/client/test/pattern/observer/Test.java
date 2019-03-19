package springcloud.client.test.pattern.observer;

/**
 * @program: HEQING_client
 * @description:
 * @author: hezy
 * @create: 2019-03-18 10:14
 **/
public class Test {
    public static void main(String[] args){
        //模拟一个3D的服务号
        ObjectFor3D subjectFor3D = new ObjectFor3D();
        //客户1
        Observer observer1 = new Observer1(subjectFor3D);
        Observer observer2 = new Oserver2(subjectFor3D);

        subjectFor3D.setMsg("20140420的3D号码是：127");
        subjectFor3D.setMsg("20140421的3D号码是：333");
    }
}
