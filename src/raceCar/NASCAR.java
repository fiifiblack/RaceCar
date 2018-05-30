package raceCar;



/**
 * Evans Appiah @author GCE evans.appiah@me.com All rights reserved
 *A race between 3 cars for 100 miles. The first car to reach 100miles wins
 *The are four classes(Main , A , B ,C) in this file with the aid of a thread
 *Class A-C are the vehicle classes and the Main uses sleep method for a fair race
 *Last edit on 02/20/2018
 */

public class NASCAR {
	
boolean gameOver =false;

	public static void main(String[] args) {
			
//	long startTime = System.nanoTime();	
		
		
		NASCAR.welcome("Welcome to our main event");// welcome message
		results("Good Luck! ");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		A obj = new A();
		obj.start();// simultaneous initiation of race(call to run method)

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		B obj1 = new B();

		obj1.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		C obj2 = new C();
		obj2.start();// Run method calls start.Implicite take it like that Evans

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		long stopTime = System.nanoTime();
//		long timeElaspe = stopTime - startTime;
//		System.out.println("Time Elasped in nano seconds: " +timeElaspe+"sec");

	}

	void racePositions(boolean PD, int M, int A) {// Reckon second position
		PD = false;
		M = 0;
		A = 0;

		if (PD == true) {
			if (M > A) {
				System.out.println("Mazda is in second position and Acura comes in last");
			} else if (A > M) {
				System.out.println("Acura is in second postion and Mazda  come in last");
			}

		}

	}

	void acuraWin( int D, int M) {// Reckon second position
		
//		if (PA == true) {

			if (D > M) {
				System.out.println("Dodge in second postion and  Mazda  come in last");
			} else if (M > D)
				System.out.println("Mazda in second postion and  Dodge  come in last");
//		}
	}

	void mazdaWin(boolean PM, int D, int A) {// Reckon second position
		if (PM == true) {

			if (D > A) {
				System.out.println("Dodge is in second postion and Acura  come in last");
			} else if (D > A) {
				System.out.println("Acurais in second postion and  Dodge  come in last");

			}

		}
	}

	private static void welcome(String a) {
		// TODO Auto-generated method stub
		System.out.println(a);
	}

	private static void results(String b) {
		// TODO Auto-generated method stub
		System.out.println(b + "& may the fast and furious vehicle win" + '\n'
				+ "Watch the console for event commentary from Evans " + '\n');
	}
}

class A extends Thread {
	boolean gameOver =false;
	public int acuraVelocity;
	public int A;
	static B objB = new B();
	static C objC = new C();
	static	NASCAR objNASCAR= new NASCAR();
	public int getA() {
		return A;
	}

	public void show() {
		acuraVelocity = (int) (Math.random() * 3 + 1);

		do {
			A += acuraVelocity;
			if (A >= 30 && A < 60) {
				System.out.println("Acura completed first lap");
				System.out.println("------------------------------------------------------");
			} else if (A >= 60 && A < 80) {
				System.out.println("Acura on second lap");
				System.out.println("_______________________________________________________");
			} else if (A >= 80) {
				System.out.println("Acura on final lap");
				System.out.println("****************************************************");
			}

			acuraVelocity = (int) (Math.random() * 30 + 10);// SUBSEQUENT LAPS
			if (A >= 100)
				A = 100; // Setting speed limit

			if (objB.getD() == 100 || objB.getD() > 100 || objB.getD() == 100 || objB.getM() > 100)
			// DOUBLE WINNER ERROR CHECKING
			{

				System.exit(0);
			}

			System.out.println("Speed: " + A + " Acura Position: " + A + " miles covered ");
			if (A == 100 && objB.getM() != 100 && objB.getD() != 100) {
				System.out.println("Acura  WINS!!!!!!!!!!  WINS!! WINS!! $$$$$$$$$$$$$$$$$$$$$");
				objNASCAR.acuraWin( objC.getM(), objB.getD());
				System.exit(0);
				break;

			} else if (A == 100 && objC.getM() == 100)
				System.out.println("TIE!! ");
			else if (A == 100 && objB.getD() == 100)
				System.out.println("TIE!! ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (A < 100);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		show();
	}

	public int getM() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getD() {
		// TODO Auto-generated method stub
		return 0;
	}

}

class B extends Thread {
	
	boolean gameOver =false;
	public int dodgeVelocity;
	public int D;

	public int getD() {
		return D;
	}

	public int getM() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void show() {

		dodgeVelocity = (int) (Math.random() * 4 + 2);

		do {
			D += dodgeVelocity;
			if (D >= 30 && D < 60) {
				System.out.println("Dodge completed first lap");
				System.out.println("------------------------------------------------------");
			} else if (D >= 60 && D < 80) {
				System.out.println("Dodge on second lap");
				System.out.println("_______________________________________________________");
			} else if (D >= 80) {
				System.out.println("Dodge on  final lap");
				System.out.println("****************************************************");
			}

			A objA = new A();// OBJECT TO ACCESS GETTERS
			B objB = new B();
			C objC = new C();

			dodgeVelocity = (int) (Math.random() * 40 + 20);// SUBSEQUENT LAPS 40 1
			if (D >= 100)
				D = 100; // Setting speed limit

			System.out.println("Speed: " + D + " Dodge Position: " + D + " miles covered ");
			if (objA.getA() == 100 || objA.getA() > 100 || objC.getM() == 100 || objC.getM() > 100)// DOUBLE WINNER
																									// ERROR CHECKING
			{

				System.exit(0);
			}
			if (D == 100 && objC.getM() != 100 && objA.getA() != 100) {
				System.out.println("Dodge   WINS!!!!!!!!!!  WINS!! WINS!! $$$$$$$$$$$$$$$$$$$$$");
				System.exit(0);
				return;// to terminate program as in break. this used with or without a loop
				
			} else if (D == 100 && objC.getM() == 100)//
				System.out.println("TIE!! ");
			else if (D == 100 && objA.getA() == 100)
				System.out.println("TIE!! ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (D < 100);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		show();
	}
}

class C extends Thread {
	boolean gameOver =false;
	int mazdaVelocity;
	int M;

	public int getM() {
		return M;
	}

	public void show() {

		mazdaVelocity = (int) (Math.random() * 5 + 1); // FIRST LAP
		do {
			M += mazdaVelocity;

			if (M >= 30 && M < 60) {
				System.out.println("Mazda completed first lap");
				System.out.println("------------------------------------------------------");
			} else if (M >= 60 && M < 80) {
				System.out.println("Mazda on second lap");
				System.out.println("_______________________________________________________");
			} else if (M >= 80) {
				System.out.println("Mazda  on final lap");
				System.out.println("****************************************************");
			}

			A objA = new A();
			B objB = new B();
			C objC = new C();

			mazdaVelocity = (int) (Math.random() * 50 + 10);// SUBSEQUENT LAPS
			if (M >= 100)
				M = 100; // Setting speed limit
			if (objB.getD() == 100 || objB.getD() > 100 || objA.getA() == 100 || objA.getA() > 100)// DOUBLE WINNER
																									// ERROR CHECKING
			{

				System.exit(0);
				break;
			}

			System.out.println("Speed: " + M + " Mazda Position: " + M + " miles covered ");
			if (M == 100 && objB.getD() != 100 && objA.getA() == 100) {
				System.out.println("Mazda  WINS!!!!!!!!!!  WINS!! WINS!! $$$$$$$$$$$$$$$$$$$$$");
				System.exit(0);
				break;// to terminate program as in 'return'. this used only in a loop

			} else if (M == 100 && objB.getD() == 100)
				System.out.println("TIE!! ");
			else if (M == 100 && objA.getA() == 100)
				System.out.println("TIE!! ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (M < 100);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		show();
		
	}
}/* rewrite this program using an instance of speed from from a type (vehicle)
Mazda never wins 03/29/2018
fix issues of returning zero in getters*/
