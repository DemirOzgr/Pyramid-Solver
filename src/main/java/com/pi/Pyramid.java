package com.pi;

/**
 *
 * @author ozgur
 */
public class Pyramid {
    
    //Bu kısımda dik üçgenimizi (orthogonal triangle) oluşturuyoruz.
    private Integer[][] matrix;

    //Verilen değerleri çekip matrisimize atıyoruz.
    public Pyramid(final String dataAsString) {
        final String[] lines = dataAsString.split("\n");
        final Integer capacity = lines.length;
        matrix = new Integer[capacity][capacity];

        for (int i = 0; i < capacity; i++) {
            final String line = lines[i];
            final String[] columns = line.split(" ");
            final Integer columnCapacity = columns.length;
            for (int j = 0; j < columnCapacity; j++) {
                matrix[i][j] = toNumber(columns[j]);
            }
        }
    }
    //Matrisi oluştururken gelen string değerleri integer'a çeviriyoruz
    private Integer toNumber(String value) {
        Integer number = null;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            //ignore
        }
        return number;
    }
    //Matirisimizi yazdırabiliyoruz.
    public void print() {
        if (matrix != null) {
            for (Integer[] lines : matrix) {
                for (Integer column : lines) {
                    System.out.print(column + "\t");
                }
                System.out.println("");
            }
        }
    }
    //Matrisimizin boyutunu döndürebiliyoruz.
    public Integer getCapacity() {
        if (matrix == null) {
            return null;
        } 
        return matrix.length;
    }

    /**
     * @return the matrix
     */
    //Oluşturduğumuz matrisi kullanmak için yazıldı.
    public Integer[][] getMatrix() {
        return matrix;
    }

}