package Ansin.web.vueForm;

import javax.validation.constraints.NotBlank;

public class User {

    private int id;
    @NotBlank(message="ユーザーを入力してください")
    //@Max(value=10,message="10桁以下を入力してください")
    private String username;
    @NotBlank(message="パスワードを入力してください")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
