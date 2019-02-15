import java.io.*;
import java.util.Scanner;

public class Bag {
    private int smallpotion ;
    private int midpotion ;
    private int bigpotion ;

    public Bag(){
        smallpotion = 5;
        midpotion = 5;
        bigpotion = 5;
    }

    public int getSmallpotion(){
        return smallpotion;
    }

    public int getMidpotion(){
        return midpotion;
    }

    public int getBigpotion(){
        return bigpotion;
    }

    public void showListitem(Novice novice){
        Scanner scanner = new Scanner(System.in);
        int select;
        System.out.println("####LIST ITEMS####");
        System.out.println("Small Potion    :"+getSmallpotion());
        System.out.println("Mid Potion      :"+getMidpotion());
        System.out.println("Big Potion      :"+getBigpotion());
        System.out.println("Press [1] to use your item.");
        select = scanner.nextInt();
        if (select == 1){
            useItem(novice);
        }
    }

    public void useItem(Novice novice){
        Scanner scanner = new Scanner(System.in);

        int select;
        System.out.println("####USE ITEMS####");
        System.out.println("[1] Use Small Potion    HP+10");
        System.out.println("[2] Use Mid Potion      HP+50");
        System.out.println("[3] Use Big Potion      HP+100");
        System.out.println("Select Items to use");
        select = scanner.nextInt();
        if (select == 1 && getSmallpotion() >= 1){
            smallpotion = smallpotion - 1 ;
            novice.useSmallpotion();
            System.out.println("Use Small Potion");
            return;
        }
        if (select == 2 && getMidpotion() >= 1){
            midpotion = midpotion - 1 ;
            novice.useMidpotion();
            System.out.println("Use Mid Potion");
            return;
        }
        if (select == 3 && getBigpotion() >= 1){
            bigpotion = bigpotion - 1 ;
            novice.useBigpotion();
            System.out.println("Use Big Potion");
            return;
        }
        else {
            System.out.println("You don't have item");
        }
    }
}
