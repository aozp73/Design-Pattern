package creational;

public class Singleton_InitializationOnDemandHolderIdiom {
    private Singleton_InitializationOnDemandHolderIdiom() {}

    private static class Holder {
        private static final Singleton_InitializationOnDemandHolderIdiom INSTANCE = new Singleton_InitializationOnDemandHolderIdiom();
    }

    public static Singleton_InitializationOnDemandHolderIdiom getInstance() {
        return Holder.INSTANCE;
    }

    public void singletonTest() {
        System.out.println("Singleton Test");
    }

    public static void main(String[] args) {
        // SingletonPattern 인스턴스 생성 및 사용
        Singleton_InitializationOnDemandHolderIdiom instance1 = Singleton_InitializationOnDemandHolderIdiom.getInstance();
        Singleton_InitializationOnDemandHolderIdiom instance2 = Singleton_InitializationOnDemandHolderIdiom.getInstance();

        instance1.singletonTest();
        instance2.singletonTest();

        // instance1과 instance2가 같은지 확인
        System.out.println(instance1 == instance2); // true 출력
    }
}

