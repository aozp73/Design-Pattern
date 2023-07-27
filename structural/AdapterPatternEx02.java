package structural;

class ThirdPartyLibrary {
    public void performAction(Object data) {
        System.out.println("Performing action with " + data.toString());
    }
}

class OurData {
    private String data;

    public OurData(String data) {
        this.data = data;
    }

    public String formatData() {
        return "Formatted " + data;
    }
}

class OurDataAdapter {
    private OurData ourData;

    public OurDataAdapter(OurData ourData) {
        this.ourData = ourData;
    }

    public Object getAdaptedData() {
        return ourData.formatData();
    }
}


public class AdapterPatternEx02 {
    public static void main(String[] args) {
        OurData ourData = new OurData("Our Data");
        OurDataAdapter adapter = new OurDataAdapter(ourData);

        ThirdPartyLibrary library = new ThirdPartyLibrary();
        library.performAction(adapter.getAdaptedData());
    }
}
