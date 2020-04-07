package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LitCode extends ByteCode
{
    private String arguments = "";
    private String variableName = "";

    public void init(ArrayList<String> args)
    {
        arguments = args.get(0);
        //If the variable name was provided, grab it and save it as variableName.
        if(args.size() > 1)
        {
            variableName = args.get(1);
        }
    }

    public void execute(VirtualMachine vm)
    {
        vm.push(Integer.parseInt(arguments));
    }

    public String toString()
    {
        String myString = "LIT " + arguments;
        if(variableName != "")
        {
            myString = "LIT " + arguments + " " + variableName + " int " + variableName;
        }
        return myString;
    }
}
