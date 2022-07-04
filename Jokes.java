/*
Mahir Rahman
May 19 2020
Assignment 15: BlackJack 
ICS3U7-02 Ms. Strelkovska
*/
import java.util.*;
import java.io.*;
public class Jokes
{
	 private static ArrayList<String> jokes = new ArrayList<String>();
	 private static Scanner readFile = null;
	 private static Scanner fileCnt = null;
	 private static int lineCount;
	 private static String randomJoke;
	 private static int tempIndex;
	 public static void loadJokes()
	 {
		randomJoke = "";
		tempIndex = 0;
		lineCount = 0;
		try
		{
			fileCnt = new Scanner(new File("jokes.txt"));
		}
		catch(Exception e)
		{
			System.out.println("No dictionary found");
		}
		while(fileCnt.hasNext())
		{
			fileCnt.nextLine();
			lineCount++;
		}
		fileCnt.close();
		try
		{
			readFile = new Scanner(new File("jokes.txt"));
		}
		catch(Exception e)
		{
			System.out.println("No dictionary found");
		}
		for(int i = 0; i<lineCount; i++)
		{
			jokes.add(readFile.nextLine());
		}
	 }
	 public static String nextJoke()
	 {
		 if(jokes.isEmpty())
		 {
			 loadJokes();
		 }
		 Collections.shuffle(jokes);
		 tempIndex = (int)(Math.random()*jokes.size());
		 randomJoke = jokes.get(tempIndex);
		 jokes.remove(tempIndex);
		 return randomJoke;
	 }
}