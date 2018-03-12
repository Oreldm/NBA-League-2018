package nba_objects;

import java.util.Arrays;

public class Player_Stats {
	public double totalMinutes;
	public double minutesPerGame;
	public double totalPoints;
	public double pointsPerGame;
	public double from1PointPrecent;
	public double from2PointPrecent;
	public double from3PointPrecent;
	public double totalRebounds;
	public double reboundsPerGame;
	public double fouls;
	public double foulsPerGame;
	public double lossBall;
	public double lossBallPerGame;
	public double assists;
	public double assistsPerGame;
	public double totalBlocks;
	public double blocksPerGame;
	public double pointPlaceInLeague;
	public double reboundsPlaceInLeague;
	public double assistsPlaceInLeague;
	public double blocksPlacecInLeague;
	public double from1PointPlaceInLeague;
	public double from2PointPlaceInLeague;
	public double from3PointPlaceInLeague;
	
	
	
	public Player_Stats(String str) {
		String[]arr = str.split(",");
		if(arr.length<24) {
			String[]tempArr=Arrays.copyOf(arr, 24);
			for(int j=arr.length;j<tempArr.length;j++) {
				tempArr[j]="";
				arr=Arrays.copyOf(tempArr, 24);
			}
		}
		totalMinutes=parseDouble(arr[0]);
		minutesPerGame=parseDouble(arr[1]);
		totalPoints=parseDouble(arr[2]);
		pointsPerGame=parseDouble(arr[3]);
		from1PointPrecent=parseDouble(arr[4]);
		from2PointPrecent=parseDouble(arr[5]);
		from3PointPrecent=parseDouble(arr[6]);
		totalRebounds=parseDouble(arr[7]);
		reboundsPerGame=parseDouble(arr[8]);
		fouls=parseDouble(arr[9]);
		foulsPerGame=parseDouble(arr[10]);
		lossBall=parseDouble(arr[11]);
		lossBallPerGame=parseDouble(arr[12]);
		assists=parseDouble(arr[13]);
		assistsPerGame=parseDouble(arr[14]);
		totalBlocks=parseDouble(arr[15]);
		blocksPerGame=parseDouble(arr[16]);
		pointPlaceInLeague=parseDouble(arr[17]);
		reboundsPlaceInLeague=parseDouble(arr[18]);
		assistsPlaceInLeague=parseDouble(arr[19]);
		blocksPlacecInLeague=parseDouble(arr[20]);
		from1PointPlaceInLeague=parseDouble(arr[21]);
		from2PointPlaceInLeague=parseDouble(arr[22]);
		from3PointPlaceInLeague=parseDouble(arr[23]);
	}
	
	private double parseDouble(String number) {
		try {
			number.replaceAll(" ", "");
			return Double.parseDouble(number);
		}catch(Exception e) {
			return 0;
		}
	}
}
