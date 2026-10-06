
public class LinkedListOfInteger {

    // Classe interna Node
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }
        
        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }        
    }

    
    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;

    
    /**
     * Construtor da lista.
     */
    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }
    
    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() { // O(1)
        return (head == null);
    }

    /**
     * Retorna o numero de elementos da lista.
     * @return o numero de elementos da lista
     */
    public int size() { // O(1)
        return count;
    }

    /**
     * Esvazia a lista
     */
    public void clear() { // O(1)
        head = null;
        tail = null;
        count = 0;
    }    

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element)  { // O(1)
        // Primeiro cria o nodo
        Node n = new Node(element);
        if (count == 0) { // se a lista esta vazia
            head = n;
        }
        else {
            tail.next = n;
        }
        tail = n;
        count++;
    }
    
    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) { // O(n)
        // Primeiro verifica se index e valido
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(); // erro
        }
        if (index == count-1) { // Se retorna o ultimo elem da lista
            return tail.element;
        }
        Node aux = head; // Referencia auxiliar que aponta para o primeiro nodo da lista
        // Faz aux "caminhar" ate a posicao index
        for (int i=0; i<index; i++) {
            aux = aux.next;
        }
        return aux.element;
    }
    
    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }    
    
    ////////////////////////////////////////////////////////////////
	
    /**
     * Retorna true se a lista contem o elemento especificado.
     * @param element o elemento a ser testado
     * @return true se a lista contem o elemento especificado
     */
    public boolean contains(Integer element) { // O(n)
        Node aux = head; // referencia para "caminhar" na lista
        for(int i=0; i<count; i++) {
            if (element.equals(aux.element)) { // se achou element...
                return true; //...retorna true
            }
            aux = aux.next; // avanca para o proximo nodo
        }
        return false; // passou por toda a lista e nao achou, retorna false
    }    	
    
    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
     * elemento indicado.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {
       // Implemente o algoritmo
        return -1;
    }
    
    /**
     * Insere um elemento em uma determinada posicao da lista.
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) { // O(n)
        // Primeiro verifica se index eh valido
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        // Cria o nodo
        Node n = new Node(element);

        // Insere o nodo criado na lista
        if (index == 0) { // se insercao no inicio
            if (count == 0) { // se a lista esta vazia
                tail = n;
            }
            else {
                n.next = head;
            }
            head = n;
        } 
        else if (index == count) { // se insercao no fim
            tail.next = n; // fas a "conexao" com o novo nodo
            tail = n; // atualiza o tail para apontar para o ultimo nodo da lista
        }
        else { // se insercao no meio
            // "Caminha" ate a posicao anterior
            Node ant = head;
            for(int i=0; i<index-1; i++) {
                ant = ant.next;
            }
            n.next = ant.next;
            ant.next = n;
        }

        // Incrementa o count
        count++;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) { // O(n)
        // Primeiro verifica se a lista esta vazia
        if (count == 0) {
            return false;
        }

        // Depois verifica se eh remocao do primeiro
        if (element.equals(head.element)) {
            if (count == 1) { // se tem apenas 1 elemento na lista
                tail = null;
            }
            head = head.next;
            count--;
            return true;
        }

        Node ant = head;
        Node aux = head.next;
        for (int i=1; i<count; i++) {
            if (element.equals(aux.element)) { // se achou o elemento a ser removvido
                if (aux == tail) { // se remocao do ultimo
                    tail = ant;
                    tail.next = null;
                }
                else { // se remocao do meio
                    ant.next = aux.next;
                }
                count --;
                return true;
            }
            ant = aux;
            aux = aux.next;
        }
        return false; // se nao achou e removeu element
    }

    /**
     * Remove o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        // Implemente o algoritmo
        return -1;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento.
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Integer element) {
        // Implemente o algoritmo
        return -1;
    }

    /**
     * Retorna um arranjo que contem os elementos da lista original entre
     * fromIndex (inclusivo) e toIndex (exclusivo).
     *
     * @param fromIndex posicao a partir da qual os elementos serao inseridos no
     * arranjo a ser retornado
     * @param toIndex indica a posicao final dos elementos que devem ser
     * inseridos
     * @return Um arranjo com um subconjunto dos elementos da lista.
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex >= toIndex)
     */
    public Integer[] subList(int fromIndex, int toIndex) {
        return null;
    }    

    /**
     * Compara o conteudo da lista com o conteudo da lista recebida por
     * parametro.
     * @param outra 
     * @return true se as listas forem iguais, false caso contrario
     */
    public boolean equals(LinkedListOfInteger outra) { // O(n)
        if (count != outra.count) { // se as listas possuem tamanhos diferentes
            return false; // retorna false
        }
        Node aux = head; // referencia auxiliar para "caminhar" na lista
        Node auxOutra = outra.head; // referencia auxiliar para "caminhar" na outra lista
        for (int i = 0; i < count; i++) {
            if (!aux.element.equals(auxOutra.element)) { // se os elementos forem diferentes
                return false; // retorna false
            }
            aux = aux.next;
            auxOutra = auxOutra.next;
        }
        return true;
    }

    /**
     * Retorna um array com o conteudo da lista invertido.
     * @return
     */
    public Integer[] getBackToFront() {
        Integer[] vet = new Integer[count];
        if (head != null) {
            getBackToFront(head, vet, count - 1);
        }
        return vet;
    }

    private void getBackToFront(Node n, Integer[] vet, int i) { 
        if (n != null) {
            getBackToFront(n.next, vet, i - 1);
            vet[i] = n.element;
        }
    }

}
