package br.com.efolly.visualtile.tile;

import br.com.efolly.visualtile.util.Config;
import java.awt.Point;

/**
 *
 * @author Eduardo Folly
 */
public class PontoPreciso {

    private final double x; // lng
    private final double y; // lat

    private final double wx;
    private final double wy;

    public PontoPreciso(double x, double y) {
        Config config = Config.getInstance();
        this.x = x;
        this.y = y;

        double siny = Math.sin(y * Math.PI / 180d);
        siny = Math.min(Math.max(siny, -0.9999d), 0.9999d);

        this.wy = ((double) config.getTile()) * (0.5d - Math.log((1d + siny) / (1d - siny)) / (4d * Math.PI));
        this.wx = ((double) config.getTile()) * (0.5d + x / 360d);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWorldY() {
        return wy;
    }

    public double getWorldX() {
        return wx;
    }

    public Point getPixelCoordinate(int scale) {
        return new Point((int) Math.floor(wx * (double) scale), (int) Math.floor(wy * (double) scale));
    }

//    public Point getTileCoordinate(int scale) {
//        return new Point((int) Math.floor(wx * scale / TILE_SIZE), (int) Math.floor(wy * scale / TILE_SIZE));
//    }
    @Override
    public String toString() {
        return "LngLat: " + x + ", " + y;
    }

    public String toWorld() {
        return "World: " + wx + ", " + wy;
    }
}
