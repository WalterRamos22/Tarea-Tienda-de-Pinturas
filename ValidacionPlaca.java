/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.validacionplaca;

import java.util.*;

/**
 *
 * @author walte
 */
public class ValidacionPlaca {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); 
        
        //Pedir cantidad de placas a validar
        System.out.print("Cuantas placas deseas validar: ");
        int cantidadPlacas = entrada.nextInt();
        entrada.nextLine();//Limpiar búfer
        System.out.println();//Espacio
        
        //Inicializar la variable de placas ingresadas
        int placasIngresadas = 0;
        
        //Proceso de ingreso de placas para validar
        while(placasIngresadas < cantidadPlacas){
            
            //Ingreso de placas
            System.out.print("Ingresa la placa " + (placasIngresadas + 1) + " a validar: ");
            String placa = entrada.nextLine();
            placa = placa.toUpperCase();//Convertir a Mayúsculas
            
            //Si es placa valida
            if(validarPlaca(placa)){
                System.out.println("La placa " + placa + " es valida");
                placasIngresadas++;//Aumentar al contador
                System.out.println("----------------------------------------------");
            //Si es placa NO valida
            }else{
                System.out.println("La placa " + placa + " No es valida, ingresa otra placa.");
                System.out.println("----------------------------------------------");
            }
        }
        entrada.close();//Cierre de Scanner entrada     
    }
    
    //Función para validar placa
    private static boolean validarPlaca(String placa){
        //Validar que placa no este vacio o longitud 0
        if (placa == null || placa.length() == 0){
            return false;//Valor falso
        }
        
        //Validar longitud de placa
        int longitud = placa.length();
        if (longitud < 7 || longitud > 9){
            return false;//Valor falso
        }
        
        //Validar prefijo de placa
        String prefijo = placa.substring(0, longitud - 6);
        if(!prefijoValido(prefijo)){
            return false;//Valor falso
        }
        
        //Validar números de placa
        for(int i = longitud - 6; i < longitud - 3; i++){
            if(!numeroValido(placa.charAt(i))){
                return false;//Valor falso
            }
        }
        
        //Validar letras consonantes de placa
        for(int i = longitud - 3; i < longitud; i++){
            if(!consonanteValida(placa.charAt(i))){
                return false;//Valor falso
            }
        }
        
        return true;//Valor verdadero
    }
    
    //Función para validar el prefijo
    private static boolean prefijoValido(String prefijo){
    String[] prefijosValidos = {"P", "A", "C", "U", "TRC", "M", "TC", "O", "CD", "CC", "MI"};
        for (int i = 0; i < prefijosValidos.length; i++){
            if (prefijo.equals(prefijosValidos[i])){
                return true;//Valor verdadero
            }
        }
    return false;//Valor falso
    }
    
    //Función para validar número de 0 a 9
    private static boolean numeroValido(char numero){
        return numero >= '0' && numero <= '9';
    }
    
    //función para validar letras consonantes
    private static boolean consonanteValida(char letra) {
    char[] consonantes = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < consonantes.length; i++) {
            if (letra == consonantes[i]) {
                return true;//Valor verdadero
            }
        }
        return false;//Valor falso
    }
}
    
      
    

