package creational;

public class Singleton_Basic {
    private static Singleton_Basic singletonInstance = null;

    // private 생성자: 외부에서의 인스턴스 생성 제한
    private Singleton_Basic() {}

    // getInstance 메서드를 통해 생성된 인스턴스 반환, 인스턴스가 없을 경우 새로 생성
    public static Singleton_Basic getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Singleton_Basic();
        }
        return singletonInstance;
    }

    public void singletonTest() {
        System.out.println("Singleton Test");
    }

    public static void main(String[] args) {
        // SingletonPattern 인스턴스 생성 및 사용
        Singleton_Basic instance1 = Singleton_Basic.getInstance();
        Singleton_Basic instance2 = Singleton_Basic.getInstance();

        instance1.singletonTest();
        instance2.singletonTest();

        // instance1과 instance2가 같은지 확인
        System.out.println(instance1 == instance2); // true 출력
    }
}
