package springcloud.client.test.pattern.singleton;

/**
 * @program: HEQING_client
 * @description: singleton
 * @author: hezy
 * @create: 2019-03-20 09:43
 **/
public enum Singleton {
    INSTANCE;

    private SingletonClass instance;

    Singleton(){
        this.instance = new SingletonClass();
        System.out.println("枚举类构造函数");
    }

    public SingletonClass getInstance() {
         return this.instance;
    }
}

class SingletonClass{
    int i = 0;

    public SingletonClass(){
        System.out.println("SingletonClass被初始化"+ ++i+"次");
    }
}

class SingletonTest{
    public static void main(String[] args){
        SingletonClass instance1 = Singleton.INSTANCE.getInstance();
        SingletonClass instance2 = Singleton.INSTANCE.getInstance();
        System.out.println("singleton1 == singleton2"+(instance1 == instance2));
    }
}