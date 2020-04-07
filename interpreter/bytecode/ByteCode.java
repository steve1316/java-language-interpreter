package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public abstract class ByteCode
{
    //Hides the functionality of these 2 methods by making them abstract and
    // also ensures that all ByteCodes have execute and init methods in them.
    public abstract void execute(VirtualMachine vm);

    public abstract void init(ArrayList<String> args);
}
