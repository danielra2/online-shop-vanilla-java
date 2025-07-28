package app.users.services;

public class UsersQuerryServiceSingleton {
    public class LazyHolder{
        private static final UsersQuerryService usersQueryService=new UsersQuerryServiceImpl();
    }
    public static UsersQuerryService getInstance(){
        return LazyHolder.usersQueryService;
    }
}
