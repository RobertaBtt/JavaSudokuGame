package com.npaw.sudoku;

public class Sudoku {
	
	private GameCell[][] sudokuCells = null;
	private Integer sudokuSize = 0 ;
	
	public Sudoku(GameCell[][] sudokuCells){
		this.sudokuCells = sudokuCells;
		this.sudokuSize = sudokuCells[0].length;
	}
	
	public GameCell[][] getSudokuCells() {
		return this.sudokuCells;
	}

	public Integer getSize(){
		return sudokuSize;
	}
	
	public void print() {
		if (this.sudokuCells != null){
			
			for (int r=0; r<sudokuCells.length; r++){
				for (int c=0; c< sudokuCells.length; c++){
					System.out.print(sudokuCells[r][c].getFirstElement() + " ");
				}
				System.out.println();
			}
		}
		
	}
	
	public Sudoku resolveSudoku(Sudoku sudoku){
	
		return null;
	}
	
	
}
