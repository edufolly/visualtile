package br.com.efolly.visualtile.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;

/**
 *
 * @author Eduardo Folly
 */
public class Config implements Serializable {

    private static final Config instance;
    private static final transient String name = "config.json";

    /**
     *
     */
    static {
        instance = load();
    }

    /**
     *
     * @return
     */
    private static Config load() {
        File configFile = new File(name);
        if (configFile.exists() && configFile.isFile()) {
            try {
                Gson gson = new Gson();
                return gson.fromJson(new FileReader(name), Config.class);
            } catch (Exception ex) {
                System.err.println("Não foi possível deserializar o arquivo de configuração.");
                ex.printStackTrace();
            }
        } else {
            System.err.println("Arquivo de configuração não encontrado.");
        }
        return new Config();
    }

    /**
     *
     */
    public static void save() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter fw = new FileWriter(name);
            fw.write(gson.toJson(instance));
            fw.close();
        } catch (Exception ex) {
            System.err.println("Não foi possível salvar o arquivo de configurações.");
        }
    }

    /**
     *
     * @return
     */
    public static Config getInstance() {
        return instance;
    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    private String nomeOrigem;
    private double limSuperior = 0.0;
    private double limEsquerdo = 0.0;
    private double limInferior = 0.0;
    private double limDireito = 0.0;
    private int minZoom = 0;
    private int maxZoom = 25;
    private String nomeDestino;
    private int minTile = 50;
    private double maxTilePercent = 1.1;
    private int tile = 256;
    private boolean antialiasing = true;

    private Config() {

    }

    public String getNomeOrigem() {
        return nomeOrigem;
    }

    public void setNomeOrigem(String nomeOrigem) {
        this.nomeOrigem = nomeOrigem;
    }

    public double getLimSuperior() {
        return limSuperior;
    }

    public void setLimSuperior(double limSuperior) {
        this.limSuperior = limSuperior;
    }

    public double getLimEsquerdo() {
        return limEsquerdo;
    }

    public void setLimEsquerdo(double limEsquerdo) {
        this.limEsquerdo = limEsquerdo;
    }

    public double getLimInferior() {
        return limInferior;
    }

    public void setLimInferior(double limInferior) {
        this.limInferior = limInferior;
    }

    public double getLimDireito() {
        return limDireito;
    }

    public void setLimDireito(double limDireito) {
        this.limDireito = limDireito;
    }

    public int getMinZoom() {
        return minZoom;
    }

    public void setMinZoom(int minZoom) {
        this.minZoom = minZoom;
    }

    public int getMaxZoom() {
        return maxZoom;
    }

    public void setMaxZoom(int maxZoom) {
        this.maxZoom = maxZoom;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    public int getMinTile() {
        return minTile;
    }

    public void setMinTile(int minTile) {
        this.minTile = minTile;
    }

    public double getMaxTilePercent() {
        return maxTilePercent;
    }

    public void setMaxTilePercent(double maxTilePercent) {
        this.maxTilePercent = maxTilePercent;
    }

    public int getTile() {
        return tile;
    }

    public void setTile(int tile) {
        this.tile = tile;
    }

    public boolean isAntialiasing() {
        return antialiasing;
    }

    public void setAntialiasing(boolean antialiasing) {
        this.antialiasing = antialiasing;
    }

}
