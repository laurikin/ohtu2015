package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();
        QueryBuilder query2 = new QueryBuilder();
        QueryBuilder query3 = new QueryBuilder();

        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(5, "goals")
                .hasFewerThan(15, "assists").build();

        Matcher m2 = query2.playsIn("EDM")
                           .hasAtLeast(40, "points").build();

        Matcher m = query3.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
