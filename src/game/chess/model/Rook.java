package game.chess.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Satya on 14/06/14.
 */
class Rook extends Piece {
    private final boolean moved;
    public Rook(Pose2d position, Player player, ChessBoard board) {
        super(position, player, board);
        moved = false;
    }

    public boolean isMoved() {
        return moved;
    }
    @Override
    public Piece withPosition(Pose2d pos) {
        return new Bishop(pos, this.player, this.board);
    }
    @Override
    public Set<Move> allPossibleMoves() {
        Set<Move> allPossibleMoves = new HashSet<>(16);

        Pose2d pos = this.position;
        int x = pos.row();
        int y = pos.col();

        int i = 1;
        pos = Pose2d.create(x + i, y);
        while (this.isSafeToMove(pos)) {
            ++i;
            allPossibleMoves.add(new Move(this.position, pos, this, false));
            pos = Pose2d.create(x + i, y);
        }
        i = 1;
        pos = Pose2d.create(x - i, y);
        while (this.isSafeToMove(pos)) {
            ++i;
            allPossibleMoves.add(new Move(this.position, pos, this, false));
            pos = Pose2d.create(x - i, y);
        }
        i = 1 ;
        pos = Pose2d.create(x, y - i);
        while (this.isSafeToMove(pos)) {
            ++i;
            allPossibleMoves.add(new Move(this.position, pos, this, false));
            pos = Pose2d.create(x, y - i);
        }
        i = 1;
        pos = Pose2d.create(x, y + i);
        while (this.isSafeToMove(pos)) {
            ++i;
            allPossibleMoves.add(new Move(this.position, pos, this, false));
            pos = Pose2d.create(x, y + i);
        }

        return allPossibleMoves;
    }
}

