/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kartik
 */
public class Machine_Learning_Engineer extends Requirements{
    
    String [] req;
    String name;
    Machine_Learning_Engineer()
    {
        req=new String[]{"experience_atleast_1_year","research_experience_must"};
        name="Machine Learning Engineer";
    }
    @Override
    String [] requirements_per_vacancy() {
        
        return req;
    }
    String get_name()
    {
        return name;
    }

}
