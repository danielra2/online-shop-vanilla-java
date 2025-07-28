package app.users.services;

public class UsersCommandServiceSingleton {
    private static class LazyHolder {
        private static final UsersCommandService USERS_SERVICE = new UsersCommandServiceImpl();
    }

    public static UsersCommandService getInstance() {
        return LazyHolder.USERS_SERVICE;
    }
}
