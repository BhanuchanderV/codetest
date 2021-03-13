package com.ncr.chess.exception;

import com.ncr.chess.Pawn;

public class ChessPawnException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pawn pawn;

    public ChessPawnException( String message, Pawn pawn )
    {
        super( message );
        this.pawn = pawn;
    }

    public ChessPawnException( String message, Pawn pawn, Throwable cause )
    {
        super( message, cause );
        this.pawn = pawn;
    }
}
