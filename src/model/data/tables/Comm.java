package model.data.tables;

import controller.utils.Regex_Utility;
import vault.global.vars.GlobalVarsValues;

public class Comm {
    private String idCom;
    private String dateCom;
    private String dateRecepit;
    private String typeCom;
    private String subjectCom;
    private String author;
    private String received;
    private String descriptionCom;
    private String referencesCom;

    public Comm(String idCom, String dateCom, String dateRecepit, String typeCom, String subjectCom, String author, String received, String descriptionCom, String referencesCom) {
        this.idCom = idCom;
        this.dateCom = dateCom;
        this.dateRecepit = dateRecepit;
        this.typeCom = typeCom;
        this.subjectCom = subjectCom;
        this.author = author;
        this.received = received;
        this.descriptionCom = descriptionCom;
        this.referencesCom = referencesCom;
    }

    public Comm() {
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIdCom() {
        return idCom;
    }

    public void setIdCom(String idCom) {
        this.idCom = idCom;
    }

    public String getDateCom() {
        return dateCom;
    }

    public void setDateCom(String dateCom) {
        if (!dateCom.equals(null)) {
            String tempValidityDate;
            if (Regex_Utility.isRegexContainedIntoSingleString(GlobalVarsValues.REGEX_DATE_OK, dateCom)) {
                this.dateCom = dateCom;
            } else {
                tempValidityDate = Regex_Utility.fixEnglishDateFormatToSQLDateFormat(dateCom);
                //System.out.println("Date Result: " + tempValidityDate);
                this.dateCom = tempValidityDate;
            }
            //this.dateCom = dateCom;
        } else {
            this.dateCom = "";
        }
    }

    public String getDateRecepit() {
        return dateRecepit;
    }

    public void setDateRecepit(String dateRecepit) {
        System.out.println("Input Date Recepit: " + dateRecepit);
        if (dateRecepit != null) {
            String tempValidityDate;
            if (Regex_Utility.isRegexContainedIntoSingleString(GlobalVarsValues.REGEX_DATE_OK, dateRecepit)) {
                this.dateRecepit = dateRecepit;
            } else {
                tempValidityDate = Regex_Utility.fixEnglishDateFormatToSQLDateFormat(dateRecepit);
                System.out.println("Date Result: " + tempValidityDate);
                this.dateRecepit = tempValidityDate;
            }
        } else {
            this.dateRecepit = "";
        }
        // this.dateRecepit = dateRecepit;
    }

    public String getTypeCom() {
        return typeCom;
    }

    public void setTypeCom(String typeCom) {
        this.typeCom = typeCom;
    }

    public String getSubjectCom() {
        return subjectCom;
    }

    public void setSubjectCom(String subjectCom) {
        this.subjectCom = subjectCom;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getDescriptionCom() {
        return descriptionCom;
    }

    public void setDescriptionCom(String descriptionCom) {
        this.descriptionCom = descriptionCom;
    }

    public String getReferencesCom() {
        return referencesCom;
    }

    public void setReferencesCom(String referencesCom) {
        this.referencesCom = referencesCom;
    }
}
