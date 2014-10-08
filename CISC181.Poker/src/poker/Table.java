package poker;

import java.util.ArrayList;
import java.util.UUID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
public class Table {
	@XmlElement
	private UUID TableID;
	@XmlElement
	private ArrayList<Game> TableGame = new ArrayList<Game>();
	@XmlElement (name = "TablePlayerID")
	private ArrayList<Player> TablePlayers = new ArrayList<Player>();
	
	public Table()
	{
		this.TableID = UUID.randomUUID();
	}
	
	public UUID GetTableID()
	{
		return this.TableID;
	}
	
	public void AddGame(Game g)
	{
		TableGame.add(g);
	}
	
	public void RemoveGame(Game g)
	{
		TableGame.remove(g);
	}
	
	public ArrayList<Game> GetGames()
	{
		return TableGame;
	}
	
	public void AddTablePlayer(Player p)
	{
		TablePlayers.add(p);
	}
	
	public void RemoveTablePlayer(Player p)
	{
		TablePlayers.remove(p);
	}
	
	public ArrayList<Player> GetTablePlayers()
	{
		return TablePlayers;
	}
}
