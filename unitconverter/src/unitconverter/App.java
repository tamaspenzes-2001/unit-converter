package unitconverter;

public class App{

	public static void main(String[] args){
		UnitConverter lengthConverter = new UnitConverter(new String[]{"km:1", "m:1000", "dm:10", "cm:10", "mm:10"});
		System.out.println(lengthConverter.convert(1000, "cm", "m") + "m");
	}

}
