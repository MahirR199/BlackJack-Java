/*
Mahir Rahman
May 19 2020
Assignment 15: BlackJack 
ICS3U7-02 Ms. Strelkovska
*/

import java.util.*;

public class Dealer extends Player{
	protected String name;
	private int age;
	protected int total;
	
	public Dealer()
	{
		super("Dealer John", 25);
		name = "Dealer John";
	}
	
	public String getName()
	{
		return name;
	}
	
	
	public void showHands()
	{
		String out=""; 
		out+=name + ": ";
		out+= Deck.cardDes[cards[0]];
		if(numOfCards<2)
			out+="\n\nTotal: "+ getTotal() + "\n\n";
		for(int i = 1; i<numOfCards; i++)
			out+= " X ";
		if(numOfCards>=2)
			out+="\n\nTotal: ?\n\n";
		System.out.println(out);
		
	}
	public void showHandsFull()
	{
		String out = name + ": ";
		for(int i = 0; i<numOfCards; i++)
		{
			out+=Deck.cardDes[cards[i]] + "  ";
		}
		out+="\n\nTotal: "+ getTotal() + "\n\n";
		System.out.println(out);
	}
}