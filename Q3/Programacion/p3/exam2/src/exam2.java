class exam2 {

    public static void main(String[] args){ //metodo main
        double[] vec = new double[15];
        acceso_por_indice(vec, 16);
    }

    public static double acceso_por_indice(double[] vector, int indice) throws RuntimeException{
        try{
            if(0 <= indice && indice <= vector.length){
                return vector[indice];
            } else {
                throw new Exception ("Indice "+indice+" no es valido");
            }
        }catch(RuntimeException e){
            throw e;
        }
        
    }
}

