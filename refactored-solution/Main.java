import java.util.*;

public class Main {
    
    static Handlers handler = new Handlers();
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
    
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            processCommand(line);
        }
    }
    
    public static void processCommand(String input){
        String [] parts = input.split(" ");
        switch (parts[0]){
            case "ALLOT_WATER":
                handler.handleAllotWater(parts);
                break;
            case "ADD_GUESTS":
                handler.addGuests(Integer.parseInt(parts[1]));
                break;
            case "BILL":
                handler.generateBill();
                break;
            default:
                throw new IllegalArgumentException(parts[0] + " is not a valid command. Enter a valid command (ALLOT_WATER, ADD_GUESTS or BILL).");
        }
    }
}