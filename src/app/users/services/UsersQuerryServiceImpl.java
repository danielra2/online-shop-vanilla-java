package app.users.services;

import app.users.models.User;
import app.users.models.UserTypes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersQuerryServiceImpl implements UsersQuerryService {

    private List<User>userList;
    public UsersQuerryServiceImpl(){
        this.userList=new ArrayList<>();
        load();
    }
    public void load() {
        File file = new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\users\\data\\users.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[]parti=line.split(",");
                UserTypes tip=UserTypes.valueOf(parti[0]);
                User user=User.fabricaUser(tip,line);
                if(user!=null){
                    this.userList.add(user);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> getAllUser() {
        return this.userList;
    }

    @Override
    public User findUserByNameAndPassword(String name,String password) {
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getFullName().equalsIgnoreCase(name)&&userList.get(i).getPassword().equalsIgnoreCase(password)){
                return userList.get(i);
            }
        }
        return null;
    }


}
