/*
Mahir Rahman
May 19 2020
Assignment 15: BlackJack 
ICS3U7-02 Ms. Strelkovska
*/
import java.util.*;

public class RahmanM_BlackJack{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		boolean tie = false;
		boolean round = true;
		boolean playerWins = false;
		boolean dealerWins = false;
		boolean keepPlaying = true;
		int age = 0;
		String hitStand = "";
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Age: ");
		age = sc.nextInt();
		Player p1 = new Player(name, age);
			
		
		
		
		sc.nextLine();
		while(keepPlaying)
		{
			
			
			System.out.println("\n\n\n");
			System.out.println(p1);
			String input = "";
			Dealer boss = new Dealer();
			System.out.println(boss);
		
		
			round = true;
			playerWins = false;
			dealerWins = false;
			Deck d = new Deck();
			System.out.println(d + "\n\n");
			d.shuffle();	
			System.out.println(d + "\n\n");
			d.shuffle();
			boss.takeACard(d.giveACard());
			boss.takeACard(d.giveACard());
			p1.takeACard(d.giveACard());
			p1.takeACard(d.giveACard());
			System.out.println(d+ "\n\n");
			p1.showHands();
			boss.showHands();
			
			while(round)
			{
				hitStand = "";
				System.out.println("Hit or Stand");
				hitStand = sc.nextLine().toLowerCase();
				
				if(hitStand.equals("hit"))
				{
					p1.takeACard(d.giveACard());
					boss.takeACard(d.giveACard());
					p1.showHands();
					boss.showHands();
				}
				else if(hitStand.equals("stand"))
				{
					boss.takeACard(d.giveACard());
					p1.showHands();
					boss.showHandsFull();
					if(boss.getTotal()>21 || p1.getTotal()>boss.getTotal())
					{
						playerWins = true;
						break;
					}
					else if(boss.getTotal() > p1.getTotal())
					{
						dealerWins = true;
						break;
					}
					if(boss.getTotal() == p1.getTotal())
					{
						tie = true;
						break;
					}
					break;
					}
					if(p1.getTotal() == 21 && boss.getTotal()!=21){
						playerWins = true;
						break;
					}
					if(p1.getTotal()<21 && boss.getTotal()>21){
						playerWins = true;
						System.out.println("Dealer busts!");
						break;
						
					}

					if(p1.getTotal()>21)
					{
						dealerWins = true;
						System.out.println("Player busts!");
						break;
					}
					if(boss.getTotal()==21 && p1.getTotal()!= 21)
					{
						dealerWins = true;
						break;
					}
					
			}
			
			if(dealerWins)
			{
				boss.showHandsFull();
				System.out.println("Dealer wins! \n\n");
				System.out.println(Jokes.nextJoke());
				System.out.println("\n\n\n");
				System.out.println("Play again? (Y/N)");
				input = sc.nextLine();
				
			}
			else if(playerWins)
			{
				boss.showHandsFull();
				System.out.println(name + " wins! \n\n");
				System.out.println(Jokes.nextJoke());
				System.out.println("\n\n\n");
				System.out.println("Play again? (Y/N)");
				input = sc.nextLine();
			}
			else if(tie)
			{
				boss.showHandsFull();
				System.out.println("Tie!");
				System.out.println("\n\n\n");
				System.out.println("Play again? (Y/N)");
				input = sc.nextLine();
			}
			if(input.toLowerCase().equals("n"))
			{
				keepPlaying = false;
			}
			else
			{
				d.shuffle();
				System.out.println(d);
				p1.setNumOfCards(0);
				boss.setNumOfCards(0);
				for(int i = 0; i <p1.cards.length; i++)
				{
					p1.cards[i] = -1;
				}
				
			}
			if(d.getNumOfCards()<=10)
			{
				d.setNumOfCards(52);
				System.out.println("Deck reset! \n");
			}
		
			
		}
	}
} 