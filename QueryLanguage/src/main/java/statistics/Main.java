package statistics;
import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        System.out.println("");
        System.out.println("And");

        Matcher mAnd = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(mAnd)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println("HasAtLeast");

        Matcher mHasAtLeast = new Not(new HasAtLeast(1, "goals"));

        for (Player player : stats.matches(mHasAtLeast)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println("Or");

        Matcher mOr = new Or(new HasAtLeast(40, "goals"),
                new HasAtLeast(60, "assists"),
                new HasAtLeast(85, "points")
        );

        for (Player player : stats.matches(mOr)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println("HasFewerThan");

        Matcher mHasFewerThan = new HasFewerThan(1, "goals");

        for (Player player : stats.matches(mHasFewerThan)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println("QueryBuilder- AND");

        QueryBuilder query = new QueryBuilder();

        Matcher mQueryAnd = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "goals").build();

        for (Player player : stats.matches(mQueryAnd)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println("QueryBuilder- OR");

        Matcher mQueryOr = query.oneOf(
                query.playsIn("PHI")
                        .hasAtLeast(10, "goals")
                        .hasFewerThan(20, "assists").build(),
                query.playsIn("EDM")
                        .hasAtLeast(60, "points").build()
        ).build();

        for (Player player : stats.matches(mQueryOr)) {
            System.out.println(player);
        }

    }
}
