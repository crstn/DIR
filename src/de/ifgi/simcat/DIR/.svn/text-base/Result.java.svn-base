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

import org.apache.log4j.Logger;

/**
 * Note: The name of this class has recently been changed from
 * ConceptSimValuePair to ResultConcept.
 * 
 * This class implements Result Concept consisting of its concept name and the
 * associated relevance value. Additionally this class can store its rank
 * position within a ranking.
 * 
 * @author Marius Austerschulte
 * 
 */
public class Result {
	private String name = "";
	private ResultObject obj;
	private double relevanceValue = 0;
	private int rankNumber = -1;

	private static Logger LOGGER = Logger.getLogger(Result.class);
	
//	public Result() {
//
//	}

	public Result(String name, ResultObject obj) {
		this.name = name;
		this.obj = obj;
	}

	/**
	 * Creates a new instance of a <code>ResultConcept</code> .
	 * 
	 * @param name
	 *            The name of the concept
	 * @param relevanceValue
	 *            The similarity value of the concept. This must be a value
	 *            between 0 and 1.
	 */
	public Result(String name, ResultObject obj, double relevanceValue) {
		this.name = name;
		this.relevanceValue = relevanceValue;
		this.obj = obj;
	}
	
	
	/**
	 * Returns the object represented encapsulated by this result.
	 * 
	 * @return
	 */
	public ResultObject getObject(){
		return obj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRelevanceValue() {
		return relevanceValue;
	}

	public void setRelevanceValue(double relValue) {
		this.relevanceValue = relValue;
	}

	/**
	 * Returns the rank number of this concept.
	 * 
	 * @return the rank number of this concept. A value of -1 means that the
	 *         rank number is undefined.
	 */
	public int getRankNumber() {
		return rankNumber;
	}

	public void setRankNumber(int rankNumber) {
		this.rankNumber = rankNumber;
	}

	/**
	 * Sets the rank number of this concept to undefined i.e., -1;
	 */
	public void setRankNumberUndefined() {
		this.rankNumber = -1;
	}


	/**
	 * Returns an exact copy of this concept.
	 */
	public Result clone() {
		String nameCopy = new String(this.name);
		ResultObject oCopy = obj.clone();
		Result rcCopy = new Result(nameCopy, oCopy, this.relevanceValue);
		rcCopy.rankNumber = this.rankNumber;
		return rcCopy;
	}

	public void log() {
		LOGGER.info(this.name+" ("+this.relevanceValue+")");
	}
	
	public String toString(){
		return this.name;
	}

}
