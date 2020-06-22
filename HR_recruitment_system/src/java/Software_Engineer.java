/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kartik
 */
public class Software_Engineer extends Requirements{    

    String [] req;
    String name;
    
    Software_Engineer()
    {
        name="Software Engineer";
        req = new String[]{"knowledge of any programming language","coding experience"};
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
