package app.users.services;

import app.users.models.User;

public interface UsersCommandService {

    //todo: add edit remove
    void addUser(User user);
    void editUser(User user);
    void removeUser(User user);
    public void load();
    public String toSave();
    public void save();


}
