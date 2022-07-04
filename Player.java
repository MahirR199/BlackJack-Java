/*
Mahir Rahman
May 5 2020
Assignment 15: BlackJack 
ICS3U7-02 Ms. Strelkovska
*/

import java.util.*;
public class Player 
{
	private String name;
	private int age;
	protected int cards[];
	protected int numOfCards;
	private int total;
	public Player(String n, int a)
	{
		this.name = n;
		this.age = a;
		numOfCards = 0;
		total = 0;
		cards = new int[10];
		for(int i = 0; i <cards.length; i++)
		{
			cards[i] = -1;
		}
	}
	public Player(int a)
	{
		this.name = "Bob";
		this.age = a;
		numOfCards = 0;
		total = 0;
		cards = new int[10];
		for(int i = 0; i <cards.length; i++)
		{
			cards[i] = -1;
		}
	}
	public String getName()
	{
		return name;
	}
	
	
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	public void setNumOfCards(int n)
	{
		numOfCards = n;
	}
	
	
	public void showHands()
	{
		String out = name + ": ";
		for(int i = 0; i<numOfCards; i++)
		{
			out+=Deck.cardDes[cards[i]] + "  ";
		}
		out+="\n\nTotal: "+ getTotal() + "\n\n";
		System.out.println(out);
	}
	public String toString()
	{
		String info =name + "\n";
		info +=age + "\n";
		return info;
	}
	
	public void takeACard(int cardID)
	{
		cards[numOfCards++]=cardID;
	}
	
	public int getTotal()
	{
		total = 0;
		String temp = "";
		String tempCards[] = new String[numOfCards];
		for(int i = 0; i<numOfCards; i++)
		{
			tempCards[i] = Deck.cardDes[cards[i]];
		}
		for(int i = 0; i<numOfCards; i++)
		{
			String card = tempCards[i];
			if(card.charAt(0) == 'J' || card.charAt(0) == 'K' || card.charAt(0) == 'Q' || card.charAt(0) == '1')
			{
				total+= 10;					
			}
			else if(card.charAt(0) != 'A')					
			{					
				total+=Integer.parseInt(card.charAt(0)+ "");
			}
			else if((i!=numOfCards-1)&&(card.charAt(0) == 'A'))
			{
				temp = tempCards[numOfCards-1];
				tempCards[numOfCards-1] = tempCards[i];
				tempCards[i] = temp;
				i -=1;
				
			}
			else if(card.charAt(0) == 'A')
			{
				if(total+11>21)
				{
					total+=1;
				}
				else{
					total+=11;
				}
			}
		}
		return total;
	}
}