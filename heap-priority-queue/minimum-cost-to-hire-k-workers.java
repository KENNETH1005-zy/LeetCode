class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // Step 1: Create a list of tuples with (wage/quality ratio, quality) for each worker
        List<double[]> workers = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            workers.add(new double[]{(double) wage[i] / quality[i], (double) quality[i]});
        }

        // Sort the workers by the wage-to-quality ratio
        Collections.sort(workers, Comparator.comparingDouble(a -> a[0]));

        // A max-heap to store the qualities of the selected workers (using a PriorityQueue)
        PriorityQueue<Double> heap = new PriorityQueue<>(Collections.reverseOrder());
        double totalQuality = 0;  // Sum of the qualities of the selected workers
        double minCost = Double.MAX_VALUE;  // Initialize the minimum cost to infinity

        // Step 2: Iterate through each worker sorted by their wage-to-quality ratio
        for (double[] worker : workers) {
            double ratio = worker[0];
            double q = worker[1];
            
            heap.add(q);  // Add the worker's quality to the heap
            totalQuality += q;  // Add the worker's quality to the total quality

            // Step 3: If we have more than k workers, remove the one with the largest quality
            if (heap.size() > k) {
                totalQuality -= heap.poll();  // Remove the largest quality
            }

            // Step 4: If we have exactly k workers, calculate the cost
            if (heap.size() == k) {
                minCost = Math.min(minCost, ratio * totalQuality);  // Calculate the minimum cost
            }
        }

        // Step 5: Return the minimum cost found
        return minCost;
    }
}