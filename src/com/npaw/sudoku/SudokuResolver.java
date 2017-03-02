package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SudokuResolver implements ISudokuResolver {

	// The core of the Sudoku Application
	public Sudoku resolveSudoku(Sudoku sudoku, String isMultiThreading) {

		int sudokuSize = sudoku.getSize();
		int expectedResolvedCell = sudokuSize * sudokuSize;
		boolean isMultiThread = toBoolean(isMultiThreading);
		
		if (isMultiThread) {
			System.out.print("MultiThread");
			// return resolveMultiThreading(sudoku);
		} else {
			System.out.print("Uno solo");
			while (sudoku.getResolvedNumberCell() < expectedResolvedCell) {
				System.out.println(sudoku.getResolvedNumberCell());
				this.resolveByMatrix(sudoku);
				// this.resolveByColumn(sudoku);
				// this.resolveByRow(sudoku);
				// this.resolveByRow(sudoku);
				// this.resolveByColumn(sudoku);
			}

		}
		

		return sudoku;
	}

	private boolean toBoolean(String stringToCheck) {

		if (stringToCheck.equals("0")) return false;
		else if (stringToCheck.equals("1")) return true;
		else return false;
		
	}

	private void resolveByRow(Sudoku sudoku) {

		Map<Integer, List<GameCell>> rows = sudoku.getRows();
		computeElements(sudoku, rows);

	}

	private void resolveByColumn(Sudoku sudoku) {

		Map<Integer, List<GameCell>> columns = sudoku.getColumns();
		computeElements(sudoku, columns);

		Set<Integer> siblings = new HashSet<Integer>();
		List<Integer> remains = new ArrayList<Integer>();

	}

	private void resolveByMatrix(Sudoku sudoku) {

		Map<Integer, List<GameCell>> matrix = sudoku.getMatrix();
		computeElements(sudoku, matrix);

	}

	private void computeElements(Sudoku sudoku,
			Map<Integer, List<GameCell>> elements) {

		List<GameCell> gameCellList = null;
		Set<Integer> siblings = new HashSet<Integer>();
		List<Integer> remains = new ArrayList<Integer>();

		if (elements != null) {
			for (int i = 0; i < elements.size(); i++) {

				gameCellList = elements.get(i);

				for (GameCell gamecell : gameCellList) {

					if (!gamecell.isResolved()) {

						siblings = sudoku.getSiblings(gamecell);
						remains = this.getRemains(siblings,
								sudoku.getSize() + 1);

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
