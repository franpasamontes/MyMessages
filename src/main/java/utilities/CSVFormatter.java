package utilities;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import basics.Message;

public class CSVFormatter {
	

	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final Object [] FILE_HEADER = {"userId","Message"};
	
	public static void writeCsvFile(String fileName, ArrayList<Message>messages) {
        PrintWriter fileWriter = null;
        CSVPrinter csvFilePrinter = null;
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
        try {
            //initialize FileWriter object
            fileWriter = new PrintWriter(fileName);
            //initialize CSVPrinter object
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
            //Create CSV file header
            csvFilePrinter.printRecord(FILE_HEADER);
            
            for (Message m : messages) {
            	Message myMessage;
            	myMessage = new Message(m.getUserId(), m.getMsg());
                csvFilePrinter.printRecord(myMessage);
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
//                File f = new File(fileName);
//                f.delete();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
 


