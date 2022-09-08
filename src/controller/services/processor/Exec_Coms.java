package controller.services.processor;

import controller.apache.poi.POIDataset;
import controller.utils.DB_Utility;
import controller.utils.Regex_Utility;
import model.data.tables.TBL_Comm;
import org.apache.poi.ss.usermodel.*;
import vault.global.vars.GlobalVarsValues;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class Exec_Coms {

    private final String verifyQry = "SELECT COUNT(*) FROM [" + GlobalVarsValues.DEFAULT_BD_NAME + "].[dbo]." + GlobalVarsValues.DEFAULT_TABLE_COMS;
    private final String insertQry = "INSERT INTO [dbo].[" + GlobalVarsValues.DEFAULT_TABLE_COMS + "](idfile,date_com,date_recipt,type_com,subject_com,author,received_ori,desc_com,references_com) VALUES (";
    private final int currentTab = 0;
    private DB_Utility DbUtility;
    private int noOfColumns = 0;
    private boolean validRecord = false;

    public Exec_Coms() throws ClassNotFoundException, SQLException {
        TBL_Comm permitItem = new TBL_Comm();

        File directoryPath = new File(GlobalVarsValues.DEFAULT_PATH_COMS);
        String[] contents = directoryPath.list();

        if (contents.length > 0) {
            if (DB_Utility.executeTableVerification(GlobalVarsValues.DEFAULT_BD_NAME, GlobalVarsValues.DEFAULT_TABLE_REPORT)) {

                Connection currentConnection = DB_Utility.startConnection_WAuth(GlobalVarsValues.DEFAULT_BD_NAME);
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Statement stmt = currentConnection.createStatement();
                ResultSet rs = stmt.executeQuery(verifyQry);

                try {
                    for (String item : contents) {
                        int lastIndexOf = item.lastIndexOf(".");

                        if (item.substring(lastIndexOf).equals(".xls") || item.substring(lastIndexOf).equals(".xlsx")) {
                            File tempFile = new File(GlobalVarsValues.DEFAULT_PATH_COMS + item);
                            System.out.println("Current File: " + tempFile);

                            Workbook workbook = WorkbookFactory.create(tempFile);
                            Sheet firstSheet = workbook.getSheetAt(currentTab);
                            Iterator<Row> iterator = firstSheet.iterator();

                            noOfColumns = firstSheet.getRow(6).getPhysicalNumberOfCells();

                            System.out.println("Columns Found: " + noOfColumns);

                            if (noOfColumns != 0) {
                                while (iterator.hasNext()) {
                                    Row nextRow = iterator.next();
                                    Iterator<Cell> cellIterator = nextRow.cellIterator();

                                    while (cellIterator.hasNext()) {
                                        Cell cell = cellIterator.next();

                                        if (cell.getRowIndex() >= 7) {
                                            if (cell.getColumnIndex() == 0) {
                                                setValidRecord(Regex_Utility.isRegexContainedIntoSingleString(GlobalVarsValues.REGEX_META_COM, cell.toString()));
                                            }

                                            if (isValidRecord() && cell.getColumnIndex() <= noOfColumns) {
                                                switch (cell.getColumnIndex()) {
                                                    case 0:
                                                        permitItem.setIdCom(POIDataset.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 1:
                                                        permitItem.setDateCom(POIDataset.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 2:
                                                        permitItem.setDateRecepit(POIDataset.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 3:
                                                        permitItem.setTypeCom(POIDataset.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 4:
                                                        permitItem.setSubjectCom(POIDataset.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 5:
                                                        permitItem.setAuthor(POIDataset.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 6:
                                                        permitItem.setReceived(POIDataset.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 7:
                                                        permitItem.setDescriptionCom(POIDataset.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 8:
                                                        permitItem.setReferencesCom(POIDataset.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                }
                                            }
                                        }
                                    }

                                    if (isValidRecord()) {
                                        String query = insertQry + "'" +
                                                permitItem.getIdCom() + "','" +
                                                permitItem.getDateCom() + "','" +
                                                permitItem.getDateRecepit() + "','" +
                                                permitItem.getTypeCom() + "','" +
                                                permitItem.getSubjectCom() + "','" +
                                                permitItem.getAuthor() + "','" +
                                                permitItem.getReceived() + "','" +
                                                permitItem.getDescriptionCom() + "','" +
                                                permitItem.getReferencesCom() + "')";

                                        System.out.println("Query: " + query);
                                        DB_Utility.executeInsertWithKeys(currentConnection, query);
                                    }
                                    rs.close();
                                    stmt.closeOnCompletion();
                                }
                            }//IF of validation to firt column
                        } else {
                            //System.out.println(">> "+Db_Utility.TestTableExist_JDBC("AGENTS"));
                            JOptionPane.showMessageDialog(null, "Table " + GlobalVarsValues.DEFAULT_TABLE_REPORT + " is not present in current database. Verify.", "Table not found", JOptionPane.ERROR_MESSAGE);
                        }
                    }//for

                } catch (IOException e) {
                    e.printStackTrace();
                    currentConnection.close();
                }
            }
        } else {
            //System.out.println(">> "+Db_Utility.TestTableExist_JDBC("AGENTS"));
            JOptionPane.showMessageDialog(null, "No files in folder: " + GlobalVarsValues.DEFAULT_PATH_COMS + ". Verify.", "Files not found", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isValidRecord() {
        return this.validRecord;
    }

    private void setValidRecord(boolean validRec) {
        this.validRecord = validRec;
    }


}
