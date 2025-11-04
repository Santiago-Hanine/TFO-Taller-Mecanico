import vista.DashboardView;
import controlador.DashboardControlador;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DashboardView view = new DashboardView();
            new DashboardControlador(view);

            JFrame frame = new JFrame("Taller Mecánico");
            frame.setContentPane(view.getRootPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
