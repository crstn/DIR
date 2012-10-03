package de.ifgi.simcat.DIR;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class DIRmahout extends DIR {

	/**
	 * Calculates the DIR value based on the ranks of the RecommendedItems in the two lists.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getDIRrank(List<RecommendedItem> a,
			List<RecommendedItem> b) {
		return getDIRrank(convertToRanking(a), convertToRanking(b));
	}

	/**
	 * Calculates the DIR value based on the relevance of the RecommendedItems in the two lists.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getDIRrel(List<RecommendedItem> a,
			List<RecommendedItem> b) {
		return getDIRrel(convertToRanking(a), convertToRanking(b));
	}

	/**
	 * Converts Mahout's lists of recommended items to DIR rankings. A
	 * recommended item's item ID is used both as the name and as the result
	 * object itself.
	 * 
	 * @param list
	 * @return
	 */
	private static Ranking convertToRanking(List<RecommendedItem> list) {
		Ranking ranking = new Ranking();

		for (RecommendedItem item : list) {
			Result result = new Result(new Float(item.getItemID()).toString(),
					new DummyResultObject(), new Double(item.getValue())
							.doubleValue());
			
			ranking.addResult(result);
		}

		return ranking;
	}

}
