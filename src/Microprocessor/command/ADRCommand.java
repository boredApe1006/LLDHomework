package Microprocessor.command;

import Microprocessor.database.DBAccessor;
import Microprocessor.model.Microprocessor;

public class ADRCommand implements Command{

    private int microprocessorId;
    private int registerId1;
    private int registerId2;

    public ADRCommand(int microprocessorId, int registerId1, int registerId2) {
        this.registerId1 = registerId1;
        this.registerId2 = registerId2;
        this.microprocessorId = microprocessorId;
    }


    @Override
    public boolean execute() {
        Microprocessor microprocessor = DBAccessor.getMicroprocessorWithId(microprocessorId);
        int oldValue1 = microprocessor.getValueOfRegister(registerId1);
        int oldValue2 = microprocessor.getValueOfRegister(registerId2);
        microprocessor.updateRegister(registerId1 , oldValue1 + oldValue2);
        DBAccessor.updateMicroprocessor(microprocessor);
    }
}
