//
package matricesdispersas;

import javax.swing.JOptionPane;

/**
 *
 * @author Maria
 */
public class Tripleta {
    //Atributos
    private int Mtri[][];
    
    //Metodos

    public Tripleta(int N) {
        
        Mtri = new int [N+1][3];
        
    }

    public int getMtri(int k, int i) {
        return Mtri[k][i];
    }

    public void setMtri(int k, int i, int d) {
        Mtri[k][i] = d;
    }
    
    public void llenarTripleta(int Mat[][],int N){
        int k=1;
        
        Mtri[0][0]=Mat.length;
        Mtri[0][1]=Mat[0].length;
        Mtri[0][2]=N;
        
        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {
                if (Mat[i][j]!=0){
                    Mtri[k][0]=i;
                    Mtri[k][1]=j;
                    Mtri[k][2]=Mat[i][j];
                    k++;
                }
            }
        }
    }
    
    public void insertar(int f, int c, int d){
        
        if (( f >= 0 && f < Mtri[0][0])&& (c>=0 && c < Mtri[0][1])){
        
        boolean x=false;
        for (int k = 1; k < Mtri.length; k++) {
            
               if (Mtri[k][0]==f && Mtri[k][1]==c) {
                   Mtri[k][2]+=d;
                   x=true;
                   break;
                
            }
            
            
        }
            if (x==false) {
                int[][] aux= new int[Mtri.length+1][Mtri[0].length];
                aux[0][0]=Mtri[0][0];
                aux[0][1]=Mtri[0][1];
                aux[0][2]=Mtri[0][2]+1;
                 int k=1;  
                 int i=1;
                 boolean insertado=false;
                 while(i < Mtri.length){
                    if (!insertado && (f < Mtri[i][0] || f ==Mtri[i][0] && c< Mtri[i][1])){
                        aux[k][0]=f;
                        aux[k][1]=c;
                        aux[k][2]=d;
                        k++;
                        insertado = true;
                        
                    }
                        aux[k][0]=Mtri[i][0];
                        aux[k][1]=Mtri[i][1];
                        aux[k][2]=Mtri[i][2];
                        k++;
                        i++;
                        
                    
                }
                 if (!insertado){
                        aux[k][0]=f;
                        aux[k][1]=c;
                        aux[k][2]=d;
                 }
                 Mtri=aux;
                 }
        
            
      } else{
            JOptionPane.showInputDialog(" La fila "+f + " y la columna" + c + "no se pueden agregar a la Tripleta");
        }
    }
        
    public void mostrar(){
        String p="";
        
        for (int k=0; k <= Mtri[0][2];k++){
            p+="|"+ Mtri[k][0]+"|"+Mtri[k][1]+"|"+Mtri[k][2]+"| \n";
        }
        JOptionPane.showMessageDialog(null, p);
    }
    
    
    public int sumarFilas(int filas){
        
    int sumaF = 0;
    String proceso = "";

    for (int k = 1; k <= Mtri[0][2]; k++){
        if (Mtri[k][0] == filas){ 
            sumaF += Mtri[k][2]; 
            proceso = proceso + Mtri[k][2] + " , ";
        }
    }
    JOptionPane.showMessageDialog(null, "Numeros sumados: " + proceso +" ");
    
    return sumaF;
}
    
    public int sumarColumnas(int columnas){
        
    int sumaC = 0;
    String proceso = "";    
    
    for (int k = 1; k <= Mtri[0][2]; k++){
        if (Mtri[k][1] == columnas){ 
            sumaC += Mtri[k][2]; 
            proceso = proceso + Mtri[k][2] + " , ";
        }
    }
    JOptionPane.showMessageDialog(null, "Numeros sumados: " + proceso +" ");
    
    return sumaC;
}
    
 public void multiplicarTripletas(Tripleta T1){
     
     
 }   
    
}
