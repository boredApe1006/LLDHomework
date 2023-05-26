package Microprocessor.command;

import Microprocessor.database.DBAccessor;
import Microprocessor.model.Microprocessor;

public class SetCommand implements Command {

    private int microprocessorId;
    private int registerId;

    private int value;

    public SetCommand(int microprocessorId, int registerId1, int value) {
        this.microprocessorId = microprocessorId;
        this.registerId = registerId1;
        this.value = value;
    }


    @Override
    public boolean execute() {
        Microprocessor microprocessor = DBAccessor.getMicroprocessorWithId(microprocessorId);
        microprocessor.updateRegister(registerId , value);
        DBAccessor.updateMicroprocessor(microprocessor);
    }
}
