import java.util.List;
import java.util.ArrayList;

public class Maze {
    private int[][] maze;
    private List<Celda> visitados = new ArrayList<>();

    public Maze() {
        /*this.maze = new int[][] {
                { 0, 0, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0 },
        };*/
        this.maze = new int[][] {
                { 0, 0, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0 },
        };
        Celda inicio = new Celda(0, 0);
        Celda fin = new Celda(4, 5);

        List<Celda> camino = new ArrayList<>();

        boolean encontrado = findPath(maze,
                inicio, fin, camino);

        if (encontrado) {
            System.out.println("\nCamino encontrado:");
            printMazeWithPath(camino);

            System.out.println("\nCeldas del camino:");
            System.out.println(camino);
        } else {
            System.out.println("\nNo se encontró el camino.");
        }
    }

    private boolean findPath(int[][] maze, Celda inicio, Celda fin, List<Celda> camino) {
        int fila = inicio.getFila();
        int columna = inicio.getColumna();

        if (fila < 0 || fila >= maze.length ||
                columna < 0 || columna >= maze[0].length) {
            return false;
        }

        if (maze[fila][columna] == 1) {
            return false;
        }
        if (visitados.contains(inicio)) {
            return false;
        }

        visitados.add(inicio);
        camino.add(inicio);

        if (inicio.equals(fin)) {
            return true;
        }
        Celda izquierda = new Celda(fila, columna - 1);

        if (findPath(maze,
                izquierda,
                fin,
                camino)) {
            camino.add(inicio);
            return true;
        }

        Celda derecha = new Celda(fila, columna + 1);

        if (findPath(maze,
                derecha,
                fin,
                camino)) {
            camino.add(inicio);
            return true;
        }

        Celda abajo = new Celda(fila + 1, columna);

        if (findPath(maze,
                abajo,
                fin,
                camino)) {
            camino.add(inicio);
            return true;
        }
        Celda arriba = new Celda(fila - 1, columna);

        if (findPath(maze,
                arriba,
                fin,
                camino)) {
            camino.add(inicio);
            return true;
        }
        return false;

    }

    private void printMazeWithPath(List<Celda> camino) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Celda celdaActual = new Celda(i, j);
                if (camino.contains(celdaActual)) {
                    System.out.print(" * ");
                } else if (maze[i][j] == 1) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}
