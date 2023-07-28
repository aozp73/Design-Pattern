package behavioral;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + "를 신용카드로 결제했습니다.");
    }
}

class PaypalStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + "를 페이팔로 결제했습니다.");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(int amount){
        paymentStrategy.pay(amount);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
}

public class StrategyPatternEx01 {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardStrategy());
        context.pay(100); // 100를 신용카드로 결제했습니다.

        context.setPaymentStrategy(new PaypalStrategy());
        context.pay(200); // 200를 페이팔로 결제했습니다.
    }
}

