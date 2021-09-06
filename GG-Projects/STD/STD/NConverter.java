package STD;

public class NConverter {/*
	//---------------
	//--- Boolean ---
	//---------------
	
	
	//------------
	//--- Byte ---
	//------------
	public String byte_toHEX_128(byte input) {
		switch (input) {
			case 0: return "00";
			case 1: return "01";
			case 2: return "02";
			case 3: return "03";
			case 4: return "04";
			case 5: return "05";
			case 6: return "06";
			case 7: return "07";
			case 8: return "08";
			case 9: return "09";
			case 10: return "0A";
			case 11: return "0B";
			case 12: return "0C";
			case 13: return "0D";
			case 14: return "0E";
			case 15: return "0F";
			
			case 16: return "10";
			case 17: return "11";
			case 18: return "12";
			case 19: return "13";
			case 20: return "14";
			case 21: return "15";
			case 22: return "16";
			case 23: return "17";
			case 24: return "18";
			case 25: return "19";
			case 26: return "1A";
			case 27: return "1B";
			case 28: return "1C";
			case 29: return "1D";
			case 30: return "1E";
			case 31: return "1F";
			
			case 32: return "20";
			case 33: return "21";
			case 34: return "22";
			case 35: return "23";
			case 36: return "24";
			case 37: return "25";
			case 38: return "26";
			case 39: return "27";
			case 40: return "28";
			case 41: return "29";
			case 42: return "2A";
			case 43: return "2B";
			case 44: return "2C";
			case 45: return "2D";
			case 46: return "2E";
			case 47: return "2F";
			
			case 48: return "30";
			case 49: return "31";
			case 50: return "32";
			case 51: return "33";
			case 52: return "34";
			case 53: return "35";
			case 54: return "36";
			case 55: return "37";
			case 56: return "38";
			case 57: return "39";
			case 58: return "3A";
			case 59: return "3B";
			case 60: return "3C";
			case 61: return "3D";
			case 62: return "3E";
			case 63: return "3F";
			
			case 64: return "40";
			case 65: return "41";
			case 66: return "42";
			case 67: return "43";
			case 68: return "44";
			case 69: return "45";
			case 70: return "46";
			case 71: return "47";
			case 72: return "48";
			case 73: return "49";
			case 74: return "4A";
			case 75: return "4B";
			case 76: return "4C";
			case 77: return "4D";
			case 78: return "4E";
			case 79: return "4F";
			
			case 80: return "50";
			case 81: return "51";
			case 82: return "52";
			case 83: return "53";
			case 84: return "54";
			case 85: return "55";
			case 86: return "56";
			case 87: return "57";
			case 88: return "58";
			case 89: return "59";
			case 90: return "5A";
			case 91: return "5B";
			case 92: return "5C";
			case 93: return "5D";
			case 94: return "5E";
			case 95: return "5F";
			
			case 96: return "60";
			case 97: return "61";
			case 98: return "62";
			case 99: return "63";
			case 100: return "64";
			case 101: return "65";
			case 102: return "66";
			case 103: return "67";
			case 104: return "68";
			case 105: return "69";
			case 106: return "6A";
			case 107: return "6B";
			case 108: return "6C";
			case 109: return "6D";
			case 110: return "6E";
			case 111: return "6F";
			
			case 112: return "70";
			case 113: return "71";
			case 114: return "72";
			case 115: return "73";
			case 116: return "74";
			case 117: return "75";
			case 118: return "76";
			case 119: return "77";
			case 120: return "78";
			case 121: return "79";
			case 122: return "7A";
			case 123: return "7B";
			case 124: return "7C";
			case 125: return "7D";
			case 126: return "7E";
			case 127: return "7F";
			
			default : return"ERROR";
		}
	}
	
	public char byte_toASCII_128(byte input) {
		switch(input) {
		
			case 0: return 'Ã¢â€šÂ¬';
			case 1: return 'Ã¢â€šÂ¬';
			case 2: return 'Ã¢â€šÂ¬';
			case 3: return 'Ã¢â€šÂ¬';
			case 4: return 'Ã¢â€šÂ¬';
			case 5: return 'Ã¢â€šÂ¬';
			case 6: return 'Ã¢â€šÂ¬';
			case 7: return 'Ã¢â€šÂ¬';
			case 8: return 'Ã¢â€šÂ¬';
			case 9: return 'Ã¢â€šÂ¬';
			case 10: return 'Ã¢â€šÂ¬';
			case 11: return 'Ã¢â€šÂ¬';
			case 12: return 'Ã¢â€šÂ¬';
			case 13: return 'Ã¢â€šÂ¬';
			case 14: return 'Ã¢â€šÂ¬';
			case 15: return 'Ã¢â€šÂ¬';
			
			case 16: return 'Ã¢â€šÂ¬';
			case 17: return 'Ã¢â€šÂ¬';
			case 18: return 'Ã¢â€šÂ¬';
			case 19: return 'Ã¢â€šÂ¬';
			case 20: return 'Ã¢â€šÂ¬';
			case 21: return 'Ã¢â€šÂ¬';
			case 22: return 'Ã¢â€šÂ¬';
			case 23: return 'Ã¢â€šÂ¬';
			case 24: return 'Ã¢â€šÂ¬';
			case 25: return 'Ã¢â€šÂ¬';
			case 26: return 'Ã¢â€šÂ¬';
			case 27: return 'Ã¢â€šÂ¬';
			case 28: return 'Ã¢â€šÂ¬';
			case 29: return 'Ã¢â€šÂ¬';
			case 30: return 'Ã¢â€šÂ¬';
			case 31: return 'Ã¢â€šÂ¬';
			
			case 32: return ' ';
			case 33: return '!';
			case 34: return '"';
			case 35: return '#';
			case 36: return '$';
			case 37: return '%';
			case 38: return '&';
			//case 39: return 'Ã¢â€šÂ¬';
			case 40: return '(';
			case 41: return ')';
			case 42: return '*';
			case 43: return '+';
			case 44: return ',';
			//case 45: return 'Ã¢â€šÂ¬';
			case 46: return '.';
			case 47: return '/';
			
			case 48: return '0';
			case 49: return '1';
			case 50: return '2';
			case 51: return '3';
			case 52: return '4';
			case 53: return '5';
			case 54: return '6';
			case 55: return '7';
			case 56: return '8';
			case 57: return '9';
			case 58: return ':';
			case 59: return ';';
			case 60: return '<';
			case 61: return '=';
			case 62: return '>';
			case 63: return '?';
			
			case 64: return '@';
			case 65: return 'A';
			case 66: return 'B';
			case 67: return 'C';
			case 68: return 'D';
			case 69: return 'E';
			case 70: return 'F';
			case 71: return 'G';
			case 72: return 'H';
			case 73: return 'I';
			case 74: return 'J';
			case 75: return 'K';
			case 76: return 'L';
			case 77: return 'M';
			case 78: return 'N';
			case 79: return 'O';
			
			case 80: return 'P';
			case 81: return 'Q';
			case 82: return 'R';
			case 83: return 'S';
			case 84: return 'T';
			case 85: return 'U';
			case 86: return 'V';
			case 87: return 'W';
			case 88: return 'X';
			case 89: return 'Y';
			case 90: return 'Z';
			case 91: return '[';
			//case 92: return 'Ã¢â€šÂ¬';
			case 93: return ']';
			case 94: return '^';
			case 95: return '_';
			
			case 96: return '`';
			case 97: return 'a';
			case 98: return 'b';
			case 99: return 'c';
			case 100: return 'd';
			case 101: return 'e';
			case 102: return 'f';
			case 103: return 'g';
			case 104: return 'h';
			case 105: return 'i';
			case 106: return 'j';
			case 107: return 'k';
			case 108: return 'l';
			case 109: return 'm';
			case 110: return 'n';
			case 111: return 'o';
			
			case 112: return 'p';
			case 113: return 'q';
			case 114: return 'r';
			case 115: return 's';
			case 116: return 't';
			case 117: return 'u';
			case 118: return 'v';
			case 119: return 'w';
			case 120: return 'x';
			case 121: return 'y';
			case 122: return 'z';
			case 123: return '{';
			case 124: return '|';
			case 125: return '}';
			case 126: return '~';
			//case 127: return 'Ã¢â€šÂ¬';
			
			default: return ' ';
			//default: return 'Ã¢â€šÂ¬';
		}
	}
	
	public char byte_toDIS_128(byte input) {
		switch(input) {
			case 0: return '0';
			case 1: return '1';
			case 2: return '2';
			case 3: return '3';
			case 4: return '4';
			case 5: return '5';
			case 6: return '6';
			case 7: return '7';
			case 8: return '8';
			case 9: return '9';
			case 10: return '+';
			case 11: return '-';
			case 12: return '*';
			case 13: return '/';
			case 14: return '=';
			case 15: return '<';
		
			case 16: return '>';
			case 17: return '|';
			case 18: return '/';
			case 19: return '(';
			case 20: return ')';
			case 21: return '[';
			case 22: return ']';
			case 23: return '{';
			case 24: return '}';
			case 25: return '%';
			case 26: return '&';
			case 27: return '~';
			case 28: return '#';
			case 29: return '!';
			case 30: return '^';
			//case 31: return 'Ã‚Â°';
		
			case 32: return '\'';
			case 33: return '"';
			case 34: return '.';
			case 35: return ':';
			case 36: return ',';
			case 37: return ';';
			//case 38: return 'Ã¢â€�ï¿½';
			//case 39: return 'Ã¢â€�â€�';
			case 40: return 'Ã¢â€�Å’';
			case 41: return 'Ã¢â€�Ëœ';
			case 42: return 'Ã‚Â±';
			case 43: return 'ÃƒÂ¸';
			case 44: return 'Ã¢â€�Â¬';
			case 45: return 'Ã¢â€�Å“';
			case 46: return 'Ã¢â€�Â¤';
			case 47: return 'Ã¢â€�Â¼';
		
			case 48: return 'Ã¢â€�Â´';
			case 49: return 'Ã‚Â¦';
			case 50: return 'Ã¢â€šÂ¬';
			case 51: return 'Ã¢â€šÂ¬';
			case 52: return 'Ã¢â€šÂ¬';
			case 53: return 'Ã¢â€šÂ¬';
			case 54: return 'Ã¢â€šÂ¬';
			case 55: return 'Ã¢â€šÂ¬';
			case 56: return 'Ã¢â€šÂ¬';
			case 57: return 'Ã‚Â§';
			case 58: return '$';
			case 59: return 'Ã¢â€šÂ¬';
			case 60: return '@';
			case 61: return '?';
			case 62: return 'ÃƒÅ¸';
			case 63: return 'Ã‚Âµ';
		
			case 64: return 'a';
			case 65: return 'b';
			case 66: return 'c';
			case 67: return 'd';
			case 68: return 'e';
			case 69: return 'f';
			case 70: return 'g';
			case 71: return 'h';
			case 72: return 'i';
			case 73: return 'j';
			case 74: return 'k';
			case 75: return 'l';
			case 76: return 'm';
			case 77: return 'n';
			case 78: return 'o';
			case 79: return 'p';
		
			case 80: return 'q';
			case 81: return 'r';
			case 82: return 's';
			case 83: return 't';
			case 84: return 'u';
			case 85: return 'v';
			case 86: return 'w';
			case 87: return 'x';
			case 88: return 'y';
			case 89: return 'z';
			case 90: return 'ÃƒÂ¤';
			case 91: return 'ÃƒÂ¶';
			case 92: return 'ÃƒÂ¼';
			case 93: return 'Ã‚Â´';
			case 94: return '`';
			case 95: return '_';
		
			case 96: return 'A';
			case 97: return 'B';
			case 98: return 'C';
			case 99: return 'D';
			case 100: return 'E';
			case 101: return 'F';
			case 102: return 'G';
			case 103: return 'H';
			case 104: return 'I';
			case 105: return 'J';
			case 106: return 'K';
			case 107: return 'L';
			case 108: return 'M';
			case 109: return 'N';
			case 110: return 'O';
			case 111: return 'P';
		
			case 112: return 'Q';
			case 113: return 'R';
			case 114: return 'S';
			case 115: return 'T';
			case 116: return 'U';
			case 117: return 'V';
			case 118: return 'W';
			case 119: return 'X';
			case 120: return 'Y';
			case 121: return 'Z';
			case 122: return 'Ãƒâ€ž';
			case 123: return 'Ãƒâ€“';
			case 124: return 'ÃƒÅ“';
			case 125: return 'Ã¢â€šÂ¬';
			case 126: return 'Ãƒâ€°';
			case 127: return ' ';
			
			default : return 'Ã¢â€šÂ¬';
		}
	}
	
	
	//-------------
	//--- SHORT ---
	//-------------
	
	
	//-----------
	//--- INT ---
	//-----------
	
	
	//-----------
	//---LONG ---
	//-----------
	
	
	//-----------
	//--- BIN ---
	//-----------
	
	
	//-----------
	//--- OCT ---
	//-----------
	
	
	
	
	//-----------
	//--- DEC ---
	//-----------
	public boolean[] dec_toBin(int input) {
		boolean[] return_array;
		
		if(input <= 1) {
			
		}else if(input <= 3) {
			
		}else if(input <= 7) {
			
		}else if(input <= 15) {
			
		}else if(input <= 31) {
			
		}else if(input <= 63) {
			
		}else if(input <= 127) {
			
		}else if(input <= 511) {
			
		}else if(input <= 1023) {
			
		}else if(input <= 2047) {
			
		}else if(input <= 4095) {
			
		}else if(input <= 8191) {
			
		}else if(input <= 16383) {
			
		}else if(input <= 32768) {
			
		}
		
		return 0;
	}
	
	public boolean[] decByte_toBin(byte input) {
		boolean[] return_array = new boolean[8];
		byte rest;
		
		//IsPostive?
		if(input < 0) {
			return_array[0] = true;
		}else if(input >= 0) {
			return_array[0] = false;
		}
		
		//BinBreakdown
		for(byte i = 8; i > 0; i--) {
			if(input > 0) {
				rest = input%2;
				input  = input/2;
				
				if(rest == 1) {
					return_array[i] = true;
				}else {
					return_array[i] = false;
				}
			}else {
				return_array[i] = false;
			}
		}
		
		return return_array;
	}
	
	public boolean[] decShort_toBin(short input) {
		boolean[] return_array = new boolean[16];
		short rest;
		
		//IsPostive?
		if(input < 0) {
			return_array[0] = true;
		}else if(input >= 0) {
			return_array[0] = false;
		}
		
		//BinBreakdown
		for(byte i = 16; i > 0; i--) {
			if(input > 0) {
				rest = input%2;
				input  = input/2;
				
				if(rest == 1) {
					return_array[i] = true;
				}else {
					return_array[i] = false;
				}
			}else {
				return_array[i] = false;
			}
		}
		
		return return_array;
	}
	
	public boolean[] decInt_toBin(int input) {
		boolean[] return_array = new boolean[32];
		int rest;
		
		//IsPostive?
		if(input < 0) {
			return_array[0] = true;
		}else if(input >= 0) {
			return_array[0] = false;
		}
		
		//BinBreakdown
		for(byte i = 32; i > 0; i--) {
			if(input > 0) {
				rest = input%2;
				input  = input/2;
				
				if(rest == 1) {
					return_array[i] = true;
				}else {
					return_array[i] = false;
				}
			}else {
				return_array[i] = false;
			}
		}
		
		return return_array;
	}
	
	public boolean[] decLong_toBin(long input) {
		boolean[] return_array = new boolean[64];
		long rest;
		
		//IsPostive?
		if(input < 0) {
			return_array[0] = true;
		}else if(input >= 0) {
			return_array[0] = false;
		}
		
		//BinBreakdown
		for(byte i = 64; i > 0; i--) {
			if(input > 0) {
				rest = input%2;
				input  = input/2;
				
				if(rest == 1) {
					return_array[i] = true;
				}else {
					return_array[i] = false;
				}
			}else {
				return_array[i] = false;
			}
		}
		
		return return_array;
	}
	
	
	//-----------
	//--- HEX ---
	//-----------
	public byte hex_toByte_128(String input) {
		return 35;
	}
	
	public byte hex_toByte_256(String input) {
		
		return 35;
	}
	
	//-------------
	//--- ASCII ---
	//-------------
	public byte ascii_toByte_128(char input) {
		switch(input) {
			case ' ': return 32;
			case '!': return 33;
			case '"': return 34;
			case '#': return 35;
			case '$': return 36;
			case '%': return 37;
			case '&': return 38;
			//case ''': return 39;
			case '(': return 40;
			case ')': return 41;
			case '*': return 42;
			case '+': return 43;
			case 'Ã‚Â´': return 44;
			case '-': return 45;
			case '.': return 46;
			case '/': return 47;
			
			case '0': return 48;
			case '1': return 49;
			case '2': return 50;
			case '3': return 51;
			case '4': return 52;
			case '5': return 53;
			case '6': return 54;
			case '7': return 55;
			case '8': return 56;
			case '9': return 57;
			case ':': return 58;
			case ';': return 59;
			case '<': return 60;
			case '=': return 61;
			case '>': return 62;
			case '?': return 63;
			
			case '@': return 64;
			case 'A': return 65;
			case 'B': return 66;
			case 'C': return 67;
			case 'D': return 68;
			case 'E': return 69;
			case 'F': return 70;
			case 'G': return 71;
			case 'H': return 72;
			case 'I': return 73;
			case 'J': return 74;
			case 'K': return 75;
			case 'L': return 76;
			case 'M': return 77;
			case 'N': return 78;
			case 'O': return 79;
			
			case 'P': return 80;
			case 'Q': return 81;
			case 'R': return 82;
			case 'S': return 83;
			case 'T': return 84;
			case 'U': return 85;
			case 'V': return 86;
			case 'W': return 87;
			case 'X': return 88;
			case 'Y': return 89;
			case 'Z': return 90;
			case '[': return 91;
			//case '\': return 92;
			case ']': return 93;
			case '^': return 94;
			case '_': return 95;
			
			case '`': return 96;
			case 'a': return 97;
			case 'b': return 98;
			case 'c': return 99;
			case 'd': return 100;
			case 'e': return 101;
			case 'f': return 102;
			case 'g': return 103;
			case 'h': return 104;
			case 'i': return 105;
			case 'j': return 106;
			case 'k': return 107;
			case 'l': return 108;
			case 'm': return 109;
			case 'n': return 110;
			case 'o': return 111;
			
			case 'p': return 112;
			case 'q': return 113;
			case 'r': return 114;
			case 's': return 115;
			case 't': return 116;
			case 'u': return 117;
			case 'v': return 118;
			case 'w': return 119;
			case 'x': return 120;
			case 'y': return 121;
			case 'z': return 122;
			case '{': return 123;
			case '|': return 124;
			case '}': return 125;
			case '~': return 126;
			//case '': return 127;
			
			default: return 0;
		}
	}
	
	public byte ascii_toByte_256(char input) {
		
		return 00;
	}
	
	//-----------
	//--- DIS ---
	//-----------
	public byte dis_toByte_128(char input) {
		switch(input) {
			case '0': return 0;
			case '1': return 1;
			case '2': return 2;
			case '3': return 3;
			case '4': return 4;
			case '5': return 5;
			case '6': return 6;
			case '7': return 7;
			case '8': return 8;
			case '9': return 9;
			case '+': return 10;
			case '-': return 11;
			case '*': return 12;
			case '/': return 13;
			case '=': return 14;
			case '<': return 15;
			
			case '>': return 16;
			case '|': return 17;
			//case '\': return 18;
			case '(': return 19;
			case ')': return 20;
			case '[': return 21;
			case ']': return 22;
			case '{': return 23;
			case '}': return 24;
			case '%': return 25;
			case '&': return 26;
			case '~': return 27;
			case '#': return 28;
			case '!': return 29;
			//case '^': return 30;
			//case 'Ã‚Â°': return 31;
		
			//case ''': return 32;
			case '"': return 33;
			case '.': return 34;
			case ':': return 35;
			case ',': return 36;
			case ';': return 37;
			case '': return 38;
			case '': return 39;
			case '': return 40;
			case '': return 41;
			case '': return 42;
			case '': return 43;
			case '': return 44;
			case '': return 45;
			case '': return 46;
			case '': return 47;
			
			//case '': return 48;
			case 'Ã‚Â¦': return 49;
			case '': return 50;
			case '': return 51;
			case '': return 52;
			case '': return 53;
			case '': return 54;
			case '': return 55;
			case '': return 56;
			case 'Ã‚Â§': return 57;
			case '$': return 58;
			case 'Ã¢â€šÂ¬': return 59;
			case '@': return 60;
			case 'ÃƒÅ¸': return 61;
			case '?': return 62;
			case 'Ã‚Âµ': return 63;
			
			case 'a': return 64;
			case 'b': return 65;
			case 'c': return 66;
			case 'd': return 67;
			case 'e': return 68;
			case 'f': return 69;
			case 'g': return 70;
			case 'h': return 71;
			case 'i': return 72;
			case 'j': return 73;
			case 'k': return 74;
			case 'l': return 75;
			case 'm': return 76;
			case 'n': return 77;
			case 'o': return 78;
			case 'p': return 79;
			
			case 'q': return 80;
			case 'r': return 81;
			case 's': return 82;
			case 't': return 83;
			case 'u': return 84;
			case 'v': return 85;
			case 'w': return 86;
			case 'x': return 87;
			case 'y': return 88;
			case 'z': return 89;
			case 'ÃƒÂ¤': return 90;
			case 'ÃƒÂ¶': return 91;
			case 'ÃƒÂ¼': return 92;
			case 'Ã‚Â´': return 93;
			case '`': return 94;
			case '_': return 95;
			
			case 'A': return 96;
			case 'B': return 97;
			case 'C': return 98;
			case 'D': return 99;
			case 'E': return 100;
			case 'F': return 101;
			case 'G': return 102;
			case 'H': return 103;
			case 'I': return 104;
			case 'J': return 105;
			case 'K': return 106;
			case 'L': return 107;
			case 'M': return 108;
			case 'N': return 109;
			case 'O': return 110;
			case 'P': return 111;
			
			case 'Q': return 112;
			case 'R': return 113;
			case 'S': return 114;
			case 'T': return 115;
			case 'U': return 116;
			case 'V': return 117;
			case 'W': return 118;
			case 'X': return 119;
			case 'Y': return 120;
			case 'Z': return 121;
			case 'Ãƒâ€ž': return 122;
			case 'Ãƒâ€“': return 123;
			case 'ÃƒÅ“': return 124;
			//case '': return 125;
			//case '': return 126;
			case ' ': return 127;
			
			default: return -1;
		}
	}
	
	public byte dis_toByte_256(char input) {
		
		return 35;
	}
		
	
	public static void main(String[] args) {
		NConverter nc = new NConverter();
		
	}
	*/
}
