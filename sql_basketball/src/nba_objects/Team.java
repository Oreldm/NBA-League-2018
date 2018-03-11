package nba_objects;

public class Team {
	public int id;
	public String name;
	public String nickname;
	public int championshipment;
	public int leagueplace;
	public String homeSuit;
	public String visitSuit;
	public String logoFileName;
	
	public Team(String teamStr) {
		String[]teamArr= teamStr.split(",");
		this.id=parseInt(teamArr[1]);
		this.name=teamArr[2];
		this.nickname=teamArr[3];
		this.championshipment=parseInt(teamArr[4]);
		this.leagueplace=parseInt(teamArr[5]);
		this.homeSuit=teamArr[6];
		this.visitSuit=teamArr[7];
		this.logoFileName=teamArr[8];
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", nickname=" + nickname + ", championshipment=" + championshipment
				+ ", leagueplace=" + leagueplace + ", homeSuit=" + homeSuit + ", visitSuit=" + visitSuit
				+ ", logoFileName=" + logoFileName + "]";
	}
	
	private int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(Exception e) {
			return 0;
		}
	}
	
	
}
