/*
Author: Robert Beery III

Description: a roll-able 6-sided die for the game Broadside.

*/


package Broadside;

import java.util.Random;

public class Die
{
    private Random generator = new Random( );
    private Integer numSides;
    private Integer lastRoll;

    public Die( )
    {
        this( 6 );
    }

    public Die( Integer n )
    {
        numSides = n;
        roll( );
    }

    public Integer roll( )
    {
        lastRoll = generator.nextInt( numSides ) + 1;
        return lastRoll;
    }

    public Integer getLastRoll( )
    {
        return lastRoll;
    }

    public String toString( )
    {
        return "" + getLastRoll( );
    }

}
