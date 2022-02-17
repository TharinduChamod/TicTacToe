/* 
    E/18/285
    S.M.T.S.C.Ranasinghe
    CO225 Softwear Construction
    Lab 06

*/




import javax.swing.*;


public class Model {

    private boolean player1 = true;                 // Variable for Selecting palyer Turn
    private int buttonSelected = 0;                 // Count selected buttons


    /* Variables get from View*/
    
    private JButton[] button;               
    private JFrame frame;
    private JLabel textField;
    private View view;


    public Model(View view){
        this.view = view;
    }



    public void setButtonCount(int count){          // Set button count
        this.buttonSelected= count;
    }

    public void setPlayerStatus(boolean player1){   // Set player 1 true or false
        this.player1 = player1;
    }

    public boolean getPlayerStatus(){               // get player 1 status
        return player1;
    }

    public int getButtonCount(){                    // get buttons selected
        return buttonSelected;
    }




    
    public void check(){            // That Checks if someone wins or not

        /*Checking winning conditions*/

        // Checking conditions for player 1 
        // If player 1 satisfying wnning conditions run method player1wins

        button = view.getButton();      // get events of button from view 

        /* Winning Combinations

                when Considering Button Grid as Matrix,

                        {0, 1, 2}
                        {3, 4, 5}
                        {6, 7, 8}

                        So, For win there Should be 1 possible combination among belows,
                            (0,1,2)
                            (3,4,5)
                            (6,7,8)
                            (0,3,6)
                            (1,4,7)
                            (2,5,8)
                            (0,4,8)
                            (2,4,6)

        */
        

        if((button[0].getText()=="1")&&(button[1].getText()=="1")&&(button[2].getText()=="1")){
            player1wins();
        }

        else if((button[3].getText()=="1")&&(button[4].getText()=="1")&&(button[5].getText()=="1")){
            player1wins();
        }

        else if((button[6].getText()=="1")&&(button[7].getText()=="1")&&(button[8].getText()=="1")){
            player1wins();
        }

        else if((button[0].getText()=="1")&&(button[3].getText()=="1")&&(button[6].getText()=="1")){
            player1wins();
        }

        else if((button[1].getText()=="1")&&(button[4].getText()=="1")&&(button[7].getText()=="1")){
            player1wins();
        }

        else if((button[2].getText()=="1")&&(button[5].getText()=="1")&&(button[8].getText()=="1")){
            player1wins();
        }

        else if((button[0].getText()=="1")&&(button[4].getText()=="1")&&(button[8].getText()=="1")){
            player1wins();
        }

        else if((button[2].getText()=="1")&&(button[4].getText()=="1")&&(button[6].getText()=="1")){
            player1wins();
        }

        // Checking conditions for player 2
        // If player 2 satisfying conditions run method player2wins


        else if((button[0].getText()=="2")&&(button[1].getText()=="2")&&(button[2].getText()=="2")){
            player2wins();
        }

        else if((button[3].getText()=="2")&&(button[4].getText()=="2")&&(button[5].getText()=="2")){
            player2wins();
        }

        else if((button[6].getText()=="2")&&(button[7].getText()=="2")&&(button[8].getText()=="2")){
            player2wins();
        }

        else if((button[0].getText()=="2")&&(button[3].getText()=="2")&&(button[6].getText()=="2")){
            player2wins();
        }

        else if((button[1].getText()=="2")&&(button[4].getText()=="2")&&(button[7].getText()=="2")){
            player2wins();
        }

        else if((button[2].getText()=="2")&&(button[5].getText()=="2")&&(button[8].getText()=="2")){
            player2wins();
        }

        else if((button[0].getText()=="2")&&(button[4].getText()=="2")&&(button[8].getText()=="2")){
            player2wins();
        }

        else if((button[2].getText()=="2")&&(button[4].getText()=="2")&&(button[6].getText()=="2")){
            player2wins();
        }

        else if(buttonSelected==9){
            gameOver();                             // If game draw reset everything
        }

    }


    public void player1wins(){
        
        textField = view.getTextfield();        // Get TextField of view
        frame = view.getFrame();                // Get Frame of view

        buttonSelected = 0;                     // Reset Button Count
        textField.setText("Player 1 Wins!");    // Set win Message
        view.setTextfield(textField);

        String text = "Player 1 Wins!";         // Player 1 win message
        int opt = view.DialogBox(text);         // get option code for dialog box
    
        if(opt==0){
            frame.dispose();
            new View();
        }
        else{
            frame.dispose();        // Exit the Game
        }

    }



    // Method to run if player 2 wins

    public void player2wins(){

        textField = view.getTextfield();        // Get TextField of view
        frame = view.getFrame();                // Get Frame of view

        buttonSelected = 0;                     // Reset Button Count
        textField.setText("Player 2 Wins!");    // Set win Message
        view.setTextfield(textField);

        String text = "Player 2 Wins!";         // Show win massage on current instance
        int opt =view.DialogBox(text);          // Show dialog Box

    
        if(opt==0){
            frame.dispose();        // Close the game
            new View();             // restart the game
        }
        else{
            frame.dispose();        // Exit the game
        }
        
    }


    // Game Over Method

    public void gameOver(){

        textField = view.getTextfield();        // Get Text Field of View
        frame = view.getFrame();                // Get Frame of View

        buttonSelected = 0;                     // Reset Button Count
        textField.setText("Game Draw!");        // Set textfied of main frame
        view.setTextfield(textField);

        String text = "Game Draw!";             // Game Draw Message
        int opt = view.DialogBox(text);         // Get option code 

        
        if(opt==0){
            frame.dispose();    // Close current Instance
            new View();         // Restart Game in select Restart option
        }
        else{
            frame.dispose();        // Exit the Game
        }
    }


}
