package com.mycompany.di_p4;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.net.URL;

public class ImagenLocal { 

    // Aquí usamos getClass().getResource() que busca recursos relativos a la clase,
    // que es la forma más sencilla de cargar algo en el mismo paquete.
    public static ImageIcon cargarYRedimensionarIcono(String nombreArchivo, int anchoDeseado, int altoDeseado) {
        try {
            // **¡LA RUTA SIMPLIFICADA!** Busca el archivo en la misma carpeta que esta clase.
            java.net.URL urlImagen = ClassLoader.getSystemResource(nombreArchivo);

            if (urlImagen == null) {
                System.err.println("Error: Recurso no encontrado: " + nombreArchivo);
                return null;
            }
            
            // Usamos ImageIcon para cargar y gestionar la imagen
            ImageIcon iconoOriginal = new ImageIcon(urlImagen); 
            Image imagenOriginal = iconoOriginal.getImage();

            if (imagenOriginal != null) {
                // Redimensionar la imagen para el botón
                Image imagenRedimensionada = imagenOriginal.getScaledInstance(
                    anchoDeseado, 
                    altoDeseado, 
                    Image.SCALE_SMOOTH
                );
                return new ImageIcon(imagenRedimensionada);
            } else {
                return null;
            }

        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + nombreArchivo + " - " + e.getMessage());
            return null;
        }
    }
}