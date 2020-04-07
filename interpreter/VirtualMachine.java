package interpreter;

import interpreter.bytecode.*;
import java.util.Stack;


public class VirtualMachine
{
    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumpState = true;
    private int previousARGS = 0;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void setPreviousARGS(int args)
    {
        previousARGS = args;
    }

    public int getPreviousARGS()
    {
        return previousARGS;
    }

    public void executeProgram()
    {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while (isRunning)
        {
            ByteCode code = program.getCode(pc);
            code.execute(this);

            //If the dumpState has been turned on and the bytecode itself is not DumpCode, print out the bytecode by implicitly
            // using its toString() and then run the dump function for the runTimeStack.
            if(dumpState && !(code instanceof DumpCode))
            {
                System.out.println(code);
                runStack.dump();
            }
            //Move on to the next ByteCode stored inside program.
            if(code instanceof CallCode || code instanceof GotoCode)
            {
                pc--;
            }
            pc++;
        }
    }

    public int peek()
    {
        int operand = runStack.peek();
        return operand;
    }

    public int pop()
    {
        int operand = runStack.pop();
        return operand;
    }

    public void push(int val)
    {
        runStack.push(val);
    }

    public int store(int atOffset) { return runStack.store(atOffset); }

    public int load(int atOffset) { return runStack.load(atOffset); }

    public void setRunningState(boolean state)
    {
        isRunning = state;
    }

    public void newFrameAt(int atOffset) { runStack.newFrameAt(atOffset); }

    public void popFrame() { runStack.popFrame(); }

    public int getPC() { return pc; }

    public void setPC(int myPC) { this.pc = myPC; }

    public int popReturnAddress() { return (int)returnAddrs.pop(); }

    public void pushReturnAddress(int returnAddress) { returnAddrs.push(returnAddress); }

    public void turnDumpOn() { dumpState = true; }

    public void turnDumpOff() { dumpState = false; }
}
