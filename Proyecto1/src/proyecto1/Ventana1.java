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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import proyecto1.Ventana2;


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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cargarTxt.setText("Cargar Grafo");
        cargarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarTxtActionPerformed(evt);
            }
        });
        jPanel1.add(cargarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 150, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Algoritmo de optimización basado en el comportamiento de");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 510, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText(" colonias de hormigas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 200, 30));

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
            // Mostrar mensaje de que el grafo se creó correctamente
            JOptionPane.showMessageDialog(this, "Grafo creado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Ocultar Ventana1 y mostrar Ventana2
            this.setVisible(false);
            Ventana2 ventana2 = new Ventana2(grafo); // Crear una instancia de Ventana2
            ventana2.setVisible(true); // Mostrar Ventana2
            
            
            
            // System.out.println("Grafo creado:");
            // System.out.println(grafo.toString());
            Ventana2.jTextArea1.setText(grafo.toString());
            

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
    private javax.swing.JButton cargarTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
