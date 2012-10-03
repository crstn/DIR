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


/**
 * This class represents a concept that is part of a merge result performed by
 * the <code>RankingMerge</code> class. When merging two rankings r1 and r2
 * into one ArrayList L the concepts from both rankings will be copied to L in
 * such a way that all concepts from both rankings will be in L but L will not
 * hold any duplicate concepts.<br>
 * Every <code>MergeResultConcept</code> C stores two rank numbers. The first
 * one is its rank number according to r1, the second one is its rank number
 * according to r2. If C is not part of r1 but part of r2 its first rank number
 * is undefined, i.e. -1, and its second rank number holds the concept's rank
 * number according to r2 and vice versa.
 * 
 * @author Marius Austerschulte
 * 
 */
public class MergeResult extends Result {
	private int secondRankNumber = -1;
	private double secondRelevanceValue = 0.0;

	public MergeResult(String resultName, ResultObject obj, double relValue, int rankNumber, int secondRankNumber) {
		super(resultName, obj, relValue);
		this.setRankNumber(rankNumber);
		this.secondRankNumber = secondRankNumber;
	}

	public MergeResult(Result c, int secondRankNumber) {
		super(c.getName(), c.getObject(), c.getRelevanceValue());
		this.setRankNumber(c.getRankNumber());
		this.secondRankNumber = secondRankNumber;
	}

	public MergeResult(Result c) {
		super(c.getName(), c.getObject(), c.getRelevanceValue());
		this.setRankNumber(c.getRankNumber());
	}

	public int getSecondRankNumber() {
		return secondRankNumber;
	}

	public void setSecondRankNumber(int secondRankNumber) {
		this.secondRankNumber = secondRankNumber;
	}

	public void setSecondRankNumberUndefined() {
		this.secondRankNumber = -1;
	}
	
	public void setSecondRelevanceValue(double relValue) {
		this.secondRelevanceValue = relValue;
	}
	
	public double getSecondRelevanceValue() {
		return this.secondRelevanceValue;
	}
}
