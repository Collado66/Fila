/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fila;

/**
 *
 * @author marce
 */


public class Fila {
    private int tamanhoMaximo; // Tamanho máximo da fila
    private int[] filaArray;   // Array para armazenar os elementos da fila
    private int frente;        // Índice do elemento na frente da fila
    private int tras;          // Índice do elemento no final da fila
    private int quantidade;    // Quantidade de elementos na fila

    // Construtor para inicializar a fila
    public Fila(int tamanho) {
        this.tamanhoMaximo = tamanho;
        this.filaArray = new int[tamanhoMaximo];
        this.frente = 0;
        this.tras = -1;
        this.quantidade = 0;
    }

    // Método para adicionar um elemento ao final da fila (enqueue)
    public void enqueue(int elemento) {
        if (isFull()) {
            System.out.println("Fila cheia! Não é possível adicionar mais elementos.");
        } else {
            tras = (tras + 1) % tamanhoMaximo; // Circularidade
            filaArray[tras] = elemento;
            quantidade++;
            System.out.println("Elemento " + elemento + " adicionado à fila.");
        }
    }

    // Método para remover o elemento da frente da fila (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Fila vazia! Não é possível remover elementos.");
            return -1; // Retorna -1 para indicar que a fila está vazia
        } else {
            int elementoRemovido = filaArray[frente];
            frente = (frente + 1) % tamanhoMaximo; // Circularidade
            quantidade--;
            System.out.println("Elemento " + elementoRemovido + " removido da fila.");
            return elementoRemovido;
        }
    }

    // Método para verificar o elemento na frente da fila (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Fila vazia! Não há elementos para visualizar.");
            return -1; // Retorna -1 para indicar que a fila está vazia
        } else {
            return filaArray[frente];
        }
    }

    // Método para verificar se a fila está vazia
    public boolean isEmpty() {
        return (quantidade == 0);
    }

    // Método para verificar se a fila está cheia
    public boolean isFull() {
        return (quantidade == tamanhoMaximo);
    }

    // Método para exibir a fila
    public void exibirFila() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
        } else {
            System.out.print("Fila: ");
            int contador = quantidade;
            int indice = frente;
            while (contador > 0) {
                System.out.print(filaArray[indice] + " ");
                indice = (indice + 1) % tamanhoMaximo; // Circularidade
                contador--;
            }
            System.out.println();
        }
    }

    // Método principal para testar a fila
    public static void main(String[] args) {
        Fila fila = new Fila(5); // Cria uma fila com tamanho máximo 5

        fila.enqueue(10); // Adiciona 10
        fila.enqueue(20); // Adiciona 20
        fila.enqueue(30); // Adiciona 30
        fila.exibirFila(); // Exibe a fila: 10 20 30

        System.out.println("Elemento na frente: " + fila.peek()); // Exibe 10

        fila.dequeue(); // Remove 10
        fila.exibirFila(); // Exibe a fila: 20 30

        fila.enqueue(40); // Adiciona 40
        fila.enqueue(50); // Adiciona 50
        fila.enqueue(60); // Adiciona 60 (fila cheia)
        fila.exibirFila(); // Exibe a fila: 20 30 40 50 60

        fila.enqueue(70); // Tentativa de adicionar a uma fila cheia
    }
}