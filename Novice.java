import java.io.*;
import java.util.Scanner;

public class Novice {

    private String characterName;
    private int characterHp;
    private int charecterExp;
    private int characterMoney;
    private int characterLevel;

    public Novice(){
        characterHp = 100;
        charecterExp = 0;
        characterMoney = 0;
        characterLevel = 1;
    }
    public void createCharacter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("####CREATE YOUR CHARACTER####");
        System.out.print("Enter character name : ");
        characterName =  scanner.nextLine();
    }

    public void useSmallpotion(){
        characterHp = characterHp+10;
        System.out.println("Change HP");
    }

    public  void useMidpotion(){
        characterHp = characterHp+50;
    }

    public void useBigpotion(){
        characterHp = characterHp+100;
    }

    public String getCharecterName(){
        return characterName;
    }

    public int getCharacterHp(){
        return characterHp;
    }

    public int getCharecterExp(){
        return charecterExp;
    }

    public  int getCharacterMoney(){
        return characterMoney;
    }

    public int getCharacterLevel(){
        return characterLevel;
    }



    public void showStatus(){
        System.out.println("####YOUR STATUS####");
        System.out.println("Character name : "+getCharecterName());
        System.out.println("Level : "+getCharacterLevel());
        System.out.println("EXP : "+getCharecterExp());
        System.out.println("HP : "+getCharacterHp());
        System.out.println("Money : "+getCharacterMoney());
    }

    public boolean playGame(Bag bag,Novice novice){
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("Press num 1-3 to select action");
        System.out.println("[1] Show character Status");
        System.out.println("[2] Attack Monster LV.1");
        System.out.println("[3] Attack Monster LV.2");
        System.out.println("[4] Attack Monster LV.3");
        System.out.println("[5] Open my bag");
        System.out.println("0.EXIT");
        switch (scan.nextInt()){
            case 1: showStatus();
                break;
            case 2: setStatus(10-characterLevel,10,0);
                System.out.println("Attack Success!");
                break;
            case 3: if(characterLevel - 4 <= 0){
                setStatus(0,0,characterLevel-10);
                System.out.println("Attack Fail!");
            }
            else {
                setStatus(10-characterLevel,10,0);
                System.out.println("Attack Success!");

            }
                break;

            case 4: if(characterLevel - 8 <= 0){
                setStatus(0,0,characterLevel-15);
                System.out.println("Attack Fail!");
            }
            else {
                setStatus(20-characterLevel,20,0);
                System.out.println("Attack Success!");

            }
                break;
            case 5:bag.showListitem(novice);
                break;

            case 0: return false;
        }
        return true;
    }

    public boolean setStatus(int exp, int money, int hp){
        characterHp = characterHp + hp ;
        characterMoney = characterMoney + money ;
        charecterExp = charecterExp + exp;
        if(charecterExp/100 == 1){
            System.out.println("###LEVEL UP###");
            charecterExp = charecterExp - 100;
            characterLevel = characterLevel + 1;
            characterHp = characterHp + 10;
        }
        if(characterHp <= 0){
            System.out.println("###YOU ARE DEAD###");
            System.out.println("###GAME OVER!###");
            return true;
        }
        return false;
    }
}
