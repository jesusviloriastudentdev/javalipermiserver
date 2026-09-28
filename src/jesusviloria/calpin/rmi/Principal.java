/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jesusviloria.calpin.rmi;

import java.rmi.RemoteException;
import jesusviloria.calpin.rmi.net.Servidor;

/**
 *
 * @author jesusviloria
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
        
        Servidor servicio = new Servidor();
        try{
           servicio.iniciar();
        }catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
        
        
    }
    
}
