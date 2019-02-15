import java.io.*;
public class Maingame {

    public static void main(String args[]){
        Novice novice = new Novice();
        Item item = new Item();
        Bag bag = new Bag();

        System.out.println("========Welcome to My Games=======");

        novice.createCharacter();
        novice.playGame(bag,novice);
        do{
            novice.playGame(bag,novice);
            if(novice.getCharacterHp() <= 0)
                return;
        }
        while (novice.playGame(bag,novice));
    }

}
