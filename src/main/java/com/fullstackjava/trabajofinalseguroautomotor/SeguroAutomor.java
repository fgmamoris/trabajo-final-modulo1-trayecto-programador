/*
 * CFP ASEGURA TU AUTO
 * Se necesita un programa que permita la emisión de una póliza de 
 * seguro para un vehículo. Con las siguientes características:
 * 1) En la primera parte debe mostrar una JOption con el logo de la compañía
 * 2) Solicitar datos del cliente:
 * a. Nombre y Apellido
 * b. Teléfono
 * c. EMAIL
 * En este caso podemos utilizar variables para cada uno de los puntos 
 * y solicitarlo por JOPTION

 * 3) Datos del vehículo
 * a. Marca, utilizar un JOption combobox a un vector
 * b. Modelo , JOPtion input
 * c. Dominio, JOPtion input
 * d. Años de antigüedad, JOPtion input
 * Luego que se solicita la antigüedad del automóvil se debe realizar el 
 * calculo para calcular la cuota. Este calculo se realiza de la siguiente manera:
 * Si el vehículo es menor igual a 5 años pagara u extra de 500
 * Si el vehículo es mayor a 5 años pero menor a 10 paga un extra de 1000
 * Si el vehículo tiene una edad mayor igual a 10 pero menor a 15 paga 1500
 * Si el vehículo tiene mas de 15 años y menor 20 paga 2000
 * Si el vehículo es mayor a 20 años no se asegura (mostrar cartel antes de seguir avanzando)

 * 4) Tipo de Cobertura
 * Utilizar un Joption combo con las opciones Terceros Completos, Todo Riesgo y Responsabilidad Civil

 * Los valores de cada cobertura son:
 * RC :1000
 * TC:2000
 * TR: 3000

 * 5) Adicionales de la cobertura
 * Utilizar un Joption combo con las opciones:
 * a. Granizo
 * b. Llantas deportivas
 * c. Asistencia Mecánica
 * d. Localizador GPS

 * Puede seleccionar mas de un adicional. Por cada dos que selecciona se cobra 
 * uno el valor de cada adicional es 300

 * Cálculos del seguro: El cálculo de lo que el cliente va a abonar se calcula con:
 * Valor de la cuota = Tipo de cobertura (valor) + Adicionales (valor)+ antigüedad del vehículo

 * 6) Impresión de póliza (opcional función)
 * Mostrar en un joption o en consola como lo prefieran, los datos que deben mostrarse son:
 * a. Datos del Usuario (datos cargados)
 * b. Datos del Vehículo (datos cargados)
 * c. Tipo de cobertura (detalle seleccionado)
 * d. Adicionales de la cobertura (detalles seleccionado)
 * e. Valor de la prima total
 * 
 */
package com.fullstackjava.trabajofinalseguroautomotor;

import com.fullstackjava.trabajofinalseguroautomotor.model.Cliente;
import com.fullstackjava.trabajofinalseguroautomotor.model.Vehiculo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Federico Mamoris
 */
public class SeguroAutomor {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        ImageIcon logo = new ImageIcon("images/logo.jpg");
        String tipoDeCobertura = "";

        //Modulo 1 - Logo Compañia
        JOptionPane.showMessageDialog(
                null, "Aseguramos tu auto con la mejor cobertura\n y el mejor precio del mercado", "CFP ASEGURA TU AUTO", JOptionPane.INFORMATION_MESSAGE, logo);
        //Modulo 2 - Crear nuevo Cliente
        Cliente cliente = crearCliente();

        //Modulo 3 - Datos del vehiculo
        Vehiculo auto = crearVehiculo();

        //Modulo 4 - Tipo de Cobertura
        auto.setTipoCobertura(seleccionarTipoDeCobertura());

        //Modulo 5 - Adicionales;
        auto.setAdicionales(seleccionarAdicionales());

        //Modulo 6 - Impresión de póliza 
        imprimirPoliza(cliente, auto);
    }

    private static Cliente crearCliente() {
        String nombre = "", apellido = "", telefono = "", email = "";
        boolean operacion = true;

        //Modulo 2 - Datos Cliente
        do {
            nombre = JOptionPane.showInputDialog(null, "Por favor ingrese su nombre:", "Bienvenido", -1);
            if (nombre == null || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Debe ingresar al menos un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                operacion = false;
            }
        } while (operacion);
        operacion = true;

        do {
            apellido = JOptionPane.showInputDialog(null, "Por favor ingrese su apellido:", "Apellido", -1);
            if (apellido == null || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Debe ingresar al menos un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                operacion = false;
            }
        } while (operacion);
        operacion = true;
        do {
            telefono = JOptionPane.showInputDialog(null, "Por favor ingrese su telefono:", "Telefono", -1);
            if (telefono == null || telefono.isEmpty() || !checkIsNumber(telefono) || telefono.length() < 8 || telefono.length() > 12) {
                JOptionPane.showMessageDialog(
                        null, "El número de teléfono ingresado tiene un formato no válido\n El mismo debe ser solo númerico, entre 8 y 12 números", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                operacion = false;
            }
        } while (operacion);
        operacion = true;

        do {
            email = JOptionPane.showInputDialog(null, "Por favor ingrese su email:", "Correo Electronico", -1);
            if (email == null || email.isEmpty() || !validate(email)) {
                JOptionPane.showMessageDialog(
                        null, "Debe ingresar un mail válido", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                operacion = false;
            }
        } while (operacion);

        System.out.println(
                "nombre:" + nombre + "\nApellido:" + apellido + "\nTelefono" + telefono + "\nEmail" + email);
        return new Cliente(nombre, apellido, telefono, email);
    }

    private static boolean checkIsNumber(String amount) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (amount == null) {
            return false;
        }
        return pattern.matcher(amount).matches();
    }

    private static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private static Vehiculo crearVehiculo() {
        String marcasAutos[] = {
            "Chevrolet", "Citroen", "Dacia", "Fiat", "Ford", "Honda",
            "Kia", "Opel", "Peugeot", "Renault", "Seat", "Volkswagen", "Otro"};
        String marca = "", modeloAuto = "", dominioAuto = "";
        int antiguedad = 0;
        boolean operacion = true;
        Object optional;
        do {
            optional = JOptionPane.showInputDialog(null, "Seleccione una marca vehiculo", "Marcas", JOptionPane.QUESTION_MESSAGE, null, marcasAutos, marcasAutos[0]);
            if (optional == null) {
                JOptionPane.showMessageDialog(
                        null, "Debe seleccionar una marca de vehículo", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                marca = optional.toString();
            }
        } while (optional == null);
        operacion = true;
        do {
            modeloAuto = JOptionPane.showInputDialog(null, "Por favor el modelo de auto:", "Modelo", -1);
            if (modeloAuto == null || modeloAuto.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Debe ingresar un modelo válido", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                operacion = false;
            }
        } while (operacion);
        operacion = true;
        String optionalString = "";
        do {
            optionalString = JOptionPane.showInputDialog(null, "Por favor el año de fabricación:", "Año de fabricación", -1);
            if (optionalString == null || optionalString.isEmpty() || !checkIsNumber(optionalString)) {
                JOptionPane.showMessageDialog(
                        null, "Debe ingresar un año válido", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (Integer.parseInt(optionalString) < 1915 || Integer.parseInt(optionalString) > Calendar.getInstance().get(Calendar.YEAR)) {
                JOptionPane.showMessageDialog(
                        null, "Fecha erronea, debe ingresar una fecha mayor a 1915 y menor al año en curso", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                operacion = false;
                if (Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(optionalString) > 20) {
                    JOptionPane.showMessageDialog(
                            null, "Lamentablemete la compañia no puede asegurar \nautos con mas de 20 años de antiguedad", "Error", JOptionPane.ERROR_MESSAGE);
                    antiguedad = 21;
                } else {
                    antiguedad = Integer.parseInt(optionalString);
                }
            }
        } while (operacion);
        operacion = true;
        do {
            dominioAuto = JOptionPane.showInputDialog(null, "Por favor el dominio de su auto:", "Patente", -1);
            if (dominioAuto == null || dominioAuto.isEmpty() || !checkDominio(dominioAuto)) {
                JOptionPane.showMessageDialog(
                        null, "Debe ingresar un modelo válido", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                operacion = false;
            }
        } while (operacion);
        return new Vehiculo(marca, modeloAuto, dominioAuto, antiguedad, "", new ArrayList<String>());
    }

    private static boolean checkDominio(String dominio) {
        if (dominio.length() == 6) {
            Pattern pattern = Pattern.compile("[a-z]{3}[\\d]{3}");
            return pattern.matcher(dominio).matches();
        } else if (dominio.length() == 7) {
            Pattern pattern = Pattern.compile("[a-z]{2}[\\d]{3}[a-z]{2}");
            return pattern.matcher(dominio).matches();
        } else {
            return false;
        }
    }

    private static String seleccionarTipoDeCobertura() {
        String tipoDeCobertura[] = {
            "Resposabilidad Civil",
            "Tercero Completo", "Todo Riesgo"};
        Object cobertura;
        do {
            cobertura = JOptionPane.showInputDialog(null, "Seleccione un tipo de cobertura para su vehículo", "Tipos de cobertura", JOptionPane.QUESTION_MESSAGE, null, tipoDeCobertura, tipoDeCobertura[0]);
            if (cobertura == null) {
                JOptionPane.showMessageDialog(
                        null, "Debe seleccionar un tipo de cobertura para su vehículo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (cobertura == null);
        return cobertura.toString();
    }

    private static ArrayList<String> seleccionarAdicionales() {
        ArrayList<String> adicionales = new ArrayList<>();
        String listaDeAdicionales[] = {
            "Granizo", "Llantas Deportivas", "Asistencia Mecanica", "Localizador Gps"};
        int accion = 0;
        boolean operacion = true;
        Object optional;
        do {
            accion = JOptionPane.showOptionDialog(null, "¿Desea agregar adicionales a su seguro?"
                    + "\nPromoción, por cada dos adicionales se le cobrará uno solo."
                    + "\n El valor por cada adicional es de $300", "CFP ASEGURA TU AUTO",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI", "NO"}, "SI");
            if (accion == 1 || accion == -1) {
                if (adicionales.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se agregaron servicios adicionales", "CFP ASEGURA TU AUTO", JOptionPane.INFORMATION_MESSAGE);
                }
                operacion = false;
            } else {
                do {
                    optional = JOptionPane.showInputDialog(null, "Seleccione un adicional de la lista", "CFP ASEGURA TU AUTO", JOptionPane.INFORMATION_MESSAGE, null, listaDeAdicionales, listaDeAdicionales[0]);
                    if (optional == null) {
                        accion = JOptionPane.showOptionDialog(null, "¿Desea cancelar la operacion de agregar adicionales?",
                                "CFP ASEGURA TU AUTO",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI", "NO"}, "SI");
                        if (accion == 0 || accion == -1) {
                            return adicionales;
                        }
                    } else {
                        if (!adicionales.contains(optional.toString())) {
                            adicionales.add(optional.toString());
                            JOptionPane.showMessageDialog(null, "Se agrego el adicional: " + optional.toString(), "CFP ASEGURA TU AUTO", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            accion = JOptionPane.showOptionDialog(null, "El adicional: " + optional.toString() + " ya se encuentra adicionado\n ¿Desea quitar el adicional de la lista?",
                                    "CFP ASEGURA TU AUTO",
                                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI", "NO"}, "SI");
                            if (accion == 0) {
                                adicionales.remove(optional.toString());
                                JOptionPane.showMessageDialog(null, "Se quitó el adicional: " + optional.toString(), "CFP ASEGURA TU AUTO", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                } while (optional == null);
            }
        } while (operacion);
        return adicionales;
    }

    private static void imprimirPoliza(Cliente clienteNuevo, Vehiculo vehiculoNuevo) {
        JOptionPane.showMessageDialog(null, "Poliza n° " + (int) (Math.random() * 3216546 + 1)
                + "\n--Datos titular del seguro--"
                + "\nNombre: " + clienteNuevo.getNombre()
                + "\nApellido: " + clienteNuevo.getApellido()
                + "\nTelefono: " + clienteNuevo.getTelefono()
                + "\nEmail: " + clienteNuevo.getEmail()
                + "\n--Datos del vehiculo asegurado--"
                + "\nMarca: " + vehiculoNuevo.getMarca()
                + "\nDominio: " + vehiculoNuevo.getDominio()
                + "\nModelo: " + vehiculoNuevo.getModelo()
                + "\nAño: " + vehiculoNuevo.getAnio()
                + "\nTipo de Cobertura: " + vehiculoNuevo.getTipoCobertura()
                + "\nAdicionales: " + (vehiculoNuevo.getAdicionales().isEmpty() ? "Sin adicionales" : vehiculoNuevo.getAdicionales().toString())
                + "\nImporte: " + calcularImporte(vehiculoNuevo),
                "CFP ASEGURA TU AUTO - COMPROBANTE DE POLIZA", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String calcularImporte(Vehiculo vehiculoNuevo) {
        int total = 0;
        int antiguedad = Calendar.getInstance().get(Calendar.YEAR) - vehiculoNuevo.getAnio();
        if (antiguedad > 20) {
            return "No es posible asegurar el auto";
        }
        switch (vehiculoNuevo.getTipoCobertura()) {
            case "Resposabilidad Civil" -> {
                total += 1000;
            }
            case "Tercero Completo" -> {
                total += 2000;
            }
            case "Todo Riesgo" -> {
                total += 3000;
            }
        }
        if (antiguedad <= 5) {
            total += 500;
        } else if (antiguedad <= 10) {
            total += 1000;
        } else if (antiguedad <= 15) {
            total += 1500;
        } else if (antiguedad <= 20) {
            total += 1500;
        }
        switch (vehiculoNuevo.getAdicionales().size()) {
            case 1,2 -> {
                total += 300;
            }
            case 3,4 -> {
                total += 600;
            }
        }
        return "$ " + String.valueOf(total);
    }
}
