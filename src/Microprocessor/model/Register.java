package Microprocessor.model;

public class Register {

    public final int id;
    public int val;

    public Register(int id, int val) {
        this.id = id;
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
