package com.kuang.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String userName;
    String userAccount;
    String Password;
    String Email;
    int user_type;
    int userId;

    public User(String userAccount,String userName, String password, String email, int user_type) {
        this.userName = userName;
        this.userAccount = userAccount;
        Password = password;
        Email = email;
        this.user_type = user_type;
    }
}
