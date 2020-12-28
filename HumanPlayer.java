/*
Author: Robert Beery III

Description: a human player with an interface
 */

package Broadside;

public class HumanPlayer implements BroadsidePlayer
{
    @Override
    public void exchangeDie(Hand hand)
    {
        new ExchangeUserInterface(hand);
    }

}
