class Solution {
    public boolean checkOverlap(
        int radius,
        int xCenter,
        int yCenter,
        int x1,
        int y1,
        int x2,
        int y2
    ) {
        // Closest point on the rectangle
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Distance between circle center and closest point
        long dx = xCenter - closestX;
        long dy = yCenter - closestY;

        long distanceSquared = dx * dx + dy * dy;
        long radiusSquared = (long) radius * radius;

        // Overlap if distance <= radius
        return distanceSquared <= radiusSquared;
    }
}