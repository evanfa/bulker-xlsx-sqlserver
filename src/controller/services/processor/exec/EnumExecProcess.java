package controller.services.processor.exec;

import controller.services.processor.ProcessObject;

public enum EnumExecProcess implements ProcessObject {
    INSERT {
        @Override
        public boolean insertToDatabase(Object itemObject, String tableDestination) {
            return false;
        }

        @Override
        public boolean deleteFromDatabase(int idObjectRow, String tableDestination) {
            return false;
        }

        @Override
        public boolean updateRecordDatabase(Object itemObject) {
            return false;
        }
    },
    DELETE {
        @Override
        public boolean deleteFromDatabase(int idObjectRow, String tableDestination) {
            return false;
        }

        @Override
        public boolean insertToDatabase(Object itemObject, String tableDestination) {
            return false;
        }

        @Override
        public boolean updateRecordDatabase(Object itemObject) {
            return false;
        }
    },
    UPDATE {
        @Override
        public boolean updateRecordDatabase(Object itemObject) {
            return false;
        }

        @Override
        public boolean insertToDatabase(Object itemObject, String tableDestination) {
            return false;
        }

        @Override
        public boolean deleteFromDatabase(int idObjectRow, String tableDestination) {
            return false;
        }
    };
}
