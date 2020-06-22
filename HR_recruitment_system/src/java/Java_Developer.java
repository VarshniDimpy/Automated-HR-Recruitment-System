/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kartik
 */
public class Java_Developer extends Requirements{
 
    String [] req;
    String name;
    Java_Developer()
    {
        name="Java Developer";
        req = new String[]{"Knowledge of core java is must"," knowledge of oops concepts is must"};
    }
   
    @Override
    String[] requirements_per_vacancy() {
        
           return req;
    }
    
    String get_name()
    {
        return name;
    }
}
