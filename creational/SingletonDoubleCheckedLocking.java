package creational;

public class SingletonDoubleCheckedLocking {
    private volatile static SingletonDoubleCheckedLocking uniqueInstance;

    private SingletonDoubleCheckedLocking() {}

    public static SingletonDoubleCheckedLocking getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonDoubleCheckedLocking.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonDoubleCheckedLocking();
                }
            }
        }
        return uniqueInstance;
    }

    public void singletonTest() {
        System.out.println("Singleton Test");
    }

    public static void main(String[] args) {
        // SingletonPattern 인스턴스 생성 및 사용
        SingletonDoubleCheckedLocking instance1 = SingletonDoubleCheckedLocking.getInstance();
        SingletonDoubleCheckedLocking instance2 = SingletonDoubleCheckedLocking.getInstance();

        instance1.singletonTest();
        instance2.singletonTest();

        // instance1과 instance2가 같은지 확인
        System.out.println(instance1 == instance2); // true 출력
    }
}
