package kai;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Calculator {
	static double orderCost = 0.00;

	public static ArrayList<String> splitStr(String inputStr, char splitChar) {
		int startPoint = 0;
		ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0; i < inputStr.length(); i++)
		{
		  if (inputStr.charAt(i) == splitChar)
		  {
		      String ab = inputStr.substring(startPoint, i);
		      arrayList.add(ab.trim());
		      startPoint = i+1;
		  }
		  if (i == (inputStr.length()-1)) {
	          String ab = inputStr.substring(startPoint, inputStr.length());
	          arrayList.add(ab.trim());
		  }
		}
	    return arrayList;
	}	

	public static ArrayList<String> splitOrderList(String ordersStr) {
	    return splitStr(ordersStr, ',');		
	}

	public static ArrayList<String> splitOrderItem(String itemStr) {
	    return splitStr(itemStr, '+');		
	}

	public static int orderQty(String itemStr) {
		return Integer.parseInt(splitStr(itemStr, 'x').get(0));
	}
	
	public static String getItemType(String itemStr) {
		return splitStr(itemStr, 'x').get(1);
	}

	public static double calcCost(String orderItems) {
		float retVal = 0.0f;
		Coffee theCoffee = null;
		Snack theSnack = null;
		String theType = "";
		ArrayList<String> items = new ArrayList<>();
		items = splitOrderItem(orderItems); // Split individual item by plus sign
		theType = getItemType(items.get(0));

		switch(theType) {
		  case "regular":
		  	theCoffee  = new RegularCoffee();
		    break;
		  case "decaf":
			theCoffee  = new DecafCoffee();
		    break;
		  case "muffins":
			theSnack  = new Muffins();
			break;
		  case "flapjacks":
			theSnack  = new Flapjacks();
			break;
		  case "cookies":
		    theSnack  = new Cookies();
			break;
		  default:
			  return 0.00;
		}
		if (theType.equalsIgnoreCase("muffins")
				||theType.equalsIgnoreCase("flapjacks")
						||theType.equalsIgnoreCase("cookies")) return (orderQty(items.get(0)) * Double.parseDouble(Float.toString(theSnack.getCost())));

		for (int i = 1; i < items.size(); i++) {
		  switch(items.get(i)) {
			  case "milk":
				theCoffee.addMilk();
			    break;
			  case "sugar":
				theCoffee.addSugar();
			    break;
			  case "cream":
				theCoffee.addCream();
				break;
			  case "sprinkles":
				theCoffee.addSprinkles();
				break;
			}
		}
		return (orderQty(items.get(0)) * Double.parseDouble(Float.toString(theCoffee.getCost())));
	}
	
	public static float calcTotalCost(String inputOrderList) {
		ArrayList<String> orderArr = new ArrayList<>();
		orderArr = splitOrderList(inputOrderList); // Split individual order by comma
		orderArr.forEach((order) -> {
            orderCost = orderCost + calcCost(order) ;
 		});		
		return Double.valueOf(orderCost).floatValue();
	}
	
	public static void main(String[] args) {
		String input = "1 x regular + milk + sugar, 1 x decaf + sprinkles, 2 x muffins";
		
		//calcTotalCost method to take a string and return the total cost as a float
		float orderTotal = calcTotalCost(input); 
		
		DecimalFormat dFormat = new DecimalFormat("0.00");
		System.out.print("Final bill is $" + dFormat.format(orderTotal) + "\n");
	}
}
