package springcloud.client.test;

/**
 * @program: HEQING_client
 * @description: test
 * @author: hezy
 * @create: 2019-03-15 16:16
 **/
public class ThreadTest1 {

    public static void main(String[] args){
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i == 30){
/*                Thread thread1 = new MyThread();
                Thread thread2 = new MyThread();*/
                Runnable runnable = new MyRunnable();
                Thread thread1 = new Thread(runnable);
                Thread thread2 = new Thread(runnable);
                thread1.start();
                thread2.start();
            }

        }
    }
}
class MyThread extends Thread{
    private int i=1;

    @Override
    public void run(){
        for (i= 0; i<100; i++){
            System.out.println(Thread.currentThread().getName() + " "+i);
        }
    }
}
class MyRunnable implements Runnable{
    private int i = 1;
    @Override
    public void run(){
        for (i=0;i<100;i++ ){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}