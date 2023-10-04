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

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    private int currentPlayer = 0;
    private int f = 0;

    public int getNextPlayer()          //TODO Implement this method
    {
        if (f == 2){
            if (currentPlayer == 0) {
                currentPlayer = 1;
            } else {
                currentPlayer = 0;
            }
            f = 0;
        }
        f++;
        //currentPlayer++;
        return currentPlayer;
       /* if (currentPlayer == 0) {
            currentPlayer = 1;
        } else {
            currentPlayer = 0;
        }
        return currentPlayer;*/

        /*  switch(currentPlayer){
            case 1:
                currentPlayer = 0;
                break;
            case 0:
                currentPlayer = 1;
                break;
        }
        //currentPlayer = (currentPlayer == 0) ? 1 : 0;
        return currentPlayer;*/
    }


    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        //TODO Implement this method
        return true;
    }

    public boolean isGameOver()
    {
        //TODO Implement this method
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        //TODO Implement this method
        return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        //TODO Implement this method
        currentPlayer = 0;
    }

}