package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResolverThread extends Thread {

	protected void computeElements(Sudoku sudoku,
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
