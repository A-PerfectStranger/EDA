/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;

/**
 *
 * @author Mayrita Carrion
 */
public class NodoAVL {
   private NodoAVL Der;
    private NodoAVL Izq;
    private int info;

    private int Fe;

    public NodoAVL(){
    }

    public NodoAVL(int inf) {
        this.Der = null;
        this.Izq = null;
        this.info = inf;
    }

    public NodoAVL getDer() {
        return Der;
    }

    public int getFe() {
        return Fe;
    }

    public void setFe(int Fe) {
        this.Fe = Fe;
    }


    public void setDer(NodoAVL Der) {
        this.Der = Der;
    }

    public NodoAVL getIzq() {
        return Izq;
    }

    public void setIzq(NodoAVL Izq) {
        this.Izq = Izq;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void insretarNodo(int inf) {
        if (inf < this.info) {
            if (this.Izq == null) {
                this.Izq = new NodoAVL(inf);
            } else {
                this.Izq.insretarNodo(inf);
            }
        } else if (inf > this.info) {
            if (this.Der == null) {
                this.Der = new NodoAVL(inf);
            } else {
                this.Der.insretarNodo(inf);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nodo ya insertado");
        }
    }
    
}
