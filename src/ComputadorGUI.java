
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComputadorGUI extends JFrame {

    private List<Computador> listadoPC = new ArrayList<>();
    private JTextField procesadorField;
    private JTextField graficaField;
    private JTextField ramField;
    private JTextArea listaPC;

    public ComputadorGUI() {
        super("Listado de Computadores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Procesador:"));
        procesadorField = new JTextField(20);
        inputPanel.add(procesadorField);
        inputPanel.add(new JLabel("Gráfica:"));
        graficaField = new JTextField(20);
        inputPanel.add(graficaField);
        inputPanel.add(new JLabel("RAM:"));
        ramField = new JTextField(5);
        inputPanel.add(ramField);
        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String procesador = procesadorField.getText();
                String grafica = graficaField.getText();
                int ram = Integer.parseInt(ramField.getText());
                Computador pc = new Computador(procesador, grafica, ram);
                listadoPC.add(pc);
                actualizarListado();
            }
        });
        inputPanel.add(agregarButton);
        panel.add(inputPanel);

        listaPC = new JTextArea(20, 50);
        JScrollPane scrollPane = new JScrollPane(listaPC);
        panel.add(scrollPane);

        setContentPane(panel);
        pack();
        setVisible(true);
    }

    private void actualizarListado() {
        listaPC.setText("");
        ordenarPorRam();
        for (Computador pc : listadoPC) {
            listaPC.append(pc.getProcesador() + ", " + pc.getGrafica() + ", " + pc.getRam() + " GB\n");
        }
    }

    private void ordenarPorRam() {
        int n = listadoPC.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listadoPC.get(j).getRam() < listadoPC.get(j + 1).getRam()) {
                    Computador temp = listadoPC.get(j);
                    listadoPC.set(j, listadoPC.get(j + 1));
                    listadoPC.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        new ComputadorGUI();
    }
}
