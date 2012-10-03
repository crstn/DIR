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
import java.util.Iterator;

import org.apache.log4j.Logger;

/**
 * Represents a rank as part of a <code>Ranking</code>. A rank has a rank number
 * according to the position of this rank within an ranking. Every rank can
 * store a set of <code>ResultConcept</code>s.
 * 
 * @author Marius Austerschulte, Carsten Ke§ler
 * 
 */
public class Rank implements Comparable {

	private ArrayList<Result> results;
	private int rankNumber = -1; // the number of the rank within a ranking.

	// -1 if undefined.

	private static Logger LOGGER = Logger.getLogger(Rank.class);

	public Rank() {
		results = new ArrayList<Result>();
	}

	public Rank(ArrayList<String> matchNames, ArrayList<ResultObject> objects, ArrayList<Double> relevanceValues) {
		results = new ArrayList<Result>();
		if (matchNames.size() == relevanceValues.size() && relevanceValues.size() == objects.size()) {
			for (Iterator<String> iterS = matchNames.iterator(); iterS
					.hasNext();) {
				Iterator<Double> iterD = relevanceValues.iterator();
				Iterator<ResultObject> objs = objects.iterator();
				results.add(new Result(iterS.next(), objs.next(), iterD.next()));
			}
		}
	}

	public Rank(ArrayList<Result> results) {
		this.results = results;
	}

	/**
	 * Retrieves the concept with the specified name from this rank.
	 * 
	 * @param resultName
	 *            The name of the concept to return.
	 * @return The concept with the specified name. If there is no such concept
	 *         in this rank null will be returned.
	 */
	public Result getResult(String resultName) {
		for (Iterator<Result> iter = results.iterator(); iter.hasNext();) {
			Result c = iter.next();
			if (c.getName().equals(resultName)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Retrieves all concepts from this rank.
	 * 
	 * @return
	 */
	public ArrayList<Result> getResults() {
		return results;
	}

	/**
	 * Adds a concept to this rank. The concept will be assigned the rank number
	 * of this rank.
	 * 
	 * @param name
	 *            the name of the concept
	 * @param relevanceValue
	 *            the relevance value (between 0 and 1)
	 */
	public void addResult(String name, ResultObject o, double relevanceValue) {
		Result c = new Result(name, o, relevanceValue);
		c.setRankNumber(this.rankNumber);
		this.results.add(c);
	}

	/**
	 * Adds a result to this rank. The result will be assigned the rank number
	 * of this rank.
	 * 
	 * @param c
	 *            the concept to add
	 */
	public void addResult(Result c) {
		c.setRankNumber(this.rankNumber);
		this.results.add(c);
	}

	/**
	 * Returns the number of results stored in this rank.
	 * 
	 * @return the number of results stored in this rank
	 */
	public int getNumberOfResults() {
		return results.size();
	}

	/**
	 * Returns the position of the result with the specified concept name. -1
	 * will be returned if such a result is not contained in this rank. The
	 * first position in this rank is 0;
	 * 
	 * @param resultName
	 *            the result name
	 * @return The position of the result in the ranking. -1 if there is no
	 *         result with specified name in this rank.
	 */
	public int indexOf(String resultName) {
		int i = -1;
		for (Iterator<Result> iter = results.iterator(); iter.hasNext();) {
			i++;
			if (iter.next().getName().equals(resultName)) {
				return i;
			}
		}
		return i;
	}

	/**
	 * Returns true if there is a concept with the specified concept name in
	 * this rank.
	 * 
	 * @param conceptName
	 * @return
	 */
	public boolean contains(String conceptName) {
		if (indexOf(conceptName) == -1)
			return false;
		else
			return true;
	}

	/**
	 * Returns the number of this rank within a ranking.
	 * 
	 * @return the rank number of this concept. A value of -1 means that the
	 *         rank number is undefined.
	 */
	public int getRankNumber() {
		return rankNumber;
	}

	/**
	 * Sets the rank number of this rank to undefined i.e. -1.<br>
	 * The undefined value will also be automatically assigned to all
	 * <code>ResultConcept</code> objects stored in this rank.
	 * 
	 */
	public void setRankNumberUndefined() {
		this.rankNumber = -1;
		for (Iterator<Result> iter = results.iterator(); iter.hasNext();) {
			iter.next().setRankNumber(-1);
		}
	}

	/**
	 * Sets the rank number of this rank.<br>
	 * The specified rank number will also be automatically assigned to all
	 * <code>ResultConcept</code> objects stored in this rank.
	 * 
	 * @param rankNumber
	 *            the number to assign to this rank
	 */
	public void setRankNumber(int rankNumber) {
		for (Iterator<Result> iter = results.iterator(); iter.hasNext();) {
			iter.next().setRankNumber(rankNumber);
		}
		this.rankNumber = rankNumber;
	}

	/**
	 * Return the similarity value of the concepts at this rank. Returns 0.0 if
	 * the rank is empty i.e., contains no ResultConcepts.
	 * 
	 * @return
	 */
	public double getRelevanceValue() {
		if (results.size() == 0)
			return 0.0;
		else
			return results.get(0).getRelevanceValue();
	}

	/**
	 * Sets the similarity value for all concepts at this rank.
	 * 
	 * @param value
	 *            The similarity value that will be assigned to all concepts
	 *            that are contained in this rank.
	 */
	public void setSimilarityValue(double value) {
		for (Iterator<Result> iter = results.iterator(); iter.hasNext();) {
			iter.next().setRelevanceValue(value);
		}
	}

	/**
	 * Returns an array of the names of all concepts stored in this rank.
	 * 
	 * @return an array of the names of all concepts stored in this rank
	 */
	public String[] getConceptNames() {
		int n = this.getNumberOfResults();
		String[] conceptNames = new String[n];
		for (int i = 0; i < n; i++) {
			conceptNames[i] = this.results.get(i).getName();
		}
		return conceptNames;
	}

	/**
	 * Returns the names of all concepts stored in this rank as a single
	 * <code>String</code>. The names are separated by a comma and a space
	 * character.
	 * 
	 * @return
	 */
	public String getCommaSeparatedConceptNames() {
		String cscn = "";
		int i = 1;
		int n = this.getNumberOfResults();
		for (Iterator<Result> iter = results.iterator(); iter.hasNext();) {
			cscn = cscn + iter.next().getName();
			if (i < n)
				cscn = cscn + ", ";
			i++;
		}
		return cscn;
	}

	/**
	 * Returns an exact copy of this <code>Rank</code> including all containing
	 * concepts.
	 */
	public Rank clone() {
		Rank rankCopy = new Rank();
		rankCopy.rankNumber = this.rankNumber;
		for (Iterator<Result> iter = this.results.iterator(); iter.hasNext();) {
			rankCopy.addResult(iter.next().clone());
		}
		return rankCopy;
	}

	public void log() {
		LOGGER.info("Rank " + rankNumber);
		for (Result result : results) {
			result.log();
		}
	}
	
	public String toString() {
		String out = this.rankNumber+": ";
		for (Result result : results) {
			out += result.toString()+", ";
		}
		return out;
	}

	/**
	 * this may seem a bit odd, since it is exactly the opposite of what you
	 * would usually do, but we want a ranking to start with HIGH relevance
	 * values and sort them descendingly!
	 */
	public int compareTo(Object o) {
		Rank r = (Rank) o;

		if (this.getRelevanceValue() < r.getRelevanceValue())
			return 1;

		if (this.getRelevanceValue() > r.getRelevanceValue())
			return -1;

		return 0;
	}
}
