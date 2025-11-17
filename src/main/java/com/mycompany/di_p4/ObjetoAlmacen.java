package com.mycompany.di_p4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ObjetoAlmacen {
    
    private Integer puntuacion; 
    private String nombre;
    
    private static final String nombreArchivo = "puntuaciones.txt";

    public ObjetoAlmacen() {
    }
    /*
    private void borrarDatos() {
        this.puntuacion = null;
        this.nombre = null;
    }
    */
    
    public Integer getPuntuacion() {
        return puntuacion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean guardarPuntuacion() {
        
        File archivoPuntuaciones = new File(nombreArchivo);
        String spuntuacion = this.puntuacion.toString();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPuntuaciones, true))) {
            String linea = this.nombre + ": " + spuntuacion; 
            writer.write(linea);
            writer.newLine();
            
            //borrarDatos();
            
            return true;
            
        } catch (IOException e) {
            System.err.println("Error al guardar la puntuación: " + e.getMessage());
            e.printStackTrace();
            
            return false;
        }
    }
}
