import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarPlatoButton;
    private JTextArea textAIngresoPlatos;
    private JButton QuemarDatosButton;
    private JTextField textIngresoPrecio;
    private JTextField textIngresoCalorias;
    private JTextField textIngresoPreparacion;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;
    private Menu menu=new Menu();
    private Ordenamiento orden=new Ordenamiento();


    public mainForm() {
        modificarModifButton.setEnabled(false);
        textoModifPrecio.setEnabled(false);
        textoModifCalorias.setEnabled(false);
        textoModifPreparacion.setEnabled(false);

        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            menu.ingresarPlato(new Plato(textIngresoNombre.getText(),Double.parseDouble(textIngresoPrecio.getText()),
                    Double.parseDouble(textIngresoCalorias.getText()),Integer.parseInt(textIngresoPrecio.getText())));
                textAIngresoPlatos.setText(menu.toString());
            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.datosQuemados();
                JOptionPane.showMessageDialog(null, "Datos cargados correctamente");
                textAIngresoPlatos.setText(menu.toString());
            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscaPorNombre(textoModifNombre.getText());
                modificarModifButton.setEnabled(true);
                textoModifPrecio.setEnabled(true);
                textoModifCalorias.setEnabled(true);
                textoModifPreparacion.setEnabled(true);

            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            menu.ModificarDatos(textoModifNombre.getText(),Double.parseDouble(textoModifPrecio.getText()),Double.parseDouble(textoModifCalorias.getText()),Integer.parseInt(textoModifPreparacion.getText()));
            limpiar();
            textAModif.setText(menu.toString());
            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plato p=menu.eliminarPlato(textNombreEliminar.getText());
                if (p!=null){
                    JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
                }
                limpiar();
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
    private void BuscaPorNombre(String nombre){
        Plato platoEncontrado= menu.BuscarPorNombre(nombre);
        if (platoEncontrado!=null){
            textoModifPrecio.setText(String.valueOf(platoEncontrado.getPrecio()));
            textoModifCalorias.setText(String.valueOf(platoEncontrado.getCalorias()));
            textoModifPreparacion.setText(String.valueOf(platoEncontrado.getTiempo()));
        }else {
            textAModif.setText("Plato no encontrado");
        }
    }
    private void limpiar(){
        textoModifNombre.setText(null);
        textoModifPrecio.setText(null);
        textoModifCalorias.setText(null);
        textoModifPreparacion.setText(null);
    }
}
