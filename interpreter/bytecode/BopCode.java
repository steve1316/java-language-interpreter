package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class BopCode extends ByteCode
{
    private String arguments = "";

    public void init(ArrayList<String> args)
    {
        //We set the first argument in the arraylist to the arguments string.
        arguments = args.get(0);
    }

    public void execute(VirtualMachine vm)
    {
        if(arguments.equalsIgnoreCase("+"))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = operand1 + operand2;
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase("-"))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = operand1 - operand2;
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase("*"))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = operand1 * operand2;
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase("/"))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = operand1 / operand2;
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase("=="))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = 0;
            if(operand1 == operand2)
            {
                result = 1;
            }
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase("=="))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = 0;
            if(operand1 != operand2)
            {
                result = 1;
            }
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase("<="))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = 0;
            if(operand1 <= operand2)
            {
                result = 1;
            }
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase(">="))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = 0;
            if(operand1 >= operand2)
            {
                result = 1;
            }
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase(">"))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = 0;
            if(operand1 > operand2)
            {
                result = 1;
            }
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase("<"))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = 0;
            if(operand1 < operand2)
            {
                result = 1;
            }
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase("|"))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = 0;
            if(operand1 == 1 || operand2 == 1)
            {
                result = 1;
            }
            vm.push(result);
        }
        else if(arguments.equalsIgnoreCase("&"))
        {
            //Pop the top 2 operands of the stack of RunTimeStack.
            int operand2 = vm.pop();
            int operand1 = vm.pop();
            //And then calculate the result and then push the result back onto the RunTimeStack.
            int result = 0;
            if(operand1 == 1 && operand2 == 1)
            {
                result = 1;
            }
            vm.push(result);
        }
    }

    public String toString()
    {
        //Return the ByteCode and its arguments as a string.
        String myString = "BOP " + arguments;
        return myString;
    }
}
