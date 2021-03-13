package com.ncr.chess.exception;

import com.ncr.chess.ChessBoard;

public class ChessboardBaseException extends Exception {

	protected ChessBoard chessBoard;

    public ChessboardBaseException( String message, ChessBoard chessBoard )
    {
        super( message );
        this.chessBoard = chessBoard;
    }

    public ChessboardBaseException( String message, ChessBoard chessBoard, Throwable cause )
    {
        super( message, cause );
        this.chessBoard = chessBoard;
    }

    public ChessBoard getChessBoard()
    {
        return this.chessBoard;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ChessboardBaseException{" );
        sb.append( "chessBoard=" ).append( chessBoard );
        sb.append( '}' );
        return sb.toString();
    }
}
