package controller.services.processor;

/*
Testing Process Object in order to implement a single insert query
 */
public interface ProcessObject {
    boolean executeInsertQuery(Object itemObject, String tableDestination);
}
