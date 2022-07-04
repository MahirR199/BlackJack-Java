/*
Mahir Rahman
May 5 2020
Assignment 15: BlackJack 
ICS3U7-02 Ms. Strelkovska
*/
public class Deck
{
	//variables
	private int cards[] = new int[52];
	protected static String cardDes[] = new String[52];
	private static int numOfCards = 52;
	public Deck()
	{
		String placeHolder="";
		int count = 0;
		for(int i = 0; i<52; i++)
		{
			cards[i] = i;
		}
		for(int i = 1; i<=13; i++)
		{
			for(int j = 3; j<=6; j++)
			{
				if(i == 1)
				{
					placeHolder = "A" + (char)j;
				}
				else if(i== 11)
					placeHolder = "J"+ (char)j;
				else if(i==12)
					placeHolder = "Q"+ (char)j;
				else if(i==13)
					placeHolder = "K"+ (char)j;
				else
					placeHolder = i +""+ (char)j;
				cardDes[count] = placeHolder;
				if(count<51)
					count++;
				
			}
		}
		
	}
	
	public void shuffle()
	{
		int tempIndex1; 
		int tempIndex2; 
		int tempVal;
		for(int i = 0; i<100; i++)
		{
			tempIndex1 = (int)(Math.random()*getNumOfCards());
			tempIndex2 = (int)(Math.random()*getNumOfCards());
			tempVal = cards[tempIndex1];
			cards[tempIndex1] = cards[tempIndex2];
			cards[tempIndex2] = tempVal;
		}
	}
	
	public int giveACard()
	{
		return cards[--numOfCards];
	}
	public String toString()
	{
		String out = "";
		for(int i = 0; i<getNumOfCards(); i++)
			out+=cardDes[cards[i]] + "  ";
		return out;
	}
	public int getNumOfCards()
	{
		return numOfCards;
	}
	public void setNumOfCards(int n)
	{
		numOfCards = n;
	}
	
	
	
}