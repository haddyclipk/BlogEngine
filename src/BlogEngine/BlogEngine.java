package BlogEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BlogEngine implements Blogger{
	
	
	// hashmap for user account,another for label 
	private Map<String, Account> entry;
	private Map<String, ArrayList<Post>> labelEntry;
	//constructor 
	public BlogEngine(){
		entry=new HashMap<String,Account>();
		//manually set label,initial label hashmap
		String[] labels = new String[]{"love","military","science","technology","life","essay"};		
		labelEntry=new HashMap<String, ArrayList<Post>>();
		for(int i=0; i<labels.length;i++){
		labelEntry.put(labels[i],new ArrayList<Post>());
		}
		
	}
	// submit a post
	public void submit(String usr_id, String title,String input,ArrayList<String> label){
		//create post,put map
		if (entry.containsKey(usr_id)){
			Account usr=entry.get(usr_id);
			usr.addPost(title,input,label);
			
		}
		else{  //create account in the map
			Account usr=new Account(usr_id);
			usr.addPost(title,input,label);
			entry.put(usr_id, usr);
		}
		// update label hashmap
		if(label.size()!=0){
			for(int i=0;i<label.size();i++){
				ArrayList<Post> pt= new ArrayList<Post>();
				pt=labelEntry.get(label.get(i));
				pt.add(entry.get(usr_id).returnPost(title));
			}
		}
		
	}
	// retrieve a post by user_id and blog title
	public Post retrieveOnePost(String usr_id, String title){
		if (!usrExist(usr_id)) return null;
		Account usr=entry.get(usr_id);
		Post pt=usr.returnPost(title);
		return pt;
	}
	// add comment to a post
	public void addComment(String usr_id, String title, String input){
		if (!usrExist(usr_id)){System.out.println("user account doesn't exist"); return;}
		Account usr=entry.get(usr_id);
		usr.addCmt(title,input);
		}
	//add label to a certain post after submit,update label hashmap
	public void addLable(String usr_id, String title, String label){
		if (!usrExist(usr_id)){
			System.out.println("user account doesn't exist"); return;
			}
		Account usr=entry.get(usr_id);
		usr.addLab(title,label);
		//update label hashmap
		ArrayList<Post> pt= new ArrayList<Post>();
		pt=labelEntry.get(label);
		pt.add(entry.get(usr_id).returnPost(title));
		
	}
	// retrieve posts by label
	public  ArrayList<Post> retrieveLabel(String label){
		return labelEntry.get(label);
	}
	// retrieve posts of given user
	public ArrayList<Post> retrieveUser(String usr_id){
		Account usr=entry.get(usr_id);
		return usr.returnAllPosts();
	}
	// retrieve comments associated with a certain post
	public ArrayList<String> retrieveComments(String usr_id, String title){
		Account usr=entry.get(usr_id);
		Post pst=usr.returnPost(title);
		return pst.returnComt();
	}
	//delete a post
	public void deletePost(String usr_id,String title){
		Account usr=entry.get(usr_id);
		Post pst=usr.returnPost(title);
		//update label hashmap
		ArrayList<String> st=pst.returnLabl();
		for(int i=0;i<st.size();i++){
			ArrayList<Post> labl=labelEntry.get(st.get(i));
			labl.remove(pst);
		}
		//delete in user account
		usr.deletePst(title);
	}
	//delete a comment
	public void deleteComment(String usr_id,String title, int number){
		Account usr=entry.get(usr_id);
		Post pst=usr.returnPost(title);
		pst.deleteCmt(number);
	}
	//delete a label of a post
	public void deleteLabel(String usr_id, String title, String label){
		Account usr=entry.get(usr_id);
		Post pst=usr.returnPost(title);
		pst.deleteLabl(label);
		//update label hashMap
		ArrayList<Post> pt= new ArrayList<Post>();
		pt=labelEntry.get(label);
		pt.remove(pst);
		
		}
	
	// check if user exists
	public boolean usrExist(String usr_id){
		return entry.containsKey(usr_id);
	}
	
}
