package cse.iitd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class UtfToVelthis {

	public static String convert(String value, String trans) {
		if (trans == "DN") {
			String[] inHex = { "05", "06", "07", "08", "09", "0a", "0b", "60", "0c", "0f", "10", "13", "14", "02", "01", "03", "3d", "4d" };
			String[] outVH = { "a", "aa", "i", "ii", "u", "uu", ".r", ".rr", ".l", "e", "ai", "o", "au", ".m", "~l", ".h", "'", "" };
			String[] matIn = { "3e", "3f", "40", "41", "42", "43", "44", "62", "47", "48", "4b", "4c" };
			String[] consIn = { "15", "16", "17", "18", "19", "1a", "1b", "1c", "1d", "1e", "1f", "20", "21", "22", "23", "24", "25", "26", "27", "28", "2a", "2b", "2c", "2d",
					"2e", "2f", "30", "32", "35", "36", "37", "38", "39", "00" };
			String orig = value.trim();
			String output = "";
			boolean wasCons = false;
			for (int i = 0; i < orig.length(); i++) {
				char origC = orig.charAt(i);
				//System.out.println(origC);
				String l = String.format("%04x", (int) origC);
				//System.out.println(origC+"  "+(int) origC+"  "+l);
				int lenL = l.length();
				if (lenL == 0)
					l = "0000";
				if (lenL == 1)
					l = "000" + l;
				if (lenL == 2)
					l = "00" + l;
				if (lenL == 3)
					l = "0" + l;
				String check = l.substring(2);
				String init = l.substring(0, 2);
				//System.out.println(check);
				//System.out.println(init);
				if (!init.equals("09"))
					check = "00";

				String[] consOut = { "k", "kh", "g", "gh", "f", "c", "ch", "j", "jh", "~n", ".t", ".th", ".d", ".dh", ".n", "t", "th", "d", "dh", "n", "p", "ph", "b", "bh", "m",
						"y", "r", "l", "v", "z", ".s", "s", "h", origC + "" };
				for (int j = 0; j < inHex.length; j++) {
					if (check.equals(inHex[j])) {
						if ((check.equals("03")) || (check.equals("01")) || (check.equals("02")) || (check.equals("3d"))) {
							if (wasCons) {
								output = output.concat("a" + outVH[j]);
							} else {
								output = output.concat(outVH[j]);
							}
						} else {
							output = output.concat(outVH[j]);
						}
						wasCons = false;
					}
				}
				for (int j = 0; j < consIn.length; j++) {
					if (check.equals(consIn[j])) {
						if (wasCons) {
							output = output.concat("a" + consOut[j]);
						} else {
							output = output.concat(consOut[j]);
						}
						if (!check.equals("00")) {
							wasCons = true;
						} else {
							wasCons = false;
						}
						/*if (i == orig.length() - 1) {
							output = output.concat("a");
						}*/
					}
				}
				for (int j = 0; j < matIn.length; j++) {
					if (check.equals(matIn[j])) {
						output = output.concat(outVH[j + 1]);
						wasCons = false;
					}
				}
			}
			return output;
		}
		if (trans == "RN") {
			String[] inRom = { "7773", "0257", "0299", "0363", "7771", "7735", "7749", "0241", "7789", "7693", "7751", "7747", "7779", "0347", "7717" };
			String[] outVH = { ".rr", "aa", "ii", "uu", ".r", ".l", "f", "~n", ".t", ".d", ".n", ".m", ".s", "z", ".h" };
			String orig = value.trim();
			String output = "";
			for (int i = 0; i < orig.length(); i++) {
				char origC = orig.charAt(i);
				String l = String.format("%04x", (int) origC);
				int lenL = l.length();
				if (lenL == 0)
					l = "0000";
				if (lenL == 1)
					l = "000" + l;
				if (lenL == 2)
					l = "00" + l;
				if (lenL == 3)
					l = "0" + l;
				String check = l;
				boolean isC = false;
				for (int j = 0; j < inRom.length; j++) {
					if (check == inRom[j]) {
						output = output.concat(outVH[j]);
						isC = true;
					}
				}
				if (!isC) {
					output = output + origC;
				}
			}
			return output;
		}
		return value;
	}

	public static String convert1(String value, String trans) {

		if (trans == "DN") {
			String[] inHex = { "05", "06", "07", "08", "09", "0a", "0b", "60", "0c", "0f", "10", "13", "14", "02", "01", "03", "3d", "4d" };
			String[] outVH = { "a", "aa", "i", "ii", "u", "uu", ".r", ".rr", ".l", "e", "ai", "o", "au", ".m", "~l", ".h", "'", "" };
			String[] matIn = { "3e", "3f", "40", "41", "42", "43", "44", "62", "47", "48", "4b", "4c" };
			String[] consIn = { "15", "16", "17", "18", "19", "1a", "1b", "1c", "1d", "1e", "1f", "20", "21", "22", "23", "24", "25", "26", "27", "28", "2a", "2b", "2c", "2d",
					"2e", "2f", "30", "32", "35", "36", "37", "38", "39", "00" };
			String orig = value.trim();
			String output = "";
			boolean wasCons = false;
			for (int i = 0; i < orig.length(); i++) {
				char origC = orig.charAt(i);
				String l = String.format("%04x", (int) origC);
				int lenL = l.length();
				if (lenL == 0)
					l = "0000";
				if (lenL == 1)
					l = "000" + l;
				if (lenL == 2)
					l = "00" + l;
				if (lenL == 3)
					l = "0" + l;
				String check = l.substring(2);
				String init = l.substring(0, 2);
				if (!init.equals("09")) {
					check = "00";
				}
				String[] consOut = { "k", "kh", "g", "gh", "f", "c", "ch", "j", "jh", "~n", ".t", ".th", ".d", ".dh", ".n", "t", "th", "d", "dh", "n", "p", "ph", "b", "bh", "m",
						"y", "r", "l", "v", "z", ".s", "s", "h", origC + "" };
				for (int j = 0; j < inHex.length; j++) {
					if (check.equals(inHex[j])) {
						if ((check.equals("03")) || (check.equals("01")) || (check.equals("02")) || (check.equals("3d"))) {
							if (wasCons) {
								output = output.concat("a" + outVH[j]);
							} else {
								output = output.concat(outVH[j]);
							}
						} else {
							output = output.concat(outVH[j]);
						}
						wasCons = false;
					}
				}
				for (int j = 0; j < consIn.length; j++) {
					if (check.equals(consIn[j])) {
						if (wasCons) {
							output = output.concat("a" + consOut[j]);
						} else {
							output = output.concat(consOut[j]);
						}
						if (!check.equals("00")) {
							wasCons = true;
						} else {
							wasCons = false;
						}
						if (i == orig.length() - 1) {
							output = output.concat("a");
						}
					}
				}
				for (int j = 0; j < matIn.length; j++) {
					if (check.equals(matIn[j])) {
						output = output.concat(outVH[j + 1]);
						wasCons = false;
					}
				}
			}
			System.out.println("out..."+output);
			return output;
		}
		if (trans == "RN") {
			String[] inRom = { "7773", "0257", "0299", "0363", "7771", "7735", "7749", "0241", "7789", "7693", "7751", "7747", "7779", "0347", "7717" };
			String[] outVH = { ".rr", "aa", "ii", "uu", ".r", ".l", "f", "~n", ".t", ".d", ".n", ".m", ".s", "z", ".h" };
			String orig = value.trim();
			String output = "";
			for (int i = 0; i < orig.length(); i++) {
				char origC = orig.charAt(i);
				String l = String.format("%04x", (int) origC);
				int lenL = l.length();
				if (lenL == 0)
					l = "0000";
				if (lenL == 1)
					l = "000" + l;
				if (lenL == 2)
					l = "00" + l;
				if (lenL == 3)
					l = "0" + l;
				String check = l;
				boolean isC = false;
				for (int j = 0; j < inRom.length; j++) {
					if (check == inRom[j]) {
						output = output.concat(outVH[j]);
						isC = true;
					}
				}
				if (!isC) {
					output = output + origC;
				}
			}
			return output;
		}
		return value;
	}

	public static String convert2(String value, String trans) {

		if (trans == "DN") {
			String[] inHex = { "05", "06", "07", "08", "09", "0a", "0b", "60", "0c", "0f", "10", "13", "14", "02", "01", "03", "3d", "4d" };
			String[] outVH = { "a", "aa", "i", "ii", "u", "uu", ".r", ".rr", ".l", "e", "ai", "o", "au", ".m", "~l", ".h", "'", "" };
			String[] matIn = { "3e", "3f", "40", "41", "42", "43", "44", "62", "47", "48", "4b", "4c" };
			String[] consIn = { "15", "16", "17", "18", "19", "1a", "1b", "1c", "1d", "1e", "1f", "20", "21", "22", "23", "24", "25", "26", "27", "28", "2a", "2b", "2c", "2d",
					"2e", "2f", "30", "32", "35", "36", "37", "38", "39", "00" };
			String orig = value.trim();
			String output = "";
			boolean wasCons = false;
			for (int i = 0; i < orig.length(); i++) {
				char origC = orig.charAt(i);
				String l = String.format("%04x", (int) origC);
				int lenL = l.length();
				if (lenL == 0)
					l = "0000";
				if (lenL == 1)
					l = "000" + l;
				if (lenL == 2)
					l = "00" + l;
				if (lenL == 3)
					l = "0" + l;
				String check = l.substring(2);
				String init = l.substring(0, 2);
				if (init != "09") {
					check = "00";
				}
				String[] consOut = { "k", "kh", "g", "gh", "f", "c", "ch", "j", "jh", "~n", ".t", ".th", ".d", ".dh", ".n", "t", "th", "d", "dh", "n", "p", "ph", "b", "bh", "m",
						"y", "r", "l", "v", "z", ".s", "s", "h", origC + "" };
				for (int j = 0; j < inHex.length; j++) {
					if (check == inHex[j]) {
						if ((check == "03") || (check == "01") || (check == "02") || (check == "3d")) {
							if (wasCons) {
								output = output.concat("a" + outVH[j]);
							} else {
								output = output.concat(outVH[j]);
							}
						} else {
							output = output.concat(outVH[j]);
						}
						wasCons = false;
					}
				}
				for (int j = 0; j < consIn.length; j++) {
					if (check == consIn[j]) {
						if (wasCons) {
							output = output.concat("a" + consOut[j]);
						} else {
							output = output.concat(consOut[j]);
						}
						if (check != "00") {
							wasCons = true;
						} else {
							wasCons = false;
						}
						if (i == orig.length() - 1) {
							output = output.concat("a");
						}
					}
				}
				for (int j = 0; j < matIn.length; j++) {
					if (check == matIn[j]) {
						output = output.concat(outVH[j + 1]);
						wasCons = false;
					}
				}
			}

			orig = value.trim();
			output = "";
			wasCons = false;
			for (int i = 0; i < orig.length(); i++) {
				char origC = orig.charAt(i);
				String l = String.format("%04x", (int) origC);
				int lenL = l.length();
				if (lenL == 0)
					l = "0000";
				if (lenL == 1)
					l = "000" + l;
				if (lenL == 2)
					l = "00" + l;
				if (lenL == 3)
					l = "0" + l;
				String check = l.substring(2);
				String init = l.substring(0, 2);
				if (init != "09") {
					check = "00";
				}
				String[] consOut = { "k", "kh", "g", "gh", "f", "c", "ch", "j", "jh", "~n", ".t", ".th", ".d", ".dh", ".n", "t", "th", "d", "dh", "n", "p", "ph", "b", "bh", "m",
						"y", "r", "l", "v", "z", ".s", "s", "h", origC + "" };
				for (int j = 0; j < inHex.length; j++) {
					if (check == inHex[j]) {
						if ((check == "03") || (check == "01") || (check == "02") || (check == "3d")) {
							if (wasCons) {
								output = output.concat("a" + outVH[j]);
							} else {
								output = output.concat(outVH[j]);
							}
						} else {
							output = output.concat(outVH[j]);
						}
						wasCons = false;
					}
				}
				for (int j = 0; j < consIn.length; j++) {
					if (check == consIn[j]) {
						if (wasCons) {
							output = output.concat("a" + consOut[j]);
						} else {
							output = output.concat(consOut[j]);
						}
						if (check != "00") {
							wasCons = true;
						} else {
							wasCons = false;
						}
						if (i == orig.length() - 1) {
							output = output.concat("a");
						}
					}
				}
				for (int j = 0; j < matIn.length; j++) {
					if (check == matIn[j]) {
						output = output.concat(outVH[j + 1]);
						wasCons = false;
					}
				}
			}
			return output;
		}
		if (trans == "RN") {
			String[] inRom = { "7773", "0257", "0299", "0363", "7771", "7735", "7749", "0241", "7789", "7693", "7751", "7747", "7779", "0347", "7717" };
			String[] outVH = { ".rr", "aa", "ii", "uu", ".r", ".l", "f", "~n", ".t", ".d", ".n", ".m", ".s", "z", ".h" };
			String orig = value.trim();
			String output = "";
			for (int i = 0; i < orig.length(); i++) {
				int origC = orig.charAt(i);
				String l = String.format("%04x", (int) origC);
				int lenL = l.length();
				if (lenL == 0)
					l = "0000";
				if (lenL == 1)
					l = "000" + l;
				if (lenL == 2)
					l = "00" + l;
				if (lenL == 3)
					l = "0" + l;
				String check = l;
				boolean isC = false;
				for (int j = 0; j < inRom.length; j++) {
					if (check == inRom[j]) {
						output = output + outVH[j];
						isC = true;
					}
				}
				if (!isC) {
					output = output + origC;
				}
			}
			orig = value.trim();
			output = "";
			for (int i = 0; i < orig.length(); i++) {
				int origC = orig.charAt(i);
				String l = String.format("%04x", (int) origC);
				int lenL = l.length();
				if (lenL == 0)
					l = "0000";
				if (lenL == 1)
					l = "000" + l;
				if (lenL == 2)
					l = "00" + l;
				if (lenL == 3)
					l = "0" + l;
				String check = l;
				boolean isC = false;
				for (int j = 0; j < inRom.length; j++) {
					if (check == inRom[j]) {
						output = output.concat(outVH[j]);
						isC = true;
					}
				}
				if (!isC) {
					output = output + origC;
				}
			}
			return output;
		}
		return value;
	}
	
	public static void convertFromFile(String filePath) throws IOException {
		File fileDir = new File(filePath);
		String outFile = filePath+".vel";
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

		String str;
		
		while ((str = in.readLine()) != null) {
			String left = convert(str.split(",")[1], "DN");
			String right = EncodingUtil.convertSLPToIAST(EncodingUtil.convertDevanagariToSLP(str.split(",")[2]));
			if(str.split(",").length < 4)
				out.write(str.split(",")[0]+","+left+","+right+","+""+"\n");
			else
				out.write(str.split(",")[0]+","+left+","+right+","+str.split(",")[3]+"\n");
		}
		in.close();
		out.close();
	}

	public static void convertFromFolder(String folderPath) throws IOException {
		File folder = new File(folderPath);
		if(folder.isDirectory())
		    for (final File fileEntry : folder.listFiles()) {
		        if (fileEntry.isDirectory()) {
		        	convertFromFolder(fileEntry.getAbsolutePath());
		        } else {
		        	convertFromFile(fileEntry.getAbsolutePath());
		        }
		    }
		else convertFromFile(folderPath);
	}

	public static void main(String[] args) throws IOException {
		//System.out.println(convert("चार्थे", "DN"));
		//System.out.println(convert("abcd", "DN"));
		//System.out.println(convert1("चार्थे", "DN"));
		//System.out.println(convert2("चार्थे", "DN"));
		
		//convertFromFolder("C:\\Users\\IBM_ADMIN\\Desktop\\IITD\\sanskritResources\\externalTools\\sandhis");
		convertFromFile("C:\\Users\\IBM_ADMIN\\Desktop\\IITD\\sanskritResources\\externalTools\\golddataset.txt");

	}

}
