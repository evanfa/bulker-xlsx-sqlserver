package model.data.tables;

public class TBL_GeoInfo {

    private String idPermit;
    private String coordX;
    private String coordY;
    private String spread;

    public TBL_GeoInfo(String idPermit, String coordX, String coordY) {
        this.idPermit = idPermit;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public void setIdPermit(String idPermit) {
        this.idPermit = idPermit;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public String getIdPermit() {
        return idPermit;
    }

    public String getCoordX() {
        return coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public String getSpread() {
        return spread;
    }
}
