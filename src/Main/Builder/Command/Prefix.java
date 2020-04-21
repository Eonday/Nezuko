package Main.Builder.Command;

public class Prefix {
	public String Prefix = ",";
	
	
	public String getPrefix() {return Prefix;}
	public void SetPrefix(String prefix)throws IllegalArgumentException {
		
		try {
			if(prefix.length() > 2) {
				throw new IllegalArgumentException();
			}
			Prefix = prefix;
		}catch(IllegalArgumentException e) {
			throw e;
		}
		
	}

}
