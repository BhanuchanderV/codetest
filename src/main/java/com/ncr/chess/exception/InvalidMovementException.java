package com.ncr.chess.exception;

import com.ncr.chess.MovementType;
import com.ncr.chess.Pawn;

public class InvalidMovementException extends ChessPawnException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int xCoordinate;
    protected int yCoordinate;
    protected MovementType movementType;

    public InvalidMovementException( String message, Pawn pawn, int xCoordinate, int yCoordinate, MovementType movementType )
    {
        super( message, pawn );
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.movementType = movementType;
    }
    

    public InvalidMovementException( String message, Pawn pawn, int xCoordinate, int yCoordinate, MovementType movementType, Throwable cause )
    {
        super( message, pawn, cause );
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.movementType = movementType;
    }

    public int getxCoordinate()
    {
        return xCoordinate;
    }

    public int getyCoordinate()
    {
        return yCoordinate;
    }
}
