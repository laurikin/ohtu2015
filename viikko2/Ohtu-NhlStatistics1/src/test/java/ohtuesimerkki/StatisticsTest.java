/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laurikin
 */
public class StatisticsTest {

    private Statistics stats;
    private final Reader readerStub;
    private Player lemieux;
    private Player semenko;
    private Player kurri;
    private Player yzerman;
    private Player gretzky;
    
    public StatisticsTest() {
        lemieux = new Player("Lemieux", "PIT", 45, 54);
        semenko = new Player("Semenko", "EDM", 4, 12);
        kurri = new Player("Kurri", "EDM", 37, 53);
        yzerman = new Player("Yzerman", "DET", 42, 56);
        gretzky = new Player("Gretzky", "EDM", 35, 89);

        readerStub = new Reader() {

            @Override
            public List<Player> getPlayers() {
                ArrayList<Player> players = new ArrayList<Player>();

                players.add(semenko);
                players.add(lemieux);
                players.add(kurri);
                players.add(yzerman);
                players.add(gretzky);

                return players;
            }
        };
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchReturnsPlayerByName() {
        Player p = stats.search("Lemieux");
        assertTrue(p == lemieux);
    }

    @Test
    public void searchReturnsNullForNonExistentPlayer() {
        Player p = stats.search("nobody");
        assertEquals(null, p);
    }

    @Test
    public void teamReturnsAListOfPlayers() {
        List<Player> players = stats.team("EDM");
        assertEquals(3, players.size());
        assertTrue(players.contains(kurri));
        assertTrue(players.contains(semenko));
        assertTrue(players.contains(gretzky));
    }

    @Test
    public void topScorersReturnsPlayersWithMostScores() {
        List<Player> players = stats.topScorers(1);
        assertEquals(2, players.size());
        assertEquals(gretzky, players.get(0));
        assertEquals(lemieux, players.get(1));
    }
}
