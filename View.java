/* 
    E/18/285
    S.M.T.S.C.Ranasinghe
    CO225 Softwear Construction
    Lab 06

*/



import javax.swing.*;
import java.awt.*;


public class View extends JFrame{

    private JFrame frame = new JFrame();            // New Frame for window
    private JPanel text_panel = new JPanel();       // Panel for Text
    private JPanel button_panel = new JPanel();     // panel For buttons
    private JButton[] button = new JButton[9];      // button for Clicking
    private JLabel textField = new JLabel();        // Add Text Field

    Model model = new Model(this);                  // Create Instance of model for receive current status

    Controller controller = new Controller(model, this);    // Create Instance Of Controller unit

    public View(){

        //Create Window

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Exit Button
        frame.setSize(500, 500);                                // window Size
        frame.getContentPane().setBackground(new Color(224, 224, 224));                  // Set The Background Colour
        frame.setTitle("Tic Tac Toe");                          // title of the window
        frame.setLayout(new BorderLayout());                    // Layout of window
        

        //TextField Settings

        textField.setBackground(new Color(255, 255, 255));      // Color of textFiled
        textField.setForeground(new Color(0, 0, 0));            // Set Font Colour
        textField.setFont(new Font("Times New Roman", Font.BOLD, 40));      // Set Font 
        textField.setHorizontalAlignment(JLabel.CENTER);        // Allign Text Field
        textField.setText("Player 1's Chance");                 // Text of Text Field   
        
        

        //Text Panel Settings

        text_panel.setLayout(new BorderLayout());               // text Panel Layout


        // Button Panel Settings

        button_panel.setLayout(new GridLayout(3,3));            // Button Layout
        button_panel.setForeground(new Color(0,0,0));           // Button Color


        // Buttons Settings

        for(int i=0; i<9; i++){
            button[i] = new JButton();                          // Create Button object
            button[i].setFont(new Font("Arial", Font.BOLD, 120));      // Set the font size on buttons
            button_panel.add(button[i]);                        // Add buttons to button panel
            button[i].setFocusable(false);
            button[i].addActionListener(controller);
        }


        // Add Panels to frame

        text_panel.add(textField);                              // Add Text fiels to text panel
        frame.add(text_panel, BorderLayout.NORTH);              // Add Text Field
        frame.add(button_panel);                                // Add buttons to frame
        frame.setVisible(true);                                 // Set window visible

        }


        /* Getter and setter Methods*/

        /*Return Buttons array*/

        public JButton[] getButton(){
            return button;                      // return Button From View
        }

        public JLabel getTextfield(){
            return textField;                   // return text Field From view
        }

        public JFrame getFrame(){
            return frame;                       // Return Frame from View
        }

        public void setButton(JButton[] button){
            this.button= button;                // Set Button of view
        }

        public void setTextfield(JLabel textField){
            this.textField = textField;         // Set text Field
        }


        /*Show Dialog Box*/

        public int DialogBox(String Message){           // Return option Code
    
            Object[] option={"Restart Game","Exit"};    // options

            int opt =
            JOptionPane.showOptionDialog(frame, Message+"\n","Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        
            return opt;                                 // Return OPtion Code
        

        }

}
