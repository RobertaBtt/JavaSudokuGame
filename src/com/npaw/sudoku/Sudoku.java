package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sudoku {
	
	
	
	private Map<Integer, List<GameCell>> rows;	
	private Map<Integer, List<GameCell>> columns;
	private Map<Integer, List<GameCell>> matrix;

	public Map<Integer, List<GameCell>> getRows() {
		return rows;
	}
	
	public Map<Integer, List<GameCell>> getColumns() {
		return columns;
	}

	public Map<Integer, List<GameCell>> getMatrix() {
		return matrix;
	}

	
	
	public Sudoku(){
		
		this.rows = new HashMap<Integer, List<GameCell>>();
		this.columns = new HashMap<Integer, List<GameCell>>();
		this.matrix = new HashMap<Integer, List<GameCell>>();
	}
	
	
	public void addToRowList(int rowId, GameCell gameCell){
		
		if (rows.get(rowId) != null) {
			rows.get(rowId).add(gameCell);
		}
		else{
			List<GameCell> gameCellList = new ArrayList<GameCell>();
			gameCellList.add(gameCell);			
			rows.put(rowId, gameCellList);
		}
	}
	
	public void addToColumnList(int columnId, GameCell gameCell){
		
		if (columns.get(columnId) != null) {
			columns.get(columnId).add(gameCell);
		}
		else{
			List<GameCell> gameCellList = new ArrayList<GameCell>();
			gameCellList.add(gameCell);			
			columns.put(columnId, gameCellList);
		}
	}

	public void addToMatrixList(int matrixId, GameCell gameCell){
		
		if (matrix.get(matrixId) != null) {
			matrix.get(matrixId).add(gameCell);
		}
		else{
			List<GameCell> gameCellList = new ArrayList<GameCell>();
			gameCellList.add(gameCell);			
			matrix.put(matrixId, gameCellList);
		}
}
	
	//restituisce i numeri fratelli di una determinatata cella
	public Set<Integer> getSiblings(GameCell gameCell){
		
		//in teoria dovrebbe essere tutti gli elementi di una riga tranne quello corrente
		Set<Integer> siblingsRow = this.getSiblingsOfRow(gameCell);
		Set<Integer> siblingsColumn = this.getSiblingsOfColumn(gameCell);
		Set<Integer> siblingsMAtrix = this.getSiblingsOfMatrix(gameCell);
		
		Set<Integer> result = new HashSet<Integer>(siblingsRow);
		result.addAll(siblingsColumn);
		result.addAll(siblingsMAtrix);
		
		return result;
				
	}
	
	
	
	private Set<Integer> getSiblingsOfRow(GameCell gameCell){
		int row = gameCell.getRow();
		int column = gameCell.getColumn();
		Set<Integer> siblingsByRow = new HashSet<Integer>();
		Integer currentElement = null;
		
		List<GameCell> rowsSibling = this.rows.get(row);
		
		for (GameCell gamecellByRow: rowsSibling){
		
			if (gamecellByRow.column != column){
				currentElement = gamecellByRow.getElement();
				if (currentElement != null) 
					siblingsByRow.add(currentElement);			
			}
		}
		
		return siblingsByRow;
		
	}
	
	private Set<Integer> getSiblingsOfColumn(GameCell gameCell){
		int row = gameCell.getRow();
		int column = gameCell.getColumn();
		Set<Integer> siblingsByColumn = new HashSet<Integer>();
		Integer currentElement = null;
		
		List<GameCell> columnSibling = this.columns.get(column);
		
		for (GameCell gamecellByRow: columnSibling){
		
			if (gamecellByRow.row != row){
				currentElement = gamecellByRow.getElement();
				if (currentElement != null) 
					siblingsByColumn.add(currentElement);			
			}
		}
		
		return siblingsByColumn;
		
	}
	
	private Set<Integer> getSiblingsOfMatrix(GameCell gameCell){
		int row = gameCell.getRow();
		int column = gameCell.getColumn();
		int matrix = gameCell.getMatrix();
		Set<Integer> siblingsByMatrix = new HashSet<Integer>();
		Integer currentElement = null;
		
		List<GameCell> matrixSibling = this.matrix.get(matrix);
		
		for (GameCell gamecellByRow: matrixSibling){
		
			if (gamecellByRow.row != row && gamecellByRow.column != column){
				currentElement = gamecellByRow.getElement();
				if (currentElement != null) 
					siblingsByMatrix.add(currentElement);			
			}
		}
		
		return siblingsByMatrix;
		
	}
	
	
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
		
		//private Map<Integer, List<GameCell>> rows;
		//Internalli we print by rows
		
		List<GameCell> gameCellList = null;
		

		if (this.rows != null){
			for (int i =0; i<rows.size(); i++){
				gameCellList = rows.get(i);
				
				for (GameCell gamecell: gameCellList){
					System.out.print(gamecell.getFirstElement() + " " );
				}
				System.out.println();	

			}
			
		}
//		if (this.sudokuCells != null){
//			
//			for (int r=0; r<sudokuCells.length; r++){
//				for (int c=0; c< sudokuCells.length; c++){
//					System.out.print(sudokuCells[r][c].getFirstElement() + " ");
//				}
//				System.out.println();
//			}
//		}
		
	}
	
	public Sudoku resolveSudoku(Sudoku sudoku){
	
		return null;
	}
	
	
}
