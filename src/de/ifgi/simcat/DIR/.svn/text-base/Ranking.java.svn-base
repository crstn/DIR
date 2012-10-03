// Copyright 2007 Institute for Geoinformatics University of Muenster (SimCat
// Project)
// 
// This file is part of SIM-DL.
// 
// SIM-DL is free software; you can redistribute it and/or modify it under the 
// terms of the GNU General Public License as published by the Free Software 
// Foundation; either version 2 of the License, or any later version.
// 
// SIM-DL is distributed in the hope that it will be useful, but WITHOUT ANY 
// WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
// FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more 
// details.
// 
// You should have received a copy of the GNU General Public License along with
// SIM-DL; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
// Fifth Floor, Boston, MA  02110-1301  USA

package de.ifgi.simcat.DIR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.apache.log4j.Logger;

/**
 * 
 * @author Marius Austerschulte
 * 
 */
public class Ranking {
	private ArrayList<Rank> ranking;

	private static Logger LOGGER = Logger.getLogger(Ranking.class);

	public Ranking() {
		this.ranking = new ArrayList<Rank>();
	}

	public Ranking(ArrayList<Rank> ranking) {
		this.ranking = ranking;
		reorder();
	}

	/**
	 * Adds a new rank to the ranking and automatically moves it to the correct
	 * position.
	 * 
	 * @param r
	 *            the ranking to add
	 */
	public void addRank(Rank r) {
		r.setRankNumber(ranking.size());
		ranking.add(r);
		reorder();
	}

	/**
	 * Returns the number of ranks currently stored within this ranking.
	 * 
	 * @return
	 */
	public int getNumberOfRanks() {
		return ranking.size();
	}

	/**
	 * Returns the rank at the specified rank number. The top rank has number 0.
	 * 
	 * @param i
	 *            The rank number of the rank to return
	 * @return The rank at rank number i
	 */
	public Rank getRank(int i) {
		return ranking.get(i);
	}

	/**
	 * Returns the number of all concepts stored within this ranking.
	 * 
	 * @return
	 */
	public int getNumberOfResults() {
		int s = 0;
		for (Iterator<Rank> iter = ranking.iterator(); iter.hasNext();) {
			s += iter.next().getNumberOfResults();
		}
		return s;
	}

	/**
	 * Returns an <code>ArrayList</code> of all the ranks stored within this
	 * ranking.
	 * 
	 * @return
	 */
	public ArrayList<Rank> getRanks() {
		return ranking;
	}

	/**
	 * Returns all concepts in this ranking.
	 * 
	 * @return
	 */
	public ArrayList<Result> getAllResults() {
		ArrayList<Result> allConcepts = new ArrayList<Result>();
		for (Iterator<Rank> iter = ranking.iterator(); iter.hasNext();) {
			allConcepts.addAll(iter.next().getResults());
		}
		return allConcepts;
	}

	/**
	 * Returns the rank number of the specified concept. If the concept is not
	 * in this ranking -1 is returned. The top rank has number 0.
	 * 
	 * @param conceptName
	 * @return
	 */
	public int getRankNumberOf(String conceptName) {
		int rankNumber = 0;
		for (Iterator<Rank> iR = ranking.iterator(); iR.hasNext();) {
			int i = iR.next().indexOf(conceptName);
			if (i != -1)
				return rankNumber;
			rankNumber++;
		}
		return -1;
	}

	/**
	 * Returns true if this ranking contains a concept with the specified name.
	 * 
	 * @param conceptName
	 *            The name of the concept to look for in this ranking.
	 * @return
	 */
	public boolean contains(String conceptName) {
		return getRankNumberOf(conceptName) != -1;
	}

	/**
	 * Returns the rank with the given relevance value, or null if that does not
	 * apply.
	 * 
	 * @param relevance
	 * @return
	 */
	public Rank getRank(double relevance) {
		Rank rank = null;

		for (Iterator<Rank> iR = ranking.iterator(); iR.hasNext();) {
			Rank r = iR.next();
			if (r.getRelevanceValue() == relevance)
				rank = r;

		}

		return rank;
	}

	/**
	 * Adds the result to the rank with the given relevance value. If no such
	 * rank exists, creates and adds a new rank.
	 * 
	 * @param r
	 *            The Result to add.
	 */
	public void addResult(Result r) {
		Rank fitter = this.getRank(r.getRelevanceValue());
		if(fitter != null){
			fitter.addResult(r);
		}else{
			Rank rA = new Rank();
			rA.addResult(r);			
			this.addRank(rA);
		}
	}

	/**
	 * Retrieves the concept with the specified name from this ranking.
	 * 
	 * @param conceptName
	 * @return the concept with the specified name. If there is no such concept
	 *         null will be returned.
	 */
	public Result getConcept(String conceptName) {
		for (Iterator<Rank> iR = ranking.iterator(); iR.hasNext();) {
			Rank r = iR.next();
			Result rc = r.getResult(conceptName);
			if (rc != null)
				return rc;
		}
		return null;
	}

	/**
	 * Sets all rank numbers of ranks contained in this ranking to undefined
	 * (-1). The rank numbers of the concepts stored within the ranks will also
	 * be set to undefined.
	 */
	private void setAllRankNumbersUndefined() {
		for (Iterator<Rank> iter = ranking.iterator(); iter.hasNext();) {
			iter.next().setRankNumberUndefined();
		}
	}

	/**
	 * Reorders the ranking so that the rank numbers are ascending and the
	 * relevance values at the ranks are descending (the relevance values are
	 * taken as the basis for this reordering, i.e. they remain unchanged).
	 */
	@SuppressWarnings("unchecked")
	private void reorder() {
		Collections.sort(ranking);
		reorderRanks();
	}

	/**
	 * To be called from reorder: assigns the appropriate rank numbers to the
	 * ranks.
	 */
	private void reorderRanks() {
		int rankNo = 0;
		for (Iterator<Rank> iter = ranking.iterator(); iter.hasNext();) {
			iter.next().setRankNumber(rankNo);
			rankNo++;
		}
	}

	/**
	 * Returns an exact copy of this <code>Ranking</code>.
	 */
	public Ranking clone() {
		Ranking rankingCopy = new Ranking();
		for (Iterator<Rank> iter = this.ranking.iterator(); iter.hasNext();) {
			rankingCopy.addRank(iter.next().clone());
		}
		return rankingCopy;
	}

	public void log() {
		for (Rank rank : ranking) {
			rank.log();
		}
	}

	public String toString() {
		String out = "";
		for (Rank rank : ranking) {
			out += rank.toString() + "\n";
		}
		return out;
	}

	public Result getResultByName(String name) {
		for (Rank rank : ranking) {
			for (Result result : rank.getResults()) {
				if (result.getName().equals(name))
					return result;
			}
		}

		return null;
	}

}
