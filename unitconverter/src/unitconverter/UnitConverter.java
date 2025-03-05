package unitconverter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class UnitConverter{
	
	private Map<String, Long> units;

	public UnitConverter(String[] units){
		this.units = new LinkedHashMap<>();
		long multiplier = 1;
		for (String unit: units) {
			String[] unitArr = unit.split(":");
			multiplier *= Long.parseLong(unitArr[1]);
			this.units.put(unitArr[0], multiplier);
		}
	}
	
	public double convert(double amount, String fromUnit, String toUnit) {
		return amount / (double) units.get(fromUnit) * units.get(toUnit);
	}
	
	public String[] getUnits() {
		Set<String> keys = units.keySet();
		return keys.toArray(new String[keys.size()]);
	}

}
