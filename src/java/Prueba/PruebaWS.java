/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

/**
 *
 * @author guill
 */
public class PruebaWS {
    
    public static void main(String[] args) {
        
        
        System.out.println(buscarMedico("1000119-3"));
        
    }

    private static Boolean buscarMedico(java.lang.String vRut) {
        WS.Service1 service = new WS.Service1();
        WS.IService1 port = service.getBasicHttpBindingIService1();
        return port.buscarMedico(vRut);
    }
}
