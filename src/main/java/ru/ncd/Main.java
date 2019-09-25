package ru.ncd;

import java.io.FileInputStream;

public class Main {

    public static int quantityOfDots(Matrix matrix){
        int quantityOfDots = 0;
        for(int i = 0; i < matrix.n; i++){
            for(int j = 0; j < matrix.m; j++){
                if(matrix.arrayMatrix[i][j] == '.'){
                    quantityOfDots++;
                }
            }
        }
        return quantityOfDots;
    }

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("./src/main/resources/input.txt");
        Matrix matrix = new Matrix();
        Graph graph = new Graph(matrix);
        MatrixInitializer mi = new MatrixInitializer();
        GraphInitializer gi = new GraphInitializer();
        mi.matrixInitialize(fis, matrix);
        gi.graphInitialize(graph, matrix);
        int result = graph.quantityOfIslands(graph) - quantityOfDots(matrix);
        System.out.println(result);
    }
}
