package structural;

interface Component {
    String operation();
}

class ConcreteComponent implements Component {
    private String message;

    public ConcreteComponent(String message) {
        this.message = message;
    }

    @Override
    public String operation() {
        return message;
    }
}

abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        return component.operation();
    }
}

class StarDecorator extends Decorator {
    public StarDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        return "*" + super.operation() + "*";
    }
}

class UpperCaseDecorator extends Decorator {
    public UpperCaseDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        return super.operation().toUpperCase();
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        String message = "hello, world!";
        Component component = new ConcreteComponent(message);
        Component starDecorator = new StarDecorator(component);
        Component upperCaseDecorator = new UpperCaseDecorator(starDecorator);

        System.out.println(component.operation());
        System.out.println(starDecorator.operation());
        System.out.println(upperCaseDecorator.operation());
    }
}
