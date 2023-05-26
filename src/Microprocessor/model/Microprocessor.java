package Microprocessor.model;

import java.util.List;

public class Microprocessor {

    public final int id;
    public final List<Register> registers;

    public Microprocessor(int id, List<Register> registers) {
        this.id = id;
        this.registers = registers;
    }
    public int getValueOfRegister(int rid) {
        return registers.get(rid).getVal();
    }

    public void updateRegister(int registerId, int value) {
       Register register = registers.get(registerId);
       register.setVal(value);
    }
}
