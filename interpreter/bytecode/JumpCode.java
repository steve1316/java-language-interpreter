package interpreter.bytecode;

public abstract class JumpCode extends ByteCode
{
    //setAddr will set the next bytecode that the program will jump to as indicated by the targetAddress.
    public abstract void setAddr(int targetAddress);

    public abstract String getLabel();
}
