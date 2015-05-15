package com.chessgame.chessgame;

import com.chessgame.chessgame.board.Board;
import java.util.Scanner;

public class Game {
    private Board board;
    
    public Game() {
        this.board = new Board();
    }
    
    public void start() {       
        while (true) {
            board.printPieces();
            round();
        }
    }
    
    public void round() {
        Scanner l = new Scanner(System.in);
        System.out.print("Input next move (ex. A2:A4): ");
        String input = l.nextLine();
        
        board.move(input);
    }
}
