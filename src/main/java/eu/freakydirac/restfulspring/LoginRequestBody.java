package eu.freakydirac.restfulspring;

/**
 * Created by buele on 28/06/15.
 */
public class LoginRequestBody {

    private String username;
    private String password;

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
