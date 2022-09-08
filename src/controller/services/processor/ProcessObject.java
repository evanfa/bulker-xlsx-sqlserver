package controller.services.processor;
public interface ProcessObject {
    boolean executeInsertQuery(Object itemObject, String tableDestination);
}
