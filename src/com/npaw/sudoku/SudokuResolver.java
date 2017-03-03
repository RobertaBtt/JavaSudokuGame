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

		boolean isMultiThread = toBoolean(isMultiThreading);
		
		if (isMultiThread) {
			List<Thread> threads = new ArrayList<Thread>();
			Thread thread;
			int expectedResolvedCell = sudokuSize * sudokuSize;
			
			while (sudoku.getResolvedNumberCell() < expectedResolvedCell) {
				
				if(sudoku.getResolvedNumberCell() %2 == 0)
					thread = new ResolveByColumnsThread(sudoku);									
				
				else
					thread = new ResolveByColumnsThread(sudoku);					
				
					
					threads.add(thread);
					thread.start();	
			}
			
			System.out.print("Threads created: " + threads.size() + "\n");
			
			try {
				for (Thread currentThread : threads){
					currentThread.join();
				}
				
			} catch (Exception e) {
				System.out.println("Interrupted" + e.getMessage());
			}
			
			
		} else {
			
			ResolveByRowsThread thread = new ResolveByRowsThread(sudoku);
			thread.start();
			
			try {
				thread.join();
			} catch (Exception e) {
				System.out.println("Interrupted" + e.getMessage());
			}

		}
		

		return sudoku;
	}
	

	private boolean toBoolean(String stringToCheck) {

		if (stringToCheck.equals("0")) return false;
		else if (stringToCheck.equals("1")) return true;
		else return false;
		
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
