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
		String inputFile = "C:\\Users\\IBM_ADMIN\\Desktop\\sanskrit\\python\\output.txt";
		String outputFile = "C:\\Users\\IBM_ADMIN\\Desktop\\sanskrit\\python\\output1.txt";
		String inputCharSet = "SLP";
		String outputCharSet = "DVN";

		if (args.length > 5){
			inputFile = args[1];
			outputFile = args[2];
			inputCharSet = args[3];
			outputCharSet = args[4];
		}
		
		if (outputCharSet.equalsIgnoreCase("DVN")) {
			String data = convertFromFile(inputFile);
			String transData = EncodingUtil.convertToDVN(data, inputCharSet).replaceAll("#####", "\n");
			writeToFile(transData, outputFile);
		} else if (outputCharSet.equalsIgnoreCase("SLP")) {
			String data = convertFromFile(inputFile);
			String transData = EncodingUtil.convertToSLP(data, inputCharSet).replaceAll("#####", "\n");
			writeToFile(transData, outputFile);
		} else if (outputCharSet.equalsIgnoreCase("IAST")) {
			String data = convertFromFile(inputFile);
			String transData = EncodingUtil.convertToIAST(data, inputCharSet)	.replaceAll("#####", "\n");
			writeToFile(transData, outputFile);
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
