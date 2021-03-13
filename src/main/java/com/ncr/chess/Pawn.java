package com.ncr.chess;

import com.ncr.chess.exception.InvalidMovementException;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;
    private Pawn capturedBy;
    private int loadXCoordinate = -1;
    private int loadYCoordinate = -1;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }
   
    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
    	 this.xCoordinate = value;
         if ( this.loadXCoordinate == -1 && this.xCoordinate > -1 )
         {
             this.loadXCoordinate = this.xCoordinate;
         }
    }
    public void setYCoordinate(int value) {
   	 this.yCoordinate = value;
        if ( this.loadYCoordinate == -1 && this.yCoordinate > -1 )
        {
            this.loadYCoordinate = this.yCoordinate;
        }
   }

    public int getYCoordinate() {
        return yCoordinate;
    }
    public int getLoadYCoordinate()
    {
        return loadYCoordinate;
    }
    public int getLoadXCoordinate()
    {
        return loadXCoordinate;
    }

    

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) throws InvalidMovementException {
    	  switch ( movementType )
          {
              case MOVE:
                  if ( !isValidMoveForChessPiece( newX, newY ) )
                  {
                      throw new InvalidMovementException( "Invalid movement", this, newX, newY, movementType );
                  }
                  break;
              case CAPTURE:
                  if ( !isValidMoveForChessPiece( newX, newY ) )
                  {
                      throw new InvalidMovementException( "Invalid movement", this, newX, newY, movementType );
                  }
                  break;
              default:
                  throw new InvalidMovementException( "Unrecognised MovementType: " + movementType, this, newX, newY, movementType );
          }


          // is it placed already?
          Pawn occupyingPiece = getChessBoard().getPieceAtCoordinate( newX, newY);

          // if valid position and a piece already exists that isn't on the same side, capture
          if ( occupyingPiece != null )
          {
              // same colour, same side
              if ( this.getPieceColor().equals( occupyingPiece.getPieceColor() ) )
              {
                  throw new InvalidMovementException( "A Chess piece on the same side already exists at position " + newX + "," + newY, this, newX, newY, movementType );
              }

              this.capturePiece( occupyingPiece );
          }

          // now move the piece to the new position
          this.setXCoordinate( newX );
          this.setYCoordinate( newY );
    }
    
    
    public boolean isValidMoveForChessPiece( int xCoordinate, int yCoordinate )
    {
        // Pawns can only move one space forward
        if ( this.getLoadYCoordinate() - 2 < 0 )
        {
            // this pawn started at the bottom the of board so y must be one greater than current y coordinate
            return ( yCoordinate - this.getYCoordinate() == 1 );
        }
        else
        {
            // this pawn started at the top the of board so y must be one less than current y coordinate
            return ( yCoordinate - this.getYCoordinate() ) == -1;

        }


    }
    
    public void capturePiece( Pawn capturedPiece )
    {
        capturedPiece.capturedBy = this;
        capturedPiece.setXCoordinate( -1 );
        capturedPiece.setYCoordinate( -1 );
    }

    @Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
    
    
}
