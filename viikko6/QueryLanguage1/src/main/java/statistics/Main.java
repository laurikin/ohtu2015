package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new Or(
                                new HasFewerThan(4, "goals"),
                                new HasAtLeast(30, "assists")
                            ),
                            new And(
                                new Not(new PlaysIn("PHI")),
                                new Not(new PlaysIn("PIT"))
                            )
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
