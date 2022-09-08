package controller.services.processor;

public interface ProcessObject {
    boolean insertToDatabase(Object itemObject, String tableDestination);

    boolean deleteFromDatabase(int idObjectRow, String tableDestination);

    boolean updateRecordDatabase(Object itemObject);
}
