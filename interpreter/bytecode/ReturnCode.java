package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ReturnCode extends ByteCode
{
    private String arguments = "";
    private String myString = "";

    public void init(ArrayList<String> args)
    {
        if(!(args.size() == 0))
        {
            arguments = args.get(0);
        }
    }

    public void execute(VirtualMachine vm)
    {
        vm.popFrame();
        vm.setPC(vm.popReturnAddress());

        if(arguments == null)
        {
            myString = "RETURN";
        }
        else
        {
            //Split up the arguments string by the appearance of the "<" character so I can parse the base ID of the function.
            String[] baseIDSplit = arguments.split("<");
            String baseID = baseIDSplit[0];
            myString = "RETURN " + arguments + " exit " + baseID + ": " + vm.peek();
        }
    }

    public String toString()
    {
        return myString;
    }
}
