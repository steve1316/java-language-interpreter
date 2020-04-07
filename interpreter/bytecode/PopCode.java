package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class PopCode extends ByteCode
{
    private String arguments = "";

    public void init(ArrayList<String> args)
    {
        arguments = args.get(0);
    }

    public void execute(VirtualMachine vm)
    {
        int count = Integer.parseInt(arguments);

        //Pop until int i reaches the count provided by the argument string.
        for(int i = 0; i < count; i++)
        {
            vm.pop();
        }
    }

    public String toString()
    {
        String myString = "POP " + arguments;
        return myString;
    }
}
