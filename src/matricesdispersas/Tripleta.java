
package matricesdispersas;

import javax.swing.JOptionPane;

/**
 *
 * @author Mariana Castro, Miguel Gallo y Gepetto
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
     public int[][] getMtric() {
        return Mtri;
    }

    public void setMtri(int k, int i, int d) {
        Mtri[k][i] = d;
    }
    public void setMtric(int Mtri[][]) {
        this.Mtri = Mtri;
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
    public void EliminarDatopp(int f,int c){
        if (( f >= 0 && f < Mtri[0][0])&& (c>=0 && c < Mtri[0][1])){
            boolean x=false;      
            for (int i = 1; i < Mtri.length; i++) {
                if(f==Mtri[i][0]&& c==Mtri[i][1]){
            
        
            int[][] aux = new int[Mtri.length-1][Mtri[0].length];

            aux[0][0] = Mtri[0][0];
            aux[0][1] = Mtri[0][1];
            aux[0][2] = Mtri[0][2]-1;

            int j = 1;
            for (int k = 1; k < Mtri.length; k++) {
                if (!(f == Mtri[k][0] && c == Mtri[k][1])) {
                    aux[j][0] = Mtri[k][0];
                    aux[j][1] = Mtri[k][1];
                    aux[j][2] = Mtri[k][2];
                    j++;
                }
                    
                }
            Mtri=aux;
            x=true;
            JOptionPane.showMessageDialog(null, "El dato en la posicion "+ f +" ,"+c+" se elimino correctamente \n"
            + " Seleccione Mostrar para ver la nueva Tripleta");
            }
                
            }
            if (!x) {
                JOptionPane.showMessageDialog(null,"Esta Posicion no se encuentra en la Tripleta");
                
            }

        
        }else{
             JOptionPane.showMessageDialog(null," La fila "+ f + " y la columna " + c + " no estan en la Tripleta");
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
            JOptionPane.showMessageDialog(null," La fila "+f + " y la columna" + c + "no se pueden agregar a la Tripleta");
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
            if (!proceso.isEmpty()) {
            proceso += ", ";
        }
            proceso = proceso + Mtri[k][2];
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
            if (!proceso.isEmpty()) {
            proceso += ", ";
        }
            proceso = proceso + Mtri[k][2] ;
        }
    }
    JOptionPane.showMessageDialog(null, "Numeros sumados: " + proceso +" ");
    
    return sumaC;
}
    public void EliminarDato(int d){
        boolean x=false;
        for (int i = 0; i < Mtri.length; i++) {
            if(Mtri[i][2]==d){
                x=true;
                break;
            }
            
        }
        if (x) {
            
        
        int cont=0;
         for (int i = 1; i < Mtri.length; i++) {
        if (Mtri[i][2] != d) {
            cont++;
        }
    }

   
    int[][] aux = new int[cont + 1][Mtri[0].length];

  
    aux[0][0] = Mtri[0][0];
    aux[0][1] = Mtri[0][1];
    aux[0][2] = cont;


    int j = 1;
    for (int i = 1; i < Mtri.length; i++) {
        if (Mtri[i][2] != d) {
            aux[j][0] = Mtri[i][0];
            aux[j][1] = Mtri[i][1];
            aux[j][2] = Mtri[i][2];
            
            j++;
        }
    }

    Mtri = aux;
    JOptionPane.showMessageDialog(null, "El dato "+ d +" se elimino correctamente \n"
            + " Seleccione Mostrar para ver la nueva Tripleta");
    
}else{
            JOptionPane.showMessageDialog(null, "Este dato no existe");
        }
    }
    
public Tripleta sumarTripletas(Tripleta T2) {

    int i = 1;
    int j = 1; 
    int k = 1;

    int tam = this.Mtri[0][2] + T2.Mtri[0][2];
    Tripleta resultado = new Tripleta(tam);

    resultado.Mtri[0][0] = this.Mtri[0][0];
    resultado.Mtri[0][1] = this.Mtri[0][1];

    while (i <= this.Mtri[0][2] && j <= T2.Mtri[0][2]) {

        int f1 = this.Mtri[i][0];
        int c1 = this.Mtri[i][1];
        int d1 = this.Mtri[i][2];

        int f2 = T2.Mtri[j][0];
        int c2 = T2.Mtri[j][1];
        int d2 = T2.Mtri[j][2];

        
        if (f1 == f2 && c1 == c2) {
            resultado.Mtri[k][0] = f1;
            resultado.Mtri[k][1] = c1;
            resultado.Mtri[k][2] = d1 + d2;
            i++; 
            j++; 
            k++;
        }
        
        else if (f1 < f2 || (f1 == f2 && c1 < c2)) {
            resultado.Mtri[k][0] = f1;
            resultado.Mtri[k][1] = c1;
            resultado.Mtri[k][2] = d1;
            i++; 
            k++;
        }
       
        else {
            resultado.Mtri[k][0] = f2;
            resultado.Mtri[k][1] = c2;
            resultado.Mtri[k][2] = d2;
            j++; 
            k++;
        }
    }

   
    while (i <= this.Mtri[0][2]) {
        resultado.Mtri[k][0] = this.Mtri[i][0];
        resultado.Mtri[k][1] = this.Mtri[i][1];
        resultado.Mtri[k][2] = this.Mtri[i][2];
        i++; k++;
    }

    while (j <= T2.Mtri[0][2]) {
        resultado.Mtri[k][0] = T2.Mtri[j][0];
        resultado.Mtri[k][1] = T2.Mtri[j][1];
        resultado.Mtri[k][2] = T2.Mtri[j][2];
        j++; k++;
    }

    resultado.Mtri[0][2] = k - 1;

    return resultado;
}
  
    
 public void multiplicarTripletas(Tripleta T2){
      if (this.Mtri[0][1] !=T2.Mtri[0][0]) {
        JOptionPane.showMessageDialog(null, "No se pueden multiplicar");
        return;
    }else{

    int filas = this.Mtri[0][0];
    int columnas = T2.Mtri[0][1];

    int[][] resultado = new int[filas][columnas];
      for (int i = 1; i < this.Mtri.length; i++) {

        int fila1 = this.Mtri[i][0];
        int columna1= this.Mtri[i][1];
        int dato1 = this.Mtri[i][2];

        for (int j = 1; j < T2.Mtri.length; j++) {

            int fila2 = T2.Mtri[j][0];
            int columna2 = T2.Mtri[j][1];
            int dato2 = T2.Mtri[j][2];

            if (columna1 == fila2) {
                resultado[fila1][columna2] += dato1 * dato2;
            }
        }
    }
      

      int N= MatricesDispersas.contarDatos(resultado);
      Tripleta t=new Tripleta(N);
      t.llenarTripleta(resultado,N);
      JOptionPane.showMessageDialog(null, "Las matrices Multiplicadas fueron las siguientes:");
      this.mostrarComoMatriz();
      T2.mostrarComoMatriz();
      JOptionPane.showMessageDialog(null, "El resultado seria: ");
      t.mostrar();
            int opcion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Deseas reemplazar la tripleta original?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {
                this.Mtri = t.Mtri;
            } else {
               JOptionPane.showMessageDialog(null, "Para ver la Matriz Original Seleccione mostrar");
            }
        }

    }
 public void mostrarComoMatriz() {

    int filas = Mtri[0][0];
    int columnas = Mtri[0][1];

    int[][] matriz = new int[filas][columnas];

    for (int i = 1; i < Mtri.length; i++) {
        int f = Mtri[i][0];
        int c = Mtri[i][1];
        int v = Mtri[i][2];

        matriz[f][c] = v;
    }

   
    String salida = "";

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            salida += String.format("%4d", matriz[i][j]);
        }
        salida += "\n";
    }

    JOptionPane.showMessageDialog(null, salida);
}

 }  

    

