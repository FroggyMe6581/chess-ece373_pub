package org.chess.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = { PieceTest.class, RookTest.class, SquareTest.class })
public class ChessTestSuite {

}
