public class Logic{

    static final int WATER_PER_PERSON_PER_DAY = 10;
    static final int DAYS = 30;
    static final double CORP_COST = 1;
    static final double BORE_COST = 1.5;

    public static int calculateBaseWater(int type){
        int people = 0;
        if(type ==2){
            return 900;
        }
        else if(type ==3) {
            return 1500;
        }
        else {
            throw new IllegalArgumentException(type+" invalid type. Enter (type 1 for 3 people, 2 for 5 people.)");
        }
    }

    public static int calculateGuestWater(int guests){
        return guests * WATER_PER_PERSON_PER_DAY * DAYS;
    }

    public static int[] splitWater(int totalWater, int corp, int bore){
        int total = corp + bore;
        int corpWater = (totalWater * corp) / total;
        int boreWater = (totalWater * bore) / total;
        return new int[] {corpWater,boreWater};
    }

    public static int calculateTotalCost(int corpWater, int boreWater, int tankerWater){
        double cost = 0;

        cost += corpWater* CORP_COST;
        cost += boreWater* BORE_COST;
        cost += calculateTankerCost(tankerWater);
        
        return (int) Math.round(cost);
    }

    public static int calculateTankerCost(int water){
        int cost = 0;

        if(water > 3000){
            cost += (water - 3000) * 8;
            water = 3000;
        }
        if(water > 1500){
            cost += (water - 1500) * 5;
            water = 1500;
        }
        if(water > 500){
            cost += (water - 500) * 3;
            water = 500;
        }
        if(water > 0){
            cost += water * 2; 
        }
        return cost;
    }
}