public class OtroArbol {

    public void InsertaBalanceado(NodoAVL nodo, boolean BO, int infor) {
        NodoAVL nodo1, nodo2;
    
        if (nodo != null) {
            if (infor < nodo.getInfo()) {
                // llamada recursiva
                InsertaBalanceado(nodo.getIzq(), BO, infor);
            } else if (infor > nodo.getInfo()) {
                // otra llamada recursiva
                InsertaBalanceado(nodo.getDer(), BO, infor);
            } else {
                // La información ya se encuentra en el árbol
                System.out.println("La información ya se encuentra en el árbol");
            }
        } else {
            // Nodo es nulo, se crea un nuevo nodo
            NodoAVL nuevoNodo = new NodoAVL();
            nuevoNodo.setInfo(infor);
            nuevoNodo.setIzq(null);
            nuevoNodo.setDer(null);
            nuevoNodo.setFe(0);
    
            // Se asigna el nuevo nodo al lugar correspondiente
            nodo = nuevoNodo;
            BO = true;
        }
    
        if (BO) {
            if (nodo.getFe() == 1) {
                nodo1 = nodo.getIzq();
                if (nodo1.getFe() <= 0) {
                    // Rotación II
                    nodo.setIzq(nodo1.getDer());
                    nodo1.setIzq(nodo);
                    nodo.setFe(0);
                    nodo = nodo1;
                } else {
                    // Rotación ID
                    nodo2 = nodo1.getDer();
                    nodo.setIzq(nodo2.getDer());
                    nodo2.setDer(nodo);
                    nodo1.setDer(nodo2.getIzq());
                    nodo2.setIzq(nodo1);
                    if (nodo2.getFe() == -1) {
                        nodo.setFe(1);
                    } else {
                        nodo.setFe(0);
                    }
                    if (nodo2.getFe() == 1) {
                        nodo1.setFe(-1);
                    } else {
                        nodo1.setFe(0);
                    }
                    nodo = nodo2;
                }
                nodo.setFe(0);
                BO = false;
            } else if (nodo.getFe() == 0) {
                nodo.setFe(-1);
            } else { // nodo.getFe() == -1
                nodo1 = nodo.getIzq();
                if (nodo1.getFe() >= 0) {
                    // Rotación DD
                    nodo.setDer(nodo1.getIzq());
                    nodo1.setIzq(nodo);
                    nodo.setFe(0);
                    nodo = nodo1;
                } else {
                    // Rotación DI
                    nodo2 = nodo1.getIzq();
                    nodo.setDer(nodo2.getIzq());
                    nodo2.setIzq(nodo);
                    nodo1.setIzq(nodo2.getDer());
                    nodo2.setDer(nodo1);
                    if (nodo2.getFe() == 1) {
                        nodo.setFe(-1);
                    } else {
                        nodo.setFe(0);
                    }
                    if (nodo2.getFe() == -1) {
                        nodo1.setFe(1);
                    } else {
                        nodo1.setFe(0);
                    }
                    nodo = nodo2;
                }
                nodo.setFe(0);
                BO = false;
            }
        }
    }
    
}
