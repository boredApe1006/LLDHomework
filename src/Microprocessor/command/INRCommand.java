package Microprocessor.command;

import Microprocessor.database.DBAccessor;
import Microprocessor.model.Microprocessor;

public class INRCommand implements Command {

    private int microprocessorId;
    private int registerId1;

    public INRCommand(int microprocessorId, int registerId1) {
        this.microprocessorId = microprocessorId;
        this.registerId1 = registerId1;
    }


    @Override
    public boolean execute() {
        Microprocessor microprocessor = DBAccessor.getMicroprocessorWithId(microprocessorId);
        int oldValue = microprocessor.getValueOfRegister(registerId1);
        microprocessor.updateRegister(registerId1 , oldValue + 1);
        DBAccessor.updateMicroprocessor(microprocessor);
    }
}
