package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class FalseBranchCode extends JumpCode
{
    private String label = "";
    int targetAddress = 0;

    public void init(ArrayList<String> args) { label = args.get(0); }

    public void execute(VirtualMachine vm)
    {
        //If the pop failed, jump to the label provided.
        if(vm.pop() == 0)
        {
            vm.setPC(targetAddress);
        }
    }

    public void setAddr(int address) { this.targetAddress = address; }

    public String getLabel() { return label; }

    public String toString()
    {
        String myString = "FALSEBRANCH " + label;
        return myString;
    }
}
