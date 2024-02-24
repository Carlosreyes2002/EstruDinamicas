import java.util.Scanner;

class Nodo {
    int dato;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}

class ListaDobleEnlazada {
    Nodo inicio;

    public ListaDobleEnlazada() {
        this.inicio = null;
    }

    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            nuevoNodo.siguiente = inicio;
            inicio.anterior = nuevoNodo;
            inicio = nuevoNodo;
        }
        System.out.println("Elemento insertado al inicio: " + dato);
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            nuevoNodo.anterior = temp;
        }
        System.out.println("Elemento insertado al final: " + dato);
    }

    public void recorrerAdelante() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    public void recorrerAtras() {
        Nodo temp = inicio;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.anterior;
        }
        System.out.println();
    }

    public void mostrarTamaño() {
        int tamaño = 0;
        Nodo temp = inicio;
        while (temp != null) {
            tamaño++;
            temp = temp.siguiente;
        }
        System.out.println("Tamaño de la lista: " + tamaño);
    }

    public void mostrarSiEstaVacia() {
        if (inicio == null) {
            System.out.println("La lista está vacía");
        } else {
            System.out.println("La lista no está vacía");
        }
    }

    public void buscarPorValor(int valor) {
        Nodo temp = inicio;
        int indice = 0;
        while (temp != null) {
            if (temp.dato == valor) {
                System.out.println("Elemento encontrado en el índice " + indice);
                return;
            }
            temp = temp.siguiente;
            indice++;
        }
        System.out.println("Elemento no encontrado");
    }

    public void buscarPorIndice(int indice) {
        Nodo temp = inicio;
        int i = 0;
        while (temp != null) {
            if (i == indice) {
                System.out.println("Elemento en el índice " + indice + ": " + temp.dato);
                return;
            }
            temp = temp.siguiente;
            i++;
        }
        System.out.println("Índice fuera de rango");
    }

    public void borrarElemento(int valor) {
        Nodo temp = inicio;
        while (temp != null) {
            if (temp.dato == valor) {
                if (temp.anterior != null) {
                    temp.anterior.siguiente = temp.siguiente;
                } else {
                    inicio = temp.siguiente;
                }
                if (temp.siguiente != null) {
                    temp.siguiente.anterior = temp.anterior;
                }
                System.out.println("Elemento eliminado: " + valor);
                return;
            }
            temp = temp.siguiente;
        }
        System.out.println("Elemento no encontrado");
    }
}

public class ListaEnlazada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDobleEnlazada lista = new ListaDobleEnlazada();

        int opcion;
        do {
            System.out.println("\nLista Doblemente Enlazada");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Recorrer hacia adelante");
            System.out.println("4. Recorrer hacia atras");
            System.out.println("5. Mostrar tamano de la lista");
            System.out.println("6. Mostrar si la lista esta vacia");
            System.out.println("7. Buscar elemento por valor");
            System.out.println("8. Buscar elemento por indice");
            System.out.println("9. Borrar un elemento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a insertar al inicio: ");
                    int elementoInicio = scanner.nextInt();
                    lista.insertarAlInicio(elementoInicio);
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a insertar al final: ");
                    int elementoFinal = scanner.nextInt();
                    lista.insertarAlFinal(elementoFinal);
                    break;
                case 3:
                    System.out.println("Elementos de la lista hacia adelante:");
                    lista.recorrerAdelante();
                    break;
                case 4:
                    System.out.println("Elementos de la lista hacia atrás:");
                    lista.recorrerAtras();
                    break;
                case 5:
                    lista.mostrarTamaño();
                    break;
                case 6:
                    lista.mostrarSiEstaVacia();
                    break;
                case 7:
                    System.out.print("Ingrese el valor a buscar: ");
                    int valorBusqueda = scanner.nextInt();
                    lista.buscarPorValor(valorBusqueda);
                    break;
                case 8:
                    System.out.print("Ingrese el índice a buscar: ");
                    int indiceBusqueda = scanner.nextInt();
                    lista.buscarPorIndice(indiceBusqueda);
                    break;
                case 9:
                    System.out.print("Ingrese el elemento a borrar: ");
                    int elementoBorrar = scanner.nextInt();
                    lista.borrarElemento(elementoBorrar);
                    break;
            }
        } while (opcion != 0);
        scanner.close();
    }
}
