package matricesdispersas;

import javax.swing.JOptionPane;
import java.util.Random;
/**
 *
 * @author Mariana Castro, Miguel Gallo y Gepetto
 */
public class MatricesDispersas {

    public static void main(String[] args) {
      
    Tripleta T1 =null;
     boolean valido = false;
     int opc=-1;
     do{

        // ERRORES: Ingreso un numero seguido de un string, hace el metodo
            
            String opci =JOptionPane.showInputDialog(" Menu Principal\n"
                + "1. Crear Tripleta\n"
                + "2. Mostrar Forma\n"
                + "3. Suma de filas\n"
                + "4. Suma de columnas\n"
                + "5. Insertar Dato \n"
                + "6. Eliminar Dato\n"
                + "7. Eliminar Dato por Posicion\n"
                + "8. Sumar\n"
                + "9. Multiplicar\n"
                + "10. Forma 1\n"
                + "11. Forma 2\n"
                + "12. F1 * F2 = Tripleta\n"
                + "0. Salir\n"
                + "Ingrese que Forma necesita");
            
            if (opci == null) {
            JOptionPane.showMessageDialog(null, "Programa finalizado");
            return;
        }

        
        if (opci.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puedes dejar el campo vacío");
            continue;
        }
        try{
            opc = Integer.parseInt(opci);
  
        }catch
            (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un número");
        
    
        }
        
    
       
            
            switch (opc) {
                case 1:
                    
                    Random r = new Random();


                    int f = r.nextInt(5) + 3;      
                    int c = r.nextInt(5) + 3;   

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
                    JOptionPane.showMessageDialog(null, "La Tripleta nueva se creo Correctamente: ");
                    T1.mostrar();
                    
             
                    
                    break;

                case 2:
                    if (T1 != null){
                    T1.mostrar();
        } else {
            JOptionPane.showMessageDialog(null, "Primero debes crear la Matriz");
            
        }
        break;
                    
                    
                 

                case 3:
                    
                    boolean valido1 = false;

                    if (T1 != null) {
                        while (!valido1) {
                            try {
                                int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una fila"));
                                int sumaF = T1.sumarFilas(filas);
                                JOptionPane.showMessageDialog(null, "La suma de la fila es: " + sumaF);
                                valido1 = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la Matriz");
                    }

                    break;

                case 4:

                    boolean valido3 = false;

                    if (T1 != null) {
                        while (!valido3) {
                            try {
                                int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una columna"));
                                int sumaC = T1.sumarColumnas(columnas);
                                JOptionPane.showMessageDialog(null, "La suma de la columna es: " + sumaC);
                                valido3 = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la Matriz");
                    }

                    break;




                case 5:
                    boolean valido2 = false;
                    if (T1 != null){
                        while(!valido2){
                    try {
                        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una fila"));
                        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una columna"));
                        int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un dato"));
                        T1.insertar(fila, columna, dato);
                        valido2=true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                    }
                        }
            
        } else {
            JOptionPane.showMessageDialog(null, "Primero debes crear la Matriz");
            
        }
                    
            
                    break;
                    
                case 6:
                     if (T1 != null) {
                     int dato=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el dato a Eliminar"));
                     T1.EliminarDato(dato);
                     }else {
            JOptionPane.showMessageDialog(null, "Primero debes crear la Matriz");
           
        }
                     break;
                     case 7:
                     if (T1 != null) {
                     int fila2=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la fila del dato que desea borrar"));
                     int columna2=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la columna del dato que desea borrar"));
                     T1.EliminarDatopp(fila2, columna2);
                     }else {
            JOptionPane.showMessageDialog(null, "Primero debes crear la Matriz");
            
        }
                     
                 
                    break;
                    
                    case 8:
                    if (T1 != null) {
                    Random r3 = new Random();
                    int f2 = T1.getMtri(0, 0);
                    int c2 = T1.getMtri(0, 1);

                    int[][] MatB = new int[f2][c2];

                    for (int i = 0; i < f2; i++) {
                        for (int j = 0; j < c2; j++) {
                            if (r3.nextInt(100) < 70) {
                                MatB[i][j] = 0;
                            } else {
                                MatB[i][j] = r3.nextInt(20) + 1;
                            }
                        }
                    }

                    int N2 = contarDatos(MatB);

                    Tripleta T3 = new Tripleta(N2);
                    T3.llenarTripleta(MatB, N2);
                    JOptionPane.showMessageDialog(null, "La Tripleta 2 se creo Correctamente: ");
                    T3.mostrar();

                    

                        JOptionPane.showMessageDialog(null, "TRIPLETA 1:");
                        T1.mostrar();

                        JOptionPane.showMessageDialog(null, "TRIPLETA 2:");
                        T3.mostrar();

                        Tripleta resultado = T1.sumarTripletas(T3);

                        JOptionPane.showMessageDialog(null, "Resultado de la suma:");
                        resultado.mostrar();
                         int opcion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Deseas reemplazar la tripleta original?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {
                T1.setMtric(resultado.getMtric());
            } else {
               JOptionPane.showMessageDialog(null, "Para ver la Matriz Original Seleccione mostrar");
            }

                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la matriz T1");
                    }
                    break;
                       
                    
                    
                    
                    
                        case 9:
                            if (T1 != null) {
                     Random r2 = new Random();


                    int f1 = T1.getMtri(0, 1);      
                    int c1 = r2.nextInt(5) + 3;   

                    int[][] Mat2 = new int[f1][c1];
                    for (int i = 0; i < Mat2.length; i++) {
                        for (int j = 0; j < Mat2[i].length; j++) {

                            int prob = r2.nextInt(100);

                            if (prob < 70) {
                                Mat2[i][j] = 0;
                            } else {
                                Mat2[i][j] = r2.nextInt(20) + 1;
                            }
                        }
                    }
                    N= contarDatos(Mat2);

                    Tripleta T2 = new Tripleta(N);
                    T2.llenarTripleta(Mat2, N);
                    JOptionPane.showMessageDialog(null, "La Tripleta 2 se creo Correctamente: ");
                    T2.mostrar();
                    T1.multiplicarTripletas(T2);
                            }else{
                                JOptionPane.showMessageDialog(null, "Debes Crear Primero la Matriz Original");
                            }
                            
                        break;
                        case 10:
                            Forma1 F1=new Forma1();
                            F1.Menu();
                            break;
                case 11:
                    Forma2 F2 = new Forma2();
                    F2.Menu();
                    break;
                case 12:
                    Forma1 F1m=new Forma1();
                     r = new Random();

                     f = r.nextInt(5) + 3;
                     c = r.nextInt(5) + 3;

                    int[][] Mat2 = new int[f][c];
                    for (int i = 0; i < Mat2.length; i++) {
                        for (int j = 0; j < Mat2[i].length; j++) {

                            int prob = r.nextInt(100);

                            if (prob < 70) {
                                Mat2[i][j] = 0;
                            } else {
                                Mat2[i][j] = r.nextInt(20) + 1;
                            }
                        }
                    }
                    F1m.LlenarMD(Mat2);
                    JOptionPane.showMessageDialog(null, "Forma 1=");
                    F1m.Mostrar();
                    Forma2 F2m=new Forma2();
                    Nodo p=F1m.getPunta();
                    F2m.crearm(p.getColumna());
                    JOptionPane.showMessageDialog(null, "Forma 2=");
                    F2m.MostrarForma();
                    JOptionPane.showMessageDialog(null, "Resultado=");
                    Tripleta.MultiplicarListas(F1m, F2m);
                          
                    break;
                case 0:
                        break;

                default:
                    JOptionPane.showMessageDialog(null, "Esta opcion es invalida");
                    opc=-1;
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
