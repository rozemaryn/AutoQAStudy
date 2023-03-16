package api;

public class UnsuccessfulReg {
    private String error;

    public String getError () {
        return error;
    }
    UnsuccessfulReg () {
    }

    public UnsuccessfulReg(String error) {
        this.error = error;
    }
}
