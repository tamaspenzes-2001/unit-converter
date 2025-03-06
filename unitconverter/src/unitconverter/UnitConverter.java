package unitconverter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * A class which can be used to convert between units provided upon instantiation.
 * Its constructor takes an array of Strings with the format unit:multiplier
 * (units are listed from largest to smallest, multipliers of units are based on the previous unit).
 */
public class UnitConverter{
	
	/**
	 * Store units with multipliers (multipliers of units are based on the largest unit, multiplier of largest unit is always 1).
	 */
	private Map<String, Double> units;

	public UnitConverter(String[] units){
		this.units = new LinkedHashMap<>();
		double multiplier = 1;
		for (String unit: units) {
			String[] unitArr = unit.split(":");
			multiplier *= Double.parseDouble(unitArr[1]);
			this.units.put(unitArr[0], multiplier);
		}
	}
	
	/**
	 * Convert an amount from fromUnit to toUnit
	 * by dividing amount by the multiplier belonging to fromUnit
	 * and multiplying the result by the multiplier belonging to toUnit.
	 * @param amount: the amount to convert
	 * @param fromUnit: the unit to convert from
	 * @param toUnit: the unit to convert to
	 * @return converted amount
	 */
	public double convert(double amount, String fromUnit, String toUnit) {
		return amount / (double) units.get(fromUnit) * units.get(toUnit);
	}
	
	/**
	 * Get all units.
	 * @return all units included in a String array
	 */
	public String[] getUnits() {
		Set<String> keys = units.keySet();
		return keys.toArray(new String[keys.size()]);
	}

}
