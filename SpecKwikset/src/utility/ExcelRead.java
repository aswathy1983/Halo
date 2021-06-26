package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelRead {
	
	int rowCount ;
    WritableSheet excelSheet;
    Workbook wb;
    WritableWorkbook writableWorkbook;
    Label label;
    String rowDate, prvRowDate ="";
	/*
	 * Function to read from the excel sheet
	 */
	public String[][] getTableArray(String xlFilePath, String sheetName,String tableName) {
		String[][] tabArray = null;
		try {
			int startRow;
			int startCol;
			int endRow;
			int endCol;
			int ci;
			int cj;
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);		
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();
			Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);
			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			tabArray = new String[endRow-startRow-1][endCol-startCol-1];
			ci = 0;
			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for ( int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			System.out.println("error in getTableArray()");
			e.printStackTrace();
			Log.addMessage("Error in reading data from excel" + e);
		}
		return tabArray;
	}
	
	/*
	 * Function assignWorkBook is used to create a workbook
	*/
	private void assignWorkBook(String xlFilePath) throws IOException, BiffException {
			File inp = new File(xlFilePath);
            try{
            	 wb = Workbook.getWorkbook(inp);
                 writableWorkbook = Workbook.createWorkbook(inp, wb);
            } catch (FileNotFoundException e){
            	writableWorkbook = Workbook.createWorkbook(inp); //Create a new one
            }
    }
	
	/*
	 * Function to write to an excel sheet
	*/
	public void writeRow(String xlFilePath, String sheetName,String currDate,String batteryPer, String cmmnt) throws WriteException, IOException, BiffException {
		try {
	        assignWorkBook(xlFilePath);
	        excelSheet = writableWorkbook.getSheet(sheetName);
	        if(excelSheet!=null) {
		        rowCount = excelSheet.getRows();
		        System.out.println("rowCount="+rowCount);
		        int colCount;
		        if(rowCount==1) {
		        	colCount=0;
		        }else {
		        	prvRowDate = excelSheet.getCell(0, rowCount-1).getContents();
		 	        System.out.println("prvRowDate="+prvRowDate);
		 	        if(currDate.equals(prvRowDate)) {
		 	        	System.out.println("matches");
		 	        	rowCount=rowCount-1;
		 	        	Cell[] cellColumn = excelSheet.getRow(rowCount);
			        	colCount = cellColumn.length;
		 	        }else {
		 	        	System.out.println("not matching");
		 	        	colCount=0;
		 	        }
		 	        System.out.println("rowCount: " + rowCount);
		        	System.out.println("cells in col: " + colCount);
		        }
		        if(colCount==0) {
		        	label = new Label(colCount++, rowCount, currDate);
		        	excelSheet.addCell(label);
		        	System.out.println("colCounta="+colCount+", currDate="+currDate);
		        }
	        	label = new Label(colCount++, rowCount, batteryPer);
	        	excelSheet.addCell(label);
	        	System.out.println("colCountb="+colCount+", batteryPer="+batteryPer);
	        	label = new Label(colCount++, rowCount, cmmnt);
	        	System.out.println("colCountc="+colCount+", cmmnt="+cmmnt);
	        	System.out.println("label="+label);
	        	excelSheet.addCell(label);
	        }
	        if(wb != null) {
	            wb.close();
	        }
	        writableWorkbook.write();
	        writableWorkbook.close(); //everytime save it.
	    }catch(Exception e) {
	    	System.out.println("error in writeRow()");
			e.printStackTrace();
			Log.addMessage("Error in writing data to excel" + e);
	    }
	}
}