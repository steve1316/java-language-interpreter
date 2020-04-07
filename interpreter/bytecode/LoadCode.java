package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LoadCode extends ByteCode
{
    private String arguments = "";

    private String variableName = "";

    public void init(ArrayList<String> args)
    {
        arguments = args.get(0);
        //If the variable name was provided, save it into variableName.
        if(args.size() > 1){
            variableName = args.get(1);
        }
    }

    public void execute(VirtualMachine vm)
    {
        vm.load(Integer.parseInt(arguments));
    }

    public String toString()
    {
        String myString = "LOAD " + arguments;
        if(variableName != "")
        {
            myString = "LOAD " + arguments + " " + variableName + " <load " + variableName + ">";
        }
        return myString;
    }
}
