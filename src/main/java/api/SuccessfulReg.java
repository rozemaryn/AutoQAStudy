package api;

public class SuccessfulReg {
    private Integer id;
    private String token;

    public SuccessfulReg(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public SuccessfulReg() {
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
