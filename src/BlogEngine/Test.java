package BlogEngine;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Blogger be=new BlogEngine();
		
		ArrayList<String> post1=new ArrayList<String>();
		post1.add("love");
		post1.add("science");
		
		ArrayList<String> post2=new ArrayList<String>();
		post2.add("love");
		post2.add("life");
		//post submit,label is chose
		be.submit("tom","mytitle1","hello,this is 1st blog",post1);
		be.submit("tom","mytitle2","hello,this is 2st blog",post2);
		be.submit("jack","jack's 1st blog","this is jack's blog",post1);
		
		//add comment to post
		be.addComment("tom","mytitle2","this is 1st comment: nice blog");
		be.addComment("tom","mytitle2","this is 2nd comment: bad blog");
		
		
		//test
		//test retrive User
		ArrayList<Post> us=be.retrieveUser("tom");
		System.out.println("before delete, show result of retriveUser(\"tom\")");
		showTestResult(us);
		
		//test deletePost
		be.deletePost("tom","mytitle1");
		ArrayList<Post> us1=be.retrieveUser("tom");
		System.out.println("\nafter delete, show result of retriveUser(\"tom\")");
		showTestResult(us1);
		
		//test retriveComments
		System.out.println("\ntest retrive comment");
		ArrayList<String> cm=be.retrieveComments("tom","mytitle2");
		System.out.println("tom's mytitle2's comment:");
		for(int i=0;i<cm.size();i++){
			System.out.println(cm.get(i));
			}
		//test deletComment
		be.deleteComment("tom","mytitle2",1);
		ArrayList<String> cm1=be.retrieveComments("tom","mytitle2");
		System.out.println("\n after delete comment, tom's mytitle2's comment:");
		for(int i=0;i<cm1.size();i++){
			System.out.println(cm1.get(i));
			}
		
		//test retriveLable
		System.out.println("\ntest retriveLabel\n");
		ArrayList<Post> pt=be.retrieveLabel("love");
		System.out.println("posts of label love:");
		showTestResult(pt);
		ArrayList<Post> pt1=be.retrieveLabel("life");
		System.out.println("\nposts of label life:");
		showTestResult(pt1);
		//test delete label
		be.deleteLabel("tom","mytitle2","love");
		System.out.println("\nafter delete tom's 2st blog's love label:\n posts of label love:");
		showTestResult(pt);
		//test retriveOnePost
		System.out.println("\nTest retriveOnePost\nInput:jack, title");
		Post pt2=be.retrieveOnePost("jack","jack's 1st blog");
		System.out.println("user: "+pt2.usr+"  title is: "+pt2.title+"  content is: "+pt2.content);
		
		
		

	}
	public static void showTestResult(ArrayList<Post> pt){
		for(int i=0;i<pt.size();i++){
			System.out.println("user: "+pt.get(i).usr+"  title is: "+pt.get(i).title+"  content is: "+pt.get(i).content);}
		
	}

}
