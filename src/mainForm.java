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
        eliminarButton.setEnabled(false);

        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tN, tP, tC, tPr;
                tN=textIngresoNombre.getText();
                tP=textIngresoPrecio.getText();
                tC=textIngresoCalorias.getText();
                tPr=textIngresoPreparacion.getText();

                if (!tN.isEmpty()&&!tP.isEmpty()&&!tC.isEmpty()&&!tPr.isEmpty() ){
                    if (menu.ingresarPlato(new Plato(textIngresoNombre.getText(),Double.parseDouble(textIngresoPrecio.getText()),
                            Double.parseDouble(textIngresoCalorias.getText()),Integer.parseInt(textIngresoPrecio.getText())))){
                        textAIngresoPlatos.setText(menu.toString());
                        JOptionPane.showMessageDialog(null, "Plato ingresado correctamente");
                    }else {
                        JOptionPane.showMessageDialog(null, "Plato ya existente");
                    }
                }else{
                    textAIngresoPlatos.setText("Campos incompletos, complete todos los campos");
                }

            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.datosQuemados();
                JOptionPane.showMessageDialog(null, "Datos cargados correctamente");
                textAIngresoPlatos.setText(menu.toString());
                QuemarDatosButton.setEnabled(false);
            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscaPorNombre(textoModifNombre.getText());



            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            menu.ModificarDatos(textoModifNombre.getText(),Double.parseDouble(textoModifPrecio.getText()),Double.parseDouble(textoModifCalorias.getText()),Integer.parseInt(textoModifPreparacion.getText()));
            modificarModifButton.setEnabled(false);
                textoModifPrecio.setEnabled(false);
                textoModifCalorias.setEnabled(false);
                textoModifPreparacion.setEnabled(false);
            textAModif.setText(visualizarPlatoModificado());
                limpiar();
            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textAEliminar.setText(BuscaPorNombre(textNombreEliminar.getText()));
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarButton.setEnabled(false);
                Plato p=menu.eliminarPlato(textNombreEliminar.getText());
                if (p!=null){
                    textAEliminar.setText("Plato eliminado correctamente");
                }
                limpiar();

            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            switch (comboBoxOrder.getSelectedIndex()){
                case 0: //Cuando seleccione Nombre
                    menu.ordenarPorNombre();
                    textAMostrar.setText(menu.toString());
                    break;
                case 1: //Cuando seleccione Precio
                     menu.ordenarPorPrecio();
                    textAMostrar.setText(menu.toString());
                     break;

                case 2: //Cuando seleccione Calorías
                    menu.ordenarPorCalorias();
                    textAMostrar.setText(menu.toString());
                    break;
                case 3: //Cuando seleccione Tiempo de Preparación
                    menu.ordenarPorTiempo();
                    textAMostrar.setText(menu.toString());
                    break;


            }

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
                String opcionSeleccionada = comboBoxOrder.getSelectedItem().toString();
                textAMostrar.setText(menu.buscarPlato(textBuscarPlatoOrden.getText(), opcionSeleccionada).toString());

            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
    private String BuscaPorNombre(String nombre){
        Plato platoEncontrado= menu.BuscarPorNombre(nombre);
        if (platoEncontrado!=null){
            textoModifPrecio.setText(String.valueOf(platoEncontrado.getPrecio()));
            textoModifCalorias.setText(String.valueOf(platoEncontrado.getCalorias()));
            textoModifPreparacion.setText(String.valueOf(platoEncontrado.getTiempo()));
            textoModifPrecio.setEnabled(true);
            textoModifCalorias.setEnabled(true);
            textoModifPreparacion.setEnabled(true);
            modificarModifButton.setEnabled(true);
            eliminarButton.setEnabled(true);
            textAModif.setText("Plato encontrado");
            return "\n"+ platoEncontrado;
        }else {

            textAModif.setText("Plato no encontrado");
            return "Plato no encontrado";
        }
    }
    public String visualizarPlatoModificado(){
        return "Nombre: " + textoModifNombre.getText().toString()+
                "\nPrecio: "+ textoModifPrecio.getText()+
                "\nCalorías: "+ textoModifCalorias.getText()+
                "\nTiempo de preparación: "+ textoModifPreparacion.getText();
    }
    private void limpiar(){
        textoModifNombre.setText(null);
        textoModifPrecio.setText(null);
        textoModifCalorias.setText(null);
        textoModifPreparacion.setText(null);
    }

}
