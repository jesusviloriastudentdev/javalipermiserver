/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jesusviloria.calpin.rmi.net;
import java.rmi.RemoteException;
import jesusviloria.calpin.rmi.lib.DatosCalPin;
import jesusviloria.calpin.rmi.lib.IRemotaCalPin;

/**
 *
 * @author jesusviloria
 */
public class CalculoRmiCalPinImplemen implements IRemotaCalPin {

    // Se declara la variable a nivel de clase tal como en el ejemplo
    private DatosCalPin datos;

    // Constructor vacío
    public CalculoRmiCalPinImplemen() throws RemoteException {
        super(); // En RMI suele ser necesario si heredas de UnicastRemoteObject, o dejarlo vacío si lo exportas de otra forma.
    }

    @Override
    public DatosCalPin calcularPintura(DatosCalPin datos) throws RemoteException {

        // Validación inicial emulando la estructura del profesor
        if (datos.getLargo() <= 0 || datos.getAncho() <= 0 || datos.getAltura() <= 0 || datos.getRendimiento() <= 0) {
            // Si las medidas son inválidas, devolvemos 0 en los resultados
            datos.setAreaTotal(0);
            datos.setLitrosRequeridos(0);
            // Si hubieras agregado un "String mensajeError" en DatosPintura, aquí harías el datos.setMensajeError("ERROR...");
            return datos;
        } else {
            // 1. Cálculo del área de las 4 paredes
            float area = (2 * datos.getLargo() * datos.getAltura()) + 
                         (2 * datos.getAncho() * datos.getAltura());
            
            // 2. Cálculo de los litros de pintura
            float litros = area / datos.getRendimiento();

            // 3. Se asignan los resultados al objeto que se va a retornar
            datos.setAreaTotal(area);
            datos.setLitrosRequeridos(litros);

            return datos; // Se retorna el objeto actualizado
        }
    }
}