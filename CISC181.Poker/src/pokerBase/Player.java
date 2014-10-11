package pokerBase;
import java.util.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

public class Player {
	
	@XmlElement
	private UUID PlayerID;
	@XmlElement
	private int PlayerNbr;
	@XmlElement
	private String PlayerName;
	@XmlElement
	private Hand PlayerHand;
	
	public Player(String PlayerName)
	{
		this.PlayerID = UUID.randomUUID();
		this.PlayerName = PlayerName;
	}
	
	public UUID GetPlayerID()
	{
		return this.PlayerID;		
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
	
	public void SetPlayerName(String PlayerName)
	{
		this.PlayerName = PlayerName;
	}
	
	public String GetPlayerName()
	{
		return this.PlayerName;
	}
}
