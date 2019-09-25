package ru.ncd;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MainTest {

    public Matrix matrix;
    public Graph graph;
    int quantityOfDots;

    @Before
    public void buildAndCheckBuildingOfElements() throws FileNotFoundException {
        System.out.println("Матрица из файла и её размер");
        matrix = new Matrix();

        assertEquals("Quantity of rows is read from file with errors", 2, matrix.n);
        assertEquals("Quantity of columns is read from file with errors", 2, matrix.m);
        char[] arr1 = {'#', '.', '.', '#'};
        int size = matrix.n * matrix.m;
        char[] arr2 = new char[size];
        int k = 0;
        for(int i = 0; i < matrix.n; i++) {
            for(int j = 0; j < matrix.m; j++) {
                arr2[k] = matrix.arrayMatrix[i][j];
                k++;
            }
        }
        assertArrayEquals("Matrix is read from file with errors", arr1, arr2);

        System.out.println(matrix.n + " " + matrix.m);
        for(int i = 0; i < matrix.n; i++){
            for(int j = 0; j < matrix.m; j++){
                System.out.print(matrix.arrayMatrix[i][j]);
            }
            System.out.println();
        }


       /* assertEquals("Matrix is read from file with errors", ".....##...." +
                "..#.....#.." +
                ".###....#.." +
                "......#.#.#" +
                "...##...#.#" +
                "##........." +
                "##.......##" +
                "##.......##", matrix.arrayMatrix);*/

        System.out.println();

        System.out.println("Матрица смежности графа и её размер");
        graph = new Graph(matrix);

        assertEquals("Size of arrayGraph is not right", graph.n, matrix.n * matrix.m);
        size = graph.n * graph.n;
        char[] arr3 = new char[size];
        char[] arr4 = {'1', '0', '0', '0', '0', '0','0', '0','0', '0','0', '0','0', '0','0','1'};
        k = 0;
        for(int i = 0; i < graph.n; i++){
            for(int j = 0; j < graph.n; j++){
                arr3[k] = graph.arrayGraph[i][j];
                k++;
            }
        }
        assertArrayEquals("graphMatrix is build with errors", arr3, arr4);


        System.out.println(graph.n);
        for(int i = 0; i < graph.n; i++){
            for(int j = 0; j < graph.n; j++){
                System.out.print(graph.arrayGraph[i][j]);
            }
            System.out.println();
        }


        System.out.println();
    }

    @Test
    public void quantityOfDots(){

        System.out.println("Количество точек в файле");
        quantityOfDots = 0;
        for(int i = 0; i < matrix.n; i++){
            for(int j = 0; j < matrix.m; j++){
                if(matrix.arrayMatrix[i][j] == '.'){
                    quantityOfDots++;
                }
            }
        }
        assertEquals("Quantity of dots is not right", quantityOfDots, 2);
        System.out.println(quantityOfDots);
        System.out.println();
    }

    @Test
    public void checkResult(){
        System.out.println("Ответ");
        quantityOfDots();
        int result = graph.quantityOfIslands(graph) - quantityOfDots;
        assertEquals("Quantity of islands is not right", quantityOfDots, 2);
        System.out.println("Quantity of islands: " + result);
        System.out.println();
    }
}