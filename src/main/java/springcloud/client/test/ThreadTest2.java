package springcloud.client.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: HEQING_client
 * @description: 2
 * @author: hezy
 * @create: 2019-03-18 19:11
 **/
public class ThreadTest2 {

    public static void main(String[] args){
        //创建MyCallable对象
        Callable<Integer> myCallable = new MyCallable();
        //使用FutureTask来包装MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i == 30){
                Thread thread = new Thread(ft);

                thread.start();
            }
        }

        System.out.println("主线程for循环执行完毕。。");

        try{
            //取得新创建线程的返回值
            int sum = ft.get();
            System.out.println("sum = "+sum);
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }

}
class MyCallable implements Callable<Integer>{

    @Override
    public Integer call(){
        int sum = 0;
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            sum += i;
        }
        return sum;
    }
}