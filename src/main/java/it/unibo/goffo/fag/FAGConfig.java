package it.unibo.goffo.fag;

public class FAGConfig {

    private static double DISP_WIDTH = 800.0;
    private static double DISP_HEIGHT = 600.0;

    public static FAGConfig getConfig() {
        return new FAGConfig();
    }

    public double getDispWidth() {
        return DISP_WIDTH;
    }

    public double getDispHeight() {
        return DISP_HEIGHT;
    }
}
