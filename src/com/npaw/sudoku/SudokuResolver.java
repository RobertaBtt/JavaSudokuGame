package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SudokuResolver implements ISudokuResolver {

	//The core of the Sudoku Application
	public Sudoku resolveSudoku(Sudoku sudoku) {

		GameCell[][] sudokuCells = sudoku.getSudokuCells();
		
		List<GameCell> gameCellList = null;
		Map<Integer, List<GameCell>> rows = sudoku.getRows(); 
		Set<Integer> siblings = new HashSet<Integer>();
		List<Integer> remains = new ArrayList<Integer>();
		
		if (rows != null){
			for (int i =0; i<rows.size(); i++){
				
				
				gameCellList = rows.get(i);
				
				for (GameCell gamecell: gameCellList){
					if (! gamecell.isResolved()){
						System.out.print("Riga " +i + "__" + "Colonna --->" + gamecell.getColumn());
						
						
						siblings = sudoku.getSiblings(gamecell);
						remains = this.getRemains(siblings, 10);
						
							if (remains.size() == 1){
								gamecell.addElement(remains.get(0));
							}
						for (Integer s : remains) {
							System.out.print(" " + s);
						}
					System.out.println();
					}
						
				}
					

			}
			
		}
		
		if (sudokuCells != null) {
			
			//finché il numero di celle non risolte 
			//del sudoku non é = 0
			//vai avanti finché sudoku non é resolved.
			//potrebbe essereun evento, con i sottoscrittori dell'evento ? : (
			//non lo so...
			
			}

		return null;
	}
	 
	private List<Integer> getRemains(Set<Integer> integerSet, int maxNumber){
		
		List<Integer> remainsNumbers = new ArrayList<Integer>();
		
		for (int i=1; i<maxNumber; i++){
			if ( ! integerSet.contains(i))
				remainsNumbers.add(i);
		}
		
		return remainsNumbers;
		
	}

	
	

}
