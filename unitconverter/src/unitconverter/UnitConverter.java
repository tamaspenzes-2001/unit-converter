package unitconverter;

import java.util.HashMap;
import java.util.Map;

public class UnitConverter{
	
	private Map<String, Integer> units;

	public UnitConverter(String[] units){
		this.units = new HashMap<>();
		int multiplier = 1;
		for (String unit: units) {
			String[] unitArr = unit.split(":");
			multiplier *= Integer.parseInt(unitArr[1]);
			this.units.put(unitArr[0], multiplier);
		}
	}
	
	public float convert(int amount, String fromUnit, String toUnit) {
		return amount / (float) units.get(fromUnit) * units.get(toUnit);
	}

}
