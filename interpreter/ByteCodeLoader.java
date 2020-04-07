package interpreter;

import interpreter.bytecode.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ByteCodeLoader extends Object
{
    private BufferedReader byteSource;
    private String line;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException { this.byteSource = new BufferedReader(new FileReader(file)); }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes()
    {
        //Instantiate a new Program object and a new ArrayList to hold any arguments that came with the given ByteCode.
        Program myProgram = new Program();
        ArrayList<String> myArgs = new ArrayList<>();

        //Prep the String line for the first run of the while loop inside of a try block. If any exception occurs, prompt the error and move on.
        try
        {
            line = byteSource.readLine();

            //Keep reading from the file until the program reads all the ByteCodes and their arguments.
            while(line != null)
            {
                //Clear the myArgs arraylist for the upcoming new ByteCode.
                myArgs.clear();
                StringTokenizer myStringTokens = new StringTokenizer(line);

                //Set className to a matched class name according to the token from myStringTokens.
                String className = CodeTable.getClassName(myStringTokens.nextToken());

                if(className != null)
                {
                    //After taking the ByteCode, see if there is any more arguments that accompanied the ByteCode and add them to myArgs arraylist.
                    while(myStringTokens.hasMoreTokens())
                    {
                        myArgs.add(myStringTokens.nextToken());
                    }

                    //After getting the correct class name, create the class here.
                    Class myNewClass = Class.forName("interpreter.bytecode." + className);
                    //Create an instance of the ByteCode for the given class blueprint
                    ByteCode myNewByteCode = (ByteCode) myNewClass.getDeclaredConstructor().newInstance();
                    //and then send any args to the newly constructed ByteCode.
                    myNewByteCode.init(myArgs);

                    //Add the new ByteCode into my program arraylist.
                    myProgram.setByteCodes(myNewByteCode);

                    //Preps the string line for the next iteration of the while loop even if the next line is null.
                    line = byteSource.readLine();
                }
            }
        }catch(Exception e)
        {
            System.out.println("Error: " + e);
        }

        //Resolve addresses here before returning this program.
        myProgram.resolveAddrs();

        return myProgram;
    }
}
