package matricesdispersas;

import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author Mariana Castro y Miguel Angel Mejia Gallo
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

    public void Menu() {
        Tripleta T1 = null;
        boolean valido = false;
        int opc = -1;
        do {

            // ERRORES: Ingreso un numero seguido de un string, hace el metodo
            String opci = JOptionPane.showInputDialog(" Menu Principal\n"
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
            try {
                opc = Integer.parseInt(opci);

            } catch (NumberFormatException e) {
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
                    this.LlenarMD(Mat);
                    this.Mostrar();
                    break;
                case 2:
                    valido = false;
                    if (Punta != null) {
                        while (!valido) {
                            try {
                    this.Mostrar();
                      valido = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la Lista");
                    }
                    break;
                case 3:
                    valido = false;
                    if (Punta != null) {
                        while (!valido) {
                            try {
                                int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una fila"));
                                this.sumarFilas(filas);

                                valido = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la Lista");
                    }

                    break;
                case 4:
                    valido = false;
                    if (Punta != null) {
                        while (!valido) {
                            try {
                                int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una columna"));
                                this.sumarColumnas(columnas);

                                valido = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la Lista");
                    }

                    break;
                case 5:
                    valido = false;
                    if (Punta != null) {
                        while (!valido) {
                            try {
                                int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una fila"));
                                int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una columna"));
                                int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un dato"));
                                this.Insertar(fila, columna, dato);

                                valido = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la Lista");
                    }

                    break;
                case 7:
                    valido = false;
                    if (Punta != null) {
                        while (!valido) {
                            try {
                                int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una fila"));
                                int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una columna"));
                                this.eliminar(fila, columna);

                                valido = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la Lista");
                    }

                    break;
                case 6:
                    valido = false;
                    if (Punta != null) {
                        while (!valido) {
                            try {
                                int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Dato"));

                                this.eliminarPorDato(dato);

                                valido = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la Lista");
                    }

                    break;
                case 8:
                    valido = false;
                    if (Punta != null) {
                        while (!valido) {
                            try {
                                r = new Random();

                                f = this.Punta.getFila();
                                c = this.Punta.getColumna();

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
                                Forma1 ob = new Forma1();
                                ob.LlenarMD(Mat2);
                                JOptionPane.showMessageDialog(null, "Listas a sumar: ");
                                this.Mostrar();
                                ob.Mostrar();
                                this.sumar(ob);
                                valido = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la Lista");
                    }
                    break;
                      case 9:
                    valido = false;
                    if (Punta != null) {
                        while (!valido) {
                            try {
                                r = new Random();

                                f = this.Punta.getColumna();
                                c = r.nextInt(5) + 3;

                                int[][] Mat3 = new int[f][c];
                                for (int i = 0; i < Mat3.length; i++) {
                                    for (int j = 0; j < Mat3[i].length; j++) {

                                        int prob = r.nextInt(100);

                                        if (prob < 70) {
                                            Mat3[i][j] = 0;
                                        } else {
                                            Mat3[i][j] = r.nextInt(20) + 1;
                                        }
                                    }
                                }
                                Forma1 ob2 = new Forma1();
                                ob2.LlenarMD(Mat3);
                                JOptionPane.showMessageDialog(null, "Listas a Multiplicar: ");
                                this.Mostrar();
                                ob2.Mostrar();
                                this.MultiplicarListas(ob2);
                                valido = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes crear la Lista");
                    }
                    break;
                case 0:
                    break;
            }
        } while (opc != 0);

    }

    public void MultiplicarListas(Forma1 ob) {
        int[][] A = this.ListaAMatriz();
        int[][] B = ob.ListaAMatriz();
        int n = A.length;
        int m = B[0].length;
        int p = B.length;

        int[][] R = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    R[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        Forma1 resultado=new Forma1();
        resultado.LlenarMD(R);
        this.Punta=resultado.Punta;

    }
    public int[][] ListaAMatriz(){

    int n = Punta.getFila();
    int m = Punta.getColumna();

    int[][] mat = new int[n][m]; 

    Nodo rc = Punta.getLiga();

    while(rc != Punta){

        Nodo p = rc.getLigaFila();

        while(p != rc){
            mat[p.getFila()][p.getColumna()] = p.getDato();
            p = p.getLigaFila();
        }

        rc = rc.getLiga();
    }

    return mat;
}

    public void sumarFilas(int f) {
        Nodo rc = Punta.getLiga();
        while (rc.getFila() != f) {
            rc = rc.getLiga();
        }
        int sumaF = 0;
        Nodo p = rc.getLigaFila();
        String texto = "fila " + f + " : ";
        while (p != rc) {
            texto += "(" + p.getFila() + "|" + p.getColumna() + "|" + p.getDato() + ") + ";
            
            sumaF += p.getDato();
            p = p.getLigaFila();
        }
        texto += "=" + sumaF;
        JOptionPane.showMessageDialog(null, "La suma de la fila es: " + texto);
    }

    public void eliminar(int f, int c) {
        
        Nodo rc = Punta.getLiga();
        
        while (rc != Punta && rc.getFila() != f) {
            rc = rc.getLiga();
        }
        
        if (rc == Punta) {
            JOptionPane.showMessageDialog(null, "La fila no existe");
            return;            
        }
        
        Nodo p = rc.getLigaFila();
        Nodo ant = rc;
        
        while (p != rc && p.getColumna() < c) {
            ant = p;
            p = p.getLigaFila();
        }
        
        if (p == rc || p.getColumna() != c) {
            JOptionPane.showMessageDialog(null, "El nodo no existe");
            return;
        }
        
        ant.setLigaFila(p.getLigaFila());
        
        Nodo cc = Punta.getLiga();
        while (cc.getColumna() != c) {
            cc = cc.getLiga();
        }
        
        Nodo q = cc.getLigaColumna();
        Nodo antCol = cc;
        
        while (q != cc && q != p) {
            antCol = q;
            q = q.getLigaColumna();
        }
        
        if (q == p) {
            antCol.setLigaColumna(q.getLigaColumna());
        }
        
    }

    public void eliminarPorDato(int d) {
        boolean eliminado = false;
        Nodo rc = Punta.getLiga();
        
        while (rc != Punta) {
            
            Nodo p = rc.getLigaFila();
            Nodo ant = rc;
            
            while (p != rc) {
                
                if (p.getDato() == d) {
                    eliminado = true;
                    Nodo cc = Punta.getLiga();
                    while (cc.getColumna() != p.getColumna()) {
                        cc = cc.getLiga();
                    }
                    
                    Nodo q = cc.getLigaColumna();
                    Nodo antCol = cc;
                    
                    while (q != cc && q != p) {
                        antCol = q;
                        q = q.getLigaColumna();
                    }
                    
                    if (q == p) {
                        antCol.setLigaColumna(q.getLigaColumna());
                    }
                    
                    ant.setLigaFila(p.getLigaFila());
                    
                    p = ant.getLigaFila();
                    
                } else {
                    ant = p;
                    p = p.getLigaFila();
                }
            }
            
            rc = rc.getLiga();
        }
        if (eliminado == false) {
            
            JOptionPane.showMessageDialog(null, "El nodo no existe");
        }
    }

    public void sumarColumnas(int c) {
        Nodo rc = Punta.getLiga();
        while (rc.getColumna() != c) {
            rc = rc.getLiga();
        }
        int sumaF = 0;
        Nodo p = rc.getLigaColumna();
        String texto = "columna " + c + " : ";
        while (p != rc) {
            texto += "(" + p.getFila() + "|" + p.getColumna() + "|" + p.getDato() + ") + ";
            
            sumaF += p.getDato();
            p = p.getLigaColumna();
        }
        texto += "=" + sumaF;
        JOptionPane.showMessageDialog(null, texto);
    }

    public void Mostrar() {
        String textofinal = "";
        
        Nodo rc = Punta.getLiga();
        
        textofinal += "Punta  [" + Punta.getFila() + "," + Punta.getColumna() + "]\n↓\n";
        
        while (rc != Punta) {
            
            textofinal += "[" + rc.getFila() + "] → ";
            
            Nodo p = rc.getLigaFila();
            
            while (p != rc) {
                textofinal += "(" + p.getFila() + "," + p.getColumna() + "," + p.getDato() + ") → ";
                p = p.getLigaFila();
            }
            
            textofinal += "⟳\n";
            textofinal += "↓\n";
            
            rc = rc.getLiga();
        }
        
        textofinal += "⟳ (regresa a Punta)";
        
        JOptionPane.showMessageDialog(null, textofinal);
    }
    
    public void Insertar(int f, int c, int d) {
        Nodo nuevo = new Nodo(f, c, d);
        if ((f < Punta.getFila() && f >= 0) && (c < Punta.getColumna()) && c >= 0) {
            Nodo rc = Punta.getLiga();
            while (rc.getFila() != nuevo.getFila()) {
                rc = rc.getLiga();
            }
            Nodo p = rc.getLigaFila();
            Nodo a = rc;
            while (p != rc && p.getColumna() < nuevo.getColumna()) {
                a = p;
                p = p.getLigaFila();
            }
            if (p != rc && p.getColumna() == nuevo.getColumna()) {
                p.setDato(d);
                return;
            }
            a.setLigaFila(nuevo);
            nuevo.setLigaFila(p);

            //ligar Columna
            Nodo cc = Punta.getLiga();
            while (cc.getColumna() != nuevo.getColumna()) {
                cc = cc.getLiga();
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

    public void sumar(Forma1 ob) {
        
        Forma1 MR = new Forma1();
        
        int n = Punta.getFila();
        int m = Punta.getColumna();
        
        MR.Paso1(n, m);        
        
        Nodo r1 = this.Punta.getLiga();
        Nodo r2 = ob.Punta.getLiga();
        Nodo rR = MR.Punta.getLiga();
        
        while (r1 != Punta) {
            
            Nodo p = r1.getLigaFila();
            Nodo q = r2.getLigaFila();
            
            while (p != r1 && q != r2) {
                
                if (p.getColumna() == q.getColumna()) {
                    
                    int suma = p.getDato() + q.getDato();
                    
                    if (suma != 0) {
                        MR.Insertar(p.getFila(), p.getColumna(), suma);
                    }
                    
                    p = p.getLigaFila();
                    q = q.getLigaFila();
                    
                } else if (p.getColumna() < q.getColumna()) {
                    
                    MR.Insertar(p.getFila(), p.getColumna(), p.getDato());
                    p = p.getLigaFila();
                    
                } else {
                    
                    MR.Insertar(q.getFila(), q.getColumna(), q.getDato());
                    q = q.getLigaFila();
                }
            }
            
            while (p != r1) {
                MR.Insertar(p.getFila(), p.getColumna(), p.getDato());
                p = p.getLigaFila();
            }
            
            while (q != r2) {
                MR.Insertar(q.getFila(), q.getColumna(), q.getDato());
                q = q.getLigaFila();
            }
            
            r1 = r1.getLiga();
            r2 = r2.getLiga();
            rR = rR.getLiga();
        }
        this.Punta=MR.Punta;
        this.Mostrar();
        
    }
    
    public void LlenarMD(int Mat[][]) {
        Paso1(Mat.length, Mat[0].length);
        Paso2(Mat);
        Paso3(Mat);
        
    }
    
    private void Paso1(int n, int m) {
        Nodo p, x;
        int i = 0, mayor;
        
        if (n > m) {
            mayor = n;            
        } else {
            mayor = m;
        }
        if (Punta == null) {
            x = new Nodo(n, m, 0);
            Punta = x;
        }
        p = Punta;
        
        while (i < mayor) {
            x = new Nodo(i, i, 0);
            x.setLigaFila(x);            
            x.setLigaColumna(x);
            p.setLiga(x);
            p = x;
            i++;
        }
        p.setLiga(Punta);        
    }
    
    private void Paso2(int Mat[][]) {
        Nodo p, q, x;
//        int i=0, j=0;
        p = Punta.getLiga();
        
        int n = Mat.length, m = Mat[0].length;
        for (int i = 0; i < n; i++) {
            p.setLigaFila(p);
            q = p;
            for (int j = 0; j < m; j++) {
                if (Mat[i][j] != 0) {
                    x = new Nodo(i, j, Mat[i][j]);
                    if (q == p) {                        
                        p.setLigaFila(x);
                        q = x;
                        
                    } else {
                        
                        q.setLigaFila(x);
                        q = x;
                        
                    }
                    
                }
                
            }
            q.setLigaFila(p);
            p = p.getLiga();
            
        }
    }

    private void Paso3(int Mat[][]) {
        
        Nodo rc = Punta.getLiga();
        
        while (rc != Punta) {
            
            Nodo a = rc;
            Nodo p = Punta.getLiga();
            while (p != Punta) {
                Nodo q = p.getLigaFila();
                while (q != p) {
                    if (p.getLigaFila() == null) {
                        System.out.println("ERROR en fila ");
                    }
                    
                    if (rc.getColumna() == q.getColumna()) {
                        a.setLigaColumna(q);
                        a = q;
                    }
                    q = q.getLigaFila();
                    
                }
                p = p.getLiga();
                
            }
            a.setLigaColumna(rc);
            rc = rc.getLiga();
            
        }
        
    }
    
}
