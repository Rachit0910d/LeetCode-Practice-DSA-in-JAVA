class Solution {

    static class State {
        int r, c, energy, mask, moves;

        State(int r, int c, int energy, int mask, int moves) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;

        int trashCount = 0;

        // Give every trash cell a bit number
        int[][] trashId = new int[m][n];

        for (int[] row : trashId) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    trashId[i][j] = trashCount++;
                }
            }
        }

        int allCollected = (1 << trashCount) - 1;

        /*
         * visited[r][c][energy][mask]
         */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << trashCount];

        Queue<State> queue = new LinkedList<>();

        queue.offer(
            new State(
                startR,
                startC,
                energy,
                0,
                0
            )
        );

        visited[startR][startC][energy][0] = true;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {

            State current = queue.poll();

            int r = current.r;
            int c = current.c;
            int e = current.energy;
            int mask = current.mask;
            int moves = current.moves;

            // All trash collected
            if (mask == allCollected) {
                return moves;
            }

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Outside grid
                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                char cell = classroom[nr].charAt(nc);

                // Wall
                if (cell == 'X') {
                    continue;
                }

                // No energy to move
                if (e == 0) {
                    continue;
                }

                int newEnergy = e - 1;
                int newMask = mask;

                // Collect trash
                if (cell == 'L') {

                    int id = trashId[nr][nc];

                    newMask |= (1 << id);
                }

                // Recharge
                if (cell == 'R') {
                    newEnergy = energy;
                }

                // Avoid duplicate states
                if (!visited[nr][nc][newEnergy][newMask]) {

                    visited[nr][nc][newEnergy][newMask] = true;

                    queue.offer(
                        new State(
                            nr,
                            nc,
                            newEnergy,
                            newMask,
                            moves + 1
                        )
                    );
                }
            }
        }

        return -1;
    }
}