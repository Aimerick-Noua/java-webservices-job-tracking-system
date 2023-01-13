/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.models.ModelEmployer;
import com.models.ModelJobSeeker;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AIMERICK NOUA
 */
public class JobSeekerRepository {

    static void saveupdate(ModelJobSeeker jsker) {
if (jsker.getJsker_id() != 0) {
            update(jsker);
        } else {
            save(jsker);
        }  
    }

    static ArrayList<ModelJobSeeker> getall() {
        ArrayList<ModelJobSeeker> listU = new ArrayList<>();
        try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("select * from public.jobseeker");
            System.out.println(rs);
            while (rs.next()) {

                ModelJobSeeker oneuser;
                oneuser = new ModelJobSeeker();
                oneuser.setJsker_id(rs.getInt("jsker_id"));
                oneuser.setName((rs.getString("name")));
                oneuser.setGender((rs.getString("gender")));
                oneuser.setCountry((rs.getString("country")));
                oneuser.setState((rs.getString("state")));
                oneuser.setCity((rs.getString("city")));
                oneuser.setPhoneNumber((rs.getInt("phonenumber")));
                oneuser.setEmail((rs.getString("email")));
                oneuser.setPassword((rs.getString("password")));
                oneuser.setExperience((rs.getInt("experience")));
                oneuser.setSkills((rs.getString("skills")));
                System.out.println("les employer : " + oneuser.getJsker_id());
                listU.add(oneuser);
            }
        } catch (Exception e) {
            System.out.println("Error while searching : " + e);
        }
        return listU;
    }

    private static void update(ModelJobSeeker jsker) {
                    String sql = "UPDATE public.jobseeker" + " SET name =  '" + jsker.getName() + "' ,"
                    + " gender ='"+jsker.getGender()+"',"
                    + " phoneNumber='"+jsker.getPhoneNumber()+"',"
                    + " country ='"+jsker.getCountry()+"',"
                    + "state = '"+jsker.getState()+"',"
                    + " city = '"+jsker.getCity()+"',"
                    + " email = '"+jsker.getEmail()+"',"
                    + " experience = '"+jsker.getExperience()+"',"
                    + " skills = '"+jsker.getSkills()+"',"
                    + " password='"+jsker.getPassword()
                    + "'  WHERE jsker_id =" + jsker.getJsker_id();
        try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Failed to update"+e);
        }
    }
    

    private static void save(ModelJobSeeker jsker) {
  try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("insert into public.jobseeker(name,gender,address,phoneNumber,country,state,city,email,password,experience,skills) "
                    + "values('" + jsker.getName() + "','" + jsker.getGender() + "',"
                    + "'" + jsker.getPhoneNumber() + "','" + jsker.getCountry() + "',"
                    + "'" + jsker.getState() + "','" + jsker.getCity() + "','" + jsker.getEmail() + "','" + jsker.getPassword() + "','" + jsker.getExperience() + "','" + jsker.getSkills() + "');");
        } catch (Exception e) {
            System.out.println("Failed to insert data in to the database: " + e);
        }
    }
}
