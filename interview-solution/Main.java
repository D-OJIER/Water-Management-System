inside interview-solution what do i need all i have is a single java file 
import java.util.*;
public class Main {
    private static int corp_Ratio, borewell_Ratio,total_Guests=0,apt_Type,total_Amount=0, total_Litres=0;
    public static void callFn(String[] operation){                              //Storing the data
        if(operation[0].equals("ALLOT_WATER")){
            allocate_Ratio(operation[1],operation[2]);
        }
        else if (operation[0].equals("ADD_GUESTS")){
            total_Guests+=toInt(operation[1]);
        }
        else if (operation[0].equals("BILL")){
            generate_Bill();
            return;
        }
    }

    public static int toInt(String str){                                         //To convert String to int
        int num=0;
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(i<str.length()){
            char c = str.charAt(i);
            num=(num*10)+(c-'0');
            i++;
        }
        return num;
    }

    public static void generate_Bill(){
        int tanker_Price=0,borewell_Price=0,corp_Price=0,borewell,corp,tanker_L=0;
        int ratio = borewell_Ratio+corp_Ratio;
        if(apt_Type==2){                                                        //Finding the apartment type and its value per ratio unit
            int part=900/ratio;
            borewell = part*borewell_Ratio;
            corp = part*corp_Ratio;
        }
        else if(apt_Type==3){
            int part=1500/ratio;
            borewell = part*borewell_Ratio;
            corp = part*corp_Ratio;
        }
        else {
            System.out.println("Invalid apartment type");
            return;
        }
        borewell_Price=(int)(borewell*1.5);                                     //Calculating the corporation and borewell prices
        corp_Price=corp*1;
        if(total_Guests!=0){
            tanker_L = total_Guests*10*30;
            int temp_L = tanker_L;
            if(temp_L>3000){                                                        //Calculating tanker amount
                tanker_Price+=(temp_L-3000)*8;
                System.out.println("3k+");
                temp_L=3000;
            }
            if(temp_L<=3000){
                tanker_Price+=(temp_L-1500)*5;
                System.out.println("3k");
                temp_L=1500;
            }
            if(temp_L<=1500 ){
                tanker_Price+=(temp_L-500)*3;
                temp_L=500;
                System.out.println("1.5");
            }
            if(temp_L<=500){
                tanker_Price+=temp_L*2;
                System.out.println("5");
            }
        }
        total_Amount = tanker_Price + borewell_Price + corp_Price;
        total_Litres = tanker_L + borewell + corp;
        System.out.println("\nOUTPUT"+"\n"+ total_Litres+" "+total_Amount);
    }

    public static void allocate_Ratio(String op1, String op2){
        apt_Type = toInt(op1);
        String[] ratio = op2.split(":");                                  //Allocating ratios
        corp_Ratio=toInt(ratio[0]);
        borewell_Ratio=toInt(ratio[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){                                                    //Receiving input
            String sentence = sc.nextLine();
            String[] content = sentence.split(" ");
            for(String word : content){
                word=word.strip();
            }
            callFn(content);
        }
        return;
    }
}