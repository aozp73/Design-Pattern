package creational;

public class Singleton_DoubleCheckedLocking {
    private volatile static Singleton_DoubleCheckedLocking uniqueInstance;

    private Singleton_DoubleCheckedLocking() {}

    public static Singleton_DoubleCheckedLocking getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton_DoubleCheckedLocking.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton_DoubleCheckedLocking();
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
        Singleton_DoubleCheckedLocking instance1 = Singleton_DoubleCheckedLocking.getInstance();
        Singleton_DoubleCheckedLocking instance2 = Singleton_DoubleCheckedLocking.getInstance();

        instance1.singletonTest();
        instance2.singletonTest();

        // instance1과 instance2가 같은지 확인
        System.out.println(instance1 == instance2); // true 출력
    }
}
