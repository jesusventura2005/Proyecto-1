/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;





/**
 * Clase que representa la interfaz de usuario para interactuar con un grafo.
 * Permite al usuario agregar ciudades, agregar caminos entre ciudades, eliminar ciudades,
 * iniciar la simulación del algoritmo de optimización basado en colonias de hormigas,
 * y guardar el grafo en un archivo de texto.
 * Esta clase es utilizada como parte de la interfaz gráfica de la aplicación.
 * @author Daniel Fariña
 * @version 18/02/2024
 */
public class Ventana2 extends javax.swing.JFrame {

    private Grafo grafo;
    private ListaSimple ciudadesEliminadas = new ListaSimple();
    public static ListaSimple iteraciones = new ListaSimple();
    public static ListaSimple caminosMasOptimos = new ListaSimple();
    public static ListaSimple grafosIteraciones = new ListaSimple();
    
    
    

    /**
     * Constructor de la clase Ventana2.
     * Crea una nueva instancia de Ventana2 para interactuar con el grafo proporcionado.
     * @param grafo El grafo con el que se interactuará en la ventana.
     */
    public Ventana2(Grafo grafo) {
        initComponents();
        this.grafo = grafo;
        this.setLocationRelativeTo(null);
    }

    private Ventana2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        agregarCiudad = new javax.swing.JButton();
        agregarCamino = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        eliminarCiudad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        iniciarSimulacion = new javax.swing.JButton();
        guardarGrafo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarCiudad.setText("Agregar Ciudad");
        agregarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(agregarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 130, 30));

        agregarCamino.setText("Agregar Camino");
        agregarCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCaminoActionPerformed(evt);
            }
        });
        jPanel1.add(agregarCamino, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 130, 30));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 250, 310));

        eliminarCiudad.setText("Eliminar Ciudad");
        eliminarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 130, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Algoritmo de optimización basado en el comportamiento de");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 510, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText(" colonias de hormigas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 200, 30));

        iniciarSimulacion.setText("Iniciar Simulación");
        iniciarSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSimulacionActionPerformed(evt);
            }
        });
        jPanel1.add(iniciarSimulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 170, 40));

        guardarGrafo.setText("Guardar Grafo");
        guardarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarGrafoActionPerformed(evt);
            }
        });
        jPanel1.add(guardarGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 630, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Botón que permite al usuario agregar una nueva ciudad al grafo.
    * Al hacer clic en este botón, se solicita al usuario el nombre de la ciudad a agregar,
    * la cual se añade al grafo si no existe previamente.
    * @param evt Evento de acción que desencadena el método (clic en el botón "Agregar Ciudad").
    */
    private void agregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCiudadActionPerformed
        // TODO add your handling code here:
        // Solicitar al usuario el nombre de la ciudad a agregar
        String ciudad = JOptionPane.showInputDialog("Agregar ciudad:");
        if (ciudad == null) {
            return; // Terminar la acción si se seleccionó cancelar
        }
        // Verificar si la ciudad ya existe en el grafo
        if (grafo.existeVertice(ciudad)) {
            JOptionPane.showMessageDialog(this, "La ciudad ya existe en el grafo.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si la ciudad ya existe
        }
        Nodo current = ciudadesEliminadas.getpFirst();
        while (current != null) {
            if (current.getInfo().equals(ciudad)) {
                ciudadesEliminadas.RemoveElement(current.getInfo()); // Eliminar la ciudad de la lista de eliminadas
                break;
            }
            current = current.getpNext();
        }
        grafo.nuevoNodo(ciudad);
        JOptionPane.showMessageDialog(this, "Ciudad agregada", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Actualizar el área de texto con la representación actual del grafo
        jTextArea1.setText(grafo.toString());
    }//GEN-LAST:event_agregarCiudadActionPerformed

    /**
    * Botón que permite al usuario agregar un nuevo camino entre dos ciudades en el grafo.
    * Al hacer clic en este botón, se solicitan al usuario el origen, destino y distancia del camino,
    * el cual se añade al grafo si las ciudades existen y la distancia es un valor numérico válido.
    * @param evt Evento de acción que desencadena el método (clic en el botón "Agregar Camino").
    */
    private void agregarCaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCaminoActionPerformed
        // TODO add your handling code here:
        // Solicitar al usuario los datos del camino
        String origen = JOptionPane.showInputDialog("Origen:");
        if (origen == null) {
            return; // Terminar la acción si se seleccionó cancelar
        }
        String destino = JOptionPane.showInputDialog("Destino:");
        if (destino == null) {
            return; // Terminar la acción si se seleccionó cancelar
        }
        if (origen.equals(destino)) {
            JOptionPane.showMessageDialog(this, "El origen no puede ser el mismo que el destino.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String distanciaStr = JOptionPane.showInputDialog("Distancia:");
        
        if (distanciaStr == null) {
            return; // Terminar la acción si se seleccionó cancelar
        }
        // Verificar si la distancia es un valor numérico
        float distancia;
        try {
            distancia = Float.parseFloat(distanciaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La distancia debe ser un valor numérico.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si la distancia no es válida
        }
        if (Float.parseFloat(distanciaStr) <= 0) {
            JOptionPane.showMessageDialog(this, "La distancia debe ser mayor que 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar si el origen y destino existen en el grafo
        if (!grafo.existeVertice(origen) || !grafo.existeVertice(destino)) {
            JOptionPane.showMessageDialog(this, "El origen o destino no existe en el grafo.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si el origen o destino no existen
        }

        // Calcular el valor de feromonas
        float feromonas = 1.0f / grafo.contarVertices();

        // Agregar el camino al grafo
        grafo.NuevaArista(origen, destino, distancia, feromonas);
        JOptionPane.showMessageDialog(this, "Arista agregada", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Actualizar el área de texto con la representación actual del grafo
        jTextArea1.setText(grafo.toString());
    }//GEN-LAST:event_agregarCaminoActionPerformed

    /**
    * Botón que permite al usuario eliminar una ciudad del grafo.
    * Al hacer clic en este botón, se solicita al usuario el nombre de la ciudad a eliminar,
    * la cual se elimina del grafo junto con todos los caminos que la involucran, si existe.
    * @param evt Evento de acción que desencadena el método (clic en el botón "Eliminar Ciudad").
    */
    private void eliminarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCiudadActionPerformed
        // TODO add your handling code here:
        // Solicitar al usuario el nombre de la ciudad a eliminar
        String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad a eliminar:");

        // Verificar si la ciudad existe en el grafo
        if (grafo.existeVertice(ciudad)) {
            // Eliminar la ciudad del grafo
            grafo.eliminarNodo(ciudad);
            ciudadesEliminadas.InsertAtTheEnd(ciudad);

            // Eliminar todas las aristas que tienen a esta ciudad como origen o destino
            grafo.eliminarAristasPorCiudad(ciudad);
            JOptionPane.showMessageDialog(this, "Ciudad eliminada junto con sus caminos", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Actualizar el área de texto con la representación actual del grafo
            jTextArea1.setText(grafo.toString());
        } else {
            JOptionPane.showMessageDialog(this, "La ciudad no existe en el grafo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarCiudadActionPerformed

    /**
    * Botón que inicia la simulación del algoritmo de optimización basado en colonias de hormigas.
    * Al hacer clic en este botón, se solicitan al usuario los parámetros necesarios para la simulación,
    * como los valores de Alpha, Beta, Rho y la cantidad de hormigas.
    * @param evt Evento de acción que desencadena el método (clic en el botón "Iniciar Simulación").
    */
    private void iniciarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSimulacionActionPerformed
        // TODO add your handling code here:S
        
        float cantidadFeromonas = 1.0f / (float) grafo.contarVertices();
        NodoGrafo temporal = grafo.getPrimero();
        while (temporal != null) {
            ListaAdyacencia lista = temporal.getLista();
            Arco arco = lista.getPrimero();
            while (arco != null) {
                arco.setFeromonas(cantidadFeromonas);
                arco = arco.getSiguiente();
            }
            temporal = temporal.getSiguiente();
        }
        
        try {
            // Obtener los valores de alpha, beta, rho y factorHormiga
            float alpha = Float.parseFloat(JOptionPane.showInputDialog("Ingrese un valor para Alpha:"));
            while (alpha < 0) {  
                alpha = Float.parseFloat(JOptionPane.showInputDialog("Por favor, ingrese un valor valido para Alpha (α ≥ 0):"));
            }
            float beta = Float.parseFloat(JOptionPane.showInputDialog("Ingrese un valor para Beta:"));
            while (beta < 1) {
                beta = Float.parseFloat(JOptionPane.showInputDialog("Por favor, ingrese un valor válido para Beta (β ≥ 1):"));
            }
            float rho = Float.parseFloat(JOptionPane.showInputDialog("Ingrese un valor para Rho:"));
            while (rho < 0 || rho >= 1) {
                rho = Float.parseFloat(JOptionPane.showInputDialog("Por favor, ingrese un valor válido para Rho (ρ ⊆ [0,1)):"));
            }
            int factorHormiga = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Hormigas que estarán en la simulación:"));
            while (factorHormiga < 1) {
                factorHormiga = Integer.parseInt(JOptionPane.showInputDialog("Por favor, ingrese una cantidad de Hormigas mayor que 0:"));
            }
            JOptionPane.showMessageDialog(this, "La ciudad inicial es: " + grafo.getPrimero().getDato() + " y la ciudad final es: " + grafo.getUltimo().getDato());
            // Crear una instancia de Colonia con los valores obtenidos
            Colonia colonia = new Colonia(factorHormiga, grafo, rho);
            
            // Inicializar las hormigas con los valores de alpha y beta
            colonia.inicializarHormigas(alpha, beta);

            // Variables para controlar la convergencia
            float mejorLongitud = Float.MAX_VALUE;
            int iteracionesSinMejora = 0;
            final int maxIteracionesSinMejora = 10; // Número máximo de iteraciones sin mejora antes de considerar que ha convergido
            this.setVisible(false);
            
            // Ejecutar la simulación hasta que converja
            while (iteracionesSinMejora < maxIteracionesSinMejora) {
                // Ejecutar una iteración de búsqueda de caminos
                colonia.ejecutarBusquedaCaminos();
                
                this.grafo = colonia.getGrafo();
                Grafo grafoClonado = grafo.clone();
                grafosIteraciones.InsertAtTheEnd(grafoClonado);
                // Obtener la longitud del camino más corto
                float longitudActual = colonia.obtenerLongitudCaminoMasCorto();
                if (longitudActual < mejorLongitud) {
                    mejorLongitud = longitudActual;
                    iteracionesSinMejora = 0; // Reiniciar el contador de iteraciones sin mejora
                } else {
                    iteracionesSinMejora++; // Incrementar el contador de iteraciones sin mejora
                }

                iteraciones.InsertAtTheEnd(colonia.getHormigas().ImprimirListadeHormigas());
                caminosMasOptimos.InsertAtTheEnd(colonia.obtenerCaminoMasCorto());
            }
            ListaSimple caminoMasOptimo = colonia.obtenerCaminoMasCorto();
            Ventana3 ventana3 = new Ventana3(factorHormiga, grafo, caminoMasOptimo);
            ventana3.setVisible(true);
            Ventana3.mostrarGrafo.setVisible(false);


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los valores deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
         
    }//GEN-LAST:event_iniciarSimulacionActionPerformed


    /**
    * Botón que permite al usuario guardar el grafo actual en un archivo de texto.
    * Al hacer clic en este botón, se abre un cuadro de diálogo para seleccionar la ubicación
    * y el nombre del archivo donde se guardará el grafo en formato de texto.
    * @param evt Evento de acción que desencadena el método (clic en el botón "Guardar Grafo").
    */
    private void guardarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarGrafoActionPerformed
        // TODO add your handling code here:
        JFileChooser selectorArchivo = new JFileChooser();
        selectorArchivo.setCurrentDirectory(new File("."));

        int s = selectorArchivo.showSaveDialog(null);
        if (s == JFileChooser.CANCEL_OPTION) {
            return;
        }

        File archivo = selectorArchivo.getSelectedFile();

        try {
            PrintStream salida = new PrintStream(archivo);
            salida.print(jTextArea1.getText());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_guardarGrafoActionPerformed

    
    
    
    /**
    * Método principal que crea una instancia de la clase Ventana2 y la hace visible.
    * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
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
            java.util.logging.Logger.getLogger(Ventana2.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCamino;
    private javax.swing.JButton agregarCiudad;
    private javax.swing.JButton eliminarCiudad;
    private javax.swing.JButton guardarGrafo;
    private javax.swing.JButton iniciarSimulacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
