package springcloud.client.test.pattern.observer;

/**
 * @program: HEQING_client
 * @description: SSQ
 * @author: hezy
 * @create: 2019-03-18 11:10
 **/
public class SSQTest {

    public static void main(String[] args){
        SubjectForSSQ subjectForSSQ = new SubjectForSSQ();
        SSQObserver1 observer1 = new SSQObserver1();
        observer1.registerSubject(subjectForSSQ);
        subjectForSSQ.setMsg("SSQ'num : 12,13,31,5,4,3 15");
    }
}
