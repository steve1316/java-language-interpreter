package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class StoreCode extends ByteCode
{
    private String arguments = "";
    private String variableName = "";

    public void init(ArrayList<String> args)
    {
        arguments = args.get(0);

        if(args.size() == 2)
        {
            variableName = args.get(1);
        }
    }

    public void execute(VirtualMachine vm)
    {
        vm.store(Integer.parseInt(arguments));
    }

    public String toString()
    {
        String myString = "STORE " + arguments;
        if(!variableName.equalsIgnoreCase(""))
        {
            myString.concat(" " + variableName + " " + variableName + " = " + arguments);
        }
        return myString;
    }
}
