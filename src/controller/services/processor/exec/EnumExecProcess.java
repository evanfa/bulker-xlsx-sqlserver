package controller.services.processor.exec;

import controller.services.processor.ProcessObject;

public enum EnumExecProcess implements ProcessObject {
    PERMIT {
        @Override
        public boolean executeInsertQuery(Object itemObject, String tableDestination) {

            return false;
        }
    },
    COMMS {
        @Override
        public boolean executeInsertQuery(Object itemObject, String tableDestination) {
            return false;
        }
    }
}
