package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {
    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump()
    {
        //If there is only one frame in the runTimeStack, just print it out and eliminate all the spaces.
        if(framePointer.size() == 1)
        {
            System.out.println(runTimeStack.toString().replaceAll(" ", ""));
        }
        else
        {
            //Create two iterators from the runTimeStack and the framePointer stacks.
            Iterator runStackIterator = runTimeStack.iterator();
            Iterator frameStackIterator = framePointer.iterator();
            //Set the stopAtCurrentFrame integer to the frame's end.
            int stopAtCurrentFrame = (Integer)frameStackIterator.next();

            System.out.print("[");

            //For loop will go through each runTimeStack element until it reaches the end.
            for(int i = 1; runStackIterator.hasNext(); i++)
            {
                //Set the next element of the runTimeStack into runStackCurrentElement.
                int runStackCurrentElement = (Integer)runStackIterator.next();
                //If the runTimeStack has another element and if the count is not equal to the end
                // of the current frame, print out the current element and a comma for the next element.
                if(runStackIterator.hasNext() && i != stopAtCurrentFrame)
                {
                    System.out.print(runStackCurrentElement + ",");
                }
                //If we reached the end of the runTimeStack but we haven't reached the end of the current
                // frame, print out the runTimeStack's last element.
                else if(!runStackIterator.hasNext() && i != stopAtCurrentFrame)
                {
                    System.out.print(runStackCurrentElement);
                }
                //If the runTimeStack has another element and we have reached the end of the current frame,
                // print out the runTimeStack's element and then the loop will begin printing out the next frame.
                else if(runStackIterator.hasNext() && i == stopAtCurrentFrame)
                {
                    System.out.print(runStackCurrentElement);
                }
                //If we have reached the end of the current frame, close it off and then prep for the next frame.
                if(i == stopAtCurrentFrame)
                {
                    System.out.print("] [");
                    //This if statement is just to make sure that there is another frame right after this.
                    if(frameStackIterator.hasNext())
                    {
                        stopAtCurrentFrame = (Integer)frameStackIterator.next();
                    }
                }
            }

            System.out.print("]\n");
        }
    }

    public int peek()
    {
        //Copy the value at the top of runTimeStack and return it.
        int tempRunTime = runTimeStack.get(runTimeStack.size() - 1);
        return tempRunTime;
    }

    public Integer push(Integer val)
    {
        //Push the given integer to the top of runTimeStack.
        runTimeStack.add(val);
        return val;
    }

    public int pop()
    {
        if(runTimeStack.size() > 1)
        {
            //Simply save the value at the top of the runTimeStack, pop it off, and then return it.
            int savedValue = runTimeStack.get(runTimeStack.size() - 1);
            runTimeStack.remove(runTimeStack.size() - 1);
            return savedValue;
        }
        else
        {
            if(!runTimeStack.isEmpty())
            {
                runTimeStack.remove(runTimeStack.size() - 1);
                return 0;
            }
            else
            {
                return 0;
            }
        }
    }

    public void newFrameAt(int offset)
    {
        //Create a new frame at the position of its first value and right above the
        // previous frame's last number in the runTimeStack.
        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame()
    {
        //Save the value or the returned value at the top of runTimeStack.
        int savedValue = runTimeStack.get(runTimeStack.size() - 1);

        //While the size of runTimeStack is not equal to that frame's size in framePointer,
        // keep removing from the runTimeStack until you reach the end of that frame.
        while(runTimeStack.size() != framePointer.peek())
        {
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        //Finalize the removal of the frame.
        framePointer.pop();
        //Now push back the saved value or the returned value onto the runTimeStack.
        runTimeStack.add(savedValue);
    }

    public int store(int offset)
    {
        if(runTimeStack.isEmpty())
        {
            return 0;
        }
        //Save the value at the top of runTimeStack.
        int savedValue = runTimeStack.get(runTimeStack.size() - 1);
        //Now remove it from the top of runTimeStack.
        runTimeStack.remove(runTimeStack.size() - 1);
        //Replace the saved value at the location inside the current frame plus the offset.
        runTimeStack.set(framePointer.peek() + offset, savedValue);
        return savedValue;
    }

    public int load(int offset)
    {
        if(runTimeStack.isEmpty())
        {
            return 0;
        }
        int savedValue = runTimeStack.get(framePointer.peek() + offset);
        //Now place the saved value at the top of runTimeStack.
        runTimeStack.add(savedValue);
        return savedValue;
    }
}
