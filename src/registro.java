import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class registro {
    private JPanel registro;
    private JTextField marca;
    private JLabel vehiLabel;
    private JLabel nombre;
    private JLabel codigo;
    private JTextField velocidad;
    private JLabel cedula;
    private JTextField anio;
    private JButton regBt;
    private JButton atrBt;
    private JButton sigBt;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JLabel color;
    private JLabel fecha;
    private JLabel signo;
    private JLabel apellido;
    private JButton cargarDatosDesdeElButton;
    private JCheckBox rojoCheckBox;
    private JCheckBox verdeCheckBox;
    private JCheckBox ningunoCheckBox;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JPanel a;

    private ArrayList<Datos> listaDatos;
    private int ind;

    public registro() {
        listaDatos = new ArrayList<>();
        regBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreIngreso = nombre.getText();
                double codigoIngreso = Double.parseDouble(codigo.getText());
                int cedulaIngreso = Integer.parseInt(cedula.getText());
                String apellidoIngreso = apellido.getText();

                Datos ingreso = new Datos(nombreIngreso,codigoIngreso,cedulaIngreso, apellidoIngreso);
                listaDatos.add(ingreso);

                for(int i = 0; i < listaDatos.size(); i++){
                    String filePath = i + "binarydata.dat";
                    try(
                            FileOutputStream fileOut = new FileOutputStream(filePath);
                            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
                    ){
                        objOut.writeObject(ingreso);
                        System.out.println("Archivo guardado correctamente");
                    }
                    catch (IOException ex){
                        throw new RuntimeException(ex);
                    }

                }

                nombre.setText("");
                codigo.setText("");
                cedula.setText("");
                apellido.setText("");

            }
        });
        sigBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ind < listaDatos.size()-1){
                    ind++;
                    Datos datos = listaDatos.get(ind);
                    marca.setText(datos.getNombre());
                    codigo.setText(String.valueOf(datos.getCodigo()));
                    cedula.setText(String.valueOf(datos.getCedula()));
                    apellido.setText(datos.getApellido());
                }
            }
        });
        atrBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ind--;
                if(ind > 0){
                    Datos datos = listaDatos.get(ind);
                    marca.setText(datos.getNombre());
                    codigo.setText(String.valueOf(datos.getCodigo()));
                    cedula.setText(String.valueOf(datos.getCedula()));
                    apellido.setText(datos.getApellido());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro Vehículos");
        frame.setContentPane(new registro().registro);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
