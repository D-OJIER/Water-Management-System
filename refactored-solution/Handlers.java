public class Handlers{

    int baseWater = 0, corpRatio =0, boreRatio =0, totalGuests =0;

    public void handleAllotWater(String[] parts){
        int apartmentType = Integer.parseInt(parts[1]);
        baseWater = Logic.calculateBaseWater(apartmentType);
        String [] ratioParts = parts[2].split(":");
        corpRatio = Integer.parseInt(ratioParts[0]);
        boreRatio = Integer.parseInt(ratioParts[1]);
    }

    public void addGuests(int guests){
        totalGuests +=guests;
    }

    public void generateBill() {
        int guestWater = 0;
        if(totalGuests!=0){
            guestWater = Logic.calculateGuestWater(totalGuests);
        }
        int[] split = Logic.splitWater(baseWater, corpRatio, boreRatio);
        int tankerWater = guestWater;
        int totalWater = baseWater + guestWater;
        int totalCost = Logic.calculateTotalCost(split[0], split[1], tankerWater);
        System.out.println(totalWater+ " "+ totalCost);
    }
}