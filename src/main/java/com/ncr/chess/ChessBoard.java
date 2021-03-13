package com.ncr.chess;

import com.ncr.chess.exception.InvalidPositionException;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) throws InvalidPositionException {
    	if ( !isLegalBoardPosition( xCoordinate, yCoordinate ) )
        {
    		pawn.setXCoordinate(-1);
    		pawn.setYCoordinate(-1);
            throw new InvalidPositionException( "Position: " + xCoordinate + "," + yCoordinate + " outwith board limits", this, xCoordinate, yCoordinate);
        }
    	pawn.setXCoordinate( xCoordinate );
    	pawn.setYCoordinate( yCoordinate );
    	pawn.setChessBoard( this );
        this.pieces[xCoordinate][yCoordinate] = pawn;
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
    	 if ( xCoordinate < 0 || xCoordinate >= MAX_BOARD_WIDTH || yCoordinate < 0 || yCoordinate >= MAX_BOARD_HEIGHT )
         {
             return false;
         }

         if ( null != getPawnAtCoordinate( xCoordinate, yCoordinate ) )
         {
            
             return false;
         }

         return true;
    }
    public Pawn getPawnAtCoordinate( int xCoordinate, int yCoordinate )
    {
        return this.pieces[xCoordinate][yCoordinate];
    }
    public Pawn getPieceAtCoordinate( int xCoordinate, int yCoordinate )
    {
        return this.pieces[xCoordinate][yCoordinate];
    }
    
}
