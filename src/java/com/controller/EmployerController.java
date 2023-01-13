/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.connection.Connexion;
import com.models.ModelEmployer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.service.userService;
import java.sql.Statement;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/EmployerController")
public class EmployerController {

    @GET
    @Path("/listEmployer")
    @Produces({"application/json"})
    public ArrayList<ModelEmployer> listdesemployer() {
        return employerRepository.getall();
    }

    
    @DELETE
    @Path("/deleteEmployer/{emp_id}")
//    @Consumes(MediaType.APPLICATION_JSON)
    public void DeleteEmployee(@PathParam("emp_id") int emp_id) throws SQLException {
        try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("Delete from public.employer where emp_id =" + emp_id);
            System.out.println("deleting");
        } catch (Exception e) {
            System.out.println("failed to delete " + e.getMessage());
        }
    }
    
    
    @POST
    @Path("/addEmployer")
//    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmployee(ModelEmployer employer) throws SQLException {
      employerRepository.saveupdate(employer);
    }
    
}
