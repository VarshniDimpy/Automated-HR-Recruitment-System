/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kartik
 */
public class Full_Stack_developer extends Requirements {
    
    String [] req;
    String name;
    
    Full_Stack_developer()
    {
        name="Full Stack Developer";
        req=new String [] {"knowledge of any backend language is must","experience on web projects"};
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
