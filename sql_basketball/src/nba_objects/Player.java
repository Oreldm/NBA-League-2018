package nba_objects;

public class Player {
	
	public int playerid;
	public String firstName;
	public String lastName;
	public int shirtNumber;
	public String position;
	public double height;
	public double weight;
	public String birthday;
	public String region;
	public String hireDate;
	public int salary;
	public int teamid;
	public String picture;
	
	public Player(String playerStr) {
		String[]playerArr= playerStr.split(",");
		System.out.println(playerStr);
		this.playerid=Integer.parseInt(playerArr[0]);
		this.firstName=playerArr[1];
		this.lastName=playerArr[2];
		this.shirtNumber=Integer.parseInt(playerArr[3]);
		this.position=playerArr[4];
		this.height=Double.parseDouble(playerArr[5]);
		this.weight=Double.parseDouble(playerArr[6]);
		this.birthday=playerArr[7];
		this.region=playerArr[8];
		this.hireDate=playerArr[9];
		this.salary=Integer.parseInt(playerArr[10]);
		this.teamid=Integer.parseInt(playerArr[11]);
		try {
			this.picture=playerArr[12];
		}catch(ArrayIndexOutOfBoundsException e) {
			this.picture="https://www.esportsearnings.com/images/unknown_player.png";
		}
		
	}
	
}
