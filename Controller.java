/* 
    
    Author - S.M.T.S.C.Ranasinghe
    Date - 2022/02/18

*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller implements ActionListener{
    
    // Initialize View And model

    private Model model;    // Instance of model
    private View view;      // Instance of view

    // variables for cotrol view and model

    private JButton[] button;
    private int buttonSelected;
    private boolean player1;
    private JLabel textField;
    

    public Controller(Model model, View view){      // Constructor
        this.model=model;
        this.view=view;
    }


    @Override
        public void actionPerformed(ActionEvent e) {        // Check inputs of Buttons

            //Instance get from methods

            button = view.getButton();
            buttonSelected = model.getButtonCount();
            player1 = model.getPlayerStatus();
            textField = view.getTextfield();;
        


            for(int i=0; i<9; i++){
                if(e.getSource()==button[i]){

                    if(player1){

                        if(button[i].getText()==""){
                            button[i].setForeground(new Color(0,0,255));    // Set Player 1 color to blue
                            button[i].setText("1");                 // Set Button to player 

                            model.getButtonCount();
                            buttonSelected++;                       // Count buttons
                            model.setButtonCount(buttonSelected);   // Set Buttons on Model

                            player1 = false;                        // give Chance to player 2
                            model.setPlayerStatus(player1);

                            model.check();                          // Check who wins
                            textField.setText("Next - Player 2");          // prompt for player 2
                            view.setTextfield(textField);
                        }
                    }

                    else{
                        if(button[i].getText()==""){
                            button[i].setForeground(new Color(255,0,0));    // Set Player 2 color to red
                            button[i].setText("2");                 // Set Button for player 2

                            model.getButtonCount();
                            buttonSelected++;                       // Count Buttons
                            model.setButtonCount(buttonSelected);   // Set values of buttons on model

                            player1 = true;                         // Give Chance to player 1
                            model.setPlayerStatus(player1);         // Set Model Player 1 Status

                            model.check();                          // Check who wins
                            textField.setText("Next - Player 1");          // prompt for player 2
                            view.setTextfield(textField);
                        }
                    }
                }
            } 
        }



}
