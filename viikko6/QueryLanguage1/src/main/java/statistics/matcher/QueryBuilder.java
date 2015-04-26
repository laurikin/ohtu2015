/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;
import statistics.Player;

/**
 *
 * @author laurikin
 */
public class QueryBuilder {

    private ArrayList<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<Matcher>();
    }

    public QueryBuilder hasAtLeast (int value, String field) {
        this.matchers.add(new HasAtLeast(value, field));
        return this;
    }

    public QueryBuilder hasFewerThan (int value, String field) {
        this.matchers.add(new HasFewerThan(value, field));
        return this;
    }

    public QueryBuilder playsIn (String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder oneOf (Matcher...matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }

    public Matcher build() {
        Matcher[] and = new Matcher[this.matchers.size()];
        for (int i = 0; i < and.length; i++) {
            and[i] = matchers.get(i);
        }
        return new And(and);
    }

    
    
}
