package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SudokuResolver implements ISudokuResolver {

	// The core of the Sudoku Application
	public Sudoku resolveSudoku(Sudoku sudoku) {

		
//		sudoku.print();
		System.out.println("--------");
		
//		sudoku.print();
		System.out.println("--------");
		
//		sudoku.print();
//		System.out.println("--------");

		this.resolveByMatrix(sudoku);
		this.resolveByColumn(sudoku);
		this.resolveByRow(sudoku);
		this.resolveByRow(sudoku);
		return sudoku;
	}

	private void resolveByRow(Sudoku sudoku) {
		GameCell[][] sudokuCells = sudoku.getSudokuCells();

		List<GameCell> gameCellList = null;
		Map<Integer, List<GameCell>> rows = sudoku.getRows();
		Set<Integer> siblings = new HashSet<Integer>();
		List<Integer> remains = new ArrayList<Integer>();
		int numberOfResolvedCell = 0;

		if (rows != null) {
			for (int i = 0; i < rows.size(); i++) {

				gameCellList = rows.get(i);

				for (GameCell gamecell : gameCellList) {
					if (!gamecell.isResolved()) {
						System.out.print("Riga " + i + "__" + "Colonna --->"
								+ gamecell.getColumn());

						siblings = sudoku.getSiblings(gamecell);
						remains = this.getRemains(siblings, 10);

						if (remains.size() == 1) {
							gamecell.addElement(remains.get(0));
						}
						for (Integer s : remains) {
							System.out.print(" " + s);
						}
						System.out.println();
					} else {
						numberOfResolvedCell += 1;

					}

				}

			}

		}

	}

	private void resolveByColumn(Sudoku sudoku) {
		GameCell[][] sudokuCells = sudoku.getSudokuCells();

		List<GameCell> gameCellList = null;
		Map<Integer, List<GameCell>> columns = sudoku.getColumns();
		Set<Integer> siblings = new HashSet<Integer>();
		List<Integer> remains = new ArrayList<Integer>();
		int numberOfResolvedCell = 0;

		if (columns != null) {
			for (int i = 0; i < columns.size(); i++) {

				gameCellList = columns.get(i);

				for (GameCell gamecell : gameCellList) {
					if (!gamecell.isResolved()) {
						System.out.print("Riga " + i + "__" + "Colonna --->"
								+ gamecell.getColumn());

						siblings = sudoku.getSiblings(gamecell);
						remains = this.getRemains(siblings, 10);

						if (remains.size() == 1) {
							gamecell.addElement(remains.get(0));
						}
						for (Integer s : remains) {
							System.out.print(" " + s);
						}
						System.out.println();
					} else {
						numberOfResolvedCell += 1;

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
		int numberOfResolvedCell = 0;

		if (matrix != null) {
			for (int i = 0; i < matrix.size(); i++) {

				gameCellList = matrix.get(i);

				for (GameCell gamecell : gameCellList) {
					if (!gamecell.isResolved()) {
						System.out.print("Matrice " + i);

						siblings = sudoku.getSiblings(gamecell);
						remains = this.getRemains(siblings, 10);

						if (remains.size() == 1) {
							gamecell.addElement(remains.get(0));
						}
						for (Integer s : remains) {
							System.out.print(" " + s);
						}
						System.out.println();
					} else {
						numberOfResolvedCell += 1;

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
