package app.users.services;

import app.users.models.User;

import java.util.List;

public interface UsersQuerryService {
    List<User>getAllUser();
    User findUserByNameAndPassword(String name,String password);
    public void load();


    //todo: findUserByEmail
}
