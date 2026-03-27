package matricesdispersas;

import javax.swing.JOptionPane;
import java.util.Random;
/**
 *
 * @author Mariana Castro, Miguel Gallo y Gepetto
 */
public class MatricesDispersas {

    public static void main(String[] args) {
      
     //int Mat[][]= { {8,0,5,0,3,0},{0,-11,0,0,-2,0},{1,0,0,6,0,19}}; //3x6
     
   
     
     
     int Mat2 [][]= { {1,3}, {4,6},{1,1},{7,3},{2,2},{5,6}}; //6x2
     int N2=contarDatos(Mat2);
     Tripleta T2= new Tripleta(N2);
     T2.llenarTripleta(Mat2,N2);
     //T2.multiplicarTripletas(T1);
    
    //MENU
    Tripleta T1 =null; 
     int opc = 0;
     


        do {
            
            opc = Integer.parseInt(JOptionPane.showInputDialog(" Menu Principal\n"
                + "1. Crear Tripleta\n"
                + "2. Mostrar Forma\n"
                + "3. Suma de filas\n"
                + "4. Suma de columnas\n"
                + "5. Insertar Dato \n"
                + "6. Eliminar Dato\n"
                + "7. Eliminar Dato por Posicion\n"
                + "8. Sumar\n"
                + "9. Multiplicar\n"
                + "0. Salir\n"
     
     
                + "Ingrese que Forma necesita"));
            
            switch (opc) {
                case 1:
                    
                    Random r = new Random();


                    int f = r.nextInt(5) + 2;      
                    int c = r.nextInt(5) + 2;   

                    int[][] Mat = new int[f][c];
                    for (int i = 0; i < Mat.length; i++) {
                        for (int j = 0; j < Mat[i].length; j++) {

                            int prob = r.nextInt(100);

                            if (prob < 70) {
                                Mat[i][j] = 0;
                            } else {
                                Mat[i][j] = r.nextInt(20) + 1;
                            }
                        }
                    }
                    int N = contarDatos(Mat);

                    T1 = new Tripleta(N);
                    T1.llenarTripleta(Mat, N);
                    
             
                    
                    break;

                case 2:
                    if (T1 != null){
            T1.mostrar();
        } else {
            JOptionPane.showMessageDialog(null, "Primero debes crear la Matriz");
        }
        break;
                    
                    
                 

                case 3:
                    
                 if (T1 != null) {
               int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una fila"));
               int sumaF = T1.sumarFilas(filas);
               JOptionPane.showMessageDialog(null, "La suma de la fila es: " + sumaF);
        }          
                 else {
                JOptionPane.showMessageDialog(null, "Primero debes crear la Matriz");
        }
                    break;

                case 4:
                    
                 if (T1 != null) {
               int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una columna"));
               int sumaC = T1.sumarColumnas(columnas);
               JOptionPane.showMessageDialog(null, "La suma de la columna es: " + sumaC);
        }          
                 else {
                JOptionPane.showMessageDialog(null, "Primero debes crear la Matriz");
        }
                    break;

                case 5:
                    boolean valido = false;
                    if (T1 != null){
                        while(!valido){
                    try {
                        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una fila"));
                        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una columna"));
                        int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un dato"));
                        T1.insertar(fila, columna, dato);
                        valido=true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                    }
                        }
            
        } else {
            JOptionPane.showMessageDialog(null, "Primero debes crear la Matriz");
        }
                    
            
                    break;
                    
                case 0:

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Esta opcion es invalida");
            }
        } while (opc!=0);
    }
    
    public static int contarDatos(int Mat[][]){
        
        int N=0;
        
        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {
                if (Mat[i][j]!=0){
                    N++;
                }
            }
        }
        
        return N;
    }
}
