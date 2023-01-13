/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.models.ModelJobSeeker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author AIMERICK NOUA
 */
@Path("/jobSeekerController")
public class JobSeekerController {
    


    @GET
    @Path("/listJobseekers")
    @Produces({"application/json"})
    public ArrayList<ModelJobSeeker> listJobs() {
        return JobSeekerRepository.getall();
    }

    
    @DELETE
    @Path("/deleteJobSeeker/{jsker_id}")
//    @Consumes(MediaType.APPLICATION_JSON)
    public void DeleteEmployee(@PathParam("jsker_id") int jsker_id) throws SQLException {
        try {
            Statement state = (Statement) com.connection.Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("Delete from public.jobseeker where jsker_id =" + jsker_id);
            System.out.println("deleting");
        } catch (Exception e) {
            System.out.println("failed to delete " + e.getMessage());
        }
    }
    
    
    @POST
    @Path("/addJobSeeker")
//    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmployee(ModelJobSeeker employer) throws SQLException {
      JobSeekerRepository.saveupdate(employer);
    }
    
}

