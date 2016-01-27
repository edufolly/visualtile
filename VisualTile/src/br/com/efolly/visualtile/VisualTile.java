package br.com.efolly.visualtile;

import br.com.efolly.visualtile.gui.Principal;
import javax.swing.UIManager;

/**
 *
 * @author Eduardo Folly
 */
public class VisualTile {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
}
