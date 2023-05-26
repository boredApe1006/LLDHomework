package Microprocessor.command;

import Microprocessor.database.DBAccessor;
import Microprocessor.model.Microprocessor;

public class AddCommand implements Command{

    int value;
    int microprocessorId;
    int registerId;

    public AddCommand(int value, int microprocessorId, int registerId) {
        this.value = value;
        this.microprocessorId = microprocessorId;
        this.registerId = registerId;
    }

    @Override
    public boolean execute() {
        Microprocessor microprocessor = DBAccessor.getMicroprocessorWithId(microprocessorId);
        int oldValue = microprocessor.getValueOfRegister(registerId);
        microprocessor.updateRegister(registerId , oldValue + value);
        DBAccessor.updateMicroprocessor(microprocessor);
    }
}
