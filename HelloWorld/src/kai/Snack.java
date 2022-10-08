package kai;

public class Snack {
	final int muffins = 1;
	final int flapjacks = 2;
	final int cookies = 3;

	//Charge of muffins ($2.03), flapjacks ($2.59) and cookies ($2.88)
	final double muffinsCharge = 2.03;
	final double flapjacksCharge = 2.59;
	final double cookiesCharge = 2.88;
	
	private double theSnackCharge = 0;
	
	float getCost() {
		return Double.valueOf(theSnackCharge).floatValue();
	}
	
	protected void setType(int snackType) {
		switch(snackType) {
		  case muffins:
			  theSnackCharge = muffinsCharge;
		    break;
		  case flapjacks:
			  theSnackCharge = flapjacksCharge;
		    break;
		  case cookies:
			  theSnackCharge = cookiesCharge;
		    break;			 
		}
	};
}
