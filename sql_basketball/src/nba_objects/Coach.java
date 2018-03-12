package nba_objects;

import java.util.ArrayList;

public class Coach {
	public int coachid;
	public String firstName;
	public String lastName;
	public String birthday;
	public String region;
	public int salary;
	public String hireDate;
	public int teamId;
	
	public Coach(ArrayList<String>array) {
		String[]arr = array.get(1).split(",");
		coachid= parseInt(arr[1]);
		firstName=arr[2];
		lastName=arr[3];
		birthday=arr[4];
		region=arr[5];
		salary=parseInt(arr[6]);
		hireDate=arr[7];
		teamId=parseInt(arr[8]);
	}

	
	private int parseInt(String number) {
		try {
			number.replaceAll(" ", "");
			return Integer.parseInt(number);
		}catch(Exception e) {
			return 0;
		}
	}
}
