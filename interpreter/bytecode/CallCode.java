package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class CallCode extends JumpCode
{
    private String label = "";
    public int targetAddress = 0;
    private String myString = "";

    public void init(ArrayList<String> args) { label = args.get(0); }

    public void execute(VirtualMachine vm)
    {
        vm.pushReturnAddress(vm.getPC());
        vm.setPC(targetAddress);

        //Split up the arguments string by the appearance of the "<" character so I can parse the base ID of the function.
        String[] baseIDSplit = label.split("<");
        String baseID = baseIDSplit[0];
        if(baseIDSplit.length != 1)
        {
            //Grabs the element that contains the number and parses it to the string callArg.
            String baseID2 = baseIDSplit[2];
            String callArg = String.valueOf(baseID2.charAt(0));

            myString = "CALL " + label + " " + baseID + "(" + vm.getPreviousARGS() + "," + callArg + ")";
        }
        //If there was no Base ID provided with CALL, just append the label to the string.
        else
        {
            myString = "CALL " + label;
        }
    }

    public String getLabel()
    {
        return label;
    }

    public String toString()
    {
        return myString;
    }

    public void setAddr(int address)
    {
        this.targetAddress = address;
    }
}
