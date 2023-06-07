import java.util.HashMap;

import javax.swing.JOptionPane;

public class Proceso {
    HashMap<Integer, Mascota> mapMascotas = new HashMap<Integer, Mascota>();
    Mascota mascotas = null;

    public void iniciar(Proceso proceso) {
        String menu = "Informacion del sistema\n";
        menu += "1. Ingresar mascota\n";
        menu += "2. Imprimir HashMap\n";
        menu += "3. Consultar mascota individual\n";
        menu += "4. Salir\n";
        menu += "Ingrese una opción:\n";
        int opc = 0;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
            validarDatos(opc);
        } while (opc != 4);
    }

    public void validarDatos(int opc) {
        switch (opc) {
            case 1:
                guardarDatos();
                break;

            case 2:
                if (!mapMascotas.isEmpty()) {
                    imprimirHashMap();
                } else {
                    System.out.println("No hay mascotas registradas");
                }
                break;
            case 3:
                if (!mapMascotas.isEmpty()) {
                    consultarMascota();
                } else {
                    System.out.println("No hay mascotas registradas");
                }
                break;
            case 4:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }

    public void guardarDatos() {
        String resp = "";
        do {
            mascotas = new Mascota();
            mascotas.ingresar();
            mascotas.hacerSonido();
            mascotas.comer();
            mascotas.jugar();
            mapMascotas.put(mascotas.codigo, mascotas);
            mascotas.mostrarInformacion();
            resp = JOptionPane.showInputDialog("Ingrese SI si desea continuar");
        } while (resp.equalsIgnoreCase("SI"));
    }


    public void imprimirHashMap() {
        System.out.println("Contenido del HashMap:");
        for (Mascota mascota : mapMascotas.values()) {
            mascota.mostrarInformacion();
        }
    }

    public void consultarMascota() {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese código de la mascota a buscar"));
            Mascota mascota = mapMascotas.get(codigo);
            if (mascota != null) {
                System.out.println("Información de la mascota con código " + codigo + ":");
                mascota.mostrarInformacion();
            } else {
                System.out.println("No se encontró una mascota con el código especificado.");
            }
    }

    public HashMap<Integer, Mascota> getSizeMap() {
        return mapMascotas;
    }
}
