package com.npaw.sudoku;

import java.util.List;
import java.util.Map;



public class ResolveByRowsThread extends Thread {

	private Sudoku sudoku;
	
	ResolveByRowsThread( Sudoku sudoku) {
	      this.sudoku = sudoku;
	      
	   }
	   
	   public void run() {
		   Map<Integer, List<GameCell>> rows = sudoku.getRows();
			//computeElements(sudoku, rows);
	   }

	   public void start () {
	   
	   }
	   
}
