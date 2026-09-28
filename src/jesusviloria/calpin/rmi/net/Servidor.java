/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jesusviloria.calpin.rmi.net;

/**
 *
 * @author jesusviloria
 */

import java.io.IOException;
import java.rmi.RemoteException;
import jesusviloria.calpin.rmi.lib.IRemotaCalPin;

// import tu.paquete.rmi.lib.IRemotaCalPin; // Importa tu interfaz

import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;

public class Servidor {

    // Se mantiene el mismo puerto que usa el profesor[cite: 6]
    private int puerto = 9007; 
    
    // Objetos de la librería LipeRMI
    private CallHandler invocador;
    private Server servidor;
    
    // Cambiamos las clases del IMC por las de tu cálculo de pintura
    private CalculoRmiCalPinImplemen calculoPintura;
    private IRemotaCalPin calculoPinturaRemoto;

    public Servidor() throws RemoteException {
        invocador = new CallHandler(); 
        servidor = new Server();
        
        // Se instancia tu implementación en lugar de la del IMC
        calculoPintura = new CalculoRmiCalPinImplemen(); 
    }

    public void iniciar() throws Exception { 
        try {
            // Se registra globalmente tu interfaz junto con la implementación instanciada
            invocador.registerGlobal(IRemotaCalPin.class, calculoPintura); 
            
            // Se pone a escuchar al servidor en el puerto 9007
            servidor.bind(puerto, invocador); 
            
        } catch (LipeRMIException ex) { 
            throw new Exception("Error: No es posible invocar metodos remotos"); 
        } catch (IOException ex) { 
            throw new Exception("Error: I/O"); 
        }
    }

    public void detener() { 
        servidor.close(); 
    }
}