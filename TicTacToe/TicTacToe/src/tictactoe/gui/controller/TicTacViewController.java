/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tictactoe.bll.GameBoard;
import tictactoe.bll.IGameModel;

/**
 *
 * @author Stegger
 */
public class TicTacViewController implements Initializable
{

    @FXML
    private Label lblPlayer;

    @FXML
    private Button btnNewGame;
    public int player = 1;

    @FXML
    public GridPane gridPane;

    private static final String TXT_PLAYER = "Player: ";
    private IGameModel game;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
            int player = game.getNextPlayer();

            if (game.play(c, r))
            {
                Button btn = (Button) event.getSource();
                String xOrO = player == 0 ? "X" : "O";
                btn.setText(xOrO);

                if (game.isGameOver())
                {
                    int winner = game.getWinner();
                    displayWinner(winner);
                    disableAllButtons(true);  //This will "Turn Off" the game so nothing can be further clicked
                }
                else
                {
                    setPlayer();
                }
            }
        } catch (Exception e)

        {
            System.out.println(e.getMessage());
        }
    }


    private void disableAllButtons(boolean toggle) {   // "import javafx.collections.ObservableList" used above for the list to function properly
        ObservableList<Node> children = gridPane.getChildren(); // Creating a new variable 'children' using an array type list that changes as more/less nodes are added or removed
        int numChildren = children.size();       // Creating 'numChildren' variable and returning a number of how many children there are in the gridPane

        for (int i = 0; i < numChildren; i++) {
            Node n = children.get(i);   // Assigning 'n' to every node that it rotates through

            if (n instanceof Button) {  //Checks if 'n' is a Button by using 'instanceof' to check the class of each object and look for Buttons
                Button button = (Button) n; //This uses 'casting' to force our variable 'n' into a Button and call it button
                button.setDisable(toggle); //This will toggle true or false to disable/enable the button
            }
        }
    }

    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        disableAllButtons(false);  //This will "Turn On" the game allowing it to be played again!
        setPlayer();
        clearBoard();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoard();
        setPlayer();
    }

    private void setPlayer()
    {
        lblPlayer.setText(TXT_PLAYER + (game.getNextPlayer()+1));
        player++;

    }

    private void displayWinner(int winner)
    {
        String message = "";
        switch (winner)
        {
            case -1:
                message = "It's a draw :-(";
                break;
            default:
                message = "Player " + (winner + 1) + " wins!!!";
                break;
        }
        lblPlayer.setText(message);
    }

    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
        }
    }

}
