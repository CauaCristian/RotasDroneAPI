package com.caua.rotasdroneapi.repositories;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PlanejadorDeRotasDoDroneRepository {

    private static String[][] matriz = gerarMatrizTabuleiro();

    public ArrayList<ArrayList<String>> gerarRotasDoDrone(String inicio) {
        boolean sair = false;
        ArrayList<ArrayList<String>> rotas = new ArrayList<>();
        ArrayList<Integer> coordenadaAtual = acharCoordenada(inicio);
        if (acharCoordenada(inicio).get(0) == 0) {
            while (!sair) {
                if (coordenadaAtual.get(1) == matriz.length - 2) {
                    rotas.add(andarParaDireita(coordenadaAtual.get(0), coordenadaAtual.get(1)));
                    coordenadaAtual.set(0, matriz.length - 1);
                    coordenadaAtual.set(1, matriz.length - 2);
                    while (coordenadaAtual.get(1) != matriz.length - 8) {
                        rotas.add(andarParaEsquerda(coordenadaAtual.get(0), coordenadaAtual.get(1)));
                        coordenadaAtual.set(1, coordenadaAtual.get(1) - 2);
                    }
                    rotas.add(andarParaEsquerda(coordenadaAtual.get(0), coordenadaAtual.get(1)));
                    coordenadaAtual.set(0, 0);
                    coordenadaAtual.set(1, 0);
                    while (coordenadaAtual.get(1) != acharCoordenada(inicio).get(1)) {
                        rotas.add(andarParaDireita(coordenadaAtual.get(0), coordenadaAtual.get(1)));
                        coordenadaAtual.set(1, coordenadaAtual.get(1) + 2);
                    }
                    sair = true;
                } else {
                    rotas.add(andarParaDireita(coordenadaAtual.get(0), coordenadaAtual.get(1)));
                    coordenadaAtual.set(1, coordenadaAtual.get(1) + 2);
                }
            }
        }
        if (acharCoordenada(inicio).get(0) == 7) {
            while (!sair) {
                if (coordenadaAtual.get(1) == matriz.length - 8) {
                    rotas.add(andarParaEsquerda(coordenadaAtual.get(0), coordenadaAtual.get(1)));
                    coordenadaAtual.set(0, 0);
                    coordenadaAtual.set(1, 0);
                    while (coordenadaAtual.get(1) != matriz.length - 2) {
                        rotas.add(andarParaDireita(coordenadaAtual.get(0), coordenadaAtual.get(1)));
                        coordenadaAtual.set(1, coordenadaAtual.get(1) + 2);
                    }
                    rotas.add(andarParaDireita(coordenadaAtual.get(0), coordenadaAtual.get(1)));
                    coordenadaAtual.set(0, 7);
                    coordenadaAtual.set(1, 6);
                    while (coordenadaAtual.get(1) != acharCoordenada(inicio).get(1)) {
                        rotas.add(andarParaEsquerda(coordenadaAtual.get(0), coordenadaAtual.get(1)));
                        coordenadaAtual.set(1, coordenadaAtual.get(1) - 2);
                    }
                    sair = true;
                } else {
                    rotas.add(andarParaEsquerda(coordenadaAtual.get(0), coordenadaAtual.get(1)));
                    coordenadaAtual.set(1, coordenadaAtual.get(1) - 2);
                }
            }
        }
        return rotas;
    }

    public static ArrayList<String> andarParaDireita(int i, int j) {
        ArrayList<String> rota = new ArrayList<>();
        rota.add(matriz[i][j]);
        rota.add(matriz[i + 1][j]);
        rota.add(matriz[i + 2][j]);
        rota.add(matriz[i + 3][j]);
        rota.add(matriz[i + 3][j + 1]);
        rota.add(matriz[i + 2][j + 1]);
        rota.add(matriz[i + 1][j + 1]);
        rota.add(matriz[i][j + 1]);
        rota.add(matriz[i][j]);
        return rota;
    }

    public static ArrayList<String> andarParaEsquerda(int i, int j) {
        ArrayList<String> rota = new ArrayList<>();
        rota.add(matriz[i][j]);
        rota.add(matriz[i - 1][j]);
        rota.add(matriz[i - 2][j]);
        rota.add(matriz[i - 3][j]);
        rota.add(matriz[i - 3][j + 1]);
        rota.add(matriz[i - 2][j + 1]);
        rota.add(matriz[i - 1][j + 1]);
        rota.add(matriz[i][j + 1]);
        rota.add(matriz[i][j]);
        return rota;
    }

    public static ArrayList<Integer> acharCoordenada(String valor) {
        ArrayList<Integer> posicao = new ArrayList<Integer>();
        int posicaoY = 0;
        int posicaoX = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (valor.equals(matriz[i][j])) {
                    posicaoY = i;
                    posicaoX = j;
                }
            }
        }
        posicao.add(posicaoY);
        posicao.add(posicaoX);
        return posicao;
    }

    public static String[][] gerarMatrizTabuleiro() {

        int tamanho = 8;
        String[][] matriz = new String[tamanho][tamanho];
        for (int linha = 0; linha < tamanho; linha++) {
            for (int coluna = 0; coluna < tamanho; coluna++) {
                matriz[linha][coluna] = (linha + 1) + "" + (char) ('A' + coluna);
            }
        }
        return matriz;
    }

}
