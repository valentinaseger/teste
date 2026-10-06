
public class App {
    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        
        System.out.println(lista);
       
        System.out.println("Elemento da posicao 2: " + lista.get(2));
        System.out.println("Elemento da ultima posicao: " + lista.get(lista.size()-1));
        
        lista.remove(2);
        lista.remove(6);
        lista.remove(12);
        System.out.println(lista);

        lista.add(0,2);
        lista.add(lista.size(), 12);
        lista.add(2,6);
        System.out.println(lista);

        lista.add(3,2);
        lista.add(2);
        lista.add(6);
        LinkedListOfInteger rep = App.getRepetidos(lista);
        System.out.println("Repetidos: \n" + rep);

    }

    public static LinkedListOfInteger getRepetidos(LinkedListOfInteger li) {
        LinkedListOfInteger rep = new LinkedListOfInteger();
        for(int i=0; i<li.size(); i++) {
            int num = li.get(i);
            for(int j=i+1; j<li.size(); j++) {
                if (li.get(j) == num) {
                    if (!rep.contains(num))
                        rep.add(num);
                }
            }
        }
        return rep;
    }     
}
