package com.npaw.sudoku;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SudokuBuilderRowsColumnsMatrix implements ISudokuBuilder {

	private Sudoku sudoku = null;
	
	public void buildSudoku(String filename) {

		List<String> sudokuLines = getLines(filename);
		
		sudoku = build_Sudoku(sudokuLines);
		//sudoku = new Sudoku(sudokuCells);
		
	}

	public Sudoku getSudoku() {
		return sudoku;
	}

	private static List<String> getLines(String filename) {

		Scanner fileScanner;
		List<String> lines = new ArrayList<String>();

		try {
				fileScanner = new Scanner(new File(filename));
				while (fileScanner.hasNextLine()) {
				lines.add(fileScanner.nextLine());
			}
			
			fileScanner.close();
		} catch (FileNotFoundException e) {}

		return lines;
	}
	
	
	private Sudoku build_Sudoku(List<String> sudokuLines){
			
		
		int row = -1;		
		int matrix = 0;	
		int currentMatrix = 0;
		int columnElement = -1;
		String[] columnString;
		List<Integer> elements;
		GameCell sudokuCellObject = null;						
		GameCell[][] sudokuCellGrid = new GameCell[sudokuLines.size()][sudokuLines.size()];
		
		Sudoku sudoku = new Sudoku();
		
		
		Map<Integer, List<GameCell>> rowsHashMap;
		Map<Integer, List<GameCell>> columnsHashMap;
		Map<Integer, List<GameCell>> matrixHashMap;
		
		// per ogni riga
		for (String line :  sudokuLines) {
			
			row +=1;
			rowsHashMap = new HashMap<Integer, List<GameCell>>();
						
						
			columnString = line.split(",");			
			if (columnString.length > 0){
				
				for (int column=0; column< columnString.length; column++){					
										
					elements = new ArrayList<Integer>();
										
					if (isInteger(columnString[column])){
						columnElement = Integer.valueOf(columnString[column]);
						elements.add(columnElement);
					} 					
					
					matrix = getMatrixPosition(row, column);
					
					sudokuCellObject = new  SudokuCell(row, column, matrix, elements);	
					
					sudoku.addToRowList(row, sudokuCellObject);
					
					sudoku.addToColumnList(column, sudokuCellObject);
					
					sudoku.addToMatrixList(matrix, sudokuCellObject);
					
					
					//sudokuCellGrid[row][column] = sudokuCellObject;					
					
				}
				
				
				//rowsHashMap.put(row, gameCellList);
			}
		}
        
		return sudoku;
	}
	
	
	
	//TODO: no hardcode here
	private int getMatrixPosition(int row, int column) {
		
		int matrixPosition = -1;
		
		if (row <=2){
			if (column <=2){matrixPosition = 0;}
			else if (column > 2 && column <=5){ matrixPosition = 1;}
			else if (column > 5 && column <=8){ matrixPosition = 2;}
		}
		
		if (row >3 && row <=5){
			if (column <=2){matrixPosition = 3;}
			else if (column > 2 && column <=5){ matrixPosition = 4;}
			else if (column > 5 && column <=8){ matrixPosition = 5;}
		}
		
		if (row > 6 && row <= 8){
			if (column <=2){matrixPosition = 6;}
			else if (column > 2 && column <=5){ matrixPosition = 7;}
			else if (column > 5 && column <=8){ matrixPosition = 8;}
		}
		
		return matrixPosition;
	}
	
	
	private boolean isInteger(String stringToCheck){
		
		try{
			Integer number = Integer.valueOf(stringToCheck);
		}
		catch(Exception ex){
			return false;
		}
		return true;
	}
	
}
