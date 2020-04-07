package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode
{
    private Scanner input = new Scanner(System.in);

    public void init(ArrayList<String> args) {}

    public void execute(VirtualMachine vm)
    {
        //Ask the user to input a number for the tester.
        System.out.println("Enter a number: ");
        int myNumber = input.nextInt();
        vm.push(myNumber);
    }

    public String toString()
    {
        String myString = "READ";
        return myString;
    }
}
