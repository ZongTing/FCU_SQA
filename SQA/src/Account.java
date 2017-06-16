public class Account {

    public String account;
    public String password;
    public String email;
    
    public Account(String account, String password, String email) {
    	this.account = account;
    	this.password = password;
    	this.email = email;
    }
    
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
