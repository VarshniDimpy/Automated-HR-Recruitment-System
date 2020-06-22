/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kartik
 */

import java.sql.*;
import java.util.*;

class vacancies {
    
    private int max_number_of_vacancies;
    private int number_of_vacancies;
    private String[] vacancies_names;
    private int[] vacancies_available;
    private Connection con;
    
    vacancies()
    {
        max_number_of_vacancies=20;
        vacancies_names=new String[20];
        vacancies_available=new int[20];
        number_of_vacancies=0;
        
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/cs_vacancies","root","");  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        this.initialize_status();
    }
    
    public void initialize_status()
    {
        try{  
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from vacancies");
                int k=0;
                while(rs.next())  
                {
                    vacancies_names[k]=rs.getString(1);
                    vacancies_available[k]=rs.getInt(2);
                    number_of_vacancies++;
                    k=k+1;
                }
                con.close();
                
                }catch(Exception e){ System.out.println(e);} 
               
     }
    
    public boolean update_vacancies(String name,int no)
    {
       int flag=0;
       try
       {
         Class.forName("com.mysql.jdbc.Driver");  
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_vacancies","root",""); 
         Statement stmt=con.createStatement();
         String sql="update vacancies set Available_seats="+no+" where Name='"+name+"'";
         
         stmt.executeUpdate(sql);
         
         
         flag=1;
        }
        catch(Exception e)
        {
            System.out.println(e);
            flag=0;
        }
     
       if (flag==1)
       {
           return true;
       }
       else
       {
           return false;
       }
    }
    
    
    String[] get_vacancies_names()
    {
        return vacancies_names;
    }
    
    int[] get_vacancies_available()
    {
        return vacancies_available;
    }
    int get_number_of_vacancies()
    {
        return number_of_vacancies;
    }
    
        
 }
    
    

public class CreateVacancies extends vacancies {
    
    public static void main(String[] args)
    {
    vacancies a=new vacancies();
    int n;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    a.update_vacancies("Machine Learning Engineer",10);
    }
    
}
