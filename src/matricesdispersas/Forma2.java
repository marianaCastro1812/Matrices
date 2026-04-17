/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricesdispersas;

import javax.swing.JOptionPane;
import java.util.Random;

public class Forma2 {

    private Nodo Punta;
    private boolean creada = false;

    public Forma2() {
        Punta = new Nodo(0,0,0);
        Punta.setLigaFila(Punta);
        Punta.setLigaColumna(Punta);
    }

    public void Menu(){
         
    boolean valido = false;
    int opc=-1;

    do{

        String opci = JOptionPane.showInputDialog(" Menu Forma 2\n"
                + "1. Crear matriz\n"
                + "2. Mostrar\n"
                + "3. Suma de filas\n"
                + "4. Suma de columnas\n"
                + "5. Insertar\n"
                + "6. Eliminar dato\n"
                + "7. Eliminar posicion\n"
                + "8. Sumar\n"
                + "9. Multiplicar\n"
                + "0. Salir\n"
                + "Ingrese opcion");

        if (opci == null) {
            JOptionPane.showMessageDialog(null, "Programa F2 finalizado");
            return;
        }

        if (opci.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puedes dejar el campo vacío");
            continue;
        }

        try{
            opc = Integer.parseInt(opci);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debes ingresar un número");
            continue;
        }

        switch (opc) {

            case 1:
                crear();
                creada = true;
                break;

            case 2:
                if (!creada){
                    JOptionPane.showMessageDialog(null, "Primero debes crear la matriz");
                    break;
                }
                MostrarForma();
                break;

            case 3:
                if (!creada){
                    JOptionPane.showMessageDialog(null, "Primero debes crear la matriz");
                    break;
                }
                boolean valido1 = false;
                while (!valido1) {
                    try {
                        int f = Integer.parseInt(JOptionPane.showInputDialog("Fila"));
                        SumaFilas(f);
                        valido1 = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                    }
                }
                break;

            case 4:
                if (!creada){
                    JOptionPane.showMessageDialog(null, "Primero debes crear la matriz");
                    break;
                }
                boolean valido2 = false;
                while (!valido2) {
                    try {
                        int c = Integer.parseInt(JOptionPane.showInputDialog("Columna"));
                        SumaColumnas(c);
                        valido2 = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                    }
                }
                break;

            case 5:
                if (!creada){
                    JOptionPane.showMessageDialog(null, "Primero debes crear la matriz");
                    break;
                }
                boolean valido3 = false;
                while (!valido3) {
                    try {
                        int f = Integer.parseInt(JOptionPane.showInputDialog("Fila"));
                        int c = Integer.parseInt(JOptionPane.showInputDialog("Columna"));
                        int dt = Integer.parseInt(JOptionPane.showInputDialog("Dato"));
                        Insertar(f,c,dt);
                        valido3 = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                    }
                }
                break;

            case 6:
                if (!creada){
                    JOptionPane.showMessageDialog(null, "Primero debes crear la matriz");
                    break;
                }
                boolean valido4 = false;
                while (!valido4) {
                    try {
                        int d = Integer.parseInt(JOptionPane.showInputDialog("Dato"));
                        eliminarDato(d);
                        valido4 = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                    }
                }
                break;

            case 7:
                if (!creada){
                    JOptionPane.showMessageDialog(null, "Primero debes crear la matriz");
                    break;
                }
                boolean valido5 = false;
                while (!valido5) {
                    try {
                        int fi = Integer.parseInt(JOptionPane.showInputDialog("Fila"));
                        int co = Integer.parseInt(JOptionPane.showInputDialog("Columna"));
                        eliminarPosicion(fi,co);
                        valido5 = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar números válidos");
                    }
                }
                break;
                
            case 8:

                if (!creada) {
                    JOptionPane.showMessageDialog(null, "Primero debes crear la matriz");
                    break;
                }

                Forma2 B = new Forma2();
                B.crear();

                Forma2 R = this.sumar(B);

                JOptionPane.showMessageDialog(null, "Matriz A:");
                this.MostrarForma();

                JOptionPane.showMessageDialog(null, "Matriz B:");
                B.MostrarForma();

                JOptionPane.showMessageDialog(null, "Resultado suma:");
                R.MostrarForma();
                break;
                
                case 9:

                if (!creada) {
                    JOptionPane.showMessageDialog(null, "Primero debes crear la matriz");
                    break;
                }

                Forma2 B2 = new Forma2();

                Random r = new Random();

                int fB = this.Punta.getColumna();
                int cB = r.nextInt(5) + 3;

                B2.Punta.setFila(fB);
                B2.Punta.setColumna(cB);

                for (int i = 0; i < fB; i++) {
                    for (int j = 0; j < cB; j++) {

                        if (r.nextInt(100) >= 70) {
                            B2.Insertar(i, j, r.nextInt(20) + 1);
                        }
                    }
                }

                if (this.Punta.getColumna() != B2.Punta.getFila()) {
                    JOptionPane.showMessageDialog(null, "No se puede multiplicar");
                    break;
                }

                Forma2 R2 = this.multiplicar(B2);

                JOptionPane.showMessageDialog(null, "Matriz A:");
                this.MostrarForma();

                JOptionPane.showMessageDialog(null, "Matriz B:");
                B2.MostrarForma();

                JOptionPane.showMessageDialog(null, "Resultado multiplicacion:");
                R2.MostrarForma();

                break;
            case 0:
                break;

            default:
                JOptionPane.showMessageDialog(null, "Esta opcion es invalida");
                opc = -1;
        }

    }while(opc!=0);
}

    public void crear(){
    Random r = new Random();

    int f = r.nextInt(5)+3;
    int c = r.nextInt(5)+3;

    Punta.setFila(f);
    Punta.setColumna(c);

    Punta.setLigaFila(Punta);
    Punta.setLigaColumna(Punta);

    for (int i = 0; i < f; i++) {
        for (int j = 0; j < c; j++) {
            if (r.nextInt(100) >= 70){
                Insertar(i,j,r.nextInt(20)+1);
            }
        }
    }

    JOptionPane.showMessageDialog(null, "Matriz creada");
}
 
    public void Insertar(int f, int c, int dt){

    if (dt == 0) return;

    if ((f < Punta.getFila() && f >= 0) && (c < Punta.getColumna() && c >= 0)) {

        Nodo nuevo = new Nodo(f,c,dt);

        Nodo p = Punta.getLigaFila();
        Nodo a = Punta;

        while (p != Punta && (p.getFila() < f || (p.getFila()==f && p.getColumna()<c))){
            a = p;
            p = p.getLigaFila();
        }

        if (p != Punta && p.getFila()==f && p.getColumna()==c){
            p.setDato(p.getDato() + dt);
            if (p.getDato() == 0){
                eliminarPosicion(f,c);
            }
            return;
        }

        a.setLigaFila(nuevo);
        nuevo.setLigaFila(p);

        Nodo cc = Punta;
        p = Punta.getLigaColumna();
        a = cc;

        while (p != Punta && (p.getColumna() < c || (p.getColumna()==c && p.getFila()<f))){
            a = p;
            p = p.getLigaColumna();
        }

        nuevo.setLigaColumna(p);
        a.setLigaColumna(nuevo);
    }
}
    public void MostrarForma(){

    Nodo p = Punta.getLigaFila();

    String salida = "Punta [" + Punta.getFila() + "," + Punta.getColumna() + "] ⭢ ";

    while (p != Punta){
        salida += "(" + p.getFila() + "," + p.getColumna() + "," + p.getDato()+")";

        p = p.getLigaFila();

        if (p != Punta){
            salida += " ⭢ ";
        }
    }

    salida += " ⭢ ⟳";

    JOptionPane.showMessageDialog(null, salida);
}

    public void SumaFilas(int fila){

        int suma = 0;
        boolean existe = false;

        Nodo p = Punta.getLigaFila();

        while (p != Punta){
            if (p.getFila() == fila){
                suma += p.getDato();
                existe = true;
            }
            p = p.getLigaFila();
        }

        if (!existe){
            JOptionPane.showMessageDialog(null, "La fila no existe en la matriz");
        } else {
            JOptionPane.showMessageDialog(null, "Suma de la fila: " + suma);
        }
    }

    public void SumaColumnas(int columna){

        int suma = 0;
        boolean existe = false;

        Nodo p = Punta.getLigaColumna();

        while (p != Punta){
            if (p.getColumna() == columna){
                suma += p.getDato();
                existe = true;
            }
            p = p.getLigaColumna();
        }

        if (!existe){
            JOptionPane.showMessageDialog(null, "La columna no existe en la matriz");
        } else {
            JOptionPane.showMessageDialog(null, "Suma de la columna: " + suma);
        }
    }

    public void eliminarDato(int d){
        Nodo p = Punta.getLigaFila();

        while (p != Punta){
            Nodo sig = p.getLigaFila();

            if (p.getDato() == d){
                eliminarPosicion(p.getFila(), p.getColumna());
            }

            p = sig;
        }
    }

    public void eliminarPosicion(int i, int j){

        Nodo ant = Punta;
        Nodo act = Punta.getLigaFila();

        while (act != Punta){
            if (act.getFila()==i && act.getColumna()==j){
                ant.setLigaFila(act.getLigaFila());
                break;
            }
            ant = act;
            act = act.getLigaFila();
        }

        ant = Punta;
        act = Punta.getLigaColumna();

        while (act != Punta){
            if (act.getFila()==i && act.getColumna()==j){
                ant.setLigaColumna(act.getLigaColumna());
                break;
            }
            ant = act;
            act = act.getLigaColumna();
        }
    }
    
    public Forma2 sumar(Forma2 B){

    Forma2 R = new Forma2();

    R.Punta.setFila(this.Punta.getFila());
    R.Punta.setColumna(this.Punta.getColumna());

    Nodo p = this.Punta.getLigaFila();

    while (p != this.Punta){
        R.Insertar(p.getFila(), p.getColumna(), p.getDato());
        p = p.getLigaFila();
    }

    Nodo q = B.Punta.getLigaFila();

    while (q != B.Punta){
        R.Insertar(q.getFila(), q.getColumna(), q.getDato());
        q = q.getLigaFila();
    }

    return R;
}
    
public Forma2 multiplicar(Forma2 B){

    Forma2 R = new Forma2();

    int f = this.Punta.getFila();
    int c = B.Punta.getColumna();

    R.Punta.setFila(f);
    R.Punta.setColumna(c);

    Nodo p = this.Punta.getLigaFila();

    while (p != this.Punta){

        Nodo q = B.Punta.getLigaFila();

        while (q != B.Punta){

            if (p.getColumna() == q.getFila()){

                int i = p.getFila();
                int j = q.getColumna();
                int valor = p.getDato() * q.getDato();

                R.Insertar(i, j, valor);
            }

            q = q.getLigaFila();
        }

        p = p.getLigaFila();
    }

    return R;
}
}
