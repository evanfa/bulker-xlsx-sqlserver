package model.data.dictonaries;

public class DD_City {
    private int idCity;
    private String cityDes;
    private int idState;

    public DD_City(int idCity, String cityDes, int idState) {
        this.idCity = idCity;
        this.cityDes = cityDes;
        this.idState = idState;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCityDes() {
        return cityDes;
    }

    public void setCityDes(String cityDes) {
        this.cityDes = cityDes;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }
}
