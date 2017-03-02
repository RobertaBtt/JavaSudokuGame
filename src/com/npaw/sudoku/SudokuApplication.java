package com.npaw.sudoku;

import com.npaw.utilities.args.Args;
import com.npaw.utilities.args.ArgsException;

public class SudokuApplication {


	public static void main(String[] args) {
		
		try{
			
			Args arg = new Args(args);
			String isMultiThreading = arg.isMultiThreadin();
			String fileNamePath = arg.getFilePath();
			
			executeApplication(fileNamePath, isMultiThreading);
				
		}
		catch(ArgsException e){
			System.out.println("The parameters must be: -p [0,1] filename"+ e.getMessage());
		}	
		
	}
	
	private static void executeApplication(String filename, String isMultiThreading){
		Sudoku sudoku = buildSudoku(filename);
		sudoku.print();
		Sudoku resolvedSudoku = resolveSudoku(sudoku, isMultiThreading);
		resolvedSudoku.print();
		
	}

	private static Sudoku buildSudoku(String filename){
		ISudokuBuilder builder = new SudokuBuilderRowsColumnsMatrix();
		builder.buildSudoku(filename);
		return builder.getSudoku();
	}
	
	private static Sudoku resolveSudoku(Sudoku sudoku, String isMultiThreading){
		ISudokuResolver sudokuResolver = new SudokuResolver();
		Sudoku resolvedSudoku = sudokuResolver.resolveSudoku(sudoku, isMultiThreading);
		return resolvedSudoku;
	}
	
	
}
