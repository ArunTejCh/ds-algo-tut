package com.arun.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MediumEvaluateDivision {

	public static void main(String[] args) {

		MediumEvaluateDivision inst = new MediumEvaluateDivision();

		String[][] arg11 = { { "a", "b" }, { "b", "c" } };
		double[] arg12 = { 2.0, 3.0 };
		String[][] arg13 = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };

		double[] res = inst.calcEquation(arg11, arg12, arg13);

		assert res[0] == 6.0;
		assert res[1] == 0.5;
		assert res[2] == -1.0;
		assert res[3] == 1.0;
		assert res[4] == -1.0;

	}

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

		HashMap<String, ArrayList<String>> edges = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<Double>> edgeWeights = new HashMap<String, ArrayList<Double>>();

		for (int i = 0; i < values.length; i++) {
			String[] curEq = equations[i];
			String top = curEq[0];
			String bot = curEq[1];
			if (!edges.containsKey(top)) {
				edges.put(top, new ArrayList<String>());
			}

			if (!edges.containsKey(bot)) {
				edges.put(bot, new ArrayList<String>());
			}

			if (!edgeWeights.containsKey(top)) {
				edgeWeights.put(top, new ArrayList<Double>());
			}

			if (!edgeWeights.containsKey(bot)) {
				edgeWeights.put(bot, new ArrayList<Double>());
			}
			
			edges.get(top).add(bot);
			edgeWeights.get(top).add(values[i]);
			
			edges.get(bot).add(top);
			edgeWeights.get(bot).add(1.0/values[i]);

		}
		
		
		double results[] = new double[queries.length];

		for(int i = 0; i < queries.length; i++){
			HashSet<String> path = new HashSet<String>();
			results[i] = dfs(queries[i][0],queries[i][1],edges,edgeWeights,path,1.0);
			if(results[i] == 0.0){
				results[i] = -1.0;
			}
		}
		
		
		return results;
	}
	
	public double dfs(String start, String end, HashMap<String, ArrayList<String>> edges, HashMap<String, ArrayList<Double>> edgeWeights, HashSet<String> path, double val){
		if(!edges.containsKey(start))
			return 0.0;
		if(path.contains(start))
			return 0.0;
		if(start.equalsIgnoreCase(end))
			return val;
		
		path.add(start);
		
		ArrayList<String> nodes = edges.get(start);
		ArrayList<Double> weights = edgeWeights.get(start);
		double tmp = 0;
		for(int i = 0; i < nodes.size(); i++){
			tmp = dfs(nodes.get(i),end,edges,edgeWeights,path,val * weights.get(i));
			if(tmp != 0.0){
				break;
			}
		}
		
		path.remove(start);
		return tmp;
	}

}
