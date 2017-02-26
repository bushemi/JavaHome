package patterns.observer;

import patterns.observer.implementation.Me;
import patterns.observer.implementation.MyFriend;

public class Main {

	public static void main(String[] args){
		RSS news = new RSS();
		MyFriend friend = new MyFriend();
		Me me = Me.getInstance();
		news.addListener(me);
		news.addListener(friend);
		news.GoodNews();
		news.removeListener(friend, "unacceptable words");
		news.GoodNews();

	}

}
