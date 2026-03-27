
package matricesdispersas;

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
        Nodo a=rc;
        Nodo p=Punta.getLiga();
        
    }
    
    
}
