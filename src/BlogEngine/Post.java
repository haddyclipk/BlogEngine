package BlogEngine;

import java.util.ArrayList;

public class Post {
	String usr;
	String title;
	String content;
	public ArrayList<String> commts;
	public ArrayList<String> labels;
	//constructor
	public Post(String usr_id,String title,String input,ArrayList<String> label){
		commts = new ArrayList<String>();
		labels = new ArrayList<String>();
		for(int i=0;i<label.size();i++){labels.add(label.get(i));}
		content=input;
		this.title=title;
		usr=usr_id;
	}
	public void addComt(String input){commts.add(input);}
	public ArrayList<String> returnComt(){return commts;}
	public ArrayList<String> returnLabl(){return labels;}
	public void addLabl(String label){labels.add(label);}
	public void deleteCmt(int number){commts.remove(number-1);}
	public void deleteLabl(String label){labels.remove(label);}
}

