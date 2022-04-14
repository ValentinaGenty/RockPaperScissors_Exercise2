package com.Revature;

import java.util.Scanner;
import java.util.Random;

public class Game {
    private String user_move;
    private String cpu_move;
    private int user_score=0;
    private int cpu_score=0;
    private String winner;
    private String user_name;

    private String [] moves = {"Rock","Paper","Scissors"};

    private void cpu_move(){
        Random r =new Random();
        int num=r.nextInt(3); //3 possible moves in RPS
        cpu_move=moves[num];
    }

    private void user_move(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("It's your turn, please enter your move:");
        System.out.println("(Rock, Paper, or Scissors)");
        boolean unacceptable_input=true;
        while(unacceptable_input) {
            String user_input = scanner.nextLine();
            switch(user_input){
                case "Rock","rock","r":
                    user_move="Rock";
                    unacceptable_input=false;
                    break;
                case "Scissors","scissors","s":
                    user_move="Scissors";
                    unacceptable_input=false;
                    break;
                case "Paper","paper","p":
                    user_move="Paper";
                    unacceptable_input=false;
                    break;
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }
        }
    }
    public void new_user(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your name: ");
        user_name=scanner.nextLine();
        System.out.println("Welcome, "+user_name+"!");
        cpu_score=0;
        user_score=0;
    }
    public void start_game(){
        gameplay();
    }
    private void gameplay() {
        boolean game_over = false;
        while (!game_over) {
            cpu_move();
            user_move();
            decide_winner();
            if (!winner.equals("neither")) {
                if (winner.equals("cpu")) {
                    cpu_score++;
                    System.out.println("Game Over! The CPU won!");
                } else if (winner.equals("user")) {
                    user_score++;
                    System.out.println("Game Over! " + user_name + " won!");
                }
                game_over = true;
                System.out.println(user_name+"'s score: "+Integer.toString(user_score)+" & CPU's score: "+Integer.toString(cpu_score));
            }
            else{
                System.out.println("Draw! Both players entered the same move!");
            }
        }
        System.out.println("Would you like to play again?(y/n)");
        Scanner scanner = new Scanner(System.in);
        boolean invalid_input = true;
        String play_again;
        while (invalid_input){
            play_again = scanner.nextLine();

            if (play_again.equals("y")) {
                invalid_input = false;
                String new_user;
                boolean new_invalid_input=true;
                System.out.println("Would you like to change your username(this also resets CPU and User scores)?(y/n)");
                while (new_invalid_input){
                    new_user = scanner.nextLine();

                    if (new_user.equals("y")) {
                        new_user();
                        start_game();
                        new_invalid_input = false;
                    } else if (new_user.equals("n")) {
                        start_game();
                        new_invalid_input = false;
                    }
                    else{
                        System.out.println("Please enter a valid input");
                    }
                }
            } else if (play_again.equals("n")) {
                System.out.println("Goodbye!");
                invalid_input = false;
            }
            else{
                System.out.println("Please enter a valid input");
            }
        }

    }

    private void decide_winner(){
        if(cpu_move.equals(user_move)){
            winner="neither";
        }
        else if(cpu_move.equals("Rock")){
            if(user_move.equals("Paper")){
                winner="user";
            }
            else if(user_move.equals("Scissors")) {
                winner="cpu";
            }
        }
        else if(cpu_move.equals("Paper")){
            if(user_move.equals("Scissors")){
                winner="user";
            }
            else if(user_move.equals("Rock")) {
                winner="cpu";
            }
        }
        else if(cpu_move.equals("Scissors")){
            if(user_move.equals("Rock")){
                winner="user";
            }
            else if(user_move.equals("Paper")) {
                winner="cpu";
            }
        }

    }
}
