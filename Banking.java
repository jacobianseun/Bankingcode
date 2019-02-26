import java.util.Random;
import java.util.Scanner;

public class Banking{
	private  String name;
	private  String accountNumber="";
	private  double accountBalance;
	private  String visaCardNumber="";
	private  String visaCardExpiry;
	private  String visaCardPin="";
	private  Random rand;
	private  Scanner scan;
	
	public Banking(){
		rand = new Random();
		scan = new Scanner(System.in);
	}
	
	public  void generateAccountNumber(){
		// this method should generate random accountNumber
		for(int i=0; i<9; i++){
			accountNumber += rand.nextInt(9);
		}
	}
	
	public  void setName(){
		//this method should set name
		name = scan.nextLine();
		
	}
	public  String getName(){

		//should get Name;
		
		return name;

	}
	public String getAccountNumber(){

		//this method should get accountNumber
		return accountNumber;
	}
	public void depositOpeningAccountBalance(){
		double accountBalance =  scan.nextDouble();
		// should set accountBalance
		if(!(accountBalance < 1000)){
			
			this.accountBalance = accountBalance;
		}

	}
	public void adjustAccountBalace(double amount){
		accountBalance -= amount;
		// should adjust accountBalance whenever there is a transaction
	}
	public double getAccountBalance(){

		//this method should getAccountBalance
		
		return accountBalance;
	}
	public void setVisaCardNumber(){
		for(int i=0; i<12; i++){
			visaCardNumber += rand.nextInt(9);
		}
	}
	public void setVisaCardPin(){
		for(int i=0; i<3; i++){
			visaCardPin += rand.nextInt(9);
		}
	}
	public void setVisaCardExpiry(){
		
		String temp = 1 + rand.nextInt(12)+"";
		String month = (temp.length()==2)? temp :"0"+temp;
		visaCardExpiry = month+"/23";
	}
	
	public String getVisaCardNumber(){
		//should return visaCardNumber
		return visaCardNumber;
	} 
	public String getVisaCardPin(){
		return visaCardPin;
	}
	public String getVisaCardExpiry(){
		//should return visaCardExpiry
		return visaCardExpiry;
	}

	public static void main(String[] args) throws InterruptedException{
		Banking bank = new Banking();
		//starting point
		while(bank.name==null || bank.name.trim().equals("")){
			System.out.println("Please enter full name?");
			bank.setName();
		}
		while(bank.accountBalance < 1000){
			System.out.println("Please enter your first deposit (must be 1000 or above)?");
			bank.depositOpeningAccountBalance();
		}
		
		bank.generateAccountNumber();
		System.out.println("Your HSBC bank accout has been opened, see details below");
		System.out.println(" ");
		System.out.println("Account Name: "+bank.getName());
		System.out.println("Account Number: "+bank.getAccountNumber());
		System.out.println("Account Balance: "+bank.getAccountBalance());
		
		System.out.println(" ");
		System.out.println("Your visa card details are: ");
		System.out.println(" ");
		bank.setVisaCardNumber();
		bank.setVisaCardPin();
		bank.setVisaCardExpiry();
		System.out.println("Visa Card Number: "+bank.getVisaCardNumber());
		System.out.println("Account 3 digit pin: "+bank.getVisaCardPin());
		System.out.println("Account Expiry Date: "+bank.getVisaCardExpiry());
		System.out.println(" ");
		System.out.println("Hello welcome to our restaurant, what would you like to buy?");
		System.out.println(" ");
		System.out.println("1. Sharwama\t\tN3,500\t-Enter 1 to buy");
		System.out.println("2. Medium Pizza\t\tN6,000\t-Enter 2 to buy");
		System.out.println("3. Large Pizza\t\tN9,000\t-Enter 3 to buy");
		System.out.println("4. Meatpie\t\tN1,500\t-Enter 4 to buy");
		System.out.println("5. Coke\t\t\tN600\t-Enter 5 to buy");
		System.out.println("6. Grilled Chicken\tN5,000\t-Enter 6 to buy");
		int[] prices ={3500, 6000, 9000, 1500, 600, 5000};
		String[] items ={"sharwama", "Medium Pizza", "Large Pizza", "Meatpie", "Coke","Grilled Chicken"};
		System.out.println(" ");
		System.out.println("please Select item to buy");
		int selection = bank.scan.nextInt()-1;
		String purchases = "you selected 1 "+items[selection]+"\n";
		int amount = prices[selection];
		int test = 0;
		while(test !=10 ){
			System.out.println("please Select another item to buy or enter 11 to end");
			selection = bank.scan.nextInt() - 1;
			if(selection != 10){
				purchases += "you selected 1 "+items[selection]+"\n";
				amount += prices[selection];
			}
			test = selection;
		}
		
		System.out.println(" ");
		System.out.println(purchases);
		System.out.println(" ");
		System.out.println("Total Amount: "+ amount);
		System.out.println(" ");
		
		System.out.println("Please enter your visa card number");
		String cardNumber = bank.scan.next();
		while(!cardNumber.equals(bank.getVisaCardNumber())){
			System.out.println("Invalid card number please try again");
			cardNumber = bank.scan.next();	
		}
		
		System.out.println(" ");
		System.out.println("Please enter your visa card 3 digit pin");
		String pinNumber = bank.scan.next();
		while(!pinNumber.equals(bank.getVisaCardPin())){
			System.out.println("Invalid pin number please try again");
			pinNumber = bank.scan.next();	
		}
		
		System.out.println(" ");
		System.out.println("Please enter your visa card expiry (format mm/yy)");
		String expiry = bank.scan.next();
		while(!expiry.equals(bank.getVisaCardExpiry())){
			System.out.println("Invalid expiry please try again");
			expiry = bank.scan.next();	
		}
		
		System.out.println(" ");
		System.out.println("Conneting please wait...");
		
		Thread.sleep(5000);
		
		if(amount > bank.getAccountBalance()){
			System.out.println("....Insufficient balance, transaction failed....");
		}else{
			System.out.println(" ");
			System.out.println("....Payment Successful....");
			
			Thread.sleep(5000);
			
			bank.adjustAccountBalace(amount);
			System.out.println(" ");
			System.out.println("DEBIT ALERT");
			System.out.println("DR:N"+amount);
			System.out.println("Balance:"+bank.getAccountBalance());
			
		}
	}
}