package com.springapp.mvc.service;

import com.springapp.mvc.model.User;

import java.util.List;

/**
 * Created by Maxim.Temborskiy on 19.11.2016.
 */
public interface UserService
{
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser (int id);
    public User getUserById (int id);
    public List<User> listUsers();

}
