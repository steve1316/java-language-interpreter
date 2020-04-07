package interpreter;

import interpreter.bytecode.*;
import interpreter.bytecode.JumpCode;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs()
    {
        int i = 0;

        HashMap<String,Integer> mapForLabels = new HashMap<>();

        //Loop and save all the Labels into a HashMap with their corresponding line number i.
        for(ByteCode myLabelCodes : program)
        {
            if(myLabelCodes instanceof LabelCode)
            {
                String tempLabel = ((LabelCode)myLabelCodes).getLabel();
                mapForLabels.put(tempLabel, i);
            }
            i++;
        }

        //Now loop again and replace all the target labels next to any instances of JumpCode (GotoCode, CallCode,
        // and FalseBranchCode) with the target address so the program can properly jump to the correct Label.
        for(ByteCode myJumpCodes : program)
        {
            if(myJumpCodes instanceof JumpCode)
            {
                String targetLabel = ((JumpCode)myJumpCodes).getLabel();
                //Grab the target address from the last for loop above with the given key string targetLabel.
                int targetAddress = mapForLabels.get(targetLabel);
                //Set the target address in the correct child class of JumpCode.
                ((JumpCode)myJumpCodes).setAddr(targetAddress);
            }
        }
    }

    public void setByteCodes(ByteCode myByteCode)
    {
        program.add(myByteCode);
    }
}
