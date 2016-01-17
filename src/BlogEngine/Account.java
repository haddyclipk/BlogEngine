package BlogEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Account {
	// hashmap to record posts
	String usr_id;
	private Map<String, Post> postEntry;
	//constructor
	public Account(String usr_id){
		this.usr_id=usr_id;
		postEntry=new HashMap<String,Post>();
	}
	// add new post to hashmap
	public void addPost(String title,String input,ArrayList<String> label){
		Post pt=new Post(usr_id,title,input,label);
		
		postEntry.put(title,pt);
	}
	//return a post with a given title
	public Post returnPost(String title){return postEntry.get(title);}
	// add a comment to a given post
	public void addCmt(String title, String input){
		Post pt=postEntry.get(title);
		pt.addComt(input);
	}
	
	// add a label to a given post
	public void addLab(String title, String label){
		Post pt=postEntry.get(title);
		pt.addComt(label);
		}
	//return all the posts of this user account
	public ArrayList<Post> returnAllPosts(){
		ArrayList<Post> pt=new ArrayList<Post>();
		Set<String> kmp=postEntry.keySet();
		Iterator<String> st=kmp.iterator();
		while (st.hasNext()){
			pt.add(postEntry.get(st.next()));
		}
		return pt;
	}
	public void deletePst(String title){
		postEntry.remove(title);
	}
}



