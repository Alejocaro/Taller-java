package controller;

import model.Node;

public class List {

    private Node firstPte;
    private Node currentPte;

    public List() {
        this.firstPte = null;
        this.currentPte = null;
    }

    private boolean empty() {
        return this.firstPte == null;
    }

    public boolean insertList(int age) throws Exception {
        boolean result = true;

        try {
            Node newNode = new Node();
            newNode.setInfo(age);
            newNode.setNextPte(null);

            if (this.empty()) {
                this.firstPte = newNode;
            } else {
                newNode.setNextPte(this.firstPte);
                this.firstPte = newNode;
            }

            this.currentPte = this.firstPte;

            return result;
        } catch (Exception e) {
            throw new Exception("No se logro ingresar nodo al inicio de la lista!...");
        }
    }

    public int iteratorTravel(boolean first) throws Exception {
        int info = 0;
        try {
            if (this.empty()) {
                return info;
            } else {
                if (first) {
                    this.currentPte = this.firstPte;
                }

                if (this.currentPte != null) {
                    info = this.currentPte.getInfo();
                    this.currentPte = this.currentPte.getNextPte();
                    return info;
                } else {
                    this.currentPte = this.firstPte;
                    return info;
                }
            }
        } catch (Exception e) {
            throw new Exception("No se logro recorrer la lista!...");
        }
    }

    public boolean destroy() {
        if (!this.empty()) {
            this.currentPte = this.firstPte;

            while (this.currentPte != null) {
                this.currentPte = this.currentPte.getNextPte();
                this.firstPte.setNextPte(null);
                this.firstPte = this.currentPte;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean insertarAlFinal(int valor) throws Exception {
        try {
            // Crear un nuevo nodo y configurarlo
            Node nuevoNodo = new Node();
            nuevoNodo.setInfo(valor);          // Asignar el valor al nodo
            nuevoNodo.setNextPte(null);        // El nuevo nodo será el último, por lo que apunta a null

            // Si la lista está vacía, el nuevo nodo será el primero
            if (this.empty()) {
                this.firstPte = nuevoNodo;
            } else {
                // Si la lista no está vacía:
                // 1. Crear un puntero auxiliar que empezará desde el primer nodo
                Node actual = this.firstPte;

                // 2. Recorrer la lista hasta encontrar el último nodo
                // (El último nodo es aquel que apunta a null)
                while (actual.getNextPte() != null) {
                    actual = actual.getNextPte();
                }

                // 3. Hacer que el último nodo apunte al nuevo nodo
                actual.setNextPte(nuevoNodo);
            }
            return true;    // Operación exitosa
        } catch (Exception e) {
            // Si ocurre algún error durante el proceso, lanzar una excepción
            throw new Exception("No se logró insertar el nodo al final de la lista!...");
        }
    }

    public void eliminarNodo(int referencia) throws Exception {
        try {
            // Verificar si la lista está vacía
            if (this.empty()) {
                throw new Exception("\nLa lista está vacía\n");
            }

            // Obtener el primer nodo de la lista
            Node actualPtr = this.firstPte;    // nodo actual
            Node previoPtr = null;             // nodo anterior al actual

            // Recorrer hasta encontrar el valor o llegar al último nodo
            while (actualPtr != null && actualPtr.getInfo() != referencia) {
                previoPtr = actualPtr;         // guardar nodo actual antes de saltar
                actualPtr = actualPtr.getNextPte();
            }

            // Si se encontró el nodo con el valor de referencia
            if (actualPtr != null && actualPtr.getInfo() == referencia) {
                Node tempPtr = actualPtr;      // guardo el nodo a eliminar

                // Si el nodo a eliminar es el primero
                if (this.firstPte == actualPtr) {
                    this.firstPte = this.firstPte.getNextPte();
                } else {
                    // El nodo previo ahora apunta al siguiente del nodo a eliminar
                    previoPtr.setNextPte(actualPtr.getNextPte());
                }

                System.out.println("\nDestruyendo el nodo: " + tempPtr.getInfo() + "\n");
                tempPtr = null;    // En Java el garbage collector se encarga de liberar la memoria
            } else {
                throw new Exception("\nEl nodo dado como referencia no se encuentra en la lista.\n");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminarPrimero() throws Exception {
        try {
            // Verificar si la lista está vacía
            if (this.empty()) {
                throw new Exception("\nLa lista está vacía\n");
            }

            System.out.println("\nDestruyendo el nodo: " + firstPte.getInfo() + "\n");
            Node tempPtr = firstPte;           
            firstPte = firstPte.getNextPte();  
            tempPtr = null;                    
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertarDespues(int referencia, int valor) throws Exception {
        try {
            // Verificar si la lista está vacía
            if (this.empty()) {
                throw new Exception("\nEl nodo dado como referencia no se encuentra en la lista.\n");
            }

            // Crear el nuevo nodo y configurarlo
            Node nuevoPtr = new Node();        // Q, variable nodo temporal
            nuevoPtr.setInfo(valor);           // DATO, se guarda el nuevo valor
            nuevoPtr.setNextPte(null);         // el nuevo nodo apunta a nulo

            // Obtener el primer nodo de la lista
            Node actualPtr = this.firstPte;    // obtiene el primer nodo de la lista

            // Recorre hasta encontrar el valor o llegar al último nodo
            while (actualPtr.getNextPte() != null && actualPtr.getInfo() != referencia) {
                actualPtr = actualPtr.getNextPte();
            }

            // Si se encontró el nodo de referencia
            if (actualPtr.getInfo() == referencia) {
                nuevoPtr.setNextPte(actualPtr.getNextPte());    // el nodo nuevo apunta al siguiente del nodo referencia
                actualPtr.setNextPte(nuevoPtr);                 // el nodo referencia apunta al nuevo
            } else {
                throw new Exception("\nEl nodo dado como referencia no se encuentra en la lista.\n");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminarUltimo() throws Exception {
        try {
            // Verificar si la lista está vacía
            if (this.empty()) {
                throw new Exception("\nLa lista está vacía\n");
            }

            // Obtener el primer nodo de la lista
            Node actualPtr = this.firstPte;    // obtiene el primer nodo de la lista
            Node previoPtr = null;             // variable que guarda el nodo anterior

            // Recorre hasta llegar al último nodo
            while (actualPtr.getNextPte() != null) {
                previoPtr = actualPtr;         // guarda el nodo actual antes de saltar
                actualPtr = actualPtr.getNextPte();
            }

            Node tempPtr = actualPtr;          // guardo el nodo eliminar

            if (this.firstPte == actualPtr) {  // solo hay un nodo
                this.firstPte = null;          // se vacía la lista
            } else {
                previoPtr.setNextPte(null);    // el nodo previo se vuelve el último
            }

            System.out.println("\nDestruyendo el nodo: " + tempPtr.getInfo() + "\n");
            tempPtr = null;                    // libero la memoria del último nodo
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}


