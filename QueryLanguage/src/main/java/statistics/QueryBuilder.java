/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import java.util.LinkedList;
import statistics.matcher.*;

/**
 *
 * @author tainalep
 */
class QueryBuilder {

    private LinkedList<Matcher> alkiot;

    public QueryBuilder() {
        alkiot = new LinkedList<Matcher>();

    }

    public QueryBuilder PlaysIn(String teamName) {

        Matcher mPlaysIn = new PlaysIn(teamName);

        return this;

    }

}
