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

public class SanskritTransliteration {
	public static void main(String[] args) throws IOException {
		// String data =
		// convertFromFile("C:\\Users\\IBM_ADMIN\\Desktop\\sanskrit\\python\\input.txt");
		// System.out.println(EncodingUtil.convertDevanagariToSLP(data).replaceAll("#####",
		// "\n"));

		if (args.length < 5)
			System.out.println("Usage...");
		else {
			if (args[4].equalsIgnoreCase("Devanagari")) {
				String data = convertFromFile(args[1]);
				writeToFile(EncodingUtil.convertToDVN(data, args[3]).replaceAll("#####", "\n"), args[2]);
			} else if (args[4].equalsIgnoreCase("SLP")) {
				String data = convertFromFile(args[1]);
				writeToFile(EncodingUtil.convertToSLP(data, args[3]).replaceAll("#####", "\n"), args[2]);
			} else if (args[4].equalsIgnoreCase("IAST")) {
				String data = convertFromFile(args[1]);
				writeToFile(EncodingUtil.convertToIAST(data, args[3]).replaceAll("#####", "\n"), args[2]);
			} 
		}
	}

	public static String convertFromFile(String filePath) throws IOException {
		File fileDir = new File(filePath);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileDir), "UTF8"));

		String str;
		String data = "";
		while ((str = in.readLine()) != null) {
			data = data + "#####" + str;
		}
		in.close();
		return data;
	}

	public static void writeToFile(String data, String outFile) throws IOException {
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(outFile), "UTF-8"));
		out.write(data);
		out.close();

	}
}
