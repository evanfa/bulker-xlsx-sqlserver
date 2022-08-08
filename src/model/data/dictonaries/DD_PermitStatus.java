package model.data.dictonaries;

public class DD_PermitStatus {
    private String permitStatus;
    private String permitDes;

    public DD_PermitStatus(String permitStatus, String permitDes) {
        this.permitStatus = permitStatus;
        this.permitDes = permitDes;
    }

    public String getPermitStatus() {
        return permitStatus;
    }

    public void setPermitStatus(String permitStatus) {
        this.permitStatus = permitStatus;
    }

    public String getPermitDes() {
        return permitDes;
    }

    public void setPermitDes(String permitDes) {
        this.permitDes = permitDes;
    }
}
