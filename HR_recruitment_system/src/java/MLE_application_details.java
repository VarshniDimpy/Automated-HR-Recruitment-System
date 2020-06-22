
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kartik
 */
public class MLE_application_details {
    
    private int app_id;
    private String First_Name;
    private String Last_Name;
    private String email;
    private String gender;
    private String graduation;
    private String percentage;
    private String research_experience;
    private String total_experience;
    private String status;
    private String interview_assigned;
    private String interview_taken;
    private int interview_result;
   
    MLE_application_details()
    {
        app_id=0;
        First_Name="dim";
        Last_Name="Varshni";
        email="dim@gmail.com";
        gender="female";
        graduation="B.Tech";
        percentage="between 70% - 80 %";
        research_experience="Core";
        total_experience="1 year";
        status="pending";
        interview_assigned="Yes";
        interview_taken="No";
        interview_result=0;
    }
    public void update_all_details()
    {
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/applications","root","");  
                Statement stmt=con.createStatement();
                PreparedStatement st = con .prepareStatement("insert into application_details_mle values(?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
                st.setInt(1,app_id); 
                st.setString(2, First_Name);
                st.setString(3,Last_Name);
                st.setString(4,email);
                st.setString(5,gender);
                st.setString(6,graduation);
                st.setString(7,percentage);
                st.setString(8,research_experience);
                st.setString(9,total_experience);
                st.setString(10, status);
                st.setString(11,interview_assigned);
                st.setString(12,interview_taken);
                st.setInt(13,interview_result);
                st.executeUpdate();
                ResultSet rs = st.executeQuery("select * from application_details_mle");
                while(rs.next())
                {
                    System.out.println(rs.getInt(1)+rs.getString(2));
                }
               
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
        
    }
    
    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
        
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getResearch_experience() {
        return research_experience;
    }

    public void setResearch_experience(String research_experience) {
        this.research_experience = research_experience;
    }

    public String getTotal_experience() {
        return total_experience;
    }

    public void setTotal_experience(String total_experirence) {
        this.total_experience = total_experirence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInterview_assigned() {
        return interview_assigned;
    }

    public void setInterview_assigned(String interview_assigned) {
        this.interview_assigned = interview_assigned;
    }

    public String getInterview_taken() {
        return interview_taken;
    }

    public void setInterview_taken(String interview_taken) {
        this.interview_taken = interview_taken;
    }

    public int getInterview_result() {
        return interview_result;
    }

    public void setInterview_result(int interview_result) {
        this.interview_result = interview_result;
    }
    
}
