package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode
{
    private String arguments = "";

    public void init(ArrayList<String> args)
    {
        arguments = args.get(0);
    }

    public void execute(VirtualMachine vm)
    {
        //Turn the dump state on if the given argument matches the string below. If not, turn it off.
        if(arguments.equalsIgnoreCase("ON"))
        {
            vm.turnDumpOn();
        }
        else
        {
            vm.turnDumpOff();
        }
    }

    public String toString()
    {
        String myString = "DUMP " + arguments;
        return myString;
    }
}
