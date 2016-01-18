package cse.iitd;

import com.sktutilities.util.Log;

public class IASTToSLP
{

    public IASTToSLP()
    {
    }

public static String transform(String transformed)
    {
    transformed = transformed.toLowerCase();
    Log.logInfo("IASTToSLP: " + transformed  );
    //Ä�
    // Vowels
    transformed = transformed.replaceAll( "Ä�","A" ); 
    transformed = transformed.replaceAll("Ä«" ,"I"); 
    transformed = transformed.replaceAll( "Å«", "U");
    transformed = transformed.replaceAll("á¹›" ,"f"); 
    transformed = transformed.replaceAll( "á¹�" , "F"); 
    transformed = transformed.replaceAll( "á¸·", "x"); 
    transformed = transformed.replaceAll( "á¸¹", "X"); 
   
    transformed = transformed.replaceAll("ai","E");
    transformed = transformed.replaceAll("au","O");
    
    transformed = transformed.replaceAll( "á¸¥", "H"); 
    transformed = transformed.replaceAll( "á¹ƒ","M");
    
    transformed = transformed.replaceAll("kh","K");
    transformed = transformed.replaceAll("gh","G");

    transformed = transformed.replaceAll("ch","C");
    transformed = transformed.replaceAll("jh","J");


    transformed = transformed.replaceAll( "á¹­h", "W");
    transformed = transformed.replaceAll( "á¹­", "w");  
    
    transformed = transformed.replaceAll( "á¸�h" , "Q");
    // vargiyas
    transformed = transformed.replaceAll( "á¸�" , "q"); 

    transformed = transformed.replaceAll("th","T"); 
    transformed = transformed.replaceAll("dh","D"); 

    transformed = transformed.replaceAll( "ph", "P"); 
    transformed = transformed.replaceAll( "bh", "B"); 

    // Nasals:
    transformed = transformed.replaceAll( "Ã±","Y"); // represents
    // SLP
    // "Y"(jYaana)
    transformed = transformed.replaceAll( "á¹…","N"); // represents
    // SLP
    // "N"(kalaNka)
    transformed = transformed.replaceAll( "á¹‡","R"); // represents
    // SLP
    // "R"(N)
    transformed = transformed.replaceAll("Å›", "S"); // represents
    // SLP
    // "S"(Sh
    // as
    // in
    // Sharma)

    transformed = transformed.replaceAll("á¹£","z"); // represents
    // SLP
    // "z"(kzaNa)
    return transformed;
    }
}

