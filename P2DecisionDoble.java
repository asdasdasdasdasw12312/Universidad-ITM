public class P2DecisionDoble {
    public static double Tiquete(clsGenerales cls){
        
        int a = cls.leerEntero("Ingrese '10' si vas a pedir clase ejecutiva con un valor de 160000, y si no ingrese '20' para la clase economica");
        if(a != 10 && a != 20){
            return Tiquete(cls);
        }else{
            return a;
        }
    }
    private static boolean NumeroDeSilla(clsGenerales cls){
        String a=cls.leerCadena2("Ingrese S si quiere seleccionar un numero de silla de lo contrario ingrese cualquier otra tecla").toLowerCase().replace(" ", "");
            return a.equals("s");
        
    }
    private static boolean EmbarquePioritario(clsGenerales cls){
        String a=cls.leerCadena2("Ingrese S si quiere embarque pioritario de lo contrario ingrese cualquier otra tecla").toLowerCase().replace(" ", "");
        return a.equals("s");
    }
    private static boolean SobrePeso(float a){
        return a>15;
    }
    private static boolean Seguro(clsGenerales cls){
        String b=cls.leerCadena2("Ingrese S si quiere embarque pioritario de lo contrario ingrese cualquier otra tecla").toLowerCase().replace(" ", "");
        return b.equals("s");
    }
    private static void valorTotalDeltiquet(clsGenerales cls){
        double subtotal =0, totalTicket=0, embarquePioritario=0,porcentajeIva=0,numeroDeSilla=0,sobrePeso=0,total=0,tiquete=0,seguro=0;
        tiquete = (Tiquete(cls) == 10) ?   160000 :   120000;
        numeroDeSilla = (NumeroDeSilla(cls)) ? 15000 : 0;
        embarquePioritario = (EmbarquePioritario(cls)) ? 30000 : 0;
        float dinero =0;
        float pesoInicial =cls.leerReal_f("Ingrese el peso de su maleta");
        if(SobrePeso(pesoInicial)){
            dinero = cls.leerRealPosMy0_f("Ingrese el valor por el cual se cobra el kilo de equipaje extra");
            sobrePeso = (pesoInicial - 15) * dinero;
        }
        seguro = (Seguro(cls)) ? 35000 : 0;
        porcentajeIva = cls.leerRealPos_f("Ingrese el porcentaje del valor del iva") / 100;
        subtotal = tiquete + numeroDeSilla + embarquePioritario + sobrePeso + seguro;
        total = subtotal + (subtotal * porcentajeIva);
        cls.Mensaje("El valor de la clase es: " + tiquete + "\n" +
                    "El valor por numero de silla es: " + numeroDeSilla + "\n" +
                    "El valor del ticket total es de: " + (tiquete + numeroDeSilla) + "\n" +
                    "El valor por seguro de viaje es de: " + seguro + "\n" +
                    "El valor por embarque pioritario es: " + embarquePioritario + "\n" +
                    "El valor por sobrepeso es de : " + sobrePeso + "\n" +
                    "El subtotal a pagar sin contar el iva es de: " + subtotal + "\n" +
                    "El valor total a pagar es de: " + total
        );
        
        

    }
    public static void main(String[] args) {
        clsGenerales cls = new clsGenerales();
        valorTotalDeltiquet(cls);
        
    }
    
}
