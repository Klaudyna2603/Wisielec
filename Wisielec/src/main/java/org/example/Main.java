package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner= new Scanner(System.in);

    public static String[] rysunek = {
                    "+---+\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +   //if the user didn't miss any guesses.
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

                    "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +   //if the user missed one guess.
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

                    "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +    //if the user missed two guesses.
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

                    " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +   //if the user missed three guesses.
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

                    " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +   //if the user missed four guesses.
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

                    " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +  //if the user missed five guesses.
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

                    " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +   //if the user missed six guesses.
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n"};

    public static void main(String[] args) {
    gameLogic();
    }
    public static void gameLogic(){
        // Utworzenie tabeli hase??
        String [] tab={"pies","kot","bocian","krowa","chomik"};
        //wybranie has??a za pomoc?? losowego indexu
        String randomWord= tab[getRandom()];
        int userError=0;
        //zamiana s??owa na tablic?? char
        char [] arr= randomWord.toCharArray();
        char [] arrTwo= new char[arr.length];
        System.out.println("To jest gra wisielec :)");
        System.out.println("Zgadnij wylosowane s??owo: ");
        fill(arrTwo);
        //p??tla, kt??ra zostaje wykonana dp??ki gracz wygra lub przegra
        while(userError < rysunek.length){
            System.out.println(showImage(userError));
            print(arrTwo);
            if(userError == rysunek.length-1){
                System.out.println("Przegra??e??");
                break;
            }
            if (checkWin(arr, arrTwo)){
                System.out.println("Wygra??e??");
                break;
            }
            System.out.println();
            String input = scanner.next();
            char letter = input.charAt(0);
            int countLetters=0;
            //sprawdzenie, czy wybrana litera jest w ha??le lub jej wcale tam nie ma
            for (int i = 0; i < arr.length; i++) {
                if(letter == arr[i]){
                    arrTwo[i] = letter;
                } else{
                    countLetters++;
                }
            }
            if (countLetters==arrTwo.length){
                userError++;
            }
            countLetters=0;
        }
    }
    // pokazuje obrazek wisielca
    public static String showImage(int errors){
        switch (errors){
            case 0: return rysunek[0];
            case 1: return rysunek[1];
            case 2: return rysunek[2];
            case 3: return rysunek[3];
            case 4: return rysunek[4];
            case 5: return rysunek[5];
            default: return rysunek[6];
        }
    }
    //losowanie randomowej cyfry
    public static int getRandom(){
        int random= (int) (Math.random()*5);
        return random;
    }
    //wype??nienie dodatkowej tablicy podkre??lnikami
    public static void fill (char [] cha){
        for (int i = 0; i < cha.length; i++) {
            cha[i]= '_';
        }
    }
   //wydrukowanie tablicy
    public static void print (char [] cha){
        System.out.print("S??owo do zgadni??cia: ");
        for (int i = 0; i < cha.length; i++) {
            System.out.print(cha[i]);
        }
        System.out.println();
    }
    //sprawdzenie warunku zwyci??stwa
    public static boolean checkWin (char [] original,char [] check){
        int countWin = 0;
        for (int i = 0; i < original.length; i++) {
            if(original[i] == check[i]){
                countWin++;
            }
        }
        return countWin==original.length;
    }


}
