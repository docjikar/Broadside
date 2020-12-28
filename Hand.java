/*
Author: Robert Beery III

Description: a hand for the dice game Broadside. this contains three dice for the main hand, a runner (which is
             usually the lowest value dice), and a way to exchange the runner with any die in the main hand.

 */


package Broadside;

import java.util.ArrayList;

public class Hand extends ArrayList<Die>
{
    private ArrayList<Die> hand = new ArrayList<Die>();

    public Hand()
    {
        hand.clear();
        for(int i=0; i < 4; i++){ hand.add(new Die());}
        orderHand();
    }

    public void orderHand()
    {
        hand.sort( new DieComparator() );

    }

    public Die runner()
    {
        return hand.get(3);
    }

    public void runnerExchange(Integer handIndex)
    {
        Die dieFromHand = hand.get(handIndex);
        Die oldRunner = hand.get(3);
        hand.set(handIndex, oldRunner);
        hand.remove(3);
        orderHand();
        hand.add(dieFromHand);
    }

    public void runnerRoller()
    {
        Die newRunner = new Die();
        hand.set(3, newRunner);
    }

    public Integer score()
    {
        Integer totalScore = 0;
        for(int i = 0; i<=2; i++)
        {
            totalScore += hand.get(i).getLastRoll();
        }
        return totalScore;
    }

    @Override
    public String toString()
    {
        return "Hand: " + hand.get(0) + ", " + hand.get(1) + ", " + hand.get(2) + ", " + hand.get(3) ;
    }

    @Override
    public Die get(int index)
    {
        return hand.get(index);
    }
}
