package com.ncr.chess.exception;

import com.ncr.chess.ChessBoard;

public class InvalidPositionException extends ChessboardBaseException {
	
	 protected int xCoordinate;
	    protected int yCoordinate;

	    public InvalidPositionException( String msg, ChessBoard chessBoard, int xCoordinate, int yCoordinate )
	    {
	        super( msg, chessBoard );
	        this.xCoordinate = xCoordinate;
	        this.yCoordinate = yCoordinate;
	    }

	    public InvalidPositionException( String msg, ChessBoard chessBoard, int xCoordinate, int yCoordinate, Throwable actionExCause )
	    {
	        super( msg, chessBoard, actionExCause );
	        this.xCoordinate = xCoordinate;
	        this.yCoordinate = yCoordinate;
	    }

	    public int getxCoordinate()
	    {
	        return xCoordinate;
	    }

	    public int getyCoordinate()
	    {
	        return yCoordinate;
	    }

	    @Override
	    public String toString()
	    {
	        final StringBuilder sb = new StringBuilder( "InvalidPositionException{" );
	        sb.append( "chessboard=" ).append( getChessBoard() );
	        sb.append( ", xCoordinate=" ).append( xCoordinate );
	        sb.append( ", yCoordinate=" ).append( yCoordinate );
	        sb.append( '}' );
	        return sb.toString();
	    }

}
