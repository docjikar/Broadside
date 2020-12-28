package Broadside;

import java.util.ArrayList;
import java.util.Collections;

public class BroadsideGame
{
    private BroadsidePlayer comPlayer;
    private BroadsidePlayer humPlayer;
    private ArrayList<Integer> comPlayerScore;
    private ArrayList<Integer> humPlayerScore;

    public BroadsideGame(BroadsidePlayer p1, ArrayList<Integer> play1Score, BroadsidePlayer p2, ArrayList<Integer> play2Score)
    {
        comPlayer = p2;
        humPlayer = p1;
        humPlayerScore = play1Score;
        comPlayerScore = play2Score;
    }

    public void playRound()
    {
        Hand humPlayerHand = new Hand();
        Hand comPlayerHand = new Hand();

        System.out.println();
        System.out.println("Index:         1, 2, 3, 4");
        System.out.print("-------------------------\n");
        System.out.println("Player   " + humPlayerHand);
        System.out.println("Computer " + comPlayerHand);


        // Each player is vying for the best lowest score they can get. But the highest score goes first.
        while(CompareHands(humPlayerHand, comPlayerHand))
        {
            if (humPlayerHand.score() > comPlayerHand.score())
            {
                humPlayer.exchangeDie(humPlayerHand);
                comPlayer.exchangeDie(comPlayerHand);
            }
            else if (humPlayerHand.score() < comPlayerHand.score())
            {
                comPlayer.exchangeDie(comPlayerHand);
                humPlayer.exchangeDie(humPlayerHand);
            }
            else
            {
                break;
            }

            comPlayerHand.runnerRoller();
            humPlayerHand.runnerRoller();

            System.out.println();
            System.out.println("Index:         1, 2, 3, 4");
            System.out.print("-------------------------\n");
            System.out.println("Player   " + humPlayerHand);
            System.out.println("Computer " + comPlayerHand);
        }

        // This is where we decide on the winner of the best lowest score. When there are no more matches between the
        // die in each hand. The lowest score wins the round and adds their score to their collection of 6 scores. this
        // collection is added up at the end of the game. the highest number wins.
        if(comPlayerHand.score() < humPlayerHand.score())
        {
            if(comPlayerScore.size() == 3 /*7*/ )
            {
                Collections.sort(comPlayerScore);
                humPlayerScore.add(comPlayerScore.remove(-1));
                comPlayerScore.add(comPlayerHand.score());
            }
            else
            {
                comPlayerScore.add(comPlayerHand.score());
            }
        }
        else if(comPlayerHand.score() > humPlayerHand.score())
        {
            if(humPlayerScore.size() == 3 /*7*/ )
            {
                Collections.sort(humPlayerScore);
                comPlayerScore.add(humPlayerScore.remove(-1));
                humPlayerScore.add(comPlayerHand.score());
            }
            else
            {
                humPlayerScore.add(humPlayerHand.score());
            }
        }
        else
        {
            rollOff(humPlayerHand, humPlayerScore, comPlayerHand, comPlayerScore);

            System.out.println();
            System.out.println("Index:         1, 2, 3, 4");
            System.out.println("-------------------------");
            System.out.println("Player   " + humPlayerHand);
            System.out.println("Computer " + comPlayerHand);

            return;
        }


    }

    public Boolean CompareHands(Hand hand1, Hand hand2)
    {
        Boolean matching = false;
        for(int i = 0; i<4; i++)
        {
            if(hand1.get(i).getLastRoll().equals(6) || hand2.get(i).getLastRoll().equals(6))
            {
                matching = false;
            }
            else if(hand1.get(i).getLastRoll().equals(5) || hand2.get(i).getLastRoll().equals(5))
            {
                matching = false;
            }
            else if(hand1.get(i).getLastRoll().equals(hand2.get(i).getLastRoll()))
            {
                matching = true;
                break;
            }


        }
        return matching;

    }

    public void rollOff(Hand hand1, ArrayList<Integer> hand1Score, Hand hand2, ArrayList<Integer> hand2Score)
    {
        hand1.runnerRoller();
        hand2.runnerRoller();

        while(hand1.runner().getLastRoll().equals(hand2.runner().getLastRoll()))
        {
            hand1.runnerRoller();
            hand2.runnerRoller();
        }

        if(hand1.runner().getLastRoll() > hand2.runner().getLastRoll())
        {
            hand1.orderHand();
            hand1Score.add(hand1.score());
        }
        else
        {
            hand2.orderHand();
            hand2Score.add(hand2.score());
        }
    }
}
