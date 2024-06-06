package beans.input;
public class LoginResponse {
    private boolean loginSuccess;
    private boolean isActive;

    public LoginResponse(boolean loginSuccess, boolean isActive) {
        this.loginSuccess = loginSuccess;
        this.isActive = isActive;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
