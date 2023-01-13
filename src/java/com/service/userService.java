/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.models.ModelEmployer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AIMERICK NOUA
 */
public class userService {

    private static List<ModelEmployer> users = new ArrayList<ModelEmployer>();

    public static void create(ModelEmployer employer) {
        users.add(employer);
    }

}
