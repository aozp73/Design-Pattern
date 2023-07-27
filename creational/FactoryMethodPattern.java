package creational;

interface Product {
    void use();
}

class ConcreteProductA implements Product {
    public void use() {
        System.out.println("Using product A");
    }
}

class ConcreteProductB implements Product {
    public void use() {
        System.out.println("Using product B");
    }
}

abstract class Creator {
    public void anOperation() {
        Product product = factoryMethod();
        product.use();
    }
    
    protected abstract Product factoryMethod();
}

class ConcreteCreatorA extends Creator {
    protected Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    protected Product factoryMethod() {
        return new ConcreteProductB();
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Creator creatorB = new ConcreteCreatorB();

        creatorA.anOperation();
        creatorB.anOperation();
    }
}