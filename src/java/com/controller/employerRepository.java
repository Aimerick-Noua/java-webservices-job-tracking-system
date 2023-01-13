/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.models.ModelEmployer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class employerRepository {

    static void save(ModelEmployer employer) {
        try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("insert into public.employer(name,dob,gender,address,phoneNumber,enterp_name,country,state,city,email,password) "
                    + "values('" + employer.getName() + "','" + employer.getDob() + "','" + employer.getGender() + "','" + employer.getAddress() + "',"
                    + "'" + employer.getPhoneNumber() + "','" + employer.getEnterp_name() + "','" + employer.getCountry() + "',"
                    + "'" + employer.getState() + "','" + employer.getCity() + "','" + employer.getEmail() + "','" + employer.getPassword() + "');");
        } catch (Exception e) {
            System.out.println("Failed to insert data in to the database: " + e);
        }
    }

    static void update(ModelEmployer employer) {
            String sql = "UPDATE public.employer" + " SET name =  '" + employer.getName() + "' ,"
                    + " dob='" +  employer.getDob() +"',"
                    + " gender ='"+employer.getGender()+"',"
                    + " address = '"+ employer.getAddress()+"',"
                    + " phoneNumber='"+employer.getPhoneNumber()+"',"
                    + " enterp_name='"+employer.getEnterp_name()+"',"
                    + " country ='"+employer.getCountry()+"',"
                    + "state = '"+employer.getState()+"',"
                    + " city = '"+employer.getCity()+"',"
                    + " email = '"+employer.getEmail()+"',"
                    + " password='"+employer.getPassword()
                    + "'  WHERE emp_id =" + employer.getEmp_id();
        try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Failed to update"+e);
        }
    }

    public static void saveupdate(ModelEmployer employer) {
        if (employer.getEmp_id() != 0) {
            update(employer);
        } else {
            save(employer);
        }
    }

    static ArrayList<ModelEmployer> getall() {
        ArrayList<ModelEmployer> listU = new ArrayList<>();
        try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("select * from public.employer");
            System.out.println(rs);
            while (rs.next()) {

                ModelEmployer oneuser;
                oneuser = new ModelEmployer();
                oneuser.setEmp_id(rs.getInt("emp_id"));
                oneuser.setName((rs.getString("name")));
                oneuser.setDob((rs.getString("dob")));
                oneuser.setGender((rs.getString("gender")));
                oneuser.setAddress((rs.getString("address")));
                oneuser.setPhoneNumber((rs.getInt("phonenumber")));
                oneuser.setEnterp_name((rs.getString("enterp_name")));
                oneuser.setCountry((rs.getString("country")));
                oneuser.setState((rs.getString("state")));
                oneuser.setCity((rs.getString("city")));
                oneuser.setEmail((rs.getString("email")));
                oneuser.setPassword((rs.getString("password")));
                System.out.println("les employer : " + oneuser.getEmp_id());
                listU.add(oneuser);
            }
        } catch (Exception e) {
            System.out.println("Error while searching : " + e);
        }
        return listU;
    }
}
