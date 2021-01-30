package Global;

import java.util.ArrayList;

public class YoutubeDataReturnForGlobal {

   private ArrayList<String> HomeList=new ArrayList<String>();
   private ArrayList<String> HomeListName=new ArrayList<String>();
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
	public ArrayList<String> getHomeListName() {
		return HomeListName;
	}
	public void setHomeListName(ArrayList<String> homeListName) {
		HomeListName = homeListName;
	}
	
}
