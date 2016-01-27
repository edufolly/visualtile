package br.com.efolly.visualtile.tile;

import br.com.efolly.visualtile.gui.Progresso;
import br.com.efolly.visualtile.util.Config;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Eduardo Folly
 */
public class Tile {

    private static Config config = Config.getInstance();

    /**
     *
     * @param barra
     * @throws IOException
     */
    public static void autoZoom(Progresso barra) throws IOException {
        System.out.println("Auto Zoom");

        barra.setMaximo(26);

        PontoPreciso se = getSuperiorEsquerdo();
        PontoPreciso id = getInferiorEsquerdo();

        BufferedImage originalImage = getImagemOriginal();
        Dimension d = getDimension(originalImage);

        for (int zoom = 0; zoom <= 25; zoom++) {
            int ret = isZoomAllowed(se, id, zoom, d);

            if (ret < 0) {
                config.setMinZoom(zoom + 1);
            } else if (ret == 0) {
                config.setMaxZoom(zoom);
            } else {
                break;
            }

            barra.incrementar();
        }

        originalImage = null;
    }

    /**
     *
     * @param barra
     * @throws IOException
     */
    public static void processar(Progresso barra) throws IOException {
        System.out.println("Processar");

        barra.setMaximo((config.getMaxZoom() - config.getMinZoom() + 1) * 2);

        int TILE_SIZE = config.getTile();

        PontoPreciso se = getSuperiorEsquerdo();
        PontoPreciso id = getInferiorEsquerdo();

        BufferedImage originalImage = getImagemOriginal();
        Dimension d = getDimension(originalImage);

        File root = new File(config.getNomeDestino());

        for (int zoom = config.getMinZoom(); zoom <= config.getMaxZoom(); zoom++) {
            if (isZoomAllowed(se, id, zoom, d) == 0) {
                // --
                int scale = 1 << zoom;
                Point pse = se.getPixelCoordinate(scale);
                Point pid = id.getPixelCoordinate(scale);
                int dx = pid.x - pse.x;
                int dy = pid.y - pse.y;
                // --

                File fileZoom = new File(root, String.valueOf(zoom));
                fileZoom.mkdir();

                int leftMargin = pse.x % TILE_SIZE;
                int topMargin = pse.y % TILE_SIZE;

                int xMax = (int) (Math.ceil((leftMargin + dx) / (double) TILE_SIZE) * TILE_SIZE);
                int yMax = (int) (Math.ceil((topMargin + dy) / (double) TILE_SIZE) * TILE_SIZE);

                Image scaled = originalImage.getScaledInstance(dx, dy, Image.SCALE_AREA_AVERAGING);
                BufferedImage resizedImage = new BufferedImage(xMax, yMax, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = resizedImage.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                if (config.isAntialiasing()) {
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                }

                g.drawImage(scaled, leftMargin, topMargin, dx, dy, null);
                ImageIO.write(resizedImage, "png", new File(fileZoom, "imagem.png"));

                barra.incrementar();
                System.out.println("Imagem redimensionada...");

                for (int x = pse.x; x < pid.x + leftMargin; x += TILE_SIZE) {

                    int xTile = (int) Math.floor(x / TILE_SIZE);
                    File xFile = new File(fileZoom, String.valueOf(xTile));
                    xFile.mkdir();

                    int xPos = (x - pse.x);

                    for (int y = pse.y; y < pid.y + topMargin; y += TILE_SIZE) {

                        int yTile = (int) Math.floor(y / TILE_SIZE);

                        int yPos = (y - pse.y);

                        File yFile = new File(xFile, yTile + ".png");

                        BufferedImage tileImage = resizedImage.getSubimage(xPos, yPos, TILE_SIZE, TILE_SIZE);
                        ImageIO.write(tileImage, "png", yFile);

                        System.out.print(xPos + "x" + yPos + " - ");
                        System.out.print(xTile + "x" + yTile);

                        System.out.println("");
                    }
                }

                g.dispose();
            }

            barra.incrementar();
        }

        originalImage = null;
    }

    /**
     *
     * @return
     */
    private static PontoPreciso getSuperiorEsquerdo() {
        PontoPreciso se = new PontoPreciso(config.getLimEsquerdo(), config.getLimSuperior());
        System.out.println(se);
        System.out.println(se.toWorld());
        return se;
    }

    /**
     *
     * @return
     */
    private static PontoPreciso getInferiorEsquerdo() {
        PontoPreciso id = new PontoPreciso(config.getLimDireito(), config.getLimInferior());
        System.out.println(id);
        System.out.println(id.toWorld());
        return id;
    }

    /**
     *
     * @return @throws IOException
     */
    private static BufferedImage getImagemOriginal() throws IOException {
        return ImageIO.read(new File(config.getNomeOrigem()));
    }

    /**
     *
     * @param image
     * @return
     */
    private static Dimension getDimension(BufferedImage image) {
        Dimension d = new Dimension(image.getWidth(), image.getHeight());
        System.out.println(d);
        return d;
    }

    /**
     *
     * @param pontoSuperiorEsquerdo
     * @param pontoInferiorDireito
     * @param zoom
     * @param originalWidth
     * @param originalHeight
     * @return
     */
    private static int isZoomAllowed(PontoPreciso pontoSuperiorEsquerdo,
            PontoPreciso pontoInferiorDireito, int zoom, Dimension d) {

        System.out.println("");
        System.out.println("Zoom: " + zoom);
        int scale = 1 << zoom;
        System.out.println("Scale: " + scale);

        Point pse = pontoSuperiorEsquerdo.getPixelCoordinate(scale);
        System.out.println(pse);

        Point pid = pontoInferiorDireito.getPixelCoordinate(scale);
        System.out.println(pid);

        int dx = pid.x - pse.x;
        int dy = pid.y - pse.y;
        System.out.println("Delta: " + dx + "x" + dy);

        int minTile = config.getMinTile();
        double maxTilePercent = config.getMaxTilePercent();

        if (dx < minTile || dy < minTile) {
            config.setMinZoom(zoom + 1);
            System.out.println("Imagem muito pequena.");
            return -1;
        }

        if (dx > d.width * maxTilePercent || dy > d.height * maxTilePercent) {
            System.out.println("Imagem muito grande.");
            return 1;
        }

        return 0;
    }
}
