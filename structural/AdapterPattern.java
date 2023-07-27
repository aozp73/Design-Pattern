package structural;

interface Target {
    public void request();
}

class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee's specific request!");
    }
}

class Adapter implements Target {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request(); 
    }
}