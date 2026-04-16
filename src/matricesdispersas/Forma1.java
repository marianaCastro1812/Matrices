
package matricesdispersas;

import javax.swing.JOptionPane;

/**
 *
 * @author Mariana Castro  y Miguel Angel Mejia Gallo
 */
public class Forma1 {
    private Nodo Punta;

    public Forma1() {
        this.Punta = null;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }
    public void Menu(){
         Tripleta T1 =null;
     boolean valido = false;
     int opc=-1;
     do{

        // ERRORES: Ingreso un numero seguido de un string, hace el metodo
            
            String opci =JOptionPane.showInputDialog(" Menu Principal\n"
                + "1. Crear Matriz en Forma 1\n"
                + "2. Mostrar Forma\n"
                + "3. Suma de filas\n"
                + "4. Suma de columnas\n"
                + "5. Insertar Dato \n"
                + "6. Eliminar Dato\n"
                + "7. Eliminar Dato por Posicion\n"
                + "8. Sumar\n"
                + "9. Multiplicar\n"  
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
            } 
            }while(opc!=0);
            
    }
    public void MostrarEstructura(){
    Nodo rc = Punta.getLiga();

    System.out.println("Punta");
    System.out.println("  ↓");

    while (rc != Punta) {

     
        System.out.print("[" + rc.getFila() + "] → ");

     
        Nodo p = rc.getLigaFila();

        while (p != rc) {
            System.out.print("(" + p.getFila() + "," + p.getColumna() + "," + p.getDato() + ") → ");
            p = p.getLigaFila();
        }

        System.out.println("⟳");


        System.out.println("  ↓");

        rc = rc.getLiga();
    }

    System.out.println(" ⟳ (regresa a Punta)");
}
    public void Insertar(int f, int c, int d){
      Nodo nuevo=new Nodo(f,c,d);
        if ((f<Punta.getFila()&& f>=0)&&(c<Punta.getColumna())&&c>=0) {
            Nodo rc=Punta.getLiga();
            while(rc.getFila()!=nuevo.getFila()){
                rc=rc.getLiga();
            }
            Nodo p=rc.getLigaFila();
            Nodo a=rc;
            while(p!=rc && p.getColumna()<nuevo.getColumna()){
                a=p;
                p=p.getLigaFila();
            }
             if (p != rc && p.getColumna() == nuevo.getColumna()) {
            p.setDato(d);
            return;
        }
            a.setLigaFila(nuevo);
            nuevo.setLigaFila(p);
            
            //ligar Columna
            Nodo cc=Punta.getLiga();
            while(cc.getColumna()!=nuevo.getColumna()){
                cc=cc.getLiga();
            }
            p = cc.getLigaColumna();
            a = cc;

            while (p != cc && p.getFila() < nuevo.getFila()) {
                a = p;
                p = p.getLigaColumna();
            }

            nuevo.setLigaColumna(p);
            a.setLigaColumna(nuevo);
        }
        
        
    }
    public void sumar(){
        
    }
    
    public void LlenarMD(int Mat[][]){
        Paso1(Mat.length,Mat[0].length);
        Paso2(Mat);
        Paso3(Mat);
        
    }
    
    private void Paso1(int n, int m){
        Nodo p,x;
        int i=0, mayor;
        
        if (n>m) {
            mayor=n;          
        }else{
            mayor=m;
        }
        if (Punta==null){
            x=new Nodo(n, m, 0);
        }
        p=Punta;
                
        while(i<mayor){
            x=new Nodo(i, i, 0);
            p.setLiga(x);
            p=x;
            i++;
        }
        p.setLiga(Punta);       
        }
        
        
    
    private void Paso2(int Mat[][]){
        Nodo p,q,x;
//        int i=0, j=0;
        p=Punta.getLiga();
        q=p;
        int n=Mat.length,m=Mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(Mat[i][j]!=0){
                    x = new Nodo(n, m, Mat[i][j]);
                    q.setLigaFila(x);
                    q=x;
                }
                
            }
            q.setLigaFila(p);
            p=p.getLiga();
            q=p;
            
        }
       
    }
    private void Paso3(int Mat[][]){
        
        Nodo rc=Punta.getLiga();
        
       
        
        
        while(rc!=Punta){
             Nodo a=rc;
             Nodo p=Punta.getLiga();
            while(p!=Punta){
                Nodo q=p.getLigaFila();
                while(q!=p){
                    if(rc.getColumna()==q.getColumna()){
                       a.setLigaColumna(q);
                       a=q;
                    }
                    q=q.getLigaFila();
                    
                }
                p=p.getLiga();
                
            }
            rc=rc.getLiga();
            
            
            
        }
        
    }
    
    
}
