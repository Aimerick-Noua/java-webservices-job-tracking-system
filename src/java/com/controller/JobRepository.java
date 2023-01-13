/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.models.ModelJob;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AIMERICK NOUA
 */
public class JobRepository {


    static void save(ModelJob job) {
        try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("insert into public.job (category,location,skills,salary,experience,description,postedDate,closedate) "
                    + "values('" + job.getCategory() + "','" + job.getLocation() + "','" + job.getSkills() + "','" + job.getSalary() + "',"
                    + "'" + job.getExperience() + "','" + job.getDescription() + "','" + job.getPostedDate() + "',"
                    + "'" + job.getClosedate() + "');");
        } catch (Exception e) {
            System.out.println("Failed to insert data in to the database: " + e);
        }
    }

    static void update(ModelJob job) {
            String sql = "UPDATE public.employer" + " SET category =  '" + job.getCategory() + "' ,"
                    + " location='" +  job.getLocation() +"',"
                    + " skills ='"+job.getSkills()+"',"
                    + " salary = '"+ job.getSalary()+"',"
                    + " experience='"+job.getExperience()+"',"
                    + " description='"+job.getDescription()+"',"
                    + " postedDate ='"+job.getPostedDate()+"',"
                    + "closedate = '"+job.getClosedate()
                    + "'  WHERE emp_id =" + job.getJob_id();
        try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Failed to update"+e);
        }
    }

    public static void saveupdate(ModelJob employer) {
        if (employer.getJob_id() != 0) {
            update(employer);
        } else {
            save(employer);
        }
    }

    public static ArrayList<ModelJob> getall() {
        ArrayList<ModelJob> listU = new ArrayList<>();
        try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("select * from public.job");
            System.out.println(rs);
            while (rs.next()) {

                ModelJob oneuser;
                oneuser = new ModelJob();
                oneuser.setJob_id(rs.getInt("emp_id"));
                oneuser.setCategory((rs.getString("category")));
                oneuser.setLocation((rs.getString("location")));
                oneuser.setSkills((rs.getString("skills")));
                oneuser.setSalary((rs.getDouble("salary")));
                oneuser.setExperience((rs.getInt("experience")));
                oneuser.setDescription((rs.getString("description")));
                oneuser.setPostedDate((rs.getTimestamp("postedDate")));
                oneuser.setClosedate((rs.getString("closedate")));
                
                System.out.println("les employer : " + oneuser.getJob_id());
                listU.add(oneuser);
            }
        } catch (Exception e) {
            System.out.println("Error while searching : " + e);
        }
        return listU;
    }
}
