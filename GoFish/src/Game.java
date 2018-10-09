import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Game
	{
		static ArrayList<Card>deck = new ArrayList<Card>();
		static ArrayList<Card>myHand = new ArrayList<Card>();
		static ArrayList<Card>enemyHand = new ArrayList<Card>();
		static int myScore = 0;
		static int enemyScore = 0;
		static Scanner userInputString = new Scanner(System.in);
		static Scanner userInputInt = new Scanner(System.in);
		static boolean run = true;
		static int myNumberOfCards = 5;
		
		
		public static void main(String[] arg)
		{
			fillDeck();
			//fishing();
			//seeHand();
			//fillHand();
			endGame();
			//introduction();
			//seeEnemyHand();
			//myRepeats();
			//enemyRepeats();
		}

		private static void enemyRepeats()
			{
				for(int i = 0; i < enemyHand.size(); i++)
					{
							{
								for(int j = i + 1; j < enemyHand.size(); j++)
									{
										if(enemyHand.get(i).getColor().equals(enemyHand.get(j).getColor()) && enemyHand.get(i).getValue() == enemyHand.get(j).getValue())
											{
												enemyHand.remove(j);
												enemyHand.remove(i);
												System.out.println("I have two of the same card.");
												enemyScore++;
												System.out.println("I have " + enemyScore + " points.");
												
												
											}
									}
							}
						
					}
				
			}

		private static void myRepeats()
			{
				
				
				for(int i = 0; i < myHand.size(); i++)
					{
							{
								for(int j = i + 1; j < myHand.size(); j++)
									{
										if(myHand.get(i).getColor().equals(myHand.get(j).getColor()) && myHand.get(i).getValue() == myHand.get(j).getValue())
											{
												myHand.remove(j);
												myHand.remove(i);
												myNumberOfCards--;
												myNumberOfCards--;
												System.out.println("You have two of the same card.");
												myScore++;
												System.out.println("You have " + myScore + " points.");
												
												
											}
									}
							}
						
					}
				
				
				
			}

		private static void seeEnemyHand()
			{
				for(int i = 0; i < enemyHand.size(); i++)
					{
						System.out.println(enemyHand.get(i).getValue() + " " + enemyHand.get(i).getColor());
					}
				
			}

		private static void introduction()
			{
				System.out.println("Hi, whats your name?");
				String name = userInputString.nextLine();
				System.out.println("Hi " + name + ", let's play Go Fish. Your hand is: ");
				
				fillHand();
				seeHand();
				
			}

		static void endGame()
			{
				introduction();
				
				while (run)
					{
						fishing();
						
//						System.out.println("***The enemy hand size is " + enemyHand.size());
//						System.out.println("***The deck size is " + deck.size());
//						System.out.println("The enemy hand is");
//						seeEnemyHand();
//						

					}
				
						
						if(myScore == enemyScore)
							{
								System.out.println("lmao we tied bro");
							}
						else if(myScore > enemyScore)
							{
								System.out.println("wow you won!");
							}
						else
							{
								System.out.println("I won!!!");
							}
					
			}

		private static void fillHand()
			{
				for(int i = 0; i < 5; i++)
					{
						myHand.add(deck.get(0));
						deck.remove(0);
						enemyHand.add(deck.get(0));
						deck.remove(0);
					}
				myRepeats();
				enemyRepeats();
			}

		private static void seeHand()
			{
				for(int i = 0; i < myHand.size(); i++)
					{
						System.out.println(myHand.get(i).getValue() + " " + myHand.get(i).getColor());
					}
			}

		private static void fishing()
			{
				
				
				//int rand = (int)(Math.random() * enemyHand.size()); 
				
				
				System.out.println("What color would you like to ask for?");
				String colorAsked = userInputString.nextLine();
				System.out.println("What value would you like to ask for?");
				int valueAsked = userInputInt.nextInt();
				
					for(int i = 0; i < enemyHand.size(); i++)
						{
//							System.out.println("#1 " + myNumberOfCards);
							if((enemyHand.get(i).getValue() == valueAsked) && (enemyHand.get(i).getColor().equals(colorAsked)))
								{
									System.out.println("I do have a " + colorAsked + " " + valueAsked + "!");
									enemyHand.remove(i);
									
									for(int j = 0; j < myHand.size(); j++)
										{
											if((myHand.get(j).getValue() == valueAsked) && (myHand.get(j).getColor().equals(colorAsked)))
												{
													myHand.remove(j);
												}
										}
									myScore++;
									System.out.println("You have " + myScore + " points.");
									seeHand();
									//System.out.println("testing 3");
								}
									
						 }
					//System.out.println("testing 2");
//					System.out.println("#2 " + myNumberOfCards);


					if(myNumberOfCards == myHand.size())
						{
							System.out.println("Go Fish!");	
							myHand.add(deck.get(0));
							deck.remove(0);
							myNumberOfCards++;
//							System.out.println("#3 " + myNumberOfCards);
							myRepeats();
							seeHand();
						}
					else
						{
							
							myNumberOfCards--;
//							System.out.println("#4" + myNumberOfCards);
						}
					
					int rand = (int)(Math.random() * enemyHand.size()); 
					
					System.out.println("Do you have a " + enemyHand.get(rand).getColor() + " " + enemyHand.get(rand).getValue());
					String response = userInputString.nextLine();
					
					if(response.equals("yes"))
						{
							for(int i = 0; i < myHand.size(); i++)
								{
									if((myHand.get(i).getValue() == enemyHand.get(rand).getValue()) && (myHand.get(i).getColor().equals(enemyHand.get(rand).getColor())))
												{
													
													myHand.remove(i);
													myNumberOfCards--;
													enemyHand.remove(rand);
													enemyScore++;
													System.out.println("I have " + enemyScore + " points");
													seeHand();
													break;
													
												}
								}
							
						}
					
					else
						{
							System.out.println("Ok, I'll go fish!");
							enemyHand.add(deck.get(0));
							deck.remove(0);
							enemyRepeats();
							seeHand();
							
						}
					//System.out.println("testing");
					
					
					if((myHand.size() == 0) || (enemyHand.size() == 0) || (deck.size() == 0))
						{
							
							run = false;
						}	
				
				
				
			}

		static void fillDeck()
			{
				

				
				deck.add(new Card(2, "black"));
				deck.add(new Card(2, "black"));
				deck.add(new Card(2, "red"));
				deck.add(new Card(2, "red"));
				deck.add(new Card(3, "black"));
				deck.add(new Card(3, "black"));
				deck.add(new Card(3, "red"));
				deck.add(new Card(3, "red"));
				deck.add(new Card(4, "black"));
				deck.add(new Card(4, "black"));
				deck.add(new Card(4, "red"));
				deck.add(new Card(4, "red"));
				deck.add(new Card(5, "black"));
				deck.add(new Card(5, "black"));
				deck.add(new Card(5, "red"));
				deck.add(new Card(5, "red"));
				deck.add(new Card(6, "black"));
				deck.add(new Card(6, "black"));
				deck.add(new Card(6, "red"));
				deck.add(new Card(6, "red"));
				deck.add(new Card(7, "black"));
				deck.add(new Card(7, "black"));
				deck.add(new Card(7, "red"));
				deck.add(new Card(7, "red"));
//				deck.add(new Card(8, "black"));
//				deck.add(new Card(8, "black"));
//				deck.add(new Card(8, "red"));
//				deck.add(new Card(8, "red"));
//				deck.add(new Card(9, "black"));
//				deck.add(new Card(9, "black"));
//				deck.add(new Card(9, "red"));
//				deck.add(new Card(9, "red"));
//				deck.add(new Card(10, "black"));
//				deck.add(new Card(10, "black"));
//				deck.add(new Card(10, "red"));
//				deck.add(new Card(10, "red"));
//				deck.add(new Card(11, "black"));
//				deck.add(new Card(11, "black"));
//				deck.add(new Card(11, "red"));
//				deck.add(new Card(11, "red"));
//				deck.add(new Card(12, "black"));
//				deck.add(new Card(12, "black"));
//				deck.add(new Card(12, "red"));
//				deck.add(new Card(12, "red"));
//				deck.add(new Card(13, "black"));
//				deck.add(new Card(13, "black"));
//				deck.add(new Card(13, "red"));
//				deck.add(new Card(13, "red"));
				
				Collections.shuffle(deck);
				
			}
	}
