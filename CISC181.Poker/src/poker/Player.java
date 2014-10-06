package poker;
import java.util.*;


public class Player {
	
	private UUID PlayerID;
	private int PlayerNbr;
	private Hand PlayerHand;
	
	
	public UUID GetPlayerID()
	{
		return this.PlayerID;
		
	}
	
	public Player()
	{
		this.PlayerID = UUID.randomUUID();
				
	}
	
	public void SetHand(Hand h)
	{
		PlayerHand = h;
	}
	
	public Hand GetHand()
	{
		return PlayerHand;
	}	

	public void SetPlayerNbr(int PlayerNbr)
	{
		this.PlayerNbr = PlayerNbr;
	}
	
	public int GetPlayerNbr()
	{
		return this.PlayerNbr;
	}
}
