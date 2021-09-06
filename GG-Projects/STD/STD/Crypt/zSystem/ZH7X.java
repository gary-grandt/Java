package STD.Crypt.zSystem;

public class ZH7X {
	public String byteToString(byte input) {
		return String.format("%02X",input);
	}
	
	public String bytesToString(byte[] input) {
		String returnString = "";
		
		for(byte current : input) {
			returnString += byteToString(current)+" ";
		}
		
		return returnString;
	}
}
