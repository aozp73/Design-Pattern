package creational;

public class SingletonBasic {
    private static SingletonBasic singletonInstance = null;

    // private 생성자: 외부에서의 인스턴스 생성 제한
    private SingletonBasic() {}

    // getInstance 메서드를 통해 생성된 인스턴스 반환, 인스턴스가 없을 경우 새로 생성
    public static SingletonBasic getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new SingletonBasic();
        }
        return singletonInstance;
    }

    public void singletonTest() {
        System.out.println("Singleton Test");
    }

    public static void main(String[] args) {
        // SingletonPattern 인스턴스 생성 및 사용
        SingletonBasic instance1 = SingletonBasic.getInstance();
        SingletonBasic instance2 = SingletonBasic.getInstance();

        instance1.singletonTest();
        instance2.singletonTest();

        // instance1과 instance2가 같은지 확인
        System.out.println(instance1 == instance2); // true 출력
    }
}
