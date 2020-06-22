/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kartik
 */
public abstract class Requirements {
    String [] req;
    
    String [] common_requirements()
    {
        req = new String[] {"undergraduate","computer_science_or_electronics_background","above_70_%"};
        
        return req;
    }
    
    abstract String [] requirements_per_vacancy();
    abstract String get_name();
}
