import view.*;
import model.*;
import controller.*;

public class TicTacToe {                                                              
                                                                                 
    public static void main(String[] args) {                                   
        // Create the components                                                 
        Model m = new Model();                                                        
        View v = new View();                                                     
        Controller c = new Controller();                                                
                                                                                 
        // Use aggregation to put the components together                        
        m.registerView(v);                                                       
        c.setModel(m);
        v.setActionListener(c);
                    
    }                                                                            
}