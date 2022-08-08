package model.data.dictonaries;

public class DD_CrossType {
    private String constType;
    private String constDes;

    public DD_CrossType(String constType, String constDes) {
        this.constType = constType;
        this.constDes = constDes;
    }

    public String getConstType() {
        return constType;
    }

    public void setConstType(String constType) {
        this.constType = constType;
    }

    public String getConstDes() {
        return constDes;
    }

    public void setConstDes(String constDes) {
        this.constDes = constDes;
    }
}
