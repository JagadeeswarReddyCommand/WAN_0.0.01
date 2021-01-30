package MyGalary;

import java.util.ArrayList;

public class YoutubeDataReturn {

	private ArrayList<String> HomeList=new ArrayList<String>();
   private ArrayList<Integer> HomeListId=new ArrayList<Integer>();
	
	public ArrayList<String> getHomeList() {
		return this.HomeList;
	}
	public void setHomeList(ArrayList<String> homeList) {
		HomeList = homeList;
	}
	public ArrayList<Integer> getHomeListId() {
		return this.HomeListId;
	}
	public void setHomeListId(ArrayList<Integer> homeListId) {
		HomeListId = homeListId;
	}
	
}
