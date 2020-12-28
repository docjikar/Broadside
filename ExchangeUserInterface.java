/*
Author: Robert Beery III

Description: A user interface for exchanging the runner die for another die in the main hand.

 */

package Broadside;

import java.util.Scanner;

public class ExchangeUserInterface
{
    public ExchangeUserInterface(Hand hand)
    {
        Integer index = -1;

        Scanner exchangeQuery = new Scanner(System.in);
        System.out.println("Would you like to exchange your Runner? Answer 'yes' or 'no' ");

        String exchangeAnswer = exchangeQuery.nextLine();
        if (yesOrNo(exchangeAnswer))
        {
            Scanner whichOne = new Scanner(System.in);
            System.out.println("Which index (1-3) would you like to exchange with your runner?");

            index = whichOne.nextInt();
            index -= 1;
        }
        else {index = 3;}

        hand.runnerExchange(index);
    }


    public Boolean yesOrNo(String yesOrNo)
    {
        Boolean isTrueOrFalse = true;
        if(yesOrNo.equals( "no" )){isTrueOrFalse = false;}

        return isTrueOrFalse;
    }
}
