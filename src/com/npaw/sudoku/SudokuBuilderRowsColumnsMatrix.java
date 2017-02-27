package com.npaw.sudoku;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SudokuBuilderRowsColumnsMatrix implements ISudokuBuilder {

	private Sudoku sudoku = null;
	
	public void buildSudoku(String filename) {

		List<String> sudokuLines = getLines(filename);
		
		GameCell[][] sudokuCells = buildCells(sudokuLines);
		sudoku = new Sudoku(sudokuCells);
		
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
	
	private GameCell[][] buildCells(List<String> sudokuLines){
				
		int row = -1;
		int column = -1;
		int matrix = 0;
		int currentMatrix = 0;
		
		Row rowObject;
		Column columnObject;
		SudokuCell sudokuCellObject;
		
		
		//First outside the cycle
		
		Matrix matrixObject = new Matrix();
		
		String[] columnString;
		
		List<Integer> elements;
				
		GameCell[][] sudokuCell = new GameCell[sudokuLines.size()][sudokuLines.size()];
//		sudokuCell = new RowDecorator(sudokuCell);
//		
//		GameCell matrixDecoratorCell = new MatrixDecorator(sudokuCell);
//		CellDecorator columnDecoratorCell = new ColumnDecorator(matrixDecorator);
					
		for (String line :  sudokuLines) {						
			row +=1;
			rowObject = new Row();
			
			columnString = line.split(",");
			
			if (columnString.length > 0){
				for (int c=0; c< columnString.length; c++){
					
					columnObject = new Column();
					
					currentMatrix = getMatrixPosition(row, c); 
					if (matrix != currentMatrix ){
						//I'm changing the matrix
						matrix = currentMatrix;		
						matrixObject = new Matrix();
					}
					
					
					elements = new ArrayList<Integer>();
					
					if (isStringInteger(columnString[c])){
						column = Integer.valueOf(columnString[c]);
						elements.add(column);
					} 					
					
					
					//Qua passare anche columnString perché calcolo la posizione
					//della matrice in base al numero di colonne
					
					
					sudokuCellObject = new  SudokuCell(row+","+c+","+matrix, elements);
					sudokuCell[row][c] = sudokuCellObject;
					
					rowObject.addCell(sudokuCellObject);
					columnObject.addCell(sudokuCellObject);
					matrixObject.addCell(sudokuCellObject);
					
				}
			}
		}
        
		return sudokuCell;
	}
	
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
	
	private boolean isStringInteger(String stringToCheck){
		
		try{
			Integer number = Integer.valueOf(stringToCheck);
		}
		catch(Exception ex){
			return false;
		}
		return true;
	}
	
}
