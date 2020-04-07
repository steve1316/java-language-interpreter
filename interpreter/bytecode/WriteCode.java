package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class WriteCode extends ByteCode
{
    public void init(ArrayList<String> args) {}

    public void execute(VirtualMachine vm)
    {
        //Peek at the top of the runTimeStack and prints it to the console.
        int operand = vm.peek();
        String output = Integer.toString(operand);
        System.out.println(output);
    }

    public String toString()
    {
        String myString = "WRITE";
        return myString;
    }
}
