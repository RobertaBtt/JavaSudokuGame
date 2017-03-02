package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SudokuResolver implements ISudokuResolver {

	// The core of the Sudoku Application
	public Sudoku resolveSudoku(Sudoku sudoku) {

		int sudokuSize = sudoku.getSize();
		int expectedResolvedCell = sudokuSize * sudokuSize;
		
		while (sudoku.getResolvedNumberCell() < expectedResolvedCell){
			this.resolveByMatrix(sudoku);
			this.resolveByColumn(sudoku);
			this.resolveByRow(sudoku);
			this.resolveByRow(sudoku);
			this.resolveByColumn(sudoku);
		}
//		sudoku.print();
		System.out.println("--------");
		
//		sudoku.print();
		System.out.println("--------");
		
//		sudoku.print();
//		System.out.println("--------");

		
		return sudoku;
	}

	private void resolveByRow(Sudoku sudoku) {

		List<GameCell> gameCellList = null;
		Map<Integer, List<GameCell>> rows = sudoku.getRows();
		Set<Integer> siblings = new HashSet<Integer>();
		List<Integer> remains = new ArrayList<Integer>();

		if (rows != null) {
			for (int i = 0; i < rows.size(); i++) {

				gameCellList = rows.get(i);

				for (GameCell gamecell : gameCellList) {
					
					if (!gamecell.isResolved()) {
						
						siblings = sudoku.getSiblings(gamecell);
						remains = this.getRemains(siblings, sudoku.getSize() + 1);

						if (remains.size() == 1) {
							gamecell.addElement(remains.get(0));
							sudoku.incrementResolvedCell();
						}						
					} 
				}

			}

		}

	}

	private void resolveByColumn(Sudoku sudoku) {

		List<GameCell> gameCellList = null;
		Map<Integer, List<GameCell>> columns = sudoku.getColumns();
		Set<Integer> siblings = new HashSet<Integer>();
		List<Integer> remains = new ArrayList<Integer>();

		if (columns != null) {
			for (int i = 0; i < columns.size(); i++) {

				gameCellList = columns.get(i);

				for (GameCell gamecell : gameCellList) {
					if (!gamecell.isResolved()) {						

						siblings = sudoku.getSiblings(gamecell);
						remains = this.getRemains(siblings, sudoku.getSize() + 1);

						if (remains.size() == 1) {
							gamecell.addElement(remains.get(0));
							sudoku.incrementResolvedCell();
						}
						
					} 
				}

			}

		}

	}
	
	private void resolveByMatrix(Sudoku sudoku) {

		List<GameCell> gameCellList = null;
		Map<Integer, List<GameCell>> matrix = sudoku.getMatrix();
		Set<Integer> siblings = new HashSet<Integer>();
		List<Integer> remains = new ArrayList<Integer>();

		if (matrix != null) {
			for (int i = 0; i < matrix.size(); i++) {

				gameCellList = matrix.get(i);

				for (GameCell gamecell : gameCellList) {
					if (!gamecell.isResolved()) {

						siblings = sudoku.getSiblings(gamecell);
						remains = this.getRemains(siblings, sudoku.getSize() + 1);

						if (remains.size() == 1) {
							gamecell.addElement(remains.get(0));
							sudoku.incrementResolvedCell();
						}
						
					} 

				}

			}

		}

	}
	
	private List<Integer> getRemains(Set<Integer> integerSet, int maxNumber) {

		List<Integer> remainsNumbers = new ArrayList<Integer>();

		for (int i = 1; i < maxNumber; i++) {
			if (!integerSet.contains(i))
				remainsNumbers.add(i);
		}

		return remainsNumbers;

	}

}
