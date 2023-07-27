package structural;

// 오래된 시스템
class LegacySystem {
    public String getInformation() {
        return "Legacy Information";
    }
}

// 새로운 시스템
class NewSystem {
    public void displayInformation(String info) {
        System.out.println("Information: " + info);
    }
}

class LegacyAdapter {
    private LegacySystem legacySystem;

    public LegacyAdapter(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    public String getAdaptedInformation() {
        String info = legacySystem.getInformation();
        return "Adapted " + info;
    }
}


public class AdapterPatternEx01 {
    public static void main(String[] args) {
        LegacySystem legacySystem = new LegacySystem();
        LegacyAdapter adapter = new LegacyAdapter(legacySystem);

        NewSystem newSystem = new NewSystem();
        newSystem.displayInformation(adapter.getAdaptedInformation());

    }
}

