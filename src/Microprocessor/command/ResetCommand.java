package Microprocessor.command;

import Microprocessor.database.DBAccessor;
import Microprocessor.model.Microprocessor;
import Microprocessor.model.Register;

public class ResetCommand implements Command{

    private int microprocessorId;

    public ResetCommand(int microprocessorId) {
        this.microprocessorId = microprocessorId;
    }


    @Override
    public boolean execute() {
        Microprocessor microprocessor = DBAccessor.getMicroprocessorWithId(microprocessorId);
        for(Register register: microprocessor.registers) {
            microprocessor.updateRegister(register.getId() , 0);
        }
        DBAccessor.updateMicroprocessor(microprocessor);
    }
}
