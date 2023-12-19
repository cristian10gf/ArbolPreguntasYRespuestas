package arbolpreguntasyrespuestas;

public class Arbol {
    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public static int alturaArbol(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return Math.max(alturaArbol(nodo.izquierdo), alturaArbol(nodo.derecho)) + 1;
    }

    public static int getcol(int h) {
        if (h == 1) {
            return 1;
        }
        return getcol(h - 1) + getcol(h - 1) + 1;
    }

    public static void printTree(int[][] M, Nodo root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = root.dato;
        printTree(M, root.izquierdo, col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.derecho, col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }

    public void TreePrinter() {
        int h = alturaArbol(this.raiz);
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, this.raiz, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(M[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void agregar(int dato) {
        Nodo nodo = new Nodo(dato);
        if (this.raiz == null) {
            this.raiz = nodo;
        } else {
            agregarRecursivo(this.raiz, nodo);
        }
    }

    public void agregarRecursivo(Nodo nodo, Nodo nuevoNodo) {
        if (nuevoNodo.dato < nodo.dato) {
            if (nodo.izquierdo == null) {
                nodo.izquierdo = nuevoNodo;
            } else {
                agregarRecursivo(nodo.izquierdo, nuevoNodo);
            }
        } else {
            if (nodo.derecho == null) {
                nodo.derecho = nuevoNodo;
            } else {
                agregarRecursivo(nodo.derecho, nuevoNodo);
            }
        }
    }

    public String buscar(Nodo nodo, int dato, String recorrido, int nivel, boolean modo) {
        if (nodo == null) return recorrido;
        
        // condicional para encontrar el dato del usuario
        if (nodo.dato == dato) {
            recorrido = recorrido + "," + nodo.dato; //almacena el valor de cada nodo por donde se paso
            if (modo) { // modo significa si desde el exterior se busca un dato del usuario o el dato a adivinado
                System.out.println("fue encontrado en el nivel " + nivel);
                
                // cada condicional para ver si es hoja o padre
                if (nodo.derecho == null && nodo.izquierdo == null) {
                    System.out.println("es una hoja, tambien hijo");
                } else if (nodo.derecho == null || nodo.izquierdo == null) {
                    System.out.println("es un padre");
                }
            }
            return recorrido;
        } else {
            if (dato < nodo.dato) {
                return buscar(nodo.izquierdo, dato, recorrido + "," + nodo.dato, nivel + 1, modo);
            } else {
                return buscar(nodo.derecho, dato, recorrido + "," + nodo.dato, nivel + 1, modo);
            }
        }
    }

}