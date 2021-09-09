import java.util.Scanner;
class entrevistaGerson {
    public static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

         System.out.println("***Entrevista Por Gerson Pérez***\n Quisiera conocer tus gustos mejor, ¿Podrías responder las siguientes preguntas? ");
         System.out.println("¿Cuál es tu nombre completo?");
         String nombre = entrada.nextLine();
         System.out.println("¿Cuál es tu personaje favorito?");
         String personFav = entrada.nextLine();
         System.out.println("¿Cuál es libro/comic/manga favorito?");
         String sagaFav = entrada.nextLine();
         System.out.println("¿Cuál es tu lugar ideal o favorito?(Valido de ficción)");
         String lugarFav = entrada.nextLine();
         System.out.println("¿Cuál es tu videojuego favorito?");
         String juegoFav = entrada.nextLine();

         System.out.println("Fue un placer conocerte "+ nombre + ", eres una persona admirable como " + personFav + " y se contarán historias sobre ti como en "+ sagaFav +".");
         System.out.println("Espero verte pronto en " + lugarFav + " y tal vez podamos jugar un poco "+ juegoFav+".");
         System.out.println("Ahora debo dejarlos, me despido muy afectuosamente... adios.");
    } 
}
