package unitconverter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		UnitConverter converter;
		int property;
		double amount;
		String[] units;
		int fromUnitInput;
		int toUnitInput;
		String fromUnit;
		String toUnit;
		double result;
		
		System.out.println("Welcome!");
		
		while (true) {
			System.out.println();
			
			System.out.println("Choose property (1-7 or 0 to exit):\n"
					+ "1. length\n"
					+ "2. area\n"
					+ "3. volume\n"
					+ "4. tonnage\n"
					+ "5. mass\n"
					+ "6. data\n"
					+ "7. time");
			while (true) {
				System.out.print("> ");
				try {
					property = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Please provide an integer from 0 to 7!");
					input.nextLine(); // consume invalid token
					continue;
				}
				
				if (property == 0) {
					input.close();
					System.exit(0);
				}
				else if (property > 0 && property <= 7) {
					converter = new UnitConverter(switch (property) {
						case 1 -> new String[]{"km:1", "m:1000", "dm:10", "cm:10", "mm:10", "µm:1000", "nm:1000"};
						case 2 -> new String[]{"km2:1", "ha:100", "a:100", "m2:100", "dm2:100", "cm2:100", "mm2:100"};
						case 3 -> new String[]{"m3:1", "dm3:1000", "cm3:1000", "mm3:1000"};
						case 4 -> new String[]{"hl:1", "l:100", "dl:10", "cl:10", "ml:10"};
						case 5 -> new String[]{"t:1", "quintals:10", "kg:100", "dag:100", "g:10", "cg:100", "mg:10"};
						case 6 -> new String[]{"EB:1", "PB:1000", "TB:1000", "GB:1000", "MB:1000", "kB:1000", "B:1000"};
						case 7 -> new String[]{"millenium:1", "c.:10", "decades:10", "lustrum:2", "y:5", "weeks:52.14285714", "d:7", "h:24", "m:60", "s:60", "ds:10", "cs:10", "ms:10", "µs:10", "ns:10"};
						default -> throw new IllegalArgumentException("Unexpected value: " + property);
					});
					break;
				}
				else {
					System.out.println("Invalid option!");
				}
			}
			
			System.out.println();
			
			while (true) {
				try {
					System.out.print("Amount: ");
					amount = input.nextDouble();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please provide a number!");
					input.nextLine(); // consume invalid token
					continue;
				}
			}
			
			System.out.println("Units:");
			units = converter.getUnits();
			System.out.println(units.length);
			for (int i = 0; i < units.length; i++) {
				System.out.println((i+1) + ". " + units[i]);
			}
			while (true) {
				System.out.print("From unit: ");
				try {
					fromUnitInput = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Please provide an integer from 0 to " + units.length + "!");
					input.nextLine(); // consume invalid token
					continue;
				}
				
				if (fromUnitInput == 0) {
					input.close();
					System.exit(0);
				}
				else if (fromUnitInput > 0 && fromUnitInput <= units.length) {
					break;
				}
				else {
					System.out.println("Invalid option!");
				}
			}
			while (true) {
				System.out.print("To unit: ");
				try {
					toUnitInput = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Please provide an integer from 0 to " + units.length + "!");
					input.nextLine(); // consume invalid token
					continue;
				}
				
				if (toUnitInput == 0) {
					input.close();
					System.exit(0);
				}
				else if (toUnitInput > 0 && toUnitInput <= units.length) {
					break;
				}
				else {
					System.out.println("Invalid option!");
				}
			}
			
			System.out.println();
			
			fromUnit = units[fromUnitInput-1];
			toUnit = units[toUnitInput-1];
			
			result = converter.convert(amount, fromUnit, toUnit);
			System.out.println(amount + fromUnit + " = " + result + toUnit);
			
			System.out.println();
			
			System.out.println("Do another conversion? [y/n]");
			while (true) {
				System.out.print("> ");
				String doAnotherConversion = input.next();
				
				if (doAnotherConversion.toLowerCase().equals("n")) {
					input.close();
					System.exit(0);
				}
				else if (doAnotherConversion.toLowerCase().equals("y")) {
					break;
				} else {
					System.out.println("Invalid option!");
				}
			}
		}
		
	}

}
