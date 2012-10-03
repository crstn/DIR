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


/**
 * This class merges two rankings to an ArrayList of
 * <code>MergedResultConcept</code>s. Each <code>MergedResultConcept</code>
 * additionally holds its rank number(s) from its source ranking(s).
 * 
 * @author Marius Austerschulte
 * 
 */
public class RankingMerge {

	private ArrayList<MergeResult> rankingMerge = new ArrayList<MergeResult>();

	public RankingMerge(Ranking r1, Ranking r2) {

		// add all concepts from ranking1 to the rankingMerge list
		ArrayList<Result> r1Concepts = r1.getAllResults();
		for (Iterator<Result> iter = r1Concepts.iterator(); iter.hasNext();) {
			MergeResult c = new MergeResult(iter.next());
			rankingMerge.add(c);
		}

		// iterate over ranking2 and see if there are equally named concepts in
		// the rankingMerge list
		ArrayList<Result> r2Concepts = r2.getAllResults();
		for (Iterator<Result> iR2 = r2Concepts.iterator(); iR2.hasNext();) {
			// this one used to be *outside* the loop -> once set to true, it was never set back to false! Fixed…
			boolean contained = false;
			
			MergeResult currentConcept = new MergeResult(iR2.next());
			
			for (Iterator<MergeResult> iRm = rankingMerge.iterator(); iRm.hasNext();) {
				MergeResult lookupConcept = iRm.next();
				if (lookupConcept.getName().equals(currentConcept.getName())) {
					// concept is in both rankings
					lookupConcept.setSecondRankNumber(currentConcept.getRankNumber());
					lookupConcept.setSecondRelevanceValue(currentConcept.getRelevanceValue());
					contained = true;
					break;					
				}
			}
			
			if (!contained) {
				currentConcept.setSecondRankNumber(currentConcept.getRankNumber());
				currentConcept.setRankNumberUndefined();
				currentConcept.setSecondRelevanceValue(currentConcept.getRelevanceValue());
				currentConcept.setRelevanceValue(0.0);
				rankingMerge.add(currentConcept);
			}
			
		}
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<MergeResult> getMergedConcepts() {
		return rankingMerge;
	}

}
