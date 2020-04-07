package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ArgsCode extends ByteCode
{
    private String arguments = "";

    public void init(ArrayList<String> args) { arguments = args.get(0); }

    public void execute(VirtualMachine vm)
    {
        vm.newFrameAt(Integer.parseInt(arguments));
        vm.setPreviousARGS(Integer.parseInt(arguments));
    }

    public String toString()
    {
        String myString = "ARGS " + arguments;
        return myString;
    }
}
