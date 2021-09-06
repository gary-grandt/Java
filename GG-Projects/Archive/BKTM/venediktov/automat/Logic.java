package BKTM.venediktov.automat;

import BKTM.venediktov.stackQueList.List;
import BKTM.venediktov.stackQueList.Stack;

public class Logic {
	// -----------------
	// --- Variables ---
	// -----------------

	// MoneyInts
	private int ct5_amount;
	private int ct10_amount;
	private int ct20_amount;
	private int ct50_amount;
	private int euro1_amount;
	private int euro2_amount;

	// MoneyStrings
	private String ct5_string = " 5ct ";
	private String ct10_string = " 10ct ";
	private String ct20_string = " 20 ct";
	private String ct50_string = " 50ct ";

	private String euro1_string = " 1euro ";
	private String euro2_string = " 2eur0 ";

	// --- Payment ---

	// PayIn
	private int cts;
	private int euros;

	// PayOut
	private String payOut;
	
	
	//--- Products ---
	
	//Product Names
	private static String[] products_Strings = { "Error : Arry[0] element",
			"Arduino Uno", "Arduino Yun", "Arduino Nano",
			"Esp 01", "Esp 8266", " D1 mini",
			"Kabel", "Lötzinn", "Conectors"
			};
	
	//Product Preise ct
	private static int[] product_ct = { -1,
			45, 35, 45,
			0, 45, 20,
			45, 55, 65
			};
	
	//Product Preise euro
	private static int[] product_euro = { -1,
			6, 23, 1,
			1, 4, 2,
			3, 5, 0
			};
	

	// ---------------
	// --- Objects ---
	// ---------------

	// parent
	GUI parent;

	// Money
	private Stack ct5 = new Stack();
	private Stack ct10 = new Stack();
	private Stack ct20 = new Stack();
	private Stack ct50 = new Stack();

	private Stack euro1 = new Stack();
	private Stack euro2 = new Stack();

	private Stack bills = new Stack();
	
	//Products
	List products = new List();
	
	// ---------------
	// --- Methods ---
	// ---------------

	// Rests the Automate
	public void reset() {
		// Fill Up
		fillUp();
		
		// parent
		parent.display(" ");
		parent.display_ausgabe("");
		parent.display_rueckgeld("");
	}

	public void fillUp() {

		// --- FillUp the MoneySlots ---

		// FillingDown the MoneySlots
		while (!ct5.isEmpty())
			ct5.pop();
		while (!ct10.isEmpty())
			ct10.pop();
		while (!ct20.isEmpty())
			ct20.pop();
		while (!ct50.isEmpty())
			ct50.pop();

		while (!euro1.isEmpty())
			euro1.pop();
		while (!euro2.isEmpty())
			euro2.pop();
		
		// FillingUp the MoneySlots
		for (int i = 0; i < 50; i++) {
			ct5.push(ct5_string);
			ct10.push(ct10_string);
			ct20.push(ct20_string);
			ct50.push(ct50_string);

			euro1.push(euro1_string);
			euro2.push(euro2_string);
		}

		// Reseting the Amounts
		ct5_amount = 50;
		ct10_amount = 50;
		ct20_amount = 50;
		ct50_amount = 50;

		euro1_amount = 50;
		euro2_amount = 50;

		// Empty out the Bills
		while (!bills.isEmpty())
			bills.pop();
		
		// Reseting the PayIn
		cts = 0;
		euros = 0;
		
		// Reseting the PayOutString
		payOut = "";
		
		
		// --- Fill Up the Products ---
		
		products.toFirst();
		while(!products.isEmpty()) products.remove();
		
		products.toFirst();
		for(int i = 9; i >= 1; i--) {
			Stack buffer = new Stack();
			for(int j = 0; j < 20; j++) {
				buffer.push(products_Strings[i]);
			}
			products.insert(buffer);
			products.toFirst();
		}
		
	}
	
	// Need fillUp()?
	private boolean needFillUp() {
		if(
			 ct5_amount >= 10 &&
			ct10_amount >= 10 &&
			ct20_amount >= 10 &&
			ct50_amount >= 10 &&
			
			euro1_amount >= 10 &&
			euro2_amount >= 10 
				) {
			return false;
		}else {
			return true;
		}
			
	}
	
	
	// Pay In
	public void payIn(int payInNumber) {
		// Need fillUp?
		if(needFillUp()) {
			parent.display(" Need FillUp! ");
			return;
		}
		
		if(euros >= 25 ||
			payInNumber == 2 && euros >= 24 && cts > 90 ||
			payInNumber == 3 && euros >= 24 && cts > 80 ||
			payInNumber == 4 && euros >= 24 && cts > 50 ||
			payInNumber == 5 && euros > 24 ||
			payInNumber == 6 && euros > 23 ||
			payInNumber == 7 && euros > 20 ||
			payInNumber == 8 && euros > 15 ||
			payInNumber == 9 && euros > 5
			) {
			parent.display("Max PayIn : 25 Euros; Euro : " + euros + " cts : " + cts);
			
		}else {		
		switch (payInNumber) {
		case 1: 
			ct5.push(ct5_string);
			ct5_amount++;
			if(cts >= 95) {
				cts = (cts +5) -100;
				euros++;
			}else {
				cts = cts +5;
			}
			break;
		case 2: 
			ct10.push(ct10_string);
			ct10_amount++;
			if(cts >= 90) {
				cts =(cts +10) -100;
				euros++;
			}else {
				cts = cts +10;
			}
			break;
		case 3: 
			ct20.push(ct20_string);
			ct20_amount++;
			if(cts >= 80) {
				cts = (cts +20) -100;
				euros++;
			}else {
				cts = cts +20;
			}
			break;
		case 4: 
			ct50.push(ct50_string);
			ct50_amount++;
			if(cts >= 50) {
				cts = (cts +50) -100;
				euros++;
			}else {
				cts = cts +50;
			}
			break;
		case 5: 
			euro1.push(euro1_string);
			euro1_amount++;
			euros++;
			break;
		case 6: 
			euro2.push(euro2_string);
			euro2_amount++;
			euros = euros +2;
			break;
		case 7: 
			bills.push("euro5");
			euros = euros +5;
			break;
		case 8: 
			bills.push("euro10");
			euros = euros +10;
			break;
		case 9: 
			bills.push("euro20");
			euros = euros +20;
			break;
		default: System.out.println("Error: Logic.payIn(int) \n ==> Incorect Number!\n");
		}
		displayMoney();
		}
	}
	
	// Display Money
	private void displayMoney() {
		parent.display("Euros : " + euros + " cts : " + cts);
	}
	
	// PayOut
	public void payOut() {
		payOut = "";
		// PayOut 2euros
		if(euros == 0 && cts == 0) {
			parent.display("No PayIn!");
		}else {
			//PayOut Loop
			while(euros != 0 || cts != 0) {
				
				// PayOut : euros2
				if(euros >= 10) {
					euros = euros -2;
					
					payOut = payOut + euro2.top();
					euro2.pop();
					euro2_amount--;
					
				// PayOut : 1euros
				}else if(euros >= 5) {
					euros = euros -1;
					
					payOut = payOut + euro1.top();
					euro1.pop();
					euro1_amount--;
					
				// PayOut : 50cts
				}else if(euros >= 2) {
					if(cts >= 50) {
						cts = cts -50;
					}else {
						euros--;
						cts = cts +50;
					}
					payOut = payOut + ct50.top();
					ct50.pop();
					ct50_amount--;
					
				// PayOut : 20cts
				}else if(euros >= 1) {
					if(cts >= 20) {
						cts = cts -20;
					}else {
						euros--;
						cts = cts +80;
					}
					payOut = payOut + ct20.top();
					ct20.pop();
					ct20_amount--;
					
				// PayOut : 10cts
				}else if(cts >= 25) {
					cts = cts -10;
					
					payOut = payOut + ct10.top();
					ct10.pop();
					ct10_amount--;
					
				// PayOut : 5cts
				}else {
					cts = cts -5;
					
					payOut = payOut + ct5.top();
					ct5.pop();
					ct5_amount--;
				}
				
				
			}
			displayMoney();
			parent.display_rueckgeld(payOut);
		}
	}
	
	
	
	// Buy Products
	public void buyProduct(int b) {
		// b ==> BuyProductNumber
		
		//Can Buy
		if(cts >= product_ct[b] && euros >= product_euro[b]) {
			cts = cts -product_ct[b];
			euros = euros -product_euro[b];
			displayMoney();
		}else if(euros > product_euro[b]) {
			cts = cts +100 -product_ct[b];
			euros = euros -1 -product_euro[b];
			displayMoney();
		}else {
			parent.display("Not enough Money ! ");
			return;
		}
		//Buy
		products.toFirst();
		for(int i = 1; i < b; i++) products.next();
		Stack buffer = (Stack) products.getObject();
		
		parent.display_ausgabe((String) buffer.top());
		buffer.pop();
		
		products.setObject(buffer);
		
	}
	
	//Control
	public void control() {
		
		System.out.println("\n---------------");
		System.out.println("--- Control ---");
		System.out.println("---------------\n");
		
		System.out.println("--- PayIn ---\n");
		System.out.println("Cents : " + cts);
		System.out.println("Euros : " + euros);
		
		System.out.println("\n--- Money-Amounts ----\n");
		System.out.println(" 5 Cents : " + ct5_amount);
		System.out.println("10 Cents : " + ct10_amount);
		System.out.println("20 Cents : " + ct20_amount);
		System.out.println("50 Cents : " + ct50_amount);
		System.out.println(" 1 Euros : " + euro1_amount);
		System.out.println(" 2 Euros : " + euro2_amount);
		
		System.out.println("\n--- Control-End ---\n");
	}
	
	
	// --------------------
	// --- GUI Methods ---
	// --------------------

	// --- Get Parent ---
	public void getParent(GUI gui) {
		parent = gui;
	}
	
	//--- Other Methods ---
	
	
}
