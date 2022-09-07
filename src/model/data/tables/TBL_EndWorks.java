package model.data.tables;

public class TBL_EndWorks {
    private String idPermit;
    private int idCom;
    private String deliveryCom;

    public TBL_EndWorks(String idPermit, int idCom, String deliveryCom) {
        this.idPermit = idPermit;
        this.idCom = idCom;
        this.deliveryCom = deliveryCom;
    }

    public String getIdPermit() {
        return idPermit;
    }

    public void setIdPermit(String idPermit) {
        this.idPermit = idPermit;
    }

    public int getIdCom() {
        return idCom;
    }

    public void setIdCom(int idCom) {
        this.idCom = idCom;
    }

    public String getDeliveryCom() {
        return deliveryCom;
    }

    public void setDeliveryCom(String deliveryCom) {
        this.deliveryCom = deliveryCom;
    }
}
