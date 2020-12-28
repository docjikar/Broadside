/*
Author: Robert Beery III

Description: A simple computer player to play against.

 */

package Broadside;

public class ComputerPlayer implements BroadsidePlayer
{

    @Override
    public void exchangeDie(Hand hand)
    {
        hand.runnerExchange(3);
        //computerAiAlgorithm(hand);
    }
}
