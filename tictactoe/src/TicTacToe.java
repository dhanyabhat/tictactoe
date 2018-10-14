/** Driver class for the game.
 * It creates objects of Model, View and Controller 
 * classes and aggregates them.
 * */

import view.*;
import model.*;
import controller.*;

public class TicTacToe {                                                              
                                                                                 
    public static void main(String[] args) {                                   
        //create the components                                                 
        Model m = new Model();                                                        
        View v = new View();                                                     
        Controller c = new Controller();                                                
                                                                                 
        // aggregate the components together                        
        m.registerView(v);                                                       
        c.setModel(m);
        v.setActionListener(c);

    }                                                                            
}