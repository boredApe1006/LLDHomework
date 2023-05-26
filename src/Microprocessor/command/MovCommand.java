package Microprocessor.command;

import Microprocessor.database.DBAccessor;
import Microprocessor.model.Microprocessor;

public class MovCommand implements Command {
    private int microprocessorId;
    private int registerId1;
    private int registerId2;

    public MovCommand(int microprocessorId, int registerId1, int registerId2) {
        this.microprocessorId = microprocessorId;
        this.registerId1 = registerId1;
        this.registerId2 = registerId2;
    }

    @Override
    public boolean execute() {
        Microprocessor microprocessor = DBAccessor.getMicroprocessorWithId(microprocessorId);

        int value = microprocessor.getValueOfRegister(registerId2);
        microprocessor.updateRegister(registerId1 , value);
        DBAccessor.updateMicroprocessor(microprocessor);
    }
}
