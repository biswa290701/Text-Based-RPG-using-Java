package Game;
import java.util.*;
import java.util.Random;

//The class Enter asks the user whether to start a new game or terminate it and it uses 3 interfaces - npc1, np2 and npc3
class Enter
{
    static void enterMessage()
    {
	System.out.println(" 		 PROPHECY				   ");
        System.out.println("X----------------MAIN MENU----------------X");
        System.out.println("X-------Type S to start a New Game.-------X");
        System.out.println("X---------Type Q to quit the Game.--------X");
        Scanner sc = new Scanner(System.in);
        char menuChoice = sc.next().charAt(0);
        if(menuChoice=='s' || menuChoice=='S')
        {
			gamezz gamezz = new gamezz();
			gamezz.begin();
        }
        else if (menuChoice=='q' || menuChoice=='Q')
        {
            System.out.println("You are about to quit the game...");
            System.out.println("Application terminated.");
            System.exit(0); 
        }
        sc.close();
    		}
		}
interface npc1{
	boolean check();
}
interface npc2{
	boolean check();
}
interface npc3{
	boolean check();
}


public class game1{
	public static void main(String Args[]) {
	Enter.enterMessage();
	}
}

//The class gamezz narrates the story and the actual gameplay
class gamezz {
	public void begin() {
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.println("Welcome!");
		Player p1 = new Player();
		Stats s1 = new Stats();
		System.out.println("Your New Stats are - \n");
		s1.pstats(p1);
		pressAnyKeyToContinue();
		System.out.println("Mirai is a delinquent boy in the small town of Unmeimachi. He grew up in a household with 4 children, and being the middle-child, he made sure his rebellious nature shined the brightest in his pre-teen years.\nMirai had a track record of vandalism, fighting and general mayhem by the time he was 15. His father Goro, who was a Forest Ranger had always tried to bend his son into inheriting the family swordsmanship. Mirai, however, had little to no interest.\r\n"
				+ "One day while on his way back from the rice fields, Mirai came across an old Seer who had a little hut by the river. Mirai sat right next to him and asked the seer to shower him with his wisdom.\nThe seer took a long look at Mirai's face, and said, \"You are the root of doom. From you it emerges and to you it shall return.\" Mirai stared at the seer for a few minutes, and then immediately bursted out laughing, calling the seer a fraud and going his own merry way.\r\n"
				+ "\n"+"Unmeimachi is protected by a magical barrier that has been set up by the founding fathers of the village. It keeps out all the black mana beasts at night.\nA few weeks later, Mirai, on his way out of the village to see his friend, came across the ancient barrier. His never-ending mischief took over him and he decided to break open one of the several runes holding the barrier in place. He did it all out of pure fun, but this was a decision for the ages that he could never undo.\r\n"
						+ "When Mirai returned to his village the next day, hell on Earth awaited him. He saw the entire village up in flames, rivers of blood seeping through the huts and into the stream.\nThe soil was painted with the corpses of the villagers. A massacre had taken place and it was evident that it were black mana beasts. Mirai ran to his house, and saw his family dragged out onto the street and butchered like livestock.\nHe saw his father Goro laying dead on the porch. He had his ranger sword in his hand, which was indication of him going out fighting. Mirai picked up his father's sword. It all came to him.\nThe seer was right. He was the root of the doom. The barrier had broken open because of his mischief, and countless lives had to pay for it, including his own family's.\r\n"
						+ "Mirai set out on a quest for revenge and atonement. This was Mirai's last and a bloodlust's first day on Earth. \r\n\n\n"
						+ "\n" +"Mirai decided to leave at dawn. Now that the magic barrier was broken, the mana beasts could roam free even during the day. It wasn't long until he came across his very first. You choose to fight.");
		Enemy Blackhound = new Enemy(-20,-20,-10,-10);
		Blackhound.fight(p1,s1);
		if(p1.HP <= 0) {
			System.out.println("YOU DIED");
			pressAnyKeyToContinue();
			Enter.enterMessage();
		}
		else {
			System.out.println("You Defeated the Blackhound! Mirai Gained an Attack Boost\nAttack +10");
			p1.Attack += 10;
			p1.Intelligence +=10;
			pressAnyKeyToContinue();
		}
		Encounter2(p1,s1);
	}
	  void pressAnyKeyToContinue()
	 { 
	        System.out.println("Press Enter key to continue..." +"\n \n \n \n");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
	  public void Encounter2(Player p1, Stats s1) {
		  System.out.println("Shortly after, Mirai stumbled upon a farmer that was atop his food cart with two black hounds ready to chew at him from the bottom.\nHowever, Mirai was running out of time and any more delay could result in him being stranded in the thick of the night. What do you do?\r\n"
					+ "\n");
			Scanner sc = new Scanner(System.in);
			System.out.println("\nPress 1 to Fight the Hounds and Save the Farmer\nPress 2 to Ignore the encounter\nPress 3 to Watch the Farmer Die(Corruption Increase)");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: 
				{Enemy Hounds = new Enemy(0,0,0,0);
				Hounds.fight(p1, s1);
				if(p1.HP <= 0) {
					System.out.println("YOU DIED");
					pressAnyKeyToContinue();
					Enter.enterMessage();
					
				}
				else {
					System.out.println("You Defeated the Blackhounds! Mirai Gained an HP Increase\nHP +30");
					p1.maxHP += 30;
					p1.HP = p1.maxHP;
					pressAnyKeyToContinue();
					npc1 n1 = () -> { return true;};
					Encounter3(p1,s1,n1);
					}
				break;
				}
			case 2: {System.out.println("You chose to ignore the situation and move on");
					npc1 n1 = () -> { return false;};
					pressAnyKeyToContinue();
					Encounter3(p1,s1,n1);
					break;
					}
			case 3: {System.out.println("You watch the Farmer get killed by the Blackhounds. It awakens something in you...\n Corruption +1");
					p1.Corruption +=1;
					npc1 n1 = () -> { return false;};
					pressAnyKeyToContinue();
					Encounter3(p1,s1,n1);
					break;
				}
			}
	  }
	  public void Encounter3(Player p1, Stats s1, npc1 n1) {
		   System.out.println("Later in the night, Mirai saw smoke in the forest. He rushed over to see a little boy trying to save his baby sister from his hut that was set on fire.\nMirai was faced with yet another difficult choice. What do you do?\r\n"
		   		+ "\n");
		   Scanner sc = new Scanner(System.in);
			System.out.println("\nPress 1 to Save the Kids\nPress 2 to Ignore the encounter\nPress 3 to Watch the kids Die(Corruption Increase)");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: {System.out.println("You Save the kids from the fire! Mirai Gained an Mana Increase\nMP +30");
					p1.maxMana += 30;
					p1.Mana = p1.maxMana;
					pressAnyKeyToContinue();
					npc2 n2 = () -> { return true;};
					Encounter4(p1,s1,n1,n2);
					break;}
			case 2: {System.out.println("You chose to ignore the situation and move on");
					pressAnyKeyToContinue();
					npc2 n2 = () -> { return false;};
					Encounter4(p1,s1,n1,n2);
					break;}
			case 3: {System.out.println("You watch the kids get killed. It awakens something in you...\n Corruption +1");
					p1.Corruption +=1;
					pressAnyKeyToContinue();
					npc2 n2 = () -> { return false;};
					Encounter4(p1,s1,n1,n2);
					break;
					}
			}
			 
	  }
	  public void Encounter4(Player p1, Stats s1, npc1 n1, npc2 n2) {
		  System.out.print("On his way out of the forest, Mirai felt a lurking presence in the woods.\nNot a minute later he is ambushed from above by a Dark Ranger, a rival class to his father's. You choose to fight.\r\n"
		  		+ "\n");
		  Enemy DarkRanger = new Enemy(0,0,0,0);
		  DarkRanger.fight(p1,s1);
			if(p1.HP <= 0) {
				System.out.println("YOU DIED");
				pressAnyKeyToContinue();
				Enter.enterMessage();
			}
			else {
				System.out.println("You Defeated the Dark Ranger! Mirai Gained an Attack Boost\nAttack +10");
				p1.Attack += 10;
				p1.Intelligence +=10;
				pressAnyKeyToContinue();
			}
			Encounter5(p1,s1,n1,n2);
	  }
	  public void Encounter5(Player p1, Stats s1, npc1 n1, npc2 n2) {
		  System.out.print("The ranger goes down on his knees and collapses to the ground. Mirai is almost about to leave, but he's stopped to see a black mana mage emerge from the shadows.\nThe mage revives the dark ranger and remotely controls him like a puppet. You choose to fight.\r\n"
		  		+ "\n");
		  Enemy PuppetRanger = new Enemy(20,20,20,10);
		  PuppetRanger.fight(p1,s1);
			if(p1.HP <= 0) {
				System.out.println("YOU DIED");
				pressAnyKeyToContinue();
				Enter.enterMessage();
			}
			else {
				System.out.println("You Defeated the Dark Ranger! Then the Dark Mage Emerges from the shadows.\nYou prepare to fight again");
				p1.HP = p1.maxHP;
				p1.Mana = p1.maxMana;
				Enemy DarkMage = new Enemy(20,20,10,10);
				DarkMage.fight(p1, s1);
				if(p1.HP <= 0) {
					System.out.println("YOU DIED");
					pressAnyKeyToContinue();
					Enter.enterMessage();
				}
				else {
					System.out.println("You Defeated the Dark Mage! Mirai Gained an Mana Increase\nMana +30");
					p1.maxMana += 30;
					p1.Mana = p1.maxMana;
				}
				pressAnyKeyToContinue();
			}
			Encounter6(p1,s1,n1,n2);
	  }
	  public void Encounter6(Player p1, Stats s1, npc1 n1,npc2 n2) {
		   System.out.println("Upon reaching the stream, Mirai could see the tracks covered in blood. He comes across a dying man laying near the river.\nWould you take some time out to bring him a blood flower from the nearby fields or would you leave him to his misery? \r\n"
		   		+ "\n");
		   Scanner sc = new Scanner(System.in);
			System.out.println("\nPress 1 to Save the Man\nPress 2 to Ignore the encounter\nPress 3 to Put the man out of his misery(Corruption Increase)");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: {System.out.println("You Save the Man and brought him a blood flower. Mirai Gained an HP Increase\nHP +80");
					p1.maxHP += 80;
					p1.HP = p1.maxHP;
					pressAnyKeyToContinue();
					npc3 n3 = () -> { return true;};
					Encounter7(p1,s1,n1,n2,n3);
					break;}
			case 2: {System.out.println("You chose to ignore the situation and move on");
					npc3 n3 = () -> { return false;};
					pressAnyKeyToContinue();
					Encounter7(p1,s1,n1,n2,n3);
					break;}
			case 3: {System.out.println("You put the man out of his misery. It awakens something in you...\n Corruption +1");
					p1.Corruption +=1;
					npc3 n3 = () -> { return false;};
					pressAnyKeyToContinue();
					Encounter7(p1,s1,n1,n2,n3);
					break;
					}
			}
}
	  public void Encounter7(Player p1, Stats s1, npc1 n1, npc2 n2, npc3 n3) {
		  System.out.print("Night falls again. Mirai enters a cold rice field with wind blowing so strong it could batter his face. Mirai somehow makes his way through the rice field.\nThe cold puts him in a penalty and minimizes his abilities. He comes across a Knight on a horse, but upon close inspection, he realizes the knight has no face.\nThe Fallen Knight challenges you to a duel. You choose to fight."+
				  			"\n");
		  p1.Attack = p1.Attack/2;
		  p1.Intelligence = p1.Intelligence/2;
		  Enemy FallenKnight = new Enemy(20,20,15,10);
		  FallenKnight.fight(p1,s1);
			if(p1.HP <= 0) {
				System.out.println("YOU DIED");
				pressAnyKeyToContinue();
				Enter.enterMessage();
			}
			else {
				System.out.println("You Defeated the Fallen Knight! Mirai Gained an Attack Boost\nAttack +30");
				p1.Attack = p1.Attack*2;
				p1.Intelligence= p1.Intelligence*2;
				p1.Attack += 30;
				p1.HP = p1.maxHP;
				p1.Mana = p1.maxMana;
				pressAnyKeyToContinue();
			}
			BossEncounter(p1,s1,n1,n2,n3);
	  }
	public void BossEncounter(Player p1, Stats s1, npc1 n1, npc2 n2, npc3 n3) {
		System.out.println("Everything comes full circle. Mirai finally arrives back at the opened magic barrier. He tries to punch in the rune he took out, but as soon as he does that, he turns around to see his own dark manifestation standing behind him.\nThis doppelganger looks and moves just like Mirai, has hollow eyes and has a foul aura emitting from him. The second part of the seer's prophecy starts echoing in Mirai's mind, \"From you it emerges and to you it shall return.\" Mirai charges for one last stand, against himself.\nYou choose to go all out.\r\n"
				+ "\n");
		Boss Doppleganger = new Boss(p1);
		Doppleganger.fight(p1, s1);
		if(p1.HP <= 0) {
			System.out.println("YOU DIED");
			pressAnyKeyToContinue();
			Enter.enterMessage();
		}
		else {
			System.out.println("After what seems to be a night-long battle, Mirai finally comes out on top.\nHe's faced with a choice that could make or break who he is. ");
			System.out.println("Press 1 to Kill his own dark manifestation\n Press 2 to Attempt to purify the manifestion\n");
			if(p1.Corruption==4) {
				System.out.println("Press 3 to Merge with your evil manifestation\n");
			}
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch(choice) {
			case 1: {System.out.println("Mirai chooses to kill the doppleganger...\r\n"
					+ "As Mirai pierced the doppleganger's core with his sword, he felt something within him, as if something just stabbed him, instead of the doppleganger. As the doppleganger was slowly vanishing, it burst out a cynical laughter.\r\n"
					+ "\"What's so funny?\", asked injured Mirai.\r\n"
					+ "\"You fool! Do you even know what I am, and why you are feeling as if you're slowly dying?\", replied the doppleganger. \"When you broke the barrier, the higher black mana mages sensed a special core within you, which could make you more powerful, and depending on what you strongly feel, your powers will bend to that feeling. So, they invaded your village and killed all the ones dear to you. This lead you to develop feelings of hatred and anger. But what the mages didn't know was that your core is special for a reason; the unique ability to physically manifest your strong feelings. Your absolutely strong feelings of hatred and revenge towards the black mana beasts lead to my incarnation with some of your life force, and those feelings were so intense that not only did i had a physical form, but also a mind, which was only filled with revenge, hatred and anger! And since you have killed me, the feeling of hatred and revenge, the reason for you to live and venture on this journey and your life force are also gonna vanish along with me.\", says the doppleganger, while slowly succumbing to its fate. \"Who knows, maybe you could've done something else to stop yourself from dying like a collateral damage and actaully sstop the evil of this world!\"\r\n"
					+ "As the doppleganger completes its last sentence, it vanishes, and along with it, Mirai dies where he was laying, with full of regrets and despair.\r\n"
					+ "");
					break;
			}
			case 2:{ if(n1.check()==true && n2.check()==true && n3.check()==true) {
					System.out.println("Mirai chooses to purify the doppleganger...\r\n"
							+ "Mirai had the intention to save the doppleganger, so he tried to purify it so as to release it from all the evil and negativity. Mirai used all the mana left within him to activate the Purification spell. The doppleganger was silent all along, but after seeing that Mirai was kind enough to purify it, Something strange started to happen.\r\n"
							+ "\r\n"
							+ "Purification spells rid this world from black mana beasts and other negative spirits by damaging their core and turning them to ashes. But what was happening in front of Mirai's eyes surprised him! \r\n"
							+ "The doppleganger, at first started to evaporate, but then it started to change it's form and turned back to how he looked, like Mirai...\r\n"
							+ "Mirai started to get ready for battling him again, though this time with fatigue from multiple battles and zero strength. But the doppleganger, although silent till now, spoke for the first time and asked Mirai to calm down.\r\n"
							+ "The newly reborn doppleganger explained to Mirai,\"When you broke the barrier, the higher black mana mages sensed a special core within you, which could make you more powerful, and depending on what you strongly feel, your powers will bend to that feeling. So, they invaded your village and killed all the ones dear to you. This lead you to develop feelings of hatred and anger. But what the mages didn't know was that your core is special for a reason; the unique ability to physically manifest your strong feelings. Your absolutely strong feelings of hatred and revenge towards the black mana beasts lead to my incarnation with some of your life force, and those feelings were so intense that not only did i had a physical form, but also a mind, which was only filled with revenge, hatred and anger!\"\r\n"
							+ "Surprised Mirai then asked the doppleganger, \"Why are you explaining this to me and why haven't you left this world already?!\"\r\n"
							+ "The doppleganger answered,\"Remember I told you I'm the physical manfestation of your feelings?! Even though you were so despaired and was on a revenge spree, you still cared enough to release the black mana beasts and help the people you stumbled upon your journey. When you used your mana to Purify me, what you actually did was conveyed your kindness towards me and my core was filled with your good intentions. Now even though I still have your negative feelings, I also have the positive feelings too!\"\r\n"
							+ "\"So now what are you going to do?\"\r\n"
							+ "\"I have a proposition for you... if we merge together, it will multiply the power you have within you many times fold. This will help you in your journey and make you more powerful than you ever were before!!!\"\r\n"
							+ "\r\n"
							+ "Reluctant to agree to its terms, Mirai felt that the malicious intent from it was gone, and he can feel that what it is saying is true. \r\n"
							+ "After giving much thought, Mirai agreed to the doppleganger's terms and as they merged, the stats of Mirai increased many times fold, as it said. And with this newly achieved strength, Mirai set out on the journey with a travel companion (a conscience of the doppleganger which is inside him) and firm determination to raise hell for those who turned his town into one.");
					break;
				}
			else {
				System.out.println("Mirai chooses to kill the doppleganger...\r\n"
						+ "As Mirai pierced the doppleganger's core with his sword, he felt something within him, as if something just stabbed him, instead of the doppleganger. As the doppleganger was slowly vanishing, it burst out a cynical laughter.\r\n"
						+ "\"What's so funny?\", asked injured Mirai.\r\n"
						+ "\"You fool! Do you even know what I am, and why you are feeling as if you're slowly dying?\", replied the doppleganger. \"When you broke the barrier, the higher black mana mages sensed a special core within you, which could make you more powerful, and depending on what you strongly feel, your powers will bend to that feeling. So, they invaded your village and killed all the ones dear to you. This lead you to develop feelings of hatred and anger. But what the mages didn't know was that your core is special for a reason; the unique ability to physically manifest your strong feelings. Your absolutely strong feelings of hatred and revenge towards the black mana beasts lead to my incarnation with some of your life force, and those feelings were so intense that not only did i had a physical form, but also a mind, which was only filled with revenge, hatred and anger! And since you have killed me, the feeling of hatred and revenge, the reason for you to live and venture on this journey and your life force are also gonna vanish along with me.\", says the doppleganger, while slowly succumbing to its fate. \"Who knows, maybe you could've done something else to stop yourself from dying like a collateral damage and actaully sstop the evil of this world!\"\r\n"
						+ "As the doppleganger completes its last sentence, it vanishes, and along with it, Mirai dies where he was laying, with full of regrets and despair.\r\n"
						+ "\n");
				break;
				}
			}
			case 3: {
				if(p1.Corruption==4) {
				System.out.println("On Mirai's hostile enquiry, the doppelganger revealed that he was just a manifestation of Mirai's sub-conscious mind, a shadow, that nurtured on the feelings of hatred and anger. The black mana needed a core, one of strong resolve, which is why Mirai had everyone near and dear to him taken away. Mirai, in denial, grabbed the doppelganger by his collar while he was trying to make sense of what he had just been told.\nHe looked deep into his hollow eyes, and before he knew it, the doppelganger let out a brief chuckle. All hell broke loose as the doppelganger tried seeping into Mirai's body, as if they were always meant to be one.\nAfter a heavily one-sided struggle, Mirai who was laying knocked out on the ground, opens his eyes, only to reveal none...\r\n"
						+ "");
				break;
					}
				else {
					break;
					}
					}
				}
			}
		}
		
	}

//The abstract class StatValues is created which shows stats
abstract class StatValues{
	int maxHP = 100;
	int maxMana = 50;
	int Attack = 20;
	int Intelligence = 10;
	
	void IncreaseHP(int h) {
		maxHP += h;
	}
	void IncreaseMana(int m) {
		maxMana += m;
	}
	void IncreaseAttack(int a) {
		Attack += a;
	}
	void IncreaseIntelligence(int i) {
		Intelligence += i;
	}
}

//The interfaces PlayerStats and EnemyStats are created
interface PlayerStats
{
    void pstats(Player p1);
}

interface EnemyStats
{
    void estats(Enemy e1);
}

//The derived class Stats implements the interfaces which shows multiple inheritace
class Stats implements PlayerStats, EnemyStats
{
    public void pstats(Player p1)
    {
        System.out.println("Hp = "+ p1.HP);
        System.out.println("Mana = "+ p1.Mana);
        System.out.println("Attack = "+ p1.Attack);
        System.out.println("Corruption = "+ p1.Corruption);
		System.out.println("Intelligence = "+ p1.Intelligence); 
    }
    public void estats( Enemy e1)
    {
        System.out.println("Hp = "+ e1.HP);
        System.out.println("Attack = "+ e1.AttackDmg1);
        System.out.println("Mana = "+ e1.Mana);
    }
    public void estats( Boss b1)
    {
        System.out.println("Hp = "+ b1.HP);
        System.out.println("Attack = "+ b1.AttackDmg1);
        System.out.println("Mana = "+ b1.Mana);
    }

}

//Subclassing is implemented here as the subclass Player is created which extends the super class StatValues
//It shows single inheritance
class Player extends StatValues{
	int HP;
	int Mana;
	int Corruption = 1;
	Player(){
		int i = 0;
		System.out.println("Please Create your Character");
		System.out.println("Enter 1 to Increase your HP \n2 to Increase Mana \n3 to Increase Attack \n4 to Increase Intelligence");
		Scanner sc1 = new Scanner(System.in);
		while (i<4) {
			System.out.println("\n you have "+ (4-i)+" point(s) left");
		int choice = sc1.nextInt();
		switch(choice) {
		case 1 : IncreaseHP(5);
				 break;
		case 2 : IncreaseMana(5);
				 break;
		case 3 : IncreaseAttack(3);
				 break;
		case 4 : IncreaseIntelligence(3); 
				 break;
				
 			}
		i++;
		}
		HP = maxHP;
		Mana = maxMana;
	}
	void Attack(Enemy e1,double Modifier) {
		e1.HP -= Attack*Modifier;
	}
	void Attack(Boss b1,double Modifier) {
		b1.HP -= Attack*Modifier;
	}
	void Heal() {
		if(HP<maxHP) {
			HP = HP+30+Intelligence;
			Mana -= 5;
			int s = 30+Intelligence;
			System.out.println("You Healed for"+s+" HP " +"\n \n \n");
		}
		else {
			System.out.println("Can't Heal" +"\n \n \n"); //PLACEHOLDER
		}
	}
	void CorrDmg(Enemy e1) {
		if(Mana>20)
		e1.HP -= Attack*Corruption + Intelligence;
		Mana -= 15;
	}
	public void CorrDmg(Boss b1) {
		if(Mana>20)
			b1.HP -= Attack*Corruption + Intelligence;
			Mana -= 15;
	}
	
}

//Interface Enemy1 is created which is implemented by classes Enemy and Boss thus implementing hierarchical inheritance
interface Enemy1{
	void Attack(Player a,Double b);
	void SpecialAttack(Player a, Double b);
	int MaxHP = 100;
	int MaxMana = 50;
	int AttackDmg = 20;
	int MagicDmg = 30;
	void fight(Player a, Stats s);
	
}
class Enemy implements Enemy1{
	int HP;
	int Mana;
	int AttackDmg1;
	int MagicDmg1;
	 Enemy(int HPModifier,int ManaModifier,int DamageModifier, int MagicModifier){
		HP = MaxHP+HPModifier;
		Mana=MaxMana+ManaModifier;
		AttackDmg1 = AttackDmg+DamageModifier;
		MagicDmg1 = MagicDmg+MagicModifier;
	}
	public void fight(Player p1, Stats s1){
		Random random = new Random();  
		int d1=0,d2=0;
		while(p1.HP>0 && HP>0)
		{	 d1=0;
			System.out.println("\nYour Stats Are - ");
			s1.pstats(p1);
		System.out.println("\nThe Enemy's Stats Are - ");
			s1.estats(this);
			Scanner sc2 = new Scanner(System.in);
			System.out.println("\nEnter 1 to Attack, 2 to Defend, 3 to Heal(5 Mana) , 4 to Use Magic(15 Mana) \n \n");
			int choice1 = sc2.nextInt();
			switch(choice1) {
			case 1:{ if(d2==1) {
				p1.Attack(this,0.3);
				System.out.println("You Attacked for " +p1.Attack*0.3+"\n \n \n");
			}
			else {
				p1.Attack(this,1);
				System.out.println("You Attacked for " +p1.Attack+"\n \n \n");
			}
				break;}
			case 2: d1 = 1;
					System.out.println("You Defend for the Next Turn" +"\n \n \n");
					break;
			case 3: p1.Heal();
					break;
			case 4: 
				p1.CorrDmg(this);
				System.out.println("You Used Magic to Attack! You Attacked for " +p1.Attack*p1.Corruption);
				break;
			}d2=0;
	
				int choice2 = random.nextInt(3); 
				switch(choice2) {
				case 0: {if(d1==1) {
					this.Attack(p1,0.4);
					System.out.println("You were Attacked for " +this.AttackDmg1*0.4 +"\n \n \n");
				}
				else {
					this.Attack(p1,1.0);
					System.out.println("You were Attacked for " +this.AttackDmg1+"\n \n \n");
				}
					break;
				}
				case 1: d2 = 1;
						System.out.println("The Enemy Defends!" +"\n \n \n");
						break;
				case 2: {if(d1==1) {
					this.SpecialAttack(p1,0.6);
				}
				else {
					this.SpecialAttack(p1,1.0);
					}
				}
			}
		}
	}

	public void Attack(Player p1, Double Modifier) {
		p1.HP -= AttackDmg1*Modifier;
	}
	public void SpecialAttack(Player p1, Double Modifier) {
		if(this.Mana>20) {
		p1.HP -= MagicDmg1*Modifier;
		this.Mana -= 20;
		System.out.println("The Enemy Used a Special Attack! You were Attacked for " +this.MagicDmg1*Modifier+"\n \n \n");
	}
		else
		{
			System.out.println("The Enemy Tried to use A Magic Attack but it did not have any Mana Left!");
		}
	}
}
	 
class Boss implements Enemy1{
	int HP;
	int Mana;
	int AttackDmg1;
	int MagicDmg1;
	Boss(Player p1){
		HP = p1.maxHP;
		Mana=p1.maxMana;
		AttackDmg1 = p1.Attack;
		MagicDmg1 = MagicDmg+p1.Intelligence;
	}
	public void Attack(Player p1, Double Modifier) {
		p1.HP -= AttackDmg1*Modifier;
	}
	@Override
	public void fight(Player p1, Stats s1){
		Random random = new Random();  
		int d1=0,d2=0;
		while(p1.HP>0 && HP>0)
		{	 d1=0;
			System.out.println("\nYour Stats Are - ");
			s1.pstats(p1);
		System.out.println("\nThe Doppleganger's Stats Are - ");
			s1.estats(this);
			Scanner sc2 = new Scanner(System.in);
			System.out.println("\nEnter 1 to Attack, 2 to Defend, 3 to Heal(5 Mana) , 4 to Use Magic(15 Mana) \n \n");
			int choice1 = sc2.nextInt();
			switch(choice1) {
			case 1:{ if(d2==1) {
				p1.Attack(this,0.4);
				System.out.println("You Attacked for " +p1.Attack*0.4+"\n \n \n");
			}
			else {
				p1.Attack(this,1);
				System.out.println("You Attacked for " +p1.Attack+"\n \n \n");
			}
				break;}
			case 2: d1 = 1;
					System.out.println("You Defend for the Next Turn" +"\n \n \n");
					break;
			case 3: p1.Heal();
					break;
			case 4: 
				p1.CorrDmg(this);
				System.out.println("You Used Magic to Attack! You Attacked for " +p1.Attack*p1.Corruption);
				break;
			}d2=0;
	
				int choice2 = random.nextInt(3); 
				switch(choice2) {
				case 0: {if(d1==1) {
					this.Attack(p1,0.4);
					System.out.println("The Doppleganger Attacked you for " +this.AttackDmg1*0.4 +"\n \n \n");
				}
				else {
					this.Attack(p1,1.0);
					System.out.println("The Doppleganger Attacked you for " +this.AttackDmg1+"\n \n \n");
				}
					break;
				}
				case 1: d2 = 1;
						System.out.println("The Doppleganger Defends!" +"\n \n \n");
						break;
				case 2: {if(d1==1) {
					this.SpecialAttack(p1,0.6);
				}
				else {
					this.SpecialAttack(p1,1.0);
					}
				}
			}
		}
	}


	@Override
	public void SpecialAttack(Player p1, Double Modifier) {
		if(this.Mana>20) {
		p1.HP -= MagicDmg1*Modifier;
		this.Mana -= 20;
		System.out.println("The Doppleganger Used a Special Attack! You were Attacked for " +this.MagicDmg1*Modifier+"\n \n \n");
	}
		else
		{
			System.out.println("The Doppleganger Tried to use A Magic Attack but it did not have any Mana Left!");
		}
	}
}