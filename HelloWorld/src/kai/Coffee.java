package kai;

public class Coffee extends Beverage{
	final int regCoffee = 1;
	final int decCoffee = 2;
	final int milk = 1001;
	final int sugar = 1002;
	final int cream = 1003;
	final int sprinkles = 1004;
	
	//Charge of two types of coffee 'regular' ($2.11) and 'decaf' ($1.51)	
	final double regCoffeeCharge = 2.11;
	final double decgCoffeeCharge = 1.51;

	//Charge of 'milk' ($0.53), 'sugar' ($0.17), 'cream' ($0.73) and 'sprinkles' ($0.29)
	final double milkCharge = 0.53;
	final double sugarCharge = 0.17;
	final double creamCharge = 0.73;
	final double sprinklesCharge = 0.29;
	
	private boolean addMilk = false;
	private boolean addSugar = false;
	private boolean addCream = false;
	private boolean addSprinkles = false;
	private int theCoffeeType = 0;
	private double theCoffeeCharge = 0;	
	private String coffeeDesc = "";
	
	protected void setType(int coffeeType) {
		theCoffeeType  = coffeeType;
		if ((theCoffeeType == regCoffee)||(theCoffeeType == decCoffee)) {
			addMilk = false;
			addSugar = false;
			addCream = false;
			addSprinkles = false;	
			if (coffeeType == regCoffee) {
				theCoffeeCharge = regCoffeeCharge;
				coffeeDesc = "regular";
			} else if (coffeeType == decCoffee) {
				theCoffeeCharge = decgCoffeeCharge;
				coffeeDesc = "decaf";
			} 			
		}
	};
	
	private void add(int extras) {
		if ((theCoffeeType == regCoffee)||(theCoffeeType == decCoffee)) {
			switch(extras) {
			  case milk:
				theCoffeeCharge = theCoffeeCharge + milkCharge;
			    break;
			  case sugar:
				theCoffeeCharge = theCoffeeCharge + sugarCharge;
			    break;
			  case cream:
				theCoffeeCharge = theCoffeeCharge + creamCharge;
			    break;
			  case sprinkles:
				theCoffeeCharge = theCoffeeCharge + sprinklesCharge;
			    break;			 
			}
		}
	};
	
	void addMilk() { addMilk = true; }

	void addSugar() { addSugar = true; }
	
	void addCream() { addCream = true; }
	
	void addSprinkles() { addSprinkles = true; }
	
	public float getCost() {
		if ((theCoffeeType == regCoffee)||(theCoffeeType == decCoffee)) {
			if (theCoffeeType == regCoffee) {
				theCoffeeCharge = regCoffeeCharge;
			} else if (theCoffeeType == decCoffee) {
				theCoffeeCharge = decgCoffeeCharge;
			} 
			if (addMilk) add(milk);
			if (addSugar) add(sugar);
			if (addCream) add(cream);
			if (addSprinkles) add(sprinkles);
		}
		return Double.valueOf(theCoffeeCharge).floatValue();
	}
	
	public String getDescription() {
		coffeeDesc = "";
		if (theCoffeeType == regCoffee) {
			coffeeDesc = "regular";
		} else if (theCoffeeType == decCoffee) {
			coffeeDesc = "decaf";
		} 
		return coffeeDesc;
	};
}
