/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import tictactoe.gui.controller.TicTacViewController;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{


    private int currentPlayer = 0;
    private int [][] board; // Represents the gameboard

    public GameBoard()
    {
        board = new int[3][3]; // makes a 3x3 grid and sets every cell to -1 for empty cells

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = -1;
            }
        }
    }
    public int getNextPlayer()          //TODO Implement this method
    {
        return currentPlayer;
    }


    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is successful the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)        //TODO Implement this method
    {
        if (board[col][row] == -1) // Check if the cell is empty
        {
            board[col][row] = currentPlayer; // Checks which player is playing and sets the square to 0,0 or 1,1 making it unusable
            currentPlayer = (currentPlayer == 0) ? 1 : 0; // Short form if-else statement: this changes the players turn
            return true; //
        }
        return false; // if the cell has a number in it, will not let the game progress
    }

    public boolean isGameOver()        //TODO Implement this method
    {
        return checkWin(0) || checkWin(1) || isBoardFull(); // simply sends true if any of these are met, false if not
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    private boolean checkWin(int player) {  //adding a checkWin method that can be called in both isGameOver and getWinner

        for (int i = 0; i < 3; i++)  // used to check all spots
        {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) { //checking rows for win
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player){ //checking columns for win
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player){ //checking for diagonals
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player){ //checking for diagonals
            return true;
        }

        return false; //no win condition met
    }
    private boolean isBoardFull(){ //checking the board if there is any more moves left - if not:Draw
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(board[i][j] == -1)
                {
                    return false;
                }
            }
        }
        return true;
    }


    public int getWinner()        //TODO Implement this method
    {
        if(checkWin(0))    // Tells the game which player has won
        {
            return 0;
        }
        if(isBoardFull()){   // Draw conditions met
            return -1;
        }
        else if (checkWin(1))
        {
            return 1;
        }
        return 1;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()        //TODO Implement this method
    {
        //if(getWinner() == 1){
        // board = new int[3][3]; // makes a 3x3 grid and sets every cell to -1 for empty cells

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = -1;
            }
        }
        currentPlayer = 0;
    }
}