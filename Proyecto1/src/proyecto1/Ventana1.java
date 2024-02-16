/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Daniel
 */
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ventana1 extends javax.swing.JFrame {

    /**
     * Creates new form Ventana1
     */
    Grafo grafo = new Grafo();

    public Ventana1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cargarTxt = new javax.swing.JButton();
        agregarCiudad = new javax.swing.JButton();
        agregarCamino = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cargarTxt.setText("Cargar Archivo");
        cargarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarTxtActionPerformed(evt);
            }
        });
        jPanel1.add(cargarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        agregarCiudad.setText("Agregar Ciudad");
        agregarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(agregarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        agregarCamino.setText("Agregar Camino");
        agregarCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCaminoActionPerformed(evt);
            }
        });
        jPanel1.add(agregarCamino, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 250, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarTxtActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));

        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                procesarArchivo(archivo);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_cargarTxtActionPerformed

    private void agregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCiudadActionPerformed
        // TODO add your handling code here:
        String ciudad = JOptionPane.showInputDialog("agregar ciudad:");
        grafo.nuevoNodo(ciudad);
        jTextArea1.append(grafo.toString());
    }//GEN-LAST:event_agregarCiudadActionPerformed

    private void agregarCaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCaminoActionPerformed
        // TODO add your handling code here:
        String origen = "";
        String destino = "";
        float distancia = 0.0f;
        float feromonas = 1.0f / grafo.contarVertices();
        origen = JOptionPane.showInputDialog("origen: ");
        destino = JOptionPane.showInputDialog("destino: ");
        distancia = Float.parseFloat(JOptionPane.showInputDialog("distancia :"));
        if (grafo.existeVertice(origen) && grafo.existeVertice(destino)) {
            grafo.NuevaArista(origen, destino, distancia, feromonas);

        }
        jTextArea1.setText(grafo.toString());
    }//GEN-LAST:event_agregarCaminoActionPerformed

    private void procesarArchivo(File archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine();
            String linea;
            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {

                if (linea.equals("aristas")) {
                    // Cuando se encuentre la línea "aristas", se cambia el modo de lectura para procesar las aristas
                    break; // Salir del bucle y comenzar a leer las aristas
                } else {
                    // Agregar nodos del grafo
                    grafo.nuevoNodo(linea.trim());
                }
            }

            // Calcular el valor de feromonas
            float feromonas = 1.0f / grafo.contarVertices();

            // Leer las aristas y agregarlas al grafo
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    Object origen = partes[0].trim();
                    Object destino = partes[1].trim();
                    float distancia = Float.parseFloat(partes[2].trim());
                    grafo.NuevaArista(origen, destino, distancia, feromonas);
                } else {
                    // Manejar líneas mal formateadas
                    JOptionPane.showMessageDialog(this, "Error de formato en las aristas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Una vez que se han leído y agregado todos los nodos y aristas al grafo, puedes hacer lo que necesites con él
            System.out.println("Grafo creado:");
            System.out.println(grafo.toString());
            jTextArea1.setText(grafo.toString());

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCamino;
    private javax.swing.JButton agregarCiudad;
    private javax.swing.JButton cargarTxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
