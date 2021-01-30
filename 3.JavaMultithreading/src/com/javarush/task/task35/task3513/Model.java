package com.javarush.task.task35.task3513;

import org.junit.Test;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;
    int score;
    int maxTile;

    public Model() {
        resetGameTiles();
        score = 0;
        maxTile = 0;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public int getScore() {
        return score;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }
        for (Tile[] tiles : gameTiles) {
            for (int i = 0; i <= tiles.length - 2; i++) {
                if (tiles[i].getValue() == tiles[i + 1].getValue()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < gameTiles[0].length; i++) {
            for (int j = 0; j <= gameTiles.length - 2; j++) {
                if (gameTiles[j][i].getValue() == gameTiles[j + 1][i].getValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void left() {
        saveState(gameTiles);
        boolean needToAddNewTile = false;
        for (Tile[] tile : gameTiles) {
            needToAddNewTile = compressTiles(tile) || needToAddNewTile;
            needToAddNewTile = mergeTiles(tile) || needToAddNewTile;
        }
        if (needToAddNewTile) {
            addTile();
        }
    }

    public void right() {
        saveState(gameTiles);
        boolean needToAddNewTile = false;
        for (Tile[] tile : gameTiles) {
            Collections.reverse(Arrays.asList(tile));
            needToAddNewTile = compressTiles(tile) || needToAddNewTile;
            needToAddNewTile = mergeTiles(tile) || needToAddNewTile;
            Collections.reverse(Arrays.asList(tile));
        }
        if (needToAddNewTile) {
            addTile();
        }
    }

    public void up() {
        saveState(gameTiles);
        boolean needToAddNewTile = false;
        for (int i = 0; i < gameTiles[0].length; i++) {
            Tile[] tileUp = new Tile[gameTiles.length];
            int j = 0;
            for (Tile[] tile : gameTiles) {
                tileUp[j++] = tile[i];
            }
            needToAddNewTile = compressTiles(tileUp) || needToAddNewTile;
            needToAddNewTile = mergeTiles(tileUp) || needToAddNewTile;
            j = 0;
            for (Tile[] tile : gameTiles) {
                tile[i] = tileUp[j++];
            }
        }
        if (needToAddNewTile) {
            addTile();
        }
    }

    public void down() {
        saveState(gameTiles);
        boolean needToAddNewTile = false;
        for (int i = 0; i < gameTiles[0].length; i++) {
            Tile[] tileDown = new Tile[gameTiles.length];
            int j = gameTiles.length - 1;
            for (Tile[] tile : gameTiles) {
                tileDown[j--] = tile[i];
            }
            needToAddNewTile = compressTiles(tileDown) || needToAddNewTile;
            needToAddNewTile = mergeTiles(tileDown) || needToAddNewTile;
            j = gameTiles.length - 1;
            for (Tile[] tile : gameTiles) {
                tile[i] = tileDown[j--];
            }
        }
        if (needToAddNewTile) {
            addTile();
        }
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::down));
        priorityQueue.peek().getMove().move();
    }


    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> result = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTile[j].isEmpty()) {
                    result.add(gameTile[j]);
                }
            }
        }
        return result;
    }

    private void addTile() {
        List<Tile> tileList = getEmptyTiles();
        if (!tileList.isEmpty()) {
            int randomTileIndex = (int) (tileList.size() * Math.random());
            Tile randomTile = tileList.get(randomTileIndex);
            randomTile.setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean change = false;
        int j = 0;
        for (int i = 0; i <= tiles.length - 2; i++) {
            if (tiles[i].isEmpty() && !tiles[i + 1].isEmpty()) {
                tiles[j].setValue(tiles[i + 1].getValue());
                tiles[i + 1].setValue(0);
                change = true;
            }
            if (!tiles[i].isEmpty()) {
                j++;
            }
        }
        return change;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean change = false;
        for (int i = 0; i <= tiles.length - 2; i++) {
            if (tiles[i].getValue() == tiles[i + 1].getValue() && tiles[i].getValue() != 0) {
                score += tiles[i].getValue() * 2;
                tiles[i].setValue(tiles[i].getValue() * 2);
                if (tiles[i].getValue() > maxTile) {
                    maxTile = tiles[i].getValue();
                }
                shiftTiles(tiles, i + 1);
                change = true;
            }
        }
        return change;
    }

    private void shiftTiles(Tile[] tiles, int i) {
        while (i <= tiles.length - 2) {
            tiles[i].setValue(tiles[i + 1].getValue());
            i++;
        }
        tiles[tiles.length - 1].setValue(0);
    }

    private void saveState(Tile[][] gameTiles) {
        Tile[][] newTile = new Tile[gameTiles.length][gameTiles[0].length];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                Tile tile = new Tile();
                tile.setValue(gameTiles[i][j].getValue());
                newTile[i][j] = tile;
            }
        }
        previousStates.push(newTile);
        previousScores.push(score);
    }

    private boolean hasBoardChanged() {
        Tile[][] previousState = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTiles[i][j].getValue() != previousState[i][j].getValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if (!hasBoardChanged()) {
            return new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }


    public static void print(Tile[] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            System.out.print(tiles[i].value + " ");
        }
        System.out.println();
    }

    public static void hash(Tile[] tiles) {
        for (int i = 0; i < tiles.length; i++)
            System.out.print(tiles[i].hashCode() + " ");
        System.out.println();
    }

    @Test
    public void test() {
        Tile[] tiles = new Tile[]{new Tile(8), new Tile(0), new Tile(0), new Tile(0)};
        print(tiles);
        hash(tiles);
        new Model().mergeTiles(tiles);
        print(tiles);
        hash(tiles);
        System.out.println("===============================");
        tiles = new Tile[]{new Tile(4), new Tile(2), new Tile(2), new Tile(4)};
        print(tiles);
        hash(tiles);
        new Model().mergeTiles(tiles);
        print(tiles);
        hash(tiles);
        System.out.println("===============================");
        tiles = new Tile[]{new Tile(4), new Tile(4), new Tile(4), new Tile(0)};
        print(tiles);
        hash(tiles);
        new Model().mergeTiles(tiles);
        print(tiles);
        hash(tiles);
        System.out.println("===============================");
        tiles = new Tile[]{new Tile(4), new Tile(4), new Tile(4), new Tile(4)};
        print(tiles);
        hash(tiles);
        new Model().mergeTiles(tiles);
        print(tiles);
        hash(tiles);
        System.out.println("===============================");
        tiles = new Tile[]{new Tile(8), new Tile(0), new Tile(0), new Tile(0)};

        print(tiles);
        hash(tiles);
        new Model().compressTiles(tiles);
        print(tiles);
        hash(tiles);
        System.out.println("===============================");
        tiles = new Tile[]{new Tile(4), new Tile(0), new Tile(0), new Tile(4)};

        print(tiles);
        hash(tiles);
        new Model().compressTiles(tiles);
        print(tiles);
        hash(tiles);
        System.out.println("===============================");
        tiles = new Tile[]{new Tile(0), new Tile(4), new Tile(4), new Tile(0)};

        print(tiles);
        hash(tiles);
        new Model().compressTiles(tiles);
        print(tiles);
        hash(tiles);
        System.out.println("===============================");
        tiles = new Tile[]{new Tile(0), new Tile(2), new Tile(0), new Tile(2)};

        print(tiles);
        hash(tiles);
        new Model().compressTiles(tiles);
        print(tiles);
        hash(tiles);
        System.out.println("===============================");

    }
}
