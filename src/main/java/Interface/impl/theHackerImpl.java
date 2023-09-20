package Interface.impl;

import Interface.theHacker;

public class theHackerImpl implements theHacker {

    @Override
    public void DoIt(String theRealMan) {
        System.out.println(theRealMan+"：黑客松去做吧！");
    }
}
