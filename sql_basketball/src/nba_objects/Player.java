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
	
	public Player(String playerStr, int i) {
		String[]playerArr= playerStr.split(",");
		System.out.println(playerStr);
		this.playerid=parseInt(playerArr[0+i]);
		this.firstName=playerArr[1+i];
		this.lastName=playerArr[2+i];
		this.shirtNumber=parseInt(playerArr[3+i]);
		this.position=playerArr[4+i];
		this.height=parseDouble(playerArr[5+i]);
		this.weight=parseDouble(playerArr[6+i]);
		this.birthday=playerArr[7+i];
		this.region=playerArr[8+i];
		this.hireDate=playerArr[9+i];
		this.salary=parseInt(playerArr[10+i]);
		this.teamid=parseInt(playerArr[11+i]);
		try {
			this.picture=playerArr[12+i];
		}catch(ArrayIndexOutOfBoundsException e) {
			this.picture="https://www.esportsearnings.com/images/unknown_player.png";
		}
		
	}
	
	private int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(Exception e) {
			return 0;
		}
	}
	
	private double parseDouble(String number) {
		try {
			return Double.parseDouble(number);
		}catch(Exception e) {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		String strToReturn="#"+shirtNumber+ " " +firstName + " "+ lastName;
		return strToReturn;
	}
	
}
