package model.data.dictonaries;

public class DD_TransactStatus {
    private int idTransact;
    private String transactStatus;
    private String transactDes;

    public DD_TransactStatus(int idTransact, String transactStatus, String transactDes) {
        this.idTransact = idTransact;
        this.transactStatus = transactStatus;
        this.transactDes = transactDes;
    }

    public int getIdTransact() {
        return idTransact;
    }

    public void setIdTransact(int idTransact) {
        this.idTransact = idTransact;
    }

    public String getTransactStatus() {
        return transactStatus;
    }

    public void setTransactStatus(String transactStatus) {
        this.transactStatus = transactStatus;
    }

    public String getTransactDes() {
        return transactDes;
    }

    public void setTransactDes(String transactDes) {
        this.transactDes = transactDes;
    }
}
