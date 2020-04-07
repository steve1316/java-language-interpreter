package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class GotoCode extends JumpCode
{
    private String label = "";
    int targetAddress = 0;

    public void init(ArrayList<String> args) { label = args.get(0); }

    public void execute(VirtualMachine vm)
    {
        vm.setPC(targetAddress);
    }

    public void setAddr(int address) { this.targetAddress = address; }

    public String getLabel() { return label; }

    public String toString()
    {
        String myString = "GOTO " + label;
        return myString;
    }
}
