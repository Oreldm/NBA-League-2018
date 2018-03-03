package nba_objects;

import java.util.ArrayList;

import Main.Actions;

public class Game {
	public int id;
	public int homeTeamId;
	public int visitTeamId;
	public String startDate;
	public String Status;
	public Referee referee;
	Team homeTeam;
	Team visitTeam;
	
	public Game(String gameStr) {
		String[]gameArr= gameStr.split(",");
		this.id=Integer.parseInt(gameArr[0]);
		this.homeTeamId=Integer.parseInt(gameArr[1]);
		this.visitTeamId=Integer.parseInt(gameArr[2]);
		
		ArrayList<String> getTeamResult = Actions.jdbc.runDBFunctionTableTypeReturn("GET_TEAM", ""+this.homeTeamId, null);
		homeTeam= new Team(getTeamResult.get(1));
		
		getTeamResult = Actions.jdbc.runDBFunctionTableTypeReturn("GET_TEAM", ""+this.visitTeamId, null);
		visitTeam= new Team(getTeamResult.get(1));
		
		this.startDate=gameArr[3];
		this.Status=gameArr[4];
		this.referee = new Referee(Integer.parseInt(gameArr[5]),gameArr[6],gameArr[7],gameArr[8],gameArr[9],gameArr[10]);
	}
	
	@Override
	public String toString() {
		return homeTeam.name + " vs " + visitTeam.name + " Status is "+Status +". The referee is "+referee.firstName + " "+referee.lastName;
	}
}
