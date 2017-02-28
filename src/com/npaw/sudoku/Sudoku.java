package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sudoku {
	
	
	
	private Map<Integer, List<GameCell>> rows;
	private Map<Integer, List<GameCell>> columns;
	private Map<Integer, List<GameCell>> matrix;
	
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
		int row = gameCell.getRow();
		int column = gameCell.getColumn();
		int matrix = gameCell.getMatrix();
		
		//in teoria dovrebbe essere tutti gli elementi di una riga tranne quello corrente
		List<GameCell> rowsSibling = this.rows.get(row);
		
		for (GameCell gamecell: rowsSibling){
			
		}
		return null;
		
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
