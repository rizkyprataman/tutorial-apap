package apap.tutorial.pergipergi.service;

import java.util.List;

import apap.tutorial.pergipergi.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> findAllUser();
    UserModel findByUsername(String username);
    void deleteUser(UserModel user);
    boolean passwordMatch(String passwordBaru, String passwordLama);
    void setPassword(UserModel user, String passworBaru);
}
