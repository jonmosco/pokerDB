package poker;

import java.util.ArrayList;
import java.util.Collections;

public class PlayHand {
	public static void main(String[] args) {

		//PlayFullHand();
		PlayFiveCardManualDeal();

	}

	private static void PlayFullHand() {
		// Regular five card stud
		Deck dStud = new Deck();
		Hand hStud = new Hand(dStud);

		// Joker five card
		Deck dJoker = new Deck(2);
		Hand hJoker = new Hand(dJoker);

		// Four Wilds five card
		ArrayList<Card> Wilds = new ArrayList<Card>();
		Wilds.add(new Card(eSuit.CLUBS, eRank.TWO));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.TWO));
		Wilds.add(new Card(eSuit.SPADES, eRank.TWO));
		Wilds.add(new Card(eSuit.HEARTS, eRank.TWO));

		Deck dWild = new Deck(0, Wilds);
		Hand hWild = new Hand(dWild);
	}

	private static void PlayFiveCardManualDeal() {
		int iPlayers = 5;

		Deck dStud = new Deck(10);
		ArrayList<Player> players = new ArrayList<Player>();

		//	Add the players, give them empty hands
		for (int i = 0; i < iPlayers; i++) {
			Player p = new Player();
			p.SetPlayerNbr(i+1);			
			p.SetHand(new Hand());
			players.add(p);
		}
	
		//	Five Card in each hand
		for (int i = 0; i < 5; i++) {
			for (Player p: players)
			{
				Hand h = p.GetHand();
				h.setPlayerID(p.GetPlayerID());
				h.AddCardToHand(dStud.drawFromDeck());			
				p.SetHand(h);
			}
		}
		
		//	Handle jokers
		for (Player p: players)
		{
			Hand h = p.GetHand();
			h.HandleJokerWilds();
			p.SetHand(h);
		}		
		
		//	Collect All Hands
		ArrayList<Hand> AllHands = new  ArrayList<Hand>();
		for (Player p: players)
		{
			AllHands.add(p.GetHand());
		}
		
		//	Find the best hand between players
		Collections.sort(AllHands, Hand.HandRank);
		
		System.out.println(AllHands.get(0).getPlayerID() + " is the winner!");
		System.out.println(AllHands.get(0).getHandStrength());
		
		for (Card c : AllHands.get(0).getCards())
		{
			System.out.print(c.getRank());
			System.out.print(" ");
			System.out.print(c.getSuit());
			System.out.print("      ");
		}

	}
	
	
	private static void TexasHoldEm() {
		int iPlayers = 5;

		Deck dStud = new Deck();
		ArrayList<Player> players = new ArrayList<Player>();

		//	Add the players, give them empty hands
		for (int i = 0; i < iPlayers; i++) {
			Player p = new Player();
			p.SetPlayerNbr(i+1);			
			p.SetHand(new Hand());
			players.add(p);
		}
		
		
		//	Two Card in each hand
		for (int i = 0; i < 2; i++) {
			for (Player p: players)
			{
				Hand h = p.GetHand();
				h.setPlayerID(p.GetPlayerID());
				h.AddCardToHand(dStud.drawFromDeck());			
				p.SetHand(h);
			}
		}
		
		//	Draw Community Cards  3 cards.
		ArrayList<Card> Community = new ArrayList<Card>();
		dStud.drawFromDeck();
		Community.add(dStud.drawFromDeck());
		Community.add(dStud.drawFromDeck());
		Community.add(dStud.drawFromDeck());
		
//		Community.add(new Card(eSuit.JOKER,eRank.JOKER));
//		Community.add(new Card(eSuit.JOKER,eRank.JOKER));
//		Hand BestCommunityHand = Hand.EvalHand(Community);
		
		
		for (Player p: players)
		{	Hand playerHand = new Hand();
			if (Community.size() == 3)
			{
				for (Card c : Community)
				{
					playerHand.AddCardToHand(c);
				}
				Hand pHand = p.GetHand();
				for (Card c: pHand.getCards())
				{
					playerHand.AddCardToHand(c);
				}
					
			}

		}
	}
	

}











