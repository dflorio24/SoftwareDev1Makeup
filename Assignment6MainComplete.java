package base;

public class Main {

    public static void main(String[] args) {
        Plant arthur = new Plant("Hydrangea", "Arthur");
        Plant agnes = new Plant("Dandelion", "Agnes");
        
        // run code for Arthur

        arthur.setWateringInstructions("Arthur needs watering every day, sometimes twice a day ni hot dry conditions.");
        arthur.getWateringInstructions();

        arthur.setSunlightRequirements("Arthur does well in a well lit place.");
        arthur.getSunlightRequirements();
        
        // run code for Agnes

        agnes.setWateringInstructions("Agnes needs no care at all.");
        agnes.getWateringInstructions();

        agnes.setSunlightInstructions("Agnes is a sun lover.");
        agnes.getSunlightInstructions();

    }
}