package model.data.tables;

public class TBL_Agent {
    private String agentName;
    private String agentLName;
    private String agentMName;
    private String agentEmail;
    private int idDepto;

    public TBL_Agent(String agentName, String agentLName, String agentMName, String agentEmail, int idDepto) {
        this.agentName = agentName;
        this.agentLName = agentLName;
        this.agentMName = agentMName;
        this.agentEmail = agentEmail;
        this.idDepto = idDepto;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setAgentLName(String agentLName) {
        this.agentLName = agentLName;
    }

    public void setAgentMName(String agentMName) {
        this.agentMName = agentMName;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public void setIdDepto(int idDepto) {
        this.idDepto = idDepto;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getAgentLName() {
        return agentLName;
    }

    public String getAgentMName() {
        return agentMName;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public int getIdDepto() {
        return idDepto;
    }
}
