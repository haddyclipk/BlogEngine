package BlogEngine;

import java.util.ArrayList;

public interface Blogger {
	// submit a post
	public void submit(String usr_id, String title,String input,ArrayList<String> label);
	// retrieve a post by user_id and blog title
	public Post retrieveOnePost(String usr_id, String title);
	// add comment to a post
	public void addComment(String usr_id, String title, String input);
	//add label to a certain post after submit
	public void addLable(String usr_id, String title, String label);
	// retrieve posts by label
	public  ArrayList<Post> retrieveLabel(String label);
	// retrieve posts of given user
	public ArrayList<Post> retrieveUser(String usr_id);
	// retrieve comments associated with a certain post
	public ArrayList<String> retrieveComments(String usr_id, String title);
	//delete a post
	public void deletePost(String usr_id,String title);
	//delete a comment of a post
	public void deleteComment(String usr_id, String title, int number);
	//delete a label of a post
	public void deleteLabel(String usr_id,String title, String label);

}
